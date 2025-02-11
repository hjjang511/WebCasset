package com.project.webbackend.Service.token;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.project.webbackend.Entity.Token;
import com.project.webbackend.Entity.User;


@Service

public interface ITokenService {
    Token addToken(User user, String token, boolean isMobileDevice);
    Token refreshToken(String refreshToken, User user) throws Exception;
}
