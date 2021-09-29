package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.PenjagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BioskopController {

    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model) {
        model.addAttribute("bioskop", new BioskopModel());
        return "form-add-bioskop";
    }

    @PostMapping("/bioskop/add")
    public String addBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.addBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "add-bioskop";
    }

    @GetMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        List<BioskopModel> listBioskop = bioskopService.getBioskopOrderByName();
        model.addAttribute("listBioskop", listBioskop);
        return "viewall-bioskop";
    }

    @GetMapping("/bioskop/view")
    public String viewDetailBioskop (
            @RequestParam(value = "noBioskop") Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);

        if(bioskop != null) {
            List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();
            model.addAttribute("bioskop", bioskop);
            model.addAttribute("listPenjaga", listPenjaga);
            return "view-bioskop";
        } else {
            model.addAttribute("noBioskop", noBioskop);
            model.addAttribute("errorName", "404 NOT FOUND");
            return "error-bioskop-404";
        }

    }

    @GetMapping("/bioskop/update/{noBioskop}")
    public String updateBioskopForm(
            @PathVariable Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        model.addAttribute("bioskop", bioskop);
        return "form-update-bioskop";
    }

    @PostMapping("/bioskop/update")
    public String updateBioskopSubmit (
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        String newName = bioskop.getNamaBioskop();

        List<BioskopModel> listBioskop = bioskopService.getBioskopList();

        boolean ada = false;
        for(BioskopModel bio : listBioskop) {
            if(bio.getNamaBioskop().equals(newName)) {
                ada = true;
                break;
            }
        }

        if(ada == true) {
            model.addAttribute("noBioskop", bioskop.getNoBioskop());
            model.addAttribute("newName", newName);
            return "error-bioskop-update";
        } else {
            bioskopService.updateBioskop(bioskop);
            model.addAttribute("noBioskop", bioskop.getNoBioskop());
            return "update-bioskop";
        }


    }

    @GetMapping("/bioskop/delete/{noBioskop}")
    public String deleteBioskopForm(
            @PathVariable Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        boolean itHasPenjaga = bioskopService.isBioskopHasPenjaga(bioskop);
        boolean isBioskopBuka = bioskopService.isBioskopOpen(bioskop);

        model.addAttribute("bioskop", bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        model.addAttribute("namaBioskop", bioskop.getNamaBioskop());
        model.addAttribute("alamatBioskop", bioskop.getAlamatBioskop());
        model.addAttribute("jumlahStudio", bioskop.getJumlahStudio());
        model.addAttribute("waktuBuka", bioskop.getWaktuBuka());
        model.addAttribute("waktuTutup", bioskop.getWaktuTutup());
        model.addAttribute("listPenjaga", bioskop.getListPenjaga());
        model.addAttribute("listFilm", bioskop.getListFilm());

        if(isBioskopBuka == false) {
            if(itHasPenjaga == false) {
                return "form-delete-bioskop";
            } else {
                model.addAttribute("errorName", "Tidak dapat men-delete Bioskop!");
                return "error-bioskop-ada-penjaga";
            }
        } else {
            model.addAttribute("errorName", "Tidak dapat men-delete Bioskop!");
            return "error-bioskop-buka";
        }
    }

    @PostMapping("/bioskop/delete")
    public String deleteBioskopSubmit (
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        model.addAttribute("bioskop", bioskop);
        bioskopService.deleteBioskop(bioskop);

        return "delete-bioskop-2";
    }
}

//package apap.tutorial.cineplux.controller;
//
//import apap.tutorial.cineplux.model.BioskopModel;
//import apap.tutorial.cineplux.service.BioskopService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class BioskopController {
//    @Autowired
//    private BioskopService bioskopService;
//
//    //Routing URL yang diinginkan
//    @RequestMapping("/bioskop/add")
//    public String addBioskop(
//            //Request parameter yang ingin digunakan
//            @RequestParam(value = "idBioskop", required = true) String idBioskop,
//            @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
//            @RequestParam(value = "alamat", required = true) String alamat,
//            @RequestParam(value = "noTelepon", required = true) String noTelepon,
//            @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
//            Model model
//    ) {
//        //Membuat objek BioskopModel
//        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);
//
//        //Menambahkan objek BioskopModel kedalam service
//        bioskopService.addBioskop(bioskopModel);
//
//        //Add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
//        model.addAttribute("idBioskop", idBioskop);
//
//        //Return view template yang digunakan
//        return "add-bioskop";
//    }
//
//    @RequestMapping("/bioskop/viewall")
//    public String listBioskop(Model model) {
//        //Mendapatkan semua bioskop
//        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
//
//        //Add variable semua BioskopModel ke 'listBioskop' untuk dirender dalam thymeleaf
//        model.addAttribute("listBioskop", listBioskop);
//
//        //Return view template yang diinginkan
//        return "viewall-bioskop";
//    }
//
//    @RequestMapping("/bioskop/view")
//    public String detailBioskop(
//            @RequestParam(value = "idBioskop", required = true) String idBioskop,
//            Model model
//    ) {
//        //Mendapatkan bioskop sesuai dengan idBioskop
//        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
//
//        //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
//        model.addAttribute("bioskop", bioskopModel);
//
//        return "view-bioskop";
//    }
//
//    @GetMapping(value="/bioskop/view/id-bioskop/{idBioskop}")
//    public String detailBioskopWithPathVariable(
//            @PathVariable String idBioskop,
//            Model model) {
//        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
//        model.addAttribute("bioskop", bioskopModel);
//
//        return "view-bioskop";
//    }
//
//    @GetMapping(value="/bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{newJumlah}")
//    public String updateJumlahStudio(
//            @PathVariable String idBioskop,
//            @PathVariable int newJumlah,
//            Model model) {
//        bioskopService.updateJumlahBioskop(idBioskop, newJumlah);
//        model.addAttribute("idBioskop", idBioskop);
//        model.addAttribute("newJumlah", newJumlah);
//
//        return "update-bioskop";
//    }
//
//    @GetMapping(value="bioskop/delete/id-bioskop/{idBioskop}")
//    public String deleteBioskop(
//            @PathVariable String idBioskop,
//            Model model) {
//        boolean ada = bioskopService.deleteBioskop(idBioskop);
//        model.addAttribute("idBioskop", idBioskop);
//
//        if(ada == true) {
//            return "delete-bioskop";
//        } else {
//            return "delete-error";
//        }
//    }
//
//
//}
