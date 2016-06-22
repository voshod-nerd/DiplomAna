package com.infiniteskills.mvc.controllers;

import com.infiniteskills.mvc.entity.Bron;
import com.infiniteskills.mvc.entity.Client;
import com.infiniteskills.mvc.entity.Employee;
import com.infiniteskills.mvc.entity.Nomerhotel;
import com.infiniteskills.mvc.entity.Organization;
import com.infiniteskills.mvc.entity.Program;
import com.infiniteskills.mvc.entity.Stoimostnomera;
import com.infiniteskills.mvc.repository.BronRepository;
import com.infiniteskills.mvc.repository.ClientRepository;
import com.infiniteskills.mvc.repository.NomerhotelRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.infiniteskills.mvc.repository.OrganizationRepository;
import com.infiniteskills.mvc.repository.ProgramRepository;
import com.infiniteskills.mvc.repository.StoimostNomeraRepository;
import com.infiniteskills.mvc.repository.UserRepository;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    private OrganizationRepository organizationDAO;
    private ProgramRepository programDAO;
    private UserRepository userDAO;
    private StoimostNomeraRepository stoimnomerDAO;
    private NomerhotelRepository nomerDAO;
    private BronRepository bronDAO;
    private ClientRepository clientDAO;

    @Autowired(required = false)
    public void setClientRepository(ClientRepository progDAO) {
        this.clientDAO = progDAO;
    }

    @Autowired(required = false)
    public void setBronRepository(BronRepository progDAO) {
        this.bronDAO = progDAO;
    }

    @Autowired(required = false)
    public void setProgRepository(ProgramRepository progDAO) {
        this.programDAO = progDAO;
    }

    @Autowired(required = false)
    public void setNomerRepository(NomerhotelRepository progDAO) {
        this.nomerDAO = progDAO;
    }

    @Autowired(required = false)
    public void setProgRepository(OrganizationRepository orgDAO) {
        this.organizationDAO = orgDAO;
    }

    @Autowired(required = false)
    public void setStoimostNomera(StoimostNomeraRepository nomDAO) {
        this.stoimnomerDAO = nomDAO;
    }

    @Autowired(required = false)
    public void setUserRepository(UserRepository dao) {
        this.userDAO = dao;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String goEnter() {
        return "corporative/enter";
    }

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String goIndex() {
        return "public/index";
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public String reservation() {
        return "public/reservation";
    }

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public String pay(@RequestParam(value = "id") int idnomer, @RequestParam(value = "dateb") Date dateb, @RequestParam(value = "datee") Date datee, ModelMap map) {
        // нужно расчитать сумму пребывания по формуле количество дней * стоимость номера
        // стоимость номера номера зависит от тарифа
        // стоимость

        Nomerhotel nomer = nomerDAO.findById(idnomer);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        System.out.println(name);
        System.out.println(nomer.getTypenomer().getId());
        Stoimostnomera sum = stoimnomerDAO.getSumForBronUser(name, nomer.getTypenomer().getId());
        System.out.println("idnomer = " + nomer.getTypenomer().getId());
        System.out.println("username = " + name);
        System.out.println("Summa bron= " + sum);
        // вычисляем количество дней 

        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        cal1.setTime(datee);
        cal2.setTime(dateb);
        int days = (int)((cal1.getTimeInMillis()-cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24));
       
        System.out.println("days=" + days);
        System.out.println("stoimnomer" + sum.getSumma().floatValue());
        float suma = (float) (sum.getSumma().floatValue() * days * 0.1);
        System.out.println("summaAfter=" + suma);

        System.out.println("2");
        map.addAttribute("idnomer", nomer.getId());
        System.out.println("3");

        Organization organ = organizationDAO.findOrganizationByUsername(name);

        map.addAttribute("idorg", organ.getId());
        System.out.println("4");
        map.addAttribute("org", organ.getName());
        System.out.println("5");
        map.addAttribute("hotel", nomer.getIdgostin().getName());
        map.addAttribute("typenomer", nomer.getTypenomer().getType());
        map.addAttribute("mest", nomer.getTypenomer().getMest());
        map.addAttribute("number", nomer.getNumber());
        map.addAttribute("sumbron", new BigDecimal(suma));
        map.addAttribute("dateb", dateb);
        map.addAttribute("datee", datee);

        return "public/pay";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String registrationClient(ModelMap model) {

        List<Organization> lsOrg = organizationDAO.findAll();

        List<Program> lsProg = programDAO.findAll();

        model.addAttribute("listOrg", lsOrg);
        model.addAttribute("listProg", lsProg);
        return "public/regclient";

    }

    @RequestMapping(value = "/brona", method = RequestMethod.POST)
    public String bronSuc(@RequestParam(value = "idnomer", required = false) int idnomer, @RequestParam(value = "dateb", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateb, @RequestParam(value = "datee", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date datee, @RequestParam(value = "fio", required = false) String fio, @RequestParam(value = "dr", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dr, @RequestParam(value = "electron", required = false) String el) throws UnsupportedEncodingException {
        String p = new String(fio.getBytes("ISO8859-1"), "UTF-8");
        Nomerhotel nomer = nomerDAO.findById(idnomer);
        Bron bron = new Bron();
        Client client = clientDAO.findByNameAndDr(p, dr);
        if (client != null) {
            bron.setIdclient(client);
        } else {
            Client cl = new Client();
            cl.setDr(dr);

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();
            Organization organ = organizationDAO.findOrganizationByUsername(name);

            cl.setIdorg(organ);
            cl.setFio(p);
            cl = clientDAO.create(cl);
            bron.setIdclient(cl);

        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Organization organ = organizationDAO.findOrganizationByUsername(name);
        bron.setIdorg(organ);

        bron.setIdnomer(nomer);

        bron.setDateb(dateb);
        bron.setDatee(datee);
        bron = bronDAO.create(bron);
        return "public/bronsuc";
    }

    @RequestMapping(value = "/regsuc", method = RequestMethod.POST)
    public String regsuc(@RequestParam("org") String org, @RequestParam("username") String log, @RequestParam("password") String pass, @RequestParam("fio") String fio) throws UnsupportedEncodingException {

        String p = new String(fio.getBytes("ISO8859-1"), "UTF-8");
        String orgname = new String(org.getBytes("ISO8859-1"), "UTF-8");
        String usr = new String(log.getBytes("ISO8859-1"), "UTF-8");

        Employee emp = new Employee();
        emp.setPassword(pass);
        emp.setUsername(usr);
        emp.setEnabled(true);
        emp.setRole("ROLE_USER");
        userDAO.create(emp);
        Organization organ = organizationDAO.findOrganizationByName(orgname);
        organ.setFiopredstavitel(p);
        organ.setIduser(emp);
        organizationDAO.update(organ);

        return "public/regsuc";
    }

    @RequestMapping(value = "/denaid", method = RequestMethod.GET)
    public String denaidBron(ModelMap map) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Organization organ = organizationDAO.findOrganizationByUsername(name);
        map.addAttribute("idorg", organ.getId());
        map.addAttribute("org", organ.getName());

        return "public/denaidbron";
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
