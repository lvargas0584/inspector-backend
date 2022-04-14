package org.inspector.security.session;

import javax.enterprise.context.RequestScoped;
import java.util.Map;

@RequestScoped
public class UserSession {
    private Map<String, String> payload;

    public Map<String, String> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }
}