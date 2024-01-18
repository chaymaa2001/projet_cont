package com.example.taxe.Controller;

import java.util.List;
import java.util.Optional;

import com.example.taxe.Service.TaxeTnbService;
import com.example.taxe.entities.TaxeTnb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/TaxeTnb")
public class TaxeTnbController {
	@Autowired
	TaxeTnbService taxetnbService;

	@PostMapping("/save")
	public <S extends TaxeTnb> S save(@RequestBody S entity) {
		return taxetnbService.save(entity);
	}

	@GetMapping("/findAll")
	public List<TaxeTnb> findAll() {
		return taxetnbService.findAll();
	}

	@GetMapping("/findById/{id}")
	public Optional<TaxeTnb> findById(@PathVariable Integer id) {
		return taxetnbService.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		taxetnbService.deleteById(id);
	}
	
	@GetMapping("/findByProprietaireCIN/{CIN}")
    public ResponseEntity<List<TaxeTnb>> findTaxeTnbByProprietaireCIN(@PathVariable String CIN) {
        List<TaxeTnb> TaxeTnbList = taxetnbService.findTaxeTnbByProprietaireCIN(CIN);
        return ResponseEntity.ok(TaxeTnbList);
    }
	
	
}
