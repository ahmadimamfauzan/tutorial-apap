package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import apap.tutorial.cineplux.repository.PenjagaDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PenjagaServiceImpl implements PenjagaService {

    @Autowired
    PenjagaDB penjagaDB;

    @Override
    public void addPenjaga(PenjagaModel penjaga) {
        penjagaDB.save(penjaga);
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findByNoPenjaga(noPenjaga);
        if(penjaga.isPresent()) {
            return penjaga.get();
        }
        return null;
    }

    @Override
    public void updatePenjaga(PenjagaModel penjaga) {
        penjagaDB.save(penjaga);
    }

//    @Override
//    public void deletePenjaga(PenjagaModel penjaga) {
//        penjagaDB.delete(penjaga);
//    }

    @Override
    public List<PenjagaModel> getPenjagaList() {
        return penjagaDB.findAll();
    }

    @Override
    public int deletePenjaga(PenjagaModel penjaga) {
        LocalTime now = LocalTime.now();
        BioskopModel bioskop = penjaga.getBioskop();
        if(now.isBefore(bioskop.getWaktuBuka()) || now.isAfter(bioskop.getWaktuTutup())) {
            penjagaDB.delete(penjaga);
            return 1;
        }
        return 0;
    }
}
