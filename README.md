# Tutorial APAP

## Authors

* **Ahmad Imam Fauzan** - *1906353542* - *APAP-C*

## Tutorial 4
1. Jelaskan perbedaan th:include dan th:replace!
    - th:include
        - akan menyertakan konten fragmen ke dalam tag hostnya.
    - th:replace
        - akan menggantikan tag host dengan fragmen. Hal ini akan menghapus tag host dan sebagai gantinya akan menambahkan tag dari fragmen.
2. Jelaskan apa fungsi dari th:object!
    - Pada tag form method yang digunakan pada form-update-penjaga adalah post sesuai yang terdapat di controller. th:object="${penjaga} adalah salah satu penerapan tag thymeleaf untuk menampung objek penjaga, objek penjaga berasal dari controller.
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
    - Tanda bintang * digunakan saat objek yang diberikan merupakan sebuah list dan biasanya digunakan untuk mengolah isi list tersebut (contohnya: for loop) sedangkan $ digunakan pada data yang tipenya tunggal.

---

## Tutorial 3
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
    - @AllArgsConstructor: menghasilkan constructor dengan 1 parameter untuk setiap field di class kita 
    - @NoArgsConstructor: menghasilkan constructor yang akan membuat objek tanpa parameter
    - @Setter: lombok akan menghasilkan setter secara default dengan return void dan 1 parameter
    - @Getter: lombok akan menghasilkan getter secara default dengan return tipe field getnya dan tanpa parameter
    - @Entity: sebagai representasi entitas dari database
    - @Table: untuk mempermudah mapping

2. Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method tersebut?
    - Untuk mendapatkan objek bioskop dengan nomor tertentu yang ada pada Repository atau Database.

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn
    - Anotasi @JoinTable dapat digunakan untuk One-to-One Relation karena akan membuat sebuah tabel bantu untuk menampung primary key masing-masing identitas.
    - Anotasi @JoinColumn dapat digunakan untuk One-to-Many Relation karena ketika menggunakan anotasi tersebut akan ada kolom salah satu entitas menjadi foreign key pada entitas yang lain.

4. Pada class PenjagaModel, digunakan anotasi @JoinColumn pada atribut bioskop, apa kegunaan dari name referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull
    - name: Nama dari kolom foreign key
    - referencedColumnName: Nama dari kolom yang direferensikan oleh kolom foreign key.
    - nullable: Menentukan apakah kolom foreign key merupakan nullable atau tidak
    - Perbedaan dari nullable dan anotasi @NotNull:
        - *The specification that defines the annotation and the required dependencies.*
        - *Where the check gets performed.*
        - *The point in time when the check gets performed.* 

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
FetchType pada Hibernate berfungsi untuk menentukan  apakah atau tidak untuk me-load semua collection object ( child ) sesaat setelah object parent di-fetch.
    - FetchType.Lazy: Hibernate tidak men-load semua collecton object ( child ) saat object parent di-fetch. Collection object (child) hanya di-load jika secara eksplisit dibutuhkan via getter method.
    - FetchType.Eager:  Hibernate men-load semua collection object ( child ) sesaat setelah object parent di-fetch.
    - CascadeType.ALL: merupakan sebuah shortcut yang dapat merepresentasikan CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH, dan CascadeType.MERGE. 

---

## Tutorial 2
1. Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi?
    - Karena pada langkah ini, kita belum mempunyai template. Controller dari addBioskop mereturn "add-bioskop" yang mencari html dengan nama tersebut. Karena pada langkah ini kita belum membuat file html, maka akan menampilkan sebuah error, yaitu whitelable page error.

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
    - Autowired merupakan implementasi dari dependency injection. Cara kerjanya yaitu dependency interface-nya diinject automatis via autowired ke service yang mengimplementasi autowired ini.

3. Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan
mengapa hal tersebut dapat terjadi.
    - Link tersebut kurang atribut jumlahStudio karena pada Controller atribut tersebut required-nya bernilai true sehingga harus ada nilai dari atribut tersebut.

4.  Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung, link apa yang harus diakses?
    - Untuk melihat bioskop dengan nama Bioskop Maung sebelumnya kita harus mengadd Bioskop tersebut dengan link http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20Maung&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10
    - Karena pada Controller detail bioskop membutuhkan/merequire sebuah idBioskop, kita perlu tahu id dari bioskop dengan nama Bioskop Maung. Kita dapat melihatnya dari http://localhost:8080/bioskop/viewall
    - Setelah kita tahu id dari bioskop dengan nama Bioskop Maung, kita dapat melihat detail tersebut dengan link http://localhost:8080/bioskop/view?idBioskop=1

5. Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall, apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
    - Link tersebut akan menampilkan semua list bioskop yang sudah di-add
    - Link screenshot: https://bit.ly/ScreenshotNo5AhmadImamFauzan

---

## Tutorial 1
### What I have learned today
(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda
juga boleh menambahkan catatan apapun di bagian ini)
    - *Installing some application that will be use in the future (for APAP requirements only)*
    - *Know the process between HTML, Java, Maven*

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
    - *Issue tracker records issues customers have experienced with a software product, and it enables support agents, engineers, and managers to track those problems until they have been successfully resolved.*
    - *The problems are such bugs on the application*

2. Apa perbedaan dari git merge dan git merge --squash?
    - *If we executed the command with squash option, the merging files would have shown in the list when we command git status but we just executed git merge. Once we pull the master branch on the feature branch, there is no difference between master and feature branch except merge commit, which means that the only merge commit exists between two. Therefore as we switch the branch from feature to master, all commits on feature branch were merged straightway.*

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi?
    - *It manages changes to a record, file, dataset, or document. The changes made to a record are stored as a version. Then each update will subsequently be open to more improvements.*

### Spring
4. Apa itu library & dependency?
    - *Libraries are collections of prewritten code that users can use to optimize tasks or build some projects.*
    - *A dependency is an essential functionality, library or piece of code that’s essential for a different part of the code to work. For example, a specific library that a given line of code depends on.*

5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
    - *Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.*
    - *Why we ue Maven because simply is one of ways to build some software project.*

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?
    - *Application enterprise and mobile application.*

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?
    - *@RequestParam is for getting the parameter from URI while @PathVariable is for getting the template from URI.*

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
    - [x] Kenapa saya harus belajar APAP?
*For getting knowledge and insights about building or creating some application or software at company environment.*

(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu
lebih dalam tentang penulisan README.md di GitHub pada link
[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))