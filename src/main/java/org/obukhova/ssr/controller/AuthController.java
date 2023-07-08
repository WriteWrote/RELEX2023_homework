package org.obukhova.ssr.controller;

import org.obukhova.ssr.model.dto.AuthResponseDTO;
import org.obukhova.ssr.model.dto.LoginDto;
import org.obukhova.ssr.model.dto.RegisterDto;
import org.obukhova.ssr.model.entity.RoleEntity;
import org.obukhova.ssr.model.entity.UserEntity;
import org.obukhova.ssr.repository.RoleRepository;
import org.obukhova.ssr.repository.UserRepository;
import org.obukhova.ssr.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));


        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);

        return ResponseEntity.ok()
                .header("Server message","Login succeeded")
                .body(new AuthResponseDTO(token));
    }

    @PostMapping("register")
    public ResponseEntity<UserEntity> register(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByUserName(registerDto.getUsername())) {
            return ResponseEntity.badRequest()
                    .header("Server message", "Username is taken")
                    .build();
        }

        UserEntity user = new UserEntity();
        user.setUserName(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));

        RoleEntity roles = roleRepository.findByRoleName("USER").get();
        user.setUserRoles(Collections.singletonList(roles));

        userRepository.save(user);

        return ResponseEntity.ok()
                .header("Server message", "User registered successfully")
                .body(user);
    }
}
