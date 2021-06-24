package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.BUser;
import kz.bcc.tutorial.balatime.repository.BUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BUserService implements UserDetailsService {

    @Autowired
    BUserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // Get Information about user by login or email
        BUser userObject = userRepository.findByLoginIgnoreCase(login);

        // User object by spring security which we need to return for spring security
        User userSecurity = new User(userObject.getLogin(), userObject.getPassword(), new ArrayList<>());

        return userSecurity;
    }

}
