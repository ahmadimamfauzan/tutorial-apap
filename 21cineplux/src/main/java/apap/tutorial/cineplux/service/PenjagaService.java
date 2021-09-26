package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;

import java.util.List;

public interface PenjagaService {
    void addPenjaga(PenjagaModel penjaga);
    PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);
    void updatePenjaga(PenjagaModel penjaga);
    void deletePenjaga(PenjagaModel penjaga);
    List<PenjagaModel> getPenjagaList();

}
