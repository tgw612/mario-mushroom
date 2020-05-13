package com.mario.demo.path;

import java.net.URISyntaxException;

/**
 * 获取当前class文件的地址
 */
public class Path {

  public static void main(String[] args) throws URISyntaxException {
    String path = Thread.currentThread().getContextClassLoader().getResource("")
        .toURI().getPath().replaceAll("%20", " ");
    System.out.println(path);
  }
}
