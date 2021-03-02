package com.example.workshop1;

import lombok.Setter;

import java.util.Random;

import static java.lang.System.out;

@Setter
public class DemoService {
  private Random random;

  public String generateData(String name) {
    int number = random.nextInt(10);
    if (number >= 5 && number <= 8) {
      return name + number;
    }
    throw new RuntimeException("Invalid number with " + number);
    /*
        1. Checked exception => compile time
        2. Unchecked exception => runtime => NPE, ArrayIndexOutOfBound, OOM, ClassCastException
         */
  }

//  public static void main(String[] args) {
//    Random random = new Random() {
//      @Override
//      public int nextInt() {
//        return 5;
//      }
//    };
//    DemoService demoService = new DemoService();
//    demoService.setRandom(random);
//    out.println(demoService.generateData("ruangwit"));
//  }
//
//  class Random5 extends Random {
//    @Override
//    public int nextInt(int bound) {
//      return 5;
//    }
//  }

}
