package com.example.workshop1.user;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String s) {
    super(s);
  }
}
