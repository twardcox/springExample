package com.madscientistlaboratories.songr;

import org.junit.Test;

import static org.junit.Assert.*;

public class HomeControllerTest {

  @Test
  public void testReverseWord() {
    String startString = "What ever you want";

    assertEquals("testReverseWord should be equal", "want you ever What", HomeController.reverseWord(startString));
  }
}