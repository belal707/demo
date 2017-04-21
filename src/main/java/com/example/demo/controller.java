package com.example.demo;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class controller {

	@RequestMapping(value="/", method=RequestMethod.POST)
	public Demo create(KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal, @RequestBody Demo demo)
	{
		String email = principal.getKeycloakSecurityContext().getToken().getEmail();
		demo.setEmail(email);
		return demo;
	}
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String get(KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal)
	{
		String email = principal.getKeycloakSecurityContext().getToken().getEmail();
		return email;
	}
}
