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

import com.fmt.pmp.fmtPMP.Model.Discipline;
import com.fmt.pmp.fmtPMP.Service.DisciplineService;


@RestController  
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")  
public class DisciplineController{
	@Autowired
	private DisciplineService DisciplineService;
	@GetMapping("Discipline")
	public ResponseEntity<Discipline> getDisciplineById(@RequestParam("id") String id) {
		Discipline Discipline = DisciplineService.getDisciplineById(Integer.parseInt(id));
		return new ResponseEntity<Discipline>(Discipline, HttpStatus.OK);
	}
	@GetMapping("all-Disciplines")
	public ResponseEntity<List<Discipline>> getAllDisciplines() {
		List<Discipline> list = DisciplineService.getAllDisciplines();
		return new ResponseEntity<List<Discipline>>(list, HttpStatus.OK);
	}
	@PostMapping("Discipline")
	public ResponseEntity<Void> createDiscipline(@RequestBody Discipline Discipline, UriComponentsBuilder builder) {
        boolean flag = DisciplineService.createDiscipline(Discipline);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/Discipline?id={id}").buildAndExpand(Discipline.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("Discipline")
	public ResponseEntity<Discipline> updateDiscipline(@RequestBody Discipline Discipline) {
		DisciplineService.updateDiscipline(Discipline);
		return new ResponseEntity<Discipline>(Discipline, HttpStatus.OK);
	}
	@DeleteMapping("Discipline")
	public ResponseEntity<Void> deleteDiscipline(@RequestParam("id") String id) {
		DisciplineService.deleteDiscipline(Integer.parseInt(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	

}
