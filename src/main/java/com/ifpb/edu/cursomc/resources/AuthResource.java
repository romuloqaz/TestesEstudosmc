package com.ifpb.edu.cursomc.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifpb.edu.cursomc.security.JWTUtil;
import com.ifpb.edu.cursomc.security.UserSS;
import com.ifpb.edu.cursomc.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private JWTUtil jwtUtil;

	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());//pega usuario logado
		response.addHeader("Authorization", "Bearer " + token);//adiciona novo token na resposta da requisiçao
		return ResponseEntity.noContent().build();
	}
}
