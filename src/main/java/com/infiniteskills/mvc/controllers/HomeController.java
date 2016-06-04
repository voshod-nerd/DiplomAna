package com.infiniteskills.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.infiniteskills.mvc.entity.Hotel;
import com.infiniteskills.mvc.entity.Sotrudnik;
import com.infiniteskills.mvc.entity.Typeza;

import com.infiniteskills.mvc.repository.HotelRepository;
import com.infiniteskills.mvc.repository.SotrudnikRepository;
import com.infiniteskills.mvc.repository.TypeZayavkaRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;

@Controller
public class HomeController {

   
    private HotelRepository hotelRepository;
    private TypeZayavkaRepository typZ;
    private SotrudnikRepository sotrRepository;

   

    @Autowired(required = false)
    public void setHotelRepository(HotelRepository hotDAO) {
        this.hotelRepository = hotDAO;
    }

    @Autowired(required = false)
    public void setTypeZRepository(TypeZayavkaRepository typeZ) {
        this.typZ = typeZ;
    }

    @Autowired(required = false)
    public void setSotrudnikRepository(SotrudnikRepository sotr) {
        this.sotrRepository = sotr;
    }

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "corporative/enter";
    }
    
    
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    
    
    
    

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "public/home";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String deptList(Model model) {

        
        return "corporative/home";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String ordersList(ModelMap model) {

        List<Hotel> lsHotel = hotelRepository.findAll();
        for (Hotel dept : lsHotel) {
            System.out.println("name " + dept.getName());
        }
        List<Typeza> lsTypeZ = typZ.findAll();

        List<Sotrudnik> lsSotr = sotrRepository.findAll();

        model.addAttribute("listHotel", lsHotel);
        model.addAttribute("listTypeZ", lsTypeZ);
        model.addAttribute("listSotr", lsSotr);

        return "corporative/orders";
    }

    @RequestMapping(value = "/hotels", method = RequestMethod.GET)
    public String pageHotel(ModelMap model) {
        return "corporative/hotels";
    }

    @RequestMapping(value = "/sotrudnik", method = RequestMethod.GET)
    public String pageSotrudnik(ModelMap model) {
        return "corporative/sotrudnik";
    }

    @RequestMapping(value = "/organiz", method = RequestMethod.GET)
    public String pageOrganization(ModelMap model) {
        return "corporative/organization";
    }

    @RequestMapping(value = "/typezav", method = RequestMethod.GET)
    public String pageTypeZav(ModelMap model) {
        return "corporative/typezav";
    }

    @RequestMapping(value = "/typenomerhot", method = RequestMethod.GET)
    public String pageTypeNomer(ModelMap model) {
        return "corporative/typenomerhot";
    }

    @RequestMapping(value = "/tarif", method = RequestMethod.GET)
    public String pageTarif(ModelMap model) {
        return "corporative/tarif";
    }

    @RequestMapping(value = "/uslug", method = RequestMethod.GET)
    public String pageUslug(ModelMap model) {
        return "corporative/uslug";
    }

    @RequestMapping(value = "/programs", method = RequestMethod.GET)
    public String pagePrograms(ModelMap model) {
        return "corporative/programs";
    }

    @RequestMapping(value = "/pitan", method = RequestMethod.GET)
    public String pagePitanie(ModelMap model) {
        return "corporative/pitan";
    }

    @RequestMapping(value = "/typeuser", method = RequestMethod.GET)
    public String pageTypeUser(ModelMap model) {
        return "corporative/typeuser";
    }

    @RequestMapping(value = "/dolgnost", method = RequestMethod.GET)
    public String pageDolgnost(ModelMap model) {
        return "corporative/dolgnost";
    }

    @RequestMapping(value = "/stoimostpitan", method = RequestMethod.GET)
    public String pageStoimPitan(ModelMap model) {
        return "corporative/stoimostpitan";
    }

    @RequestMapping(value = "/stoimostnomer", method = RequestMethod.GET)
    public String pageStoimNomer(ModelMap model) {
        return "corporative/stoimostnomer";
    }

    @RequestMapping(value = "/stoimostuslug", method = RequestMethod.GET)
    public String pageStoimUslug(ModelMap model) {
        return "corporative/stoimostuslug";
    }

    @RequestMapping(value = "/otpusk", method = RequestMethod.GET)
    public String pageOtpusk(ModelMap model) {
        return "corporative/otpusk";
    }

    @RequestMapping(value = "/grafik", method = RequestMethod.GET)
    public String pageGrafik(ModelMap model) {
        return "corporative/grafik";
    }

}
