package kz.bcc.tutorial.balatime.service.impl;

import kz.bcc.tutorial.balatime.model.BUser;
import kz.bcc.tutorial.balatime.repository.BUserRepository;
import kz.bcc.tutorial.balatime.service.IBUserServiceAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BUserServiceAccess implements IBUserServiceAccess {

    @Autowired
    private BUserRepository userRepository;


    @Override
    public BUser findByLoginIgnoreCase(String login) throws Exception {
        BUser userObj = userRepository.findByLoginIgnoreCase(login);

        if (userObj != null) {
            return userObj;
        } else {
            throw new Exception("User Access Exception");
        }
    }

    @Override
    public BUser registrationUser(BUser user) throws Exception {

        if (user.getLogin() == null || user.getPassword() == null) {
            throw new Exception("User Access Exception");
        }

        BUser userObj = userRepository.findByLoginIgnoreCase(user.getLogin());
        if (userObj != null) {
            throw new Exception("User registered before");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String encodingPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodingPassword);

        return userRepository.save(user);
    }

}
