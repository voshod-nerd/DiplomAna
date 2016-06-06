package com.infiniteskills.mvc.controllers;

import com.infiniteskills.mvc.entity.Employee;
import com.infiniteskills.mvc.entity.Organization;
import com.infiniteskills.mvc.entity.Program;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.infiniteskills.mvc.repository.OrganizationRepository;
import com.infiniteskills.mvc.repository.ProgramRepository;
import com.infiniteskills.mvc.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    private OrganizationRepository organizationDAO;
    private ProgramRepository programDAO;
    private UserRepository userDAO;

    @Autowired(required = false)
    public void setProgRepository(ProgramRepository progDAO) {
        this.programDAO = progDAO;
    }

    @Autowired(required = false)
    public void setProgRepository(OrganizationRepository orgDAO) {
        this.organizationDAO = orgDAO;
    }

    @Autowired(required = false)
    public void setUserRepository(UserRepository dao) {
        this.userDAO = dao;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String goIndex() {
        return "public/index";
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public String reservation() {
        return "public/reservation";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String registrationClient(ModelMap model) {

        List<Organization> lsOrg = organizationDAO.findAll();
        for (Organization dept : lsOrg) {
            System.out.println("name " + dept.getName());
        }

        List<Program> lsProg = programDAO.findAll();

        for (Program tm : lsProg) {
            System.out.println(tm.getName());
        }

        model.addAttribute("listOrg", lsOrg);
        model.addAttribute("listProg", lsProg);
        return "public/regclient";

    }

    @RequestMapping(value = "/regsuc", method = RequestMethod.POST)
    public String regsuc(@RequestParam("org") String org, @RequestParam("username") String log, @RequestParam("password") String pass, @RequestParam("fio") String fio) {

        System.out.println(fio);
        System.out.println(org);
        System.out.println(log);

        Employee emp = new Employee();
        emp.setPassword(pass);
        emp.setUsername(log);
        emp.setEnabled(true);
        emp.setRole("USER_ROLE");

        Organization organ = organizationDAO.findOrganizationByName(org);
        organ.setFiopredstavitel(fio);
        organizationDAO.update(organ);

        userDAO.create(emp);

        return "public/regsuc";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        return "public/about";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        return "public/contact";
    }

   

}
