package com.teophiloribeiro.curso.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.teophiloribeiro.curso.dto.EmailDTO;
import com.teophiloribeiro.curso.security.JWTUtil;
import com.teophiloribeiro.curso.security.UserSS;
import com.teophiloribeiro.curso.services.AuthService;
import com.teophiloribeiro.curso.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService service;

    @RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {

        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.POST)
    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) {

        service.sendNewPassword(objDto.getEmail());
        return ResponseEntity.noContent().build();
    }
}
