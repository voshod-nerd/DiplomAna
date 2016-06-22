/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;

import static com.infiniteskills.mvc.controllers.rest.RestControllerProgivanie._PATH7;
import com.infiniteskills.mvc.entity.Progivanie;
import com.infiniteskills.mvc.entity.Reestruslug;
import com.infiniteskills.mvc.entity.Stoimostnomera;
import com.infiniteskills.mvc.entity.Stoimostuslug;
import com.infiniteskills.mvc.entity.Tarifz;
import com.infiniteskills.mvc.entity.Typenomerhotel;
import com.infiniteskills.mvc.repository.ProgivanieRepository;
import com.infiniteskills.mvc.repository.ReestrUslugRepository;
import com.infiniteskills.mvc.repository.StoimostNomeraRepository;
import com.infiniteskills.mvc.repository.StoimostUslugRepository;
import com.infiniteskills.mvc.repository.TarifzRepository;
import com.infiniteskills.mvc.repository.TypeNomerHotelRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
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
@RequestMapping(path = _PATH7,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerProgivanie {
    public static final String _PATH7 = "/restprogivanie";
    public static final String ITEM_PATH = "/item";
    
     private ProgivanieRepository uService;
     private  ReestrUslugRepository  ReestService;
     private StoimostUslugRepository uslugService;
     private TarifzRepository tarifService;
      private TypeNomerHotelRepository typenomerService;
        private StoimostNomeraRepository stoimService;
     
    @Autowired(required = false)
    public void setServiceProg(ProgivanieRepository uService) {
        this.uService = uService;
    }
    
     @Autowired(required = false)
    public void setServiceNomer(StoimostNomeraRepository uService) {
        this.stoimService = uService;
    }
    
    
    @Autowired(required = false)
    public void setServiceTypenomer(TypeNomerHotelRepository uService) {
        this.typenomerService = uService;
    }
    
     @Autowired(required = false)
    public void setServiceReest(ReestrUslugRepository uService) {
        this.ReestService = uService;
    }
    
     @Autowired(required = false)
    public void setServiceTarif(TarifzRepository uService) {
        this.tarifService = uService;
    }
    
    
     @Autowired(required = false)
    public void setServiceUslug(StoimostUslugRepository uService) {
        this.uslugService = uService;
    }
     
    
     @RequestMapping(method = RequestMethod.GET)
    public List<Progivanie> getUnitList() {
        
        
        return uService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Progivanie createU(@RequestBody Progivanie zav) {
       Collection<Reestruslug> listUslug= ReestService.getListUslugByIdClient(zav.getIdclient());
       System.out.println("1 step");
        BigDecimal dopsum = new BigDecimal(0.0);
        for (Reestruslug uslug : listUslug)
        {
          Stoimostuslug temp= uslugService.getListUslugByIdUslug(uslug.getIduslug());
        if (temp==null)  continue;
        dopsum.add(temp.getSumma()); 
        }
        System.out.println("2 step");
        zav.setDopusl(dopsum);
        
        Tarifz tarif= tarifService.getTarifByClient(zav.getIdclient());
        System.out.println(tarif.getName());
        System.out.println(zav.getIdnomer());
        Typenomerhotel typenomer=typenomerService.getTypeNomerByIdnomer(zav.getIdnomer());
        Stoimostnomera temp=stoimService.getStoimNomerByNomerAndTarif(tarif.getId(), zav.getIdnomer().getId());
  
        zav.setIdstoimostnomer(temp);
        System.out.println("3 step");
        
        BigInteger  stoimpit =zav.getIdstoimostpit().getSum();
       
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        cal1.setTime(zav.getDateout());
        cal2.setTime(zav.getDatein());
        int days = (int)((cal1.getTimeInMillis()-cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24));
        System.out.println(days);
        
        BigDecimal totalSum = new BigDecimal(0.0);
       
         totalSum=totalSum.add(temp.getSumma());
        
        BigDecimal dayDec = new BigDecimal(days);
        totalSum=totalSum.multiply(dayDec);
        
        
        BigDecimal totalpit = new BigDecimal(0.0);
        
        totalpit=totalpit.add( new BigDecimal(zav.getIdstoimostpit().getSum()));
        totalpit=totalpit.multiply(dayDec);
        System.out.println("4 step");
        System.out.println(totalSum.floatValue());
        
        totalSum=totalSum.add(dopsum);
        totalSum=totalSum.add(totalpit);
        zav.setTotalsum(totalSum);
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Progivanie updateU(@RequestBody Progivanie zav) {
        Collection<Reestruslug> listUslug= ReestService.getListUslugByIdClient(zav.getIdclient());
       System.out.println("1 step");
        BigDecimal dopsum = new BigDecimal(0.0);
        for (Reestruslug uslug : listUslug)
        {
          Stoimostuslug temp= uslugService.getListUslugByIdUslug(uslug.getIduslug());
        if (temp==null)  continue;
        dopsum.add(temp.getSumma()); 
        }
        System.out.println("2 step");
        zav.setDopusl(dopsum);
        
        Tarifz tarif= tarifService.getTarifByClient(zav.getIdclient());
        System.out.println(tarif.getName());
        System.out.println(zav.getIdnomer());
        Typenomerhotel typenomer=typenomerService.getTypeNomerByIdnomer(zav.getIdnomer());
        Stoimostnomera temp=stoimService.getStoimNomerByNomerAndTarif(tarif.getId(), zav.getIdnomer().getId());
  
        zav.setIdstoimostnomer(temp);
        System.out.println("3 step");
        
        BigInteger  stoimpit =zav.getIdstoimostpit().getSum();
       
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        cal1.setTime(zav.getDateout());
        cal2.setTime(zav.getDatein());
        int days = (int)((cal1.getTimeInMillis()-cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24));
        System.out.println(days);
        
        BigDecimal totalSum = new BigDecimal(0.0);
       
         totalSum=totalSum.add(temp.getSumma());
        
        BigDecimal dayDec = new BigDecimal(days);
        totalSum=totalSum.multiply(dayDec);
        
        
        BigDecimal totalpit = new BigDecimal(0.0);
        
        totalpit=totalpit.add( new BigDecimal(zav.getIdstoimostpit().getSum()));
        totalpit=totalpit.multiply(dayDec);
        System.out.println("4 step");
        System.out.println(totalSum.floatValue());
        
        totalSum=totalSum.add(dopsum);
        totalSum=totalSum.add(totalpit);
        zav.setTotalsum(totalSum);
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteU(@RequestBody Progivanie zav) {
        uService.delete(zav);
    }
}
