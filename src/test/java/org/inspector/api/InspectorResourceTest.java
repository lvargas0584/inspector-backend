package org.inspector.api;

import io.quarkus.test.junit.QuarkusTest;
import org.inspector.core.service.impl.ReportServiceImpl;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class InspectorResourceTest {

    @Inject
    ReportServiceImpl reportGenerate;

    @Test
    public void testHelloEndpoint() {
        //reportGenerate.generateZip("5f31e9cdea1aa54a174f45a7");
    }

}