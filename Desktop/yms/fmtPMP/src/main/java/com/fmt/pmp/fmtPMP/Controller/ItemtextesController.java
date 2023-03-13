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

import com.fmt.pmp.fmtPMP.Model.Itemtextes;
import com.fmt.pmp.fmtPMP.Service.ItemtextesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class ItemtextesController {
	@Autowired
	private ItemtextesService ItemtextesService;

	@GetMapping("Itemtexte")
	public ResponseEntity<Itemtextes> getItemtextesById(@RequestParam("id") String id) {
		Itemtextes Itemtextes = ItemtextesService.getItemtextesById(Integer.parseInt(id));
		return new ResponseEntity<Itemtextes>(Itemtextes, HttpStatus.OK);
	}

	@GetMapping("all-Itemtextes")
	public ResponseEntity<List<Itemtextes>> getAllItemtextess() {
		List<Itemtextes> list = ItemtextesService.getAllItemtextess();
		return new ResponseEntity<List<Itemtextes>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/Itemtexte", method = RequestMethod.POST)
	public Itemtextes createItemtextes(@RequestBody Itemtextes discipline) {

		return (ItemtextesService.createItemtextes(discipline));
	}

	@PutMapping("Itemtexte")
	public ResponseEntity<Itemtextes> updateItemtextes(@RequestBody Itemtextes Itemtextes) {
		ItemtextesService.updateItemtextes(Itemtextes);
		return new ResponseEntity<Itemtextes>(Itemtextes, HttpStatus.OK);
	}

	@DeleteMapping("Itemtexte")
	public String deleteItemtextes(@RequestParam("id") String id) {
		Itemtextes itemtexte = ItemtextesService.getItemtextesById(Integer.parseInt(id));
		if (itemtexte == null) {
			throw new RuntimeException("Itemtexte Id not found");
		}
		ItemtextesService.deleteItemtextes(Integer.parseInt(id));
		return "deleted Itemtexte id " + id;

	}

}
