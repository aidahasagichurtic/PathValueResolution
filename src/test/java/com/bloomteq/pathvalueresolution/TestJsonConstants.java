package com.bloomteq.pathvalueresolution;

public class TestJsonConstants {
    public static final String VALID_SIMPLE_JSON = """
            {
            "property1": {
                "property2": "Apple",
                "property3": "Orange"
                }
            }
            """;

    public static final String VALID_COMPLEX_JSON = """
            {
                "property1": {
                    "property2": "Banana",
                    "property3": [{
                        "property4": "Apple"
                    },{
                        "property4": "Orange"
                    }]
                }
            }
            """;

    public static final String INVALID_JSON = """
            {
                "property1": {
                    "property2": "Apple",
                    "property3": {
                        "property4": "Orange"
                    }
                }
            }
            """;
}
