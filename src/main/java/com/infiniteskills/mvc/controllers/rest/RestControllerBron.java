/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;

import static com.infiniteskills.mvc.controllers.rest.RestControllerBron._PATH45;
import com.infiniteskills.mvc.entity.Bron;
import com.infiniteskills.mvc.entity.Progivanie;
import com.infiniteskills.mvc.repository.BronRepository;
import com.infiniteskills.mvc.repository.ProgivanieRepository;
import java.util.List;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Юыху
 */
@RestController
@RequestMapping(path = _PATH45,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerBron {
    public static final String _PATH45 = "/restbron";
    public static final String ITEM_PATH = "/item";
    
     private BronRepository uService;
     private ProgivanieRepository progService;
     
    @Autowired(required = false)
    public void setService(BronRepository uService) {
        this.uService = uService;
    }
    
    @Autowired(required = false)
    public void setProgService(ProgivanieRepository uService) {
        this.progService = uService;
    }
     
    @RequestMapping(value = "/restbronparam", method = RequestMethod.GET)
    public List<Bron> getUnitByParam(@RequestParam(value = "idorg") int idorg) {
        return uService.getBronByIdOrg(idorg);
    }
    
    
     @RequestMapping(method = RequestMethod.GET)
    public List<Bron> getUnitList() {
        return uService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Bron createU(@RequestBody Bron zav) {
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Bron updateU(@RequestBody Bron zav) {
        if  (zav.getClosed()==1) 
        {
            Progivanie prog = new Progivanie();
            prog.setIdclient(zav.getIdclient());
            prog.setDatein(zav.getDateb());
            prog.setDateout(zav.getDatee());
            prog.setIdnomer(zav.getIdnomer());
            progService.create(prog);
            
        
        }
        
        return uService.update(zav);
    }
    
   
    

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteU(@RequestBody Bron zav) {
        
        uService.delete(zav);
    }
    
    
}
