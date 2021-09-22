package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;

    //Routing URL yang diinginkan
    @RequestMapping("/bioskop/add")
    public String addBioskop(
            //Request parameter yang ingin digunakan
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        //Membuat objek BioskopModel
        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);

        //Menambahkan objek BioskopModel kedalam service
        bioskopService.addBioskop(bioskopModel);

        //Add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);

        //Return view template yang digunakan
        return "add-bioskop";
    }

    @RequestMapping("/bioskop/add2")
    public String addJumlahKursi(
            //Request parameter yang ingin digunakan
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
            @RequestParam(value = "jumlahKursi", required = true) int jumlahKursi,
            Model model
    ) {
        bioskopService.addJumlahKursi(idBioskop, jumlahKursi);

        model.addAttribute("idBioskop", idBioskop);
        model.addAttribute("jumlahKursi", jumlahKursi);

        return "add-jumlah-kursi";
    }

    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        //Mendapatkan semua bioskop
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();

        //Add variable semua BioskopModel ke 'listBioskop' untuk dirender dalam thymeleaf
        model.addAttribute("listBioskop", listBioskop);

        //Return view template yang diinginkan
        return "viewall-bioskop";
    }

    @RequestMapping("/bioskop/view")
    public String detailBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            Model model
    ) {
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);

        return "view-bioskop";
    }

    @GetMapping(value="/bioskop/view/id-bioskop/{idBioskop}")
    public String detailBioskopWithPathVariable(
            @PathVariable String idBioskop,
            Model model) {
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
        model.addAttribute("bioskop", bioskopModel);

        return "view-bioskop";
    }

    @GetMapping(value="/bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{newJumlah}")
    public String updateJumlahStudio(
            @PathVariable String idBioskop,
            @PathVariable int newJumlah,
            Model model) {
        bioskopService.updateJumlahBioskop(idBioskop, newJumlah);
        model.addAttribute("idBioskop", idBioskop);
        model.addAttribute("newJumlah", newJumlah);

        return "update-bioskop";
    }

    @GetMapping(value="bioskop/delete/id-bioskop/{idBioskop}")
    public String deleteBioskop(
            @PathVariable String idBioskop,
            Model model) {
        boolean ada = bioskopService.deleteBioskop(idBioskop);
        model.addAttribute("idBioskop", idBioskop);

        if(ada == true) {
            return "delete-bioskop";
        } else {
            return "delete-error";
        }
    }
}
