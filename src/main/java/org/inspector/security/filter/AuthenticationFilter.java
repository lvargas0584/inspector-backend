package org.inspector.security.filter;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import org.inspector.security.provider.JwtProvider;
import org.inspector.security.session.UserSession;
import org.jboss.logging.Logger;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {
    private static final Logger LOG = Logger.getLogger(AuthenticationFilter.class);

    private static final String AUTHORIZATION_PROPERTY = "Authorization";

    @Inject
    UserSession userSession;

    @Inject
    JwtProvider _jwtProvider;

    @Context
    UriInfo info;

    @Context
    ResourceInfo resourceInfo;

    @Context
    HttpServerRequest request;

    @Context
    HttpServerResponse response;

    @Context
    ResourceContext resourceContext;

    @Override
    public void filter(ContainerRequestContext context) throws IOException {

        Method method = resourceInfo.getResourceMethod();

        if (method.isAnnotationPresent(PermitAll.class)) {
            return;
        }

        // Verify Authentication Header
        final MultivaluedMap<String, String> headers = context.getHeaders();
        final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

        // If no authorization information present; block access
        if(authorization == null || authorization.isEmpty())
        {
            context.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("You cannot access this resource").build());
            return;
        }

        // Verify token and returns null if is invalid
        final Map<String, String> claims = _jwtProvider.validateToken(authorization.get(0));

        if (claims == null) {
            context.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("You cannot access this resource").build());
            return;
        }

        // When management with roles
        if (method.isAnnotationPresent(RolesAllowed.class)) {
            // TODO WHEN USE ROLES
            RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
            Set<String> rolesSet = new HashSet<>(Arrays.asList(rolesAnnotation.value()));

            return;
        }
        String currentPath = request.path();
        claims.put("currentPath", currentPath);
        // Set session payload
        userSession.setPayload(claims);

        LOG.infof("Request %s %s from IP %s", context.getMethod(), info.getPath(), request.remoteAddress().toString());
    }
}
