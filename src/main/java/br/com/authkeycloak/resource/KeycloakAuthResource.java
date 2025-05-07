package br.com.authkeycloak.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.core.Response;

public class KeycloakAuthResource {

	@GET
	@RolesAllowed("AUTH-KEYCLOAK")
	public Response hello() {
		return Response.ok("Hello, keycloak authentication check!").build();
	}
}
