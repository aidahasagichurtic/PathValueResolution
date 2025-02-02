package com.bloomteq.pathvalueresolution.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.bloomteq.pathvalueresolution.TestJsonConstants.VALID_COMPLEX_JSON;
import static com.bloomteq.pathvalueresolution.TestJsonConstants.VALID_SIMPLE_JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ValueExtractorTests {

    static JsonNode simpleJsonNodes;
    static JsonNode complexJsonNodes;

    @BeforeAll
    static void setUpOnce() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        simpleJsonNodes = objectMapper.readTree(VALID_SIMPLE_JSON);
        complexJsonNodes = objectMapper.readTree(VALID_COMPLEX_JSON);
    }

    @Test
    void extractValue_validPath() {
        String path = "property1.property3";
        Object result = ValueExtractor.extractSimpleJsonValue(simpleJsonNodes, path);

        assertEquals("Orange", result);
    }

    @Test
    void extractSimpleDataValue_invalidPath() {
        assertNull(ValueExtractor.extractSimpleJsonValue(simpleJsonNodes, ""));
    }

    @Test
    void extractSimpleDataValue_nonExistingPath() {
        String path = "property1.property4";
        assertNull(ValueExtractor.extractSimpleJsonValue(simpleJsonNodes, path));
    }

    @Test
    void extractComplexDataValue_validPath() {
        String path = "property1.property3.property4";
        Object result = ValueExtractor.extractComplexJsonValue(complexJsonNodes, path);

        assertEquals("Apple", result);
    }

    @Test
    void extractComplexDataValue_invalidPath() {
        assertNull(ValueExtractor.extractComplexJsonValue(complexJsonNodes, ""));
    }

    @Test
    void extractComplexDataValue_notExistingPath() {
        String path = "property1.property6.property4";
        assertNull(ValueExtractor.extractComplexJsonValue(complexJsonNodes, path));
    }
}
