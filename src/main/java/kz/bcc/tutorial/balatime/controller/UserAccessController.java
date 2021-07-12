package kz.bcc.tutorial.balatime.controller;

import com.google.gson.Gson;
import kz.bcc.tutorial.balatime.model.BUser;
import kz.bcc.tutorial.balatime.service.impl.BUserServiceAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserAccessController {

    @Autowired
    private BUserServiceAccess userServiceAccess;

    @PostMapping("/login")
    @CrossOrigin(origins = {"http://localhost:4300", "http://localhost:4200"})
    public BUser loginUser(@RequestBody BUser user) throws Exception {
        return userServiceAccess.findByLoginIgnoreCase(user.getLogin());
    }

    @PostMapping("/registration")
    @CrossOrigin(origins = {"http://localhost:4300", "http://localhost:4200"})
    public BUser registrationUser(@RequestBody BUser user) throws Exception {
        return userServiceAccess.registrationUser(user);
    }

    @GetMapping("/current")
    public ResponseEntity<String> getCurrent1(Principal principal) {
        System.out.println("Current User");
        System.out.println(principal);
        return ResponseEntity.ok(new Gson().toJson(principal));
    }
}
