package com.project.webbackend.Service.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.webbackend.Entity.User;
import com.project.webbackend.dtos.UpdateUserDTO;
import com.project.webbackend.dtos.UserDTO;
import com.project.webbackend.exceptions.DataNotFoundException;
import com.project.webbackend.exceptions.InvalidPasswordException;

public interface IUserService {
    User createUser(UserDTO userDTO) throws Exception;
    String login(String phoneNumber, String password, Long roleId) throws Exception;
    User getUserDetailsFromToken(String token) throws Exception;
    User getUserDetailsFromRefreshToken(String token) throws Exception;
    User updateUser(Long userId, UpdateUserDTO updatedUserDTO) throws Exception;

    Page<User> findAll(String keyword, Pageable pageable) throws Exception;
    void resetPassword(Long userId, String newPassword)
            throws InvalidPasswordException, DataNotFoundException ;
    public void blockOrEnable(Long userId, Boolean active) throws DataNotFoundException;
}
