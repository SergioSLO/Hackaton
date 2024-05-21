package com.example.Reservas.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public UserDetailsService userDetailsService() {
        return username -> studentRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


}
