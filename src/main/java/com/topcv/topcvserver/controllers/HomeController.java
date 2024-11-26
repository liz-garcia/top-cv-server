package com.topcv.topcvserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling basic routing in the application. Provides responses for the root ("/")
 * and "/api" endpoints.
 */
@RestController
public class HomeController {
  /**
   * Handles requests to the root URL ("/").
   *
   * @return A welcome message for the TopCV API.
   */
  @GetMapping("/")
  public String home() {
    return "Welcome to the TopCV API! Access endpoints at /api/";
  }

  /**
   * Handles requests to the "/api" URL.
   *
   * @return A message indicating API access details.
   */
  @GetMapping("/api")
  public String apiHome() {
    return "This is the TopCV API! Explore endpoints like /api/users.";
  }
}
