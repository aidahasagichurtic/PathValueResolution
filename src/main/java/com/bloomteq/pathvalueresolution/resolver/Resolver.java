package com.bloomteq.pathvalueresolution.resolver;

import com.bloomteq.pathvalueresolution.util.ValueExtractor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class Resolver {

    private final ObjectMapper objectMapper;

    public Object getSimpleJsonValue(String json, String path) {
        return processJson(json, path, ValueExtractor::extractSimpleJsonValue);
    }

    public Object getComplexJsonValue(String json, String path) {
        return processJson(json, path, ValueExtractor::extractComplexJsonValue);
    }

    private Object processJson(String json, String path, JsonProcessor processor) {
        try {
            // load Json string into JsonNode tree
            JsonNode nodes = objectMapper.readTree(json);

            // extract specific path value from JsonNode tree using corresponding processor
            return processor.extract(nodes, path);
        } catch (JsonProcessingException e) {
            log.error("Invalid JSON input: {}", e.getMessage());
        } catch (Exception e) {
            log.error("Error while resolving path: {}", e.getMessage());
        }
        return null;
    }

    @FunctionalInterface
    private interface JsonProcessor {
        Object extract(JsonNode nodes, String path);
    }
}
