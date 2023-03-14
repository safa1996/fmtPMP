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

import com.fmt.pmp.fmtPMP.Model.Itemticono;
import com.fmt.pmp.fmtPMP.Service.ItemticonoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class ItemticonoController {
	@Autowired
	private ItemticonoService ItemticonoService;

	@GetMapping("Itemticono")
	public ResponseEntity<Itemticono> getItemticonoById(@RequestParam("id") String id) {
		Itemticono Itemticono = ItemticonoService.getItemticonoById(Integer.parseInt(id));
		return new ResponseEntity<Itemticono>(Itemticono, HttpStatus.OK);
	}

	@GetMapping("all-Itemticonos")
	public ResponseEntity<List<Itemticono>> getAllItemticonos() {
		List<Itemticono> list = ItemticonoService.getAllItemticonos();
		return new ResponseEntity<List<Itemticono>>(list, HttpStatus.OK);
	}

	@GetMapping("Itemticonos-By-pmp")
	public ResponseEntity<List<Itemticono>> getItemtextesByPmp(@RequestParam("id") int id) {
		List<Itemticono> list = ItemticonoService.getItemIconoByPmp(id);
		return new ResponseEntity<List<Itemticono>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/Itemticono", method = RequestMethod.POST)
	public Itemticono createItemticono(@RequestBody Itemticono discipline) {

		return (ItemticonoService.createItemticono(discipline));
	}

	@PutMapping("Itemticono")
	public ResponseEntity<Itemticono> updateItemticono(@RequestBody Itemticono Itemticono) {
		ItemticonoService.updateItemticono(Itemticono);
		return new ResponseEntity<Itemticono>(Itemticono, HttpStatus.OK);
	}

	@DeleteMapping("Itemticono")
	public String deleteItemticono(@RequestParam("id") String id) {
		Itemticono itemIcono = ItemticonoService.getItemticonoById(Integer.parseInt(id));
		if (itemIcono == null) {
			throw new RuntimeException("Itemtexte Id not found");
		}
		ItemticonoService.deleteItemticono(Integer.parseInt(id));
		return "deleted Itemtexte id " + id;

	}

}
