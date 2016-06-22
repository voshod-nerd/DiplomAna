package com.infiniteskills.mvc.controllers;

import com.infiniteskills.mvc.entity.Bron;
import com.infiniteskills.mvc.entity.Grafik;
import java.util.List;
import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.nio.charset.Charset;
import com.infiniteskills.mvc.entity.Hotel;
import com.infiniteskills.mvc.entity.Nomerhotel;
import com.infiniteskills.mvc.entity.Otpusk;
import com.infiniteskills.mvc.entity.Progivanie;
import com.infiniteskills.mvc.entity.Reestruslug;
import com.infiniteskills.mvc.entity.Sotrudnik;
import com.infiniteskills.mvc.entity.Typeza;
import com.infiniteskills.mvc.entity.Zayvka;
import com.infiniteskills.mvc.report.Anketa;
import com.infiniteskills.mvc.report.Bolnic;
import com.infiniteskills.mvc.report.ClientReports;
import com.infiniteskills.mvc.report.GrafikReport;
import com.infiniteskills.mvc.report.Gurnal;
import com.infiniteskills.mvc.report.Hoda;
import com.infiniteskills.mvc.report.IzmReport;
import com.infiniteskills.mvc.report.ListLife;
import com.infiniteskills.mvc.report.OtpuskRep;
import com.infiniteskills.mvc.report.PersonalCard;
import com.infiniteskills.mvc.report.PlanRemont;
import com.infiniteskills.mvc.report.UvolRep;
import com.infiniteskills.mvc.repository.BronRepository;
import com.infiniteskills.mvc.repository.GrafikRepository;

import com.infiniteskills.mvc.repository.HotelRepository;
import com.infiniteskills.mvc.repository.NomerhotelRepository;
import com.infiniteskills.mvc.repository.OtpuskRepository;
import com.infiniteskills.mvc.repository.ProgivanieRepository;
import com.infiniteskills.mvc.repository.ReestrUslugRepository;
import com.infiniteskills.mvc.repository.SotrudnikRepository;
import com.infiniteskills.mvc.repository.TypeZayavkaRepository;
import com.infiniteskills.mvc.repository.ZayavkaRepository;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.util.FileCopyUtils;

@Controller
public class HomeController {

    private static final String EXTERNAL_FILE_PATH = "C:/mytemp/";

    private HotelRepository hotelRepository;
    private TypeZayavkaRepository typZ;
    private SotrudnikRepository sotrRepository;
    private OtpuskRepository otpRepository;
    private ProgivanieRepository progivRepository;
    private ReestrUslugRepository reestRepository;
    private ZayavkaRepository zayRepository;
    private BronRepository bronRepository;
    private NomerhotelRepository nomerRepository;
    private ClientReports clientReports;
    private GrafikRepository grafikRepository;

    @Autowired(required = false)
    public void setGrafRepository(GrafikRepository hotDAO) {
        this.grafikRepository = hotDAO;
    }

    @Autowired(required = false)
    public void setnomerRepository(NomerhotelRepository hotDAO) {
        this.nomerRepository = hotDAO;
    }

    @Autowired(required = false)
    public void setBronRepository(BronRepository hotDAO) {
        this.bronRepository = hotDAO;
    }

    @Autowired(required = false)
    public void setZayRepository(ZayavkaRepository hotDAO) {
        this.zayRepository = hotDAO;
    }

    @Autowired(required = false)
    public void setProgivRepository(ProgivanieRepository hotDAO) {
        this.progivRepository = hotDAO;
    }

    @Autowired(required = false)
    public void setProgivRepository(ReestrUslugRepository hotDAO) {
        this.reestRepository = hotDAO;
    }

    @Autowired(required = false)
    public void setOtpuskRepository(OtpuskRepository hotDAO) {
        this.otpRepository = hotDAO;
    }

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

    @Autowired(required = false)
    public void setClientReports(ClientReports clientReports) {
        this.clientReports = clientReports;
    }

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "corporative/enter";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

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

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String pageClient(ModelMap model) {
        return "corporative/client";
    }

    @RequestMapping(value = "/bronz", method = RequestMethod.GET)
    public String pagebron(ModelMap model) {
        return "corporative/bron";
    }

    @RequestMapping(value = "/nomer", method = RequestMethod.GET)
    public String pageNomer(ModelMap model) {
        // try {
        List<Hotel> hotels = hotelRepository.findAll();
        ArrayList<String[]> Array = new ArrayList<String[]>();

        for (Hotel hotel : hotels) {
            String[] subAr = new String[5];

            subAr[0] = hotel.getName();
            List<Nomerhotel> free = nomerRepository.getFreeByHotel(hotel);
            if (!(free == null)) {
                subAr[1] = String.valueOf(free.size());
            } else {
                subAr[1] = "0";
            }
            List<Nomerhotel> bron = nomerRepository.getBronByHotel(hotel);
            if (!(bron == null)) {
                System.out.println("bron" + bron.size());
                subAr[2] = String.valueOf(bron.size());
            } else {
                subAr[1] = "0";
            }
            List<Nomerhotel> progiv = nomerRepository.getProgByHotel(hotel);
            if (!(progiv == null)) {
                subAr[3] = String.valueOf(progiv.size());
            } else {
                subAr[1] = "0";
            }
            List<Nomerhotel> remont = nomerRepository.getRemontByHotel(hotel);
            subAr[4] = String.valueOf(remont.size());
            if (!(remont == null)) {
                System.out.println(subAr[3]);
            } else {
                subAr[1] = "0";
            }
            Array.add(subAr);
        }
        model.addAttribute("array", Array);
        // } catch (Exception err) {}
        return "corporative/nomer";
    }

    @RequestMapping(value = "/reestuslug", method = RequestMethod.GET)
    public String pageReestUslug(ModelMap model) {
        return "corporative/reestruslug";
    }

    @RequestMapping(value = "/progiv", method = RequestMethod.GET)
    public String pageReestProgiv(ModelMap model) {
        return "corporative/progivanie";
    }

    @RequestMapping(value = "/report/{type}/{params}", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response, @PathVariable("type") String type, @PathVariable("params") String param) throws IOException {
        File file = null;
        System.out.println(type);
        if (type.equals("1")) {
            System.out.println(type);
            PersonalCard card = new PersonalCard();
            Sotrudnik sotr = sotrRepository.getSotrudnikById(param);
            List<Otpusk> otpusk = otpRepository.getOtpuskByIdsotr(param);
            file = card.doReport(sotr, otpusk);
        }

        if (type.equals("2")) {
            Progivanie progiv = progivRepository.findProgivById(param);
            Date currentDate = new Date();
            progiv.setDateout(currentDate);
            progiv.setClosed(1);
            progivRepository.update(progiv);

            List<Reestruslug> listuslug = reestRepository.getListUslugByIdClient(progiv.getIdclient());

            file = clientReports.doReport(progiv, listuslug);
        }

        if (type.equals("3")) {

            List<Zayvka> currentz = zayRepository.getAllCurrentZyavka();
            PlanRemont pl = new PlanRemont();

            file = pl.doReport(currentz);
        }

        if (type.equals("4")) {

            //file = xmlCreator.getAddedHouse();
            ListLife fl = new ListLife();
            List<Progivanie> list = progivRepository.findProgivByHotel(param);
            List<Bron> bron = bronRepository.getBronByHotel(param);
            List<Nomerhotel> nomers = nomerRepository.getNomerHotelByHotel(param);

            file = fl.doReport(list, bron, nomers);
        }

        if (type.equals("5")) {
            Anketa fl = new Anketa();
            Progivanie progiv = progivRepository.findProgivById(param);
            file = fl.doReport(progiv);
        }

        if (type.equals("6")) {
            System.out.println(param);
            String[] arr = param.split("-");
            System.out.println(arr[0]);
            System.out.println(arr[1]);

            int god = Integer.parseInt(arr[0]);
            int month = Integer.parseInt(arr[1]);
            Calendar cal = Calendar.getInstance();
            cal.set(god, month - 1, 1);
            Date dateb = cal.getTime();
            int max_date = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            cal.set(god, month - 1, max_date);
            Date dateend = cal.getTime();

            System.out.print(dateb);
            System.out.println(dateend);

            List<Grafik> grafik = grafikRepository.getGrafikByHotel(dateb, dateend);

            List<Hotel> hotels = hotelRepository.findAll();
            GrafikReport rep = new GrafikReport();

            file = rep.doReport(grafik, hotels, month);

        }

        if (type.equals("7")) {
            List<Progivanie> list = progivRepository.getCurrentProg();
            Hoda hod = new Hoda();
            file = hod.doReport(list);

        }

        if (type.equals("8")) {
            File fl = new File("C:/mytemp/zav1.xls");
            file = fl;
        }

        if (type.equals("9")) {
            List<Progivanie> list = progivRepository.getCurrentProg();
            Gurnal hod = new Gurnal();
            file = hod.doReport(list);

        }

        if (type.equals("10")) {
            File fl = new File("C:/mytemp/reestr1.xls");
            file = fl;

        }

        if (type.equals("11")) {
            File fl = new File("C:/mytemp/reestr2.xls");
            file = fl;

        }

        if (type.equals("otpusk")) {
            OtpuskRep report = new OtpuskRep();
            Otpusk ot = otpRepository.getOtpuskById(param);
            File fl = report.doReport(ot);
            file = fl;

        }

        if (type.equals("bolnic")) {
            Bolnic report = new Bolnic();
            Sotrudnik sotr = sotrRepository.getSotrudnikById(param);
            File fl = report.doReport(sotr);
            file = fl;

        }

        if (type.equals("uvol")) {
            UvolRep report = new UvolRep();
            Sotrudnik sotr = sotrRepository.getSotrudnikById(param);
            File fl = report.doReport(sotr);
            file = fl;

        }

        if (type.equals("izm")) {

            System.out.println(param);
            String[] arr = param.split(":::");

            SimpleDateFormat format = new SimpleDateFormat();

            Date de = new Date();
            Date db = new Date();
           

            format.applyPattern("yyyy-MM-dd");
            try {

                db = format.parse(arr[0]);
            } catch (ParseException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }

            SimpleDateFormat format1 = new SimpleDateFormat();
            format1.applyPattern("yyyy-MM-dd");
            try {

                de = format1.parse(arr[1]);
            } catch (ParseException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(de);
            System.out.println(db);
            
            try {
            List<Bron> bron = bronRepository.getBronByPeriod(db, de);
            List<Progivanie> prog =progivRepository.ProgivByPeriod(db, de);
            List<Zayvka>  zayv= zayRepository.getAllZyavkaByPeriod(db, de);
            IzmReport izm = new IzmReport();
            file=izm.doReport(bron, prog, zayv, db, de);
            
            } catch (Exception erroe) {
            file = new File("ddd");
            }
        }


        /*
        if (type.equals("doc")) {
            file = docCreator.getFile();
        }
         */
        if (!file.exists()) {
            String errorMessage = "Sorry. The file you are looking for does not exist";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
        String mimeType = "application/octet-stream";
        System.out.println("mimetype : " + mimeType);
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
        response.setContentLength((int) file.length());
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        FileCopyUtils.copy(inputStream, response.getOutputStream());

    }

}
