package com.mario.demo.path;

import java.net.URISyntaxException;

public class Path {
    public static void main(String[] args) throws URISyntaxException {
        String path = Thread.currentThread().getContextClassLoader().getResource("")
                .toURI().getPath().replaceAll("%20", " ");
        System.out.println(path);
    }
}
