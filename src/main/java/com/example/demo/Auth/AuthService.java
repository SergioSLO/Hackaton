package com.example.demo.Auth;

import com.example.demo.Auth.dtos.AuthJwtResponse;
import com.example.demo.Auth.dtos.AuthLoginRequest;
import com.example.demo.Auth.dtos.AuthRegisterRequest;
import com.example.demo.Auth.exceptions.UserAlreadyExistException;
import com.example.demo.Config.JwtService;
import com.example.demo.Usuario.Domain.Role;
import com.example.demo.Usuario.Domain.Usuario;
import com.example.demo.Usuario.Infraestructure.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    final UsuarioRepository usuarioRepository;
    final JwtService jwtService;
    final PasswordEncoder passwordEncoder;
    final ModelMapper modelMapper;

    @Autowired
    public AuthService(UsuarioRepository usuarioRepository, JwtService jwtService, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }


    public AuthJwtResponse login(AuthLoginRequest req) {
        Optional<Usuario> user = usuarioRepository.findByEmail(req.getEmail());

        if (user.isEmpty()) throw new UsernameNotFoundException("Email is not registered");

        if (!passwordEncoder.matches(req.getPassword(), user.get().getPassword()))
            throw new IllegalArgumentException("Password is incorrect");

        AuthJwtResponse response = new AuthJwtResponse();

        response.setToken(jwtService.generateToken(user.get()));
        return response;
    }

    public AuthJwtResponse register(AuthRegisterRequest req) {
        Optional<Usuario> user = usuarioRepository.findByEmail(req.getEmail());
        if (user.isPresent()) throw new UserAlreadyExistException("Email is already registered");

        Usuario newUsuario = modelMapper.map(req, Usuario.class);
        newUsuario.setPassword(passwordEncoder.encode(req.getPassword()));


        if(req.getIsAdmin()) newUsuario.setRole(Role.ADMIN);
        else newUsuario.setRole(Role.USER);

        usuarioRepository.save(newUsuario);

        AuthJwtResponse response = new AuthJwtResponse();
        response.setToken(jwtService.generateToken(newUsuario));
        return response;
    }

}
