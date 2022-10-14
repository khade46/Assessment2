package com.user;

import com.user.repository.UserRepository;
import com.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp()
    {
        this.userService
                = new UserService(this.userRepository);
    }

    @Test
    void findAllUser()
    {
        userService.findAllUser();
        verify(userRepository).findAll();
    }
}
