package com.Antoine.Jerry.Spring.Security.App.request;

import com.Antoine.Jerry.Spring.Security.App.model.Role;
import lombok.Data;

@Data
public class UserRegistrationRequest {

    private String username;

    private String password;

    public Role role;
}
