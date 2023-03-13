package com.fmt.pmp.fmtPMP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fmt.pmp.fmtPMP.Model.Reponse;
import com.fmt.pmp.fmtPMP.Service.ReponseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class ReponseController {
	@Autowired
	private ReponseService ReponseService;

	@GetMapping("Reponse")
	public ResponseEntity<Reponse> getReponseById(@RequestParam("id") String id) {
		Reponse Reponse = ReponseService.getReponseById(Integer.parseInt(id));
		return new ResponseEntity<Reponse>(Reponse, HttpStatus.OK);
	}

	@GetMapping("all-Reponses")
	public ResponseEntity<List<Reponse>> getAllReponses() {
		List<Reponse> list = ReponseService.getAllReponses();
		return new ResponseEntity<List<Reponse>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/Reponse", method = RequestMethod.POST)
	public Reponse addTransaction(@RequestBody Reponse Reponse) {

		return (ReponseService.createReponse(Reponse));
	}

	@PutMapping("Reponse")
	public ResponseEntity<Reponse> updateReponse(@RequestBody Reponse Reponse) {
		ReponseService.updateReponse(Reponse);
		return new ResponseEntity<Reponse>(Reponse, HttpStatus.OK);
	}

	@DeleteMapping("Reponse")
	public String deleteReponse(@RequestParam("id") String id) {
		Reponse Reponse = ReponseService.getReponseById(Integer.parseInt(id));
		if (Reponse == null) {
			throw new RuntimeException("Reponse Id not found");
		}
		ReponseService.deleteReponse(Integer.parseInt(id));
		return "deleted Reponse id " + id;

	}
}
