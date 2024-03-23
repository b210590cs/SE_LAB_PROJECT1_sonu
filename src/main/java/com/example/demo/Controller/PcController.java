package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Pc;
import com.example.demo.Service.PcService;

@RestController
public class PcController {

	
	@Autowired
    private PcService pcService;
	
	@PostMapping("/addPcEntity")
	public Pc postDetails(@RequestBody Pc pc)
	{
		return pcService.saveDetails(pc);
	}

}
