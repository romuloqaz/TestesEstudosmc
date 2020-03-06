package com.ifpb.edu.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.ifpb.edu.cursomc.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();//returna usuario logado
		}
		catch (Exception e) {
			return null;
		}
	}

}
