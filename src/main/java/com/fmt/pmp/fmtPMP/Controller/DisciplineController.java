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

import com.fmt.pmp.fmtPMP.Model.Discipline;
import com.fmt.pmp.fmtPMP.Service.DisciplineService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class DisciplineController {
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

	@RequestMapping(value = "/Discipline", method = RequestMethod.POST)
	public Discipline addTransaction(@RequestBody Discipline discipline) {

		return (DisciplineService.createDiscipline(discipline));
	}

	@PutMapping("Discipline")
	public ResponseEntity<Discipline> updateDiscipline(@RequestBody Discipline Discipline) {
		DisciplineService.updateDiscipline(Discipline);
		return new ResponseEntity<Discipline>(Discipline, HttpStatus.OK);
	}

	@DeleteMapping("Discipline")
    public String deleteDiscipline(@RequestParam("id") String id){
    	Discipline discipline = DisciplineService.getDisciplineById(Integer.parseInt(id));
        if(discipline == null){
            throw new RuntimeException("Discipline Id not found");
        }
        DisciplineService.deleteDiscipline(Integer.parseInt(id));
        return "deleted Discipline id " + id;

    }

}
