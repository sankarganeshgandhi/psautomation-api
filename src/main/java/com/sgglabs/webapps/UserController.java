package com.sgglabs.webapps;

import com.sgglabs.webapps.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for all Task related operations
 *
 * @author Sankarganesh Gandhi (sankarganesh.gandhi@gmail.com)
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepo;

    /**
     * Get all tasks
     * @return
     */
    @GetMapping
    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        for (User user : userRepo.findAll()) {
            usersList.add(user);
        }
        return usersList;
    }
}