package com.cybersecure.tokenbasedapi.service;

import com.cybersecure.tokenbasedapi.dtos.RegisterDto;
import com.cybersecure.tokenbasedapi.models.User;

public interface UserService {
    public String createUser(RegisterDto user);
    public User getLoggedInUser();
}
