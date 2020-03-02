package com.mario.demo.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.org.objectweb.asm.TypeReference;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class util {
    private static ObjectMapper objectMapper = new CustomObjectMapper();

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static <T> T toCollection(String json, TypeReference<T> reference) {
        return objectMapper.readValue(json, reference);
    }

    public static <T> T toObject(String json, TypeReference reference) {
        return objectMapper.readValue(json, reference);
    }


    public static <T> T fromJson(String json, Class<T> type) {
        T t = null;
        try {
            t = objectMapper.readValue(json, type);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("json error! ");
        }
        return t;
    }


    public static <T> String toJson(T t) {
        String json;
        try {
            json = objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("json error! ");
        }
        return json;
    }


}
