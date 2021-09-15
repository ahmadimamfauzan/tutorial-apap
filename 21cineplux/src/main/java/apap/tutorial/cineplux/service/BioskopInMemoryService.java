package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class BioskopInMemoryService implements BioskopService {
    private List<BioskopModel> listBioskop;

    //Constructor
    public BioskopInMemoryService() {
        listBioskop = new ArrayList<>();
    }

    @Override
    public void addBioskop(BioskopModel bioskop) {
        listBioskop.add(bioskop);
    }

    @Override
    public List<BioskopModel> getBioskopList() {
        return listBioskop;
    }

    @Override
    public BioskopModel getBioskopByIdBioskop(String idBioskop) {
        BioskopModel bioskopTarget = null;
        for(BioskopModel bioskop : listBioskop) {
            if(bioskop.getIdBioskop().equals(idBioskop)) {
                bioskopTarget = bioskop;
                break;
            }
        }
        return bioskopTarget;
    }

    @Override
    public void updateJumlahBioskop(String idBioskop, int newJumlah) {
        BioskopModel bioskopTarget = getBioskopByIdBioskop(idBioskop);
        bioskopTarget.setJumlahStudio(newJumlah);
    }

    @Override
    public boolean deleteBioskop(String idBioskop) {
        BioskopModel bioskopTarget = getBioskopByIdBioskop(idBioskop);
        if(bioskopTarget != null) {
            int idx = listBioskop.indexOf(bioskopTarget);
            listBioskop.remove(idx);
            return true;
        } else {
            return false;
        }
    }
}
