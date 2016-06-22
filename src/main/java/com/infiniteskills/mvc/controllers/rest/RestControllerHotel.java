/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;


import static com.infiniteskills.mvc.controllers.rest.RestControllerHotel._PATH99;
import com.infiniteskills.mvc.entity.Hotel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infiniteskills.mvc.repository.HotelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author Юыху
 */

@RestController
@RequestMapping(path = _PATH99,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerHotel {
    public static final String _PATH99 = "/resthotel";
    public static final String ITEM_PATH = "/item";
    
     private HotelRepository uService;
     
    @Autowired(required = false)
    public void setService(HotelRepository uService) {
        this.uService = uService;
    }
     
    
     @RequestMapping(method = RequestMethod.GET)
    public List<Hotel> getUnitList() {
        return uService.findAll();
    }
    
    
    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Hotel createU(@RequestBody Hotel zav) {
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Hotel updateU(@RequestBody Hotel zav) {
        System.out.println("I am here");
        return uService.update(zav);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteU(@RequestBody Hotel zav) {
        uService.delete(zav);
    }
    
    
}
