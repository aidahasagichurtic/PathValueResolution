package com.bloomteq.pathvalueresolution;

import com.bloomteq.pathvalueresolution.resolver.Resolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
@AllArgsConstructor
public class PathResolverApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(PathResolverApplication.class, args);
        Resolver resolver = context.getBean(Resolver.class);

        final String path = "property1.property2";
        final String json = """
                {
                    "property1": {
                        "property2": "Apple",
                        "property3": "Orange"
                    }
                }
                """;

        var simpleResolverPathValue = resolver.getSimpleJsonValue(json, path);
        var complexResolverPathValue = resolver.getComplexJsonValue(json, path);
        log.info("Resolved value for simple data: {}", simpleResolverPathValue);
        log.info("Resolved value for complex data: {}", complexResolverPathValue);
    }

}
