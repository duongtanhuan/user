package com.supportportal.listener;

import com.supportportal.domain.User;
import com.supportportal.domain.UserPrincipal;
import com.supportportal.service.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationAccessListener {
    private LoginAttemptService loginAttemptService;

    @Autowired
    public AuthenticationAccessListener(LoginAttemptService loginAttemptService) {
        this.loginAttemptService = loginAttemptService;
    }

    @EventListener
    public void onAuthenticationSuccess(AuthenticationSuccessEvent event) {
        Object  principal = event.getAuthentication().getPrincipal();
        if (principal instanceof User) {
            UserPrincipal userPrincipal  = (UserPrincipal) event.getAuthentication().getPrincipal();
            loginAttemptService.evictUserFromLoginAttemptCache(userPrincipal.getUsername());
        }
    }
}
