package com.project.webbackend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.webbackend.Entity.Token;
import com.project.webbackend.Entity.User;

import java.util.List;

public interface TokenRepository extends JpaRepository<Token, Long> {
  List<Token> findByUser(User user);

  Token findByToken(String token);

  Token findByRefreshToken(String token);
}
