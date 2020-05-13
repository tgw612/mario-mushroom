package com.github.jvmgo;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArgsTest {

  @Test
  public void test() {
    assertTrue(com.github.jvmgo.Args.parse(new String[]{"-?"}).helpFlag);
    assertTrue(com.github.jvmgo.Args.parse(new String[]{"-help"}).helpFlag);
    assertTrue(com.github.jvmgo.Args.parse(new String[]{"-version"}).versionFlag);
    assertFalse(com.github.jvmgo.Args.parse(new String[]{"-cp"}).ok);
    assertFalse(com.github.jvmgo.Args.parse(new String[]{"-classpath"}).ok);
    assertEquals("foo.jar", com.github.jvmgo.Args.parse(new String[]{"-cp", "foo.jar"}).classpath);
    assertEquals("foo.jar",
        com.github.jvmgo.Args.parse(new String[]{"-classpath", "foo.jar"}).classpath);
    assertEquals(Arrays.asList("Main", "foo"),
        com.github.jvmgo.Args.parse(new String[]{"Main", "foo"}).mainClassAndArgs);
  }

}
