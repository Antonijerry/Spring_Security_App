package com.Antoine.Jerry.Spring.Security.App.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthenticationRequest {
    String username;
    String password;
}
