package com.fmt.pmp.fmtPMP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fmt.pmp.fmtPMP.Model.Pmp;
import com.fmt.pmp.fmtPMP.Service.PmpService;

@RestController  
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")  
public class PmpController {
	@Autowired
	private PmpService PmpService;
	@GetMapping("Pmp")
	public ResponseEntity<Pmp> getPmpById(@RequestParam("id") String id) {
		Pmp Pmp = PmpService.getPmpById(Integer.parseInt(id));
		return new ResponseEntity<Pmp>(Pmp, HttpStatus.OK);
	}
	@GetMapping("all-Pmps")
	public ResponseEntity<List<Pmp>> getAllPmps() {
		List<Pmp> list = PmpService.getAllPmps();
		return new ResponseEntity<List<Pmp>>(list, HttpStatus.OK);
	}
	@PostMapping("Pmp")
	public ResponseEntity<Void> createPmp(@RequestBody Pmp Pmp, UriComponentsBuilder builder) {
        boolean flag = PmpService.createPmp(Pmp);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/Pmp?id={id}").buildAndExpand(Pmp.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("Pmp")
	public ResponseEntity<Pmp> updatePmp(@RequestBody Pmp Pmp) {
		PmpService.updatePmp(Pmp);
		return new ResponseEntity<Pmp>(Pmp, HttpStatus.OK);
	}
	@DeleteMapping("Pmp")
	public ResponseEntity<Void> deletePmp(@RequestParam("id") String id) {
		PmpService.deletePmp(Integer.parseInt(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
