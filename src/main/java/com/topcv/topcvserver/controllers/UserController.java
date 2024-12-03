package com.topcv.topcvserver.controllers;

import java.util.List;
import com.topcv.topcvserver.dto.Response;
import com.topcv.topcvserver.models.User;
import com.topcv.topcvserver.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Controller for managing User-related API endpoints. Provides endpoints to fetch user data. */
@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /** Handles GET requests to fetch all users. */
  @GetMapping
  public Response getUsers() {
    try {
      List<User> users = userRepository.findAll();
      return Response.success(users);
    } catch (Exception e) {
      return Response.error("An unexpected error occurred: " + e.getMessage());
    }
  }

}
