package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.UserDTO;
import com.project.bugtrackingsystem.entity.User;
import com.project.bugtrackingsystem.exception.UserNotAvailableException;
import com.project.bugtrackingsystem.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Displays registered users from developer and testEngineer
    @Override
    public Page<UserDTO> getAllUsers(Pageable pageable) {
    	Page<User> userEntities = userRepository.findAll(pageable);
    	
    	Page<UserDTO> userDtoPage = userEntities.map(user-> modelMapper.map(user, UserDTO.class));
		return userDtoPage;
    }

    // Signs in a user with the provided username and password
    @Override
    public UserDTO signIn(String userName, String password) throws UserNotAvailableException {
        User userEntity = userRepository.findByUserNameAndUserPassword(userName, password);
 
        if (userEntity != null) {
            return modelMapper.map(userEntity, UserDTO.class);
        } else {
            throw new UserNotAvailableException("User not found or authentication failed for username: " + userName);
        }
    }

    // Signs out the currently authenticated user
    @Override
    public String signOut() {
        // Return a message or status indicating the sign-out action was successful
        return "User signed out successfully";
    }
}
