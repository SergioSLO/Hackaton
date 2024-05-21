package com.example.demo.Auth;

import com.example.demo.Auth.dtos.AuthJwtResponse;
import com.example.demo.Auth.dtos.AuthLoginRequest;
import com.example.demo.Auth.dtos.AuthRegisterRequest;
import com.example.demo.Auth.exceptions.UserAlreadyExistException;
import com.example.demo.Config.JwtService;
import com.example.demo.Student.Role;
import com.example.demo.Student.Student;
import com.example.demo.Student.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {
    final StudentRepository userRepository;
    final JwtService jwtService;
    final PasswordEncoder passwordEncoder;
    final ModelMapper modelMapper;

    @Autowired
    public AuthService(StudentRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }


    public AuthJwtResponse login(AuthLoginRequest req) {
        Optional<Student> user = userRepository.findByEmail(req.getEmail());

        if (user.isEmpty()) throw new UsernameNotFoundException("Email is not registered");

        if (!passwordEncoder.matches(req.getPassword(), user.get().getPassword()))
            throw new IllegalArgumentException("Password is incorrect");

        AuthJwtResponse response = new AuthJwtResponse();

        response.setToken(jwtService.generateToken(user.get()));
        return response;
    }

    public AuthJwtResponse register(AuthRegisterRequest req) {
        Optional<Student> user = userRepository.findByEmail(req.getEmail());
        if (user.isPresent()) throw new UserAlreadyExistException("Email is already registered");

        Student newUser = modelMapper.map(req, Student.class);
        newUser.setPassword(passwordEncoder.encode(req.getPassword()));


        if(req.getIsAdmin()) newUser.setRole(Role.ADMIN);
        else newUser.setRole(Role.USER);

        userRepository.save(newUser);

        AuthJwtResponse response = new AuthJwtResponse();
        response.setToken(jwtService.generateToken(newUser));
        return response;
    }

}
