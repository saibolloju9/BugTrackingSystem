package com.project.bugtrackingsystem.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.bugtrackingsystem.dto.UserDTO;

public interface UserService {

	// To get all registered users from developer and testEngineer
	Page<UserDTO> getAllUsers(Pageable pageable);

    // Signs in a user with the provided username and password.
    UserDTO signIn(String userName, String password);

    // Signs out the currently authenticated user.
    String signOut();
}
