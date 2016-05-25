package com.infiniteskills.mvc.controllers;

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

@Controller
public class IndexController {

    private OrganizationRepository organizationDAO;
    private ProgramRepository programDAO;

    @Autowired(required = false)
    public void setProgRepository(ProgramRepository progDAO) {
        this.programDAO = progDAO;
    }

    @Autowired(required = false)
    public void setProgRepository(OrganizationRepository orgDAO) {
        this.organizationDAO = orgDAO;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String goIndex() {
        return "public/index";
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public String reservation() {
        return "public/reservation";
    }

    @RequestMapping(value = "/regclient", method = RequestMethod.GET)
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
        return "public/registrationclient";

    }

    @RequestMapping(value = "/testreg",method = RequestMethod.GET)
    public String testReg(Model model) {
        return "public/testreg";
    }

    @RequestMapping(value = "/testsucreg",method = RequestMethod.GET)
    public String TestSucReg(Model model) {
        return "public/testsuccsesreg";
    }

}
