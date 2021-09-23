package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import apap.tutorial.cineplux.repository.PenjagaDB;
import apap.tutorial.cineplux.service.PenjagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BioskopServiceImpl implements BioskopService {

    @Autowired
    BioskopDB bioskopDB;
    PenjagaService penjagaService;

    @Override
    public void addBioskop(BioskopModel bioskop) {
        bioskopDB.save(bioskop);
    }

    @Override
    public void updateBioskop(BioskopModel bioskop) {
        bioskopDB.save(bioskop);
    }

    @Override
    public List<BioskopModel> getBioskopList() {
        return bioskopDB.findAll();
    }

    @Override
    public BioskopModel getBioskopByNoBioskop(Long noBioskop) {
        Optional<BioskopModel> bioskop = bioskopDB.findByNoBioskop(noBioskop);
        if(bioskop.isPresent()) {
            return bioskop.get();
        }
        return null;
    }

    @Override
    public List<BioskopModel> getBioskopOrderByName() {
        return bioskopDB.findAll(Sort.by(Sort.Direction.ASC, "namaBioskop"));
    }

    @Override
    public boolean isBioskopOpen(BioskopModel bioskop) {
        LocalTime waktuBuka = bioskop.getWaktuBuka();
        LocalTime waktuTutup = bioskop.getWaktuTutup();

        LocalTime current = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = current.format(formatter);
        current = LocalTime.parse(formattedTime);

        return (current.isAfter(waktuBuka) && current.isBefore(waktuTutup));
    }

    @Override
    public boolean isBioskopHasPenjaga(BioskopModel bioskop) {
        List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();
        if(listPenjaga.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void deleteBioskop(BioskopModel bioskop) {
        bioskopDB.delete(bioskop);
    }

}
