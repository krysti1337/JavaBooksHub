package com.example.JavaBooksHub.security;

import com.example.JavaBooksHub.model.ERole;
import com.example.JavaBooksHub.model.Role;
import com.example.JavaBooksHub.model.User;
import com.example.JavaBooksHub.repository.RoleRepository;
import com.example.JavaBooksHub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(String username, String email, String password) {

        //Verificam daca este deja user cu acest nume sau email
        if (userRepository.existsByUsername(username)) {
            return "Error: Username is already exist!";
        }

        if (userRepository.existsByEmail(email)) {
            return "Error: Email is already in use!";
        }

        //Cream user-ul
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));


        //Setam rolul : ROLE_USER
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role not found."));
        user.setRoles(Set.of(userRole));

        userRepository.save(user);
        return "User registered successfully!";
    }

    public boolean authenticateUser(String username, String rawPassword) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return passwordEncoder.matches(rawPassword, user.getPassword());
        }
        return false;
    }
}

