package com.cybersecure.tokenbasedapi.service;

import com.cybersecure.tokenbasedapi.dtos.RegisterDto;
import com.cybersecure.tokenbasedapi.exceptions.ItemExistsAlreadyException;
import com.cybersecure.tokenbasedapi.models.Role;
import com.cybersecure.tokenbasedapi.models.User;
import com.cybersecure.tokenbasedapi.repository.RoleRepository;
import com.cybersecure.tokenbasedapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder bcryptEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder bcryptEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bcryptEncoder = bcryptEncoder;
    }

    @Override
    public String createUser(RegisterDto registerDto) {
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new ItemExistsAlreadyException("User is already registered with username " + registerDto.getUsername());
        }
        User newUser = new User();
        BeanUtils.copyProperties(registerDto, newUser);
        newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
        if(newUser.getName().contains("_admin")){
            Role roles = roleRepository.findByName("ROLE_ADMIN").get();
            newUser.setRoles(Collections.singletonList(roles));
        }
        else{
            Role roles = roleRepository.findByName("ROLE_USER").get();
            newUser.setRoles(Collections.singletonList(roles));
        }
        userRepository.save(newUser);
        return "Successfully Created User";
    }

    @Override
    public User getLoggedInUser() {
        return null;
    }
}
