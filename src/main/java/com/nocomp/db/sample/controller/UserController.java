package com.nocomp.db.sample.controller;

import com.nocomp.db.sample.model.User;
import com.nocomp.db.sample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path="/sample")
@CrossOrigin(origins = "http://localhost:24201")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public @ResponseBody Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public @ResponseBody long addUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        log.info("Created user id: {}", savedUser.getId());
        return savedUser.getId();
    }
}
