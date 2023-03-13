package com.fmt.pmp.fmtPMP.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestAPIs {
	
	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/enseignant")
	@PreAuthorize("hasRole('ENSEIGNANT')")
	public String projectManagementAccess() {
		return ">>> Board enseignant";
	}
	
	@GetMapping("/api/test/etudiant")
	@PreAuthorize("hasRole('ETUDIANT')")
	public String adminAccess() {
		return ">>> Etudiant";
	}
}