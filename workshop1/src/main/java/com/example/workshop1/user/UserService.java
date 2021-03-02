package com.example.workshop1.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
  public UserResponse getInfo(int id) {
    if (id <= 10) {
      return new UserResponse(id, "ruangwit", 26);
    }
    throw new UserNotFoundException("User not found id=" + id);
  }
}
