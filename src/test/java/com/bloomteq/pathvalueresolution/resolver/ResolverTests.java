package com.bloomteq.pathvalueresolution.resolver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.bloomteq.pathvalueresolution.TestJsonConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class ResolverTests {

    @InjectMocks
    private Resolver resolver;

    @Mock
    private ObjectMapper objectMapperMock;

    static JsonNode simpleJsonNodes;
    static JsonNode complexJsonNodes;

    @BeforeAll
    static void setUpOnce() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        simpleJsonNodes = objectMapper.readTree(VALID_SIMPLE_JSON);
        complexJsonNodes = objectMapper.readTree(VALID_COMPLEX_JSON);

    }
    @Test
    void getSimpleJsonValue_shouldReturn_correctValue() throws JsonProcessingException {
        when(objectMapperMock.readTree(VALID_SIMPLE_JSON)).thenReturn(simpleJsonNodes);
        Object result = resolver.getSimpleJsonValue(VALID_SIMPLE_JSON, "property1.property3");
        assertEquals("Orange", result);

        verify(objectMapperMock, times(1)).readTree(VALID_SIMPLE_JSON);
    }

    @Test
    void getComplexJsonValue_shouldReturn_correctValue() throws JsonProcessingException {
        when(objectMapperMock.readTree(VALID_COMPLEX_JSON)).thenReturn(complexJsonNodes);
        Object result = resolver.getComplexJsonValue(VALID_COMPLEX_JSON, "property1.property3.property4");
        assertEquals("Apple", result);

        verify(objectMapperMock, times(1)).readTree(VALID_COMPLEX_JSON);
    }

    @Test
    void getSimpleJsonValue_invalidJson_shouldReturn_null() {
        assertNull(resolver.getSimpleJsonValue(INVALID_JSON, "property1.property4.property5"));
    }

    @Test
    void getComplexJsonValue_invalidJson_shouldReturn_null() {
        assertNull(resolver.getComplexJsonValue(INVALID_JSON, "property1.property4.property5"));
    }

    @Test
    void getSimpleJsonValue_nullJson_shouldReturn_null() {
        assertNull(resolver.getSimpleJsonValue(null, "property1.property4.property5"));
    }

    @Test
    void getComplexJsonValue_nullJson_shouldReturn_null() {
        assertNull(resolver.getComplexJsonValue(null, "property1.property4.property5"));
    }

    @Test
    void getSimpleJsonValue_nullPath_shouldReturn_null() {
        assertNull(resolver.getSimpleJsonValue(VALID_SIMPLE_JSON, null));
    }

    @Test
    void getComplexJsonValue_nullPath_shouldReturn_null() {
        assertNull(resolver.getComplexJsonValue(VALID_COMPLEX_JSON, null));
    }

    @Test
    void getSimpleJsonValue_nullParameters_shouldReturn_null() {
        assertNull(resolver.getSimpleJsonValue(null, null));
    }

    @Test
    void getComplexJsonValue_nullParameters_shouldReturn_null() {
        assertNull(resolver.getComplexJsonValue(null, null));
    }
}