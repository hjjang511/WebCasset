package com.project.webbackend.Response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.webbackend.Entity.User;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {
  @JsonProperty("message")
  private String message;

  @JsonProperty("user")
  private User user;
}
