package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;

import java.util.List;

public interface BioskopService {
    void addBioskop(BioskopModel bioskop);
    void updateBioskop(BioskopModel bioskop);
    List<BioskopModel> getBioskopList();
    BioskopModel getBioskopByNoBioskop(Long noBioskop);
    List<BioskopModel> getBioskopOrderByName();
    boolean isBioskopOpen(BioskopModel bioskop);
    boolean isBioskopHasPenjaga(BioskopModel bioskop);
    void deleteBioskop(BioskopModel bioskop);
}

//package apap.tutorial.cineplux.service;
//
//import apap.tutorial.cineplux.model.BioskopModel;
//
//import java.util.List;
//
//public interface BioskopService {
//    //Method untuk menambahkan bioskop
//    void addBioskop(BioskopModel bioskop);
//
//    //Method untuk mendapatkan daftar Bioskop yang telah tersimpan
//    List<BioskopModel> getBioskopList();
//
//    //Method untuk mendapatkan data sebuah bioskop berdasarkan id bioskop
//    BioskopModel getBioskopByIdBioskop(String idBioskop);
//
//    //Method untuk mengupdate Jumlah Studio
//    void updateJumlahBioskop(String idBioskop, int newJumlah);
//
//    //Method untuk mendelete bioskop
//    boolean deleteBioskop(String idBioskop);
//}
