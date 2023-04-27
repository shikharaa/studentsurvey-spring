//creating endpoints for accessing and submit the data from student survey form

package com.swe645.swehw3;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class Swehw3Controller {
	
	@Autowired
	public Swehw3Repository hw3r;
	
	//This mapping is used for creating get endpoint
	@GetMapping("/getAllSurveys")
	public List<Swehw3Model> getAllSurveys() {
		return hw3r.findAll();
	}
	
	//This mapping is used for creating post endpoint
	
	@PostMapping("/submitSurvey")
	public void submitSurvey(@RequestBody Swehw3Model model) {
		hw3r.save(model);
	}
		
}
