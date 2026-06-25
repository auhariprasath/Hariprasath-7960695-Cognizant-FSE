package com.example.JunitDemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    void testExternalApi() {

        // Create Mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stubbing
        when(mockApi.getData()).thenReturn("Mock Data");

        // Inject Mock
        MyService service = new MyService(mockApi);

        // Call Method
        String result = service.fetchData();

        // Assertion
        assertEquals("Mock Data", result);
    }

    @Test
    void testVerifyInteraction() {

    // Create Mock
    ExternalApi mockApi = mock(ExternalApi.class);

    // Inject Mock
    MyService service = new MyService(mockApi);

    // Call Method
    service.fetchData();

    // Verify Interaction
    verify(mockApi).getData();
}
}