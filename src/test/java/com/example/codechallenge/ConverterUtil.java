package com.example.codechallenge;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ConverterUtil {

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
    }

    private ConverterUtil() {}

    public static <T> T readDataFromFileJson(
            String fileName, Class<T> className) {
        try {
            return mapper.readValue(
                    ConverterUtil.class.getClassLoader().getResourceAsStream(fileName), className
            );
        } catch (IOException e) {
            return null;
        }
    }

}
