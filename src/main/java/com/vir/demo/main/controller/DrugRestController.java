package com.vir.demo.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vir.demo.main.Service.FetchFromDBService;

@RestController
@Component
public class DrugRestController {
	
	
	
	@Autowired
   private FetchFromDBService fetchFromDBService;
	
	@RequestMapping(value="/dbresponse")
	public String showSampleText(){
		System.out.println(fetchFromDBService.getDrugInfo());
		return  "DB Response - Name List = "+ fetchFromDBService.getDrugInfo(); 
	}

	@RequestMapping(value="/")
	public String showText(){
		return  "Welcome to drug web app...!"; 
	}
	
	
}
