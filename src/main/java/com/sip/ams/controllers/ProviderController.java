package com.sip.ams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Provider;
import com.sip.ams.services.ProviderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/providers")
@Slf4j

@CrossOrigin("*")
public class ProviderController {
	@Autowired
	ProviderService providerService;
	
	@GetMapping("/all")
	public List<Provider> findAllProvider(){
		log.info("provider test Log Info");
		
		return providerService.findAllProvider();
	}
	
	
	@PostMapping("/add")
	public Provider addProvider(@RequestBody Provider provider){
		log.info("provider Add ");
		
		return providerService.saveProvider(provider);
	}
	
	
	@GetMapping("/{id}")
	public Provider getProviderByID(@PathVariable("id")Long id){
		log.info("provider Find by id");
		
		return providerService.findProviderById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id")Long id){
		log.info("provider deleted by id");
		
		providerService.DeleteProviderById(id);
	}
	
	
	@PutMapping("/put/{id}")
	public void UpdateProvider(@PathVariable("id")Long id,@RequestBody Provider newProvider){
		log.info("provider Updated");
		
		providerService.UpdateProviderById(id,newProvider);
	}
	
	
	
	
	

}
