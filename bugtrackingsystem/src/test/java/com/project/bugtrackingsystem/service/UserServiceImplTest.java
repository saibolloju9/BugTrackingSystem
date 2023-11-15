package com.project.bugtrackingsystem.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.project.bugtrackingsystem.dto.UserDTO;
import com.project.bugtrackingsystem.entity.User;
import com.project.bugtrackingsystem.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testSignIn() {
        // Arrange
        String userName = "testUser";
        String password = "testPassword";
        UserDTO userDTO = new UserDTO();
        User userEntity = new User();
        when(userRepository.findByUserNameAndUserPassword(userName, password)).thenReturn(userEntity);
        when(modelMapper.map(userEntity, UserDTO.class)).thenReturn(userDTO);

        // Act
        UserDTO result = userService.signIn(userName, password);

        // Assert
        assertEquals(userDTO, result);
        verify(userRepository).findByUserNameAndUserPassword(userName, password);
        verify(modelMapper).map(userEntity, UserDTO.class);
    }

    @Test
    void testSignOut() {
        // Act
        String result = userService.signOut();

        // Assert
        assertEquals("User signed out successfully", result);
        // Add additional assertions based on your specific sign-out logic
    }
}

