package com.bloomteq.pathvalueresolution.util;

import com.fasterxml.jackson.databind.JsonNode;

import static java.util.Arrays.stream;

public class ValueExtractor {

    public static Object extractSimpleJsonValue(JsonNode nodes, String path) {
        // split the path by dots into keys and iterate through each key to navigate the Json nodes, updating currentNode at each step.
        // if a key is missing or currentNode is null, stop and return null, otherwise, return the final node found.
        JsonNode node = stream(path.split("\\."))
                .reduce(nodes, (currentNode, key) -> currentNode == null ? null : currentNode.get(key), (a, b) -> b);

        // if node found, return its text value, otherwise return null
        return convertToText(node);
    }

    public static Object extractComplexJsonValue(JsonNode nodes, String path) {
        // split the path by dots into keys and iterate through each key to navigate the Json nodes, updating currentNode at each step.
        // if currentNode is an array, check the first element for the key.
        // If a key is missing or currentNode is null, stop and return null, otherwise, return the final node found.
        JsonNode node = stream(path.split("\\."))
                .reduce(nodes, (currentNode, key) -> {
                    if (currentNode == null)
                        return null;

                    return currentNode.isArray()
                            ? currentNode.elements().next().get(key)
                            : currentNode.get(key);
                }, (a, b) -> b);

        // if node found, return its text value, otherwise return null
        return convertToText(node);
    }

    private static String convertToText(JsonNode node) {
        return node != null ? node.asText() : null;
    }
}
