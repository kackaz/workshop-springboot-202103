package com.example.workshop1.user;

import org.apache.coyote.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void success_get_user_id() {
    UserResponse response = restTemplate.getForObject("/user/1", UserResponse.class);

    assertEquals(1, response.getId());
    assertEquals("ruangwit", response.getName());
    assertEquals(26, response.getAge());

    //Quiz
    UserResponse expected = new UserResponse(1, "ruangwit", 26);
    assertEquals(expected, response);
  }

  @Test
  public void user_not_found_with_user_id_15() {
    ErrorResponse response = restTemplate.getForObject("/user/15", ErrorResponse.class);

    assertEquals(1234, response.getCode());
    assertEquals("User not found id=15", response.getMessage());
    ErrorResponse expected = new ErrorResponse(1234, "User not found id=15");
    assertEquals(expected, response);

  }
}