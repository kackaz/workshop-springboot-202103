package com.example.workshop1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class DemoServiceTest {

  @Test
  @DisplayName("ในการทำงานต้อง random ได้ค่า 5")
  public void random_5() {
    DemoService demoService = new DemoService();
    demoService.setRandom(new MockRandom(5));
    String actualResult = demoService.generateData("ruangwit");
    assertEquals("ruangwit5", actualResult);
  }

  @Test
  public void throw_exception_1() {
    DemoService demoService = new DemoService();
    demoService.setRandom(new MockRandom(1));
    try {
      demoService.generateData("ruangwit");
      fail();
    } catch (RuntimeException e) {
      assertEquals("Invalid number with 1", e.getMessage());
    }
  }

  @Test
  public void throw_exception_with_junit5() {
    DemoService demoService = new DemoService();
    demoService.setRandom(new MockRandom(1));

    Exception exception = assertThrows(RuntimeException.class, () -> {
      demoService.generateData("ruangwit");
    });
    assertEquals("Invalid number with 1", exception.getMessage());
  }

  class MockRandom extends Random {
    private final int result;

    MockRandom(int result) {
      this.result = result;
    }

    @Override
    public int nextInt(int bound) {
      return result;
    }
  }
}