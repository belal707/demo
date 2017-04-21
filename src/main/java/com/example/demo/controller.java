package com.example.demo;

import java.util.List;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class controller {
	
	@Autowired
	DemoRepo demorepo;

	@RequestMapping(value="/", method=RequestMethod.POST)
	public Demo create(KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal, @RequestBody Demo demo)
	{
		String email = principal.getKeycloakSecurityContext().getToken().getEmail();
		demo.setEmail(email);
		demorepo.save(demo);
		return demo;
	}
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<Demo> get(KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal)
	{
		String email = principal.getKeycloakSecurityContext().getToken().getEmail();
		return demorepo.findAll();
	}
}
