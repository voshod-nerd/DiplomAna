package com.infiniteskills.mvc.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.infiniteskills.mvc.helpclasses.Data;






@RestController
public class AngularController {

@RequestMapping(path="/isfree",method=RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Data> isFreeNumber(@RequestBody Data dat) {
System.out.println("All in ass");	
return new ResponseEntity<Data>(dat, HttpStatus.OK);

}



	
	
}
