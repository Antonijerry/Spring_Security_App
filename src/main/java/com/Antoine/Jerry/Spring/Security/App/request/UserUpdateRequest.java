package com.Antoine.Jerry.Spring.Security.App.request;


import com.Antoine.Jerry.Spring.Security.App.model.Role;
import lombok.Data;

@Data
public class UserUpdateRequest {

    public String username;
    public String password;
    public Role role;
}
