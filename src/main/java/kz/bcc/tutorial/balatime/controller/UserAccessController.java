package kz.bcc.tutorial.balatime.controller;

import kz.bcc.tutorial.balatime.model.BUser;
import kz.bcc.tutorial.balatime.service.impl.BUserServiceAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccessController {

    @Autowired
    private BUserServiceAccess userServiceAccess;


//    @PostMapping("/login")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public BUser loginUserA(@RequestBody BUser user) throws Exception {
//        return userServiceAccess.findByLoginIgnoreCase(user.getLogin());
//    }
//
//    @PostMapping("/registration")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public BUser registrationUserA(@RequestBody BUser user) throws Exception {
//        return userServiceAccess.registrationUser(user);
//    }
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4300")
    public BUser loginUser(@RequestBody BUser user) throws Exception {
        return userServiceAccess.findByLoginIgnoreCase(user.getLogin());
    }

    @PostMapping("/registration")
    @CrossOrigin(origins = "http://localhost:4300")
    public BUser registrationUser(@RequestBody BUser user) throws Exception {
        return userServiceAccess.registrationUser(user);
    }
}
