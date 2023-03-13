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

import com.fmt.pmp.fmtPMP.Model.Bonus;
import com.fmt.pmp.fmtPMP.Service.BonusService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class BonusController {
	@Autowired
	private BonusService BonusService;

	@GetMapping("Bonus")
	public ResponseEntity<Bonus> getBonusById(@RequestParam("id") String id) {
		Bonus Bonus = BonusService.getBonusById(Integer.parseInt(id));
		return new ResponseEntity<Bonus>(Bonus, HttpStatus.OK);
	}

	@GetMapping("all-Bonuss")
	public ResponseEntity<List<Bonus>> getAllBonuss() {
		List<Bonus> list = BonusService.getAllBonuss();
		return new ResponseEntity<List<Bonus>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/Bonus", method = RequestMethod.POST)
	public Bonus addTransaction(@RequestBody Bonus Bonus) {

		return (BonusService.createBonus(Bonus));
	}

	@PutMapping("Bonus")
	public ResponseEntity<Bonus> updateBonus(@RequestBody Bonus Bonus) {
		BonusService.updateBonus(Bonus);
		return new ResponseEntity<Bonus>(Bonus, HttpStatus.OK);
	}

	@DeleteMapping("Bonus")
	public String deleteBonus(@RequestParam("id") String id) {
		Bonus Bonus = BonusService.getBonusById(Integer.parseInt(id));
		if (Bonus == null) {
			throw new RuntimeException("Bonus Id not found");
		}
		BonusService.deleteBonus(Integer.parseInt(id));
		return "deleted Bonus id " + id;

	}
}
