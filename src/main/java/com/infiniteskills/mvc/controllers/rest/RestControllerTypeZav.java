/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;


import static com.infiniteskills.mvc.controllers.rest.RestControllerTypeZav._PATH19;
import com.infiniteskills.mvc.entity.Typeza;
import com.infiniteskills.mvc.repository.TypeZayavkaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Юыху
 */
@RestController
@RequestMapping(path = _PATH19,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerTypeZav {
    public static final String _PATH19 = "/resttypezav";
    public static final String ITEM_PATH = "/item";
    
     private TypeZayavkaRepository uService;
     
    @Autowired(required = false)
    public void setService(TypeZayavkaRepository uService) {
        this.uService = uService;
    }
     
    
     @RequestMapping(method = RequestMethod.GET)
    public List<Typeza> getUnitList() {
        return uService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Typeza createU(@RequestBody Typeza zav) {
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Typeza updateU(@RequestBody Typeza zav) {
        return uService.update(zav);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteU(@RequestBody Typeza zav) {
        uService.delete(zav);
    }
}
