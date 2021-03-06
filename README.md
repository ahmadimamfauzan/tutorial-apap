# Tutorial APAP

## Authors

* **Ahmad Imam Fauzan** - *1906353542* - *APAP-C*

## Tutorial 7
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.
    - Jawaban dapat dilihat di https://ristek.link/Tutorial-7-APAP-Jawaban-Nomor-1-1906353542
2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
    - State adalah data private sebuah component. Data ini hanya tersedia untuk component tersebut dan tidak bisa di akses dari component lain. Component dapat merubah statenya sendiri.
    - Prop singkatan dari Property. Mirip seperti atrribute pada tag HTML. Dalam pembuatannya, jika dalam functional component maka prop ini adalah parameternya.
3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.
    - Sebaiknya kita menggunakan component dalam React karena sifatnya yang reusable sesuai dengan kebutuhan kita. Contoh pada tutorial kali ini dimana ada component List dan Item yang bisa dipanggil ulang untuk menampilkan seluruh produk katalog yang ada di file json sekaligus menampilkan seluruh produk yang masuk ke keranjang. Kode ini bisa kita panggil berkali-kali sesuai denga kebutuhan kita.
4. Apa perbedaan class component dan functional component?
    - Class component memiliki state, sedangkan function based component tidak memiliki state (hanya menerima props). Secara sederhana, ketika kita membutuhkan state sudah hampir pasti akan membutuhkan class based component.
5. Dalam react, apakah perbedaan component dan element?
    - Komponen pada React secara konsep sama seperti function pada JavaScript, perbedaannya adalah jika function menerima sebarang input yang disebut parameter atau argumen dan me-return sebuah nilai, komponen menerima input yang disebut props dan me-return React Element yang menggambarkan apa yang akan ditampilkan di layar. Komponen memungkinkan kita untuk membuat UI yang independent, isolated, dan reusable sehingga mengurangi repetisi kode.
    - Elemen adalah blok bangunan terkecil di React, yang menggambarkan apa yang akan dilihat oleh user di layar mereka. Secara sederhana, elemen dapat didefinisikan sebagai representasi virtual dari DOM.

---

## Tutorial 6
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
   - Otentikasi digunakan untuk memeriksa apakah username dan password dari akun pengguna ada di sistem. Sementara itu, otorisasi digunakan untuk memeriksa hak akses atau izin pengguna yang sudah diotentikasikan untuk mengakses bagian spesifik sistem.
   - Implementasi otentikasi pada class WebSecurityConfig: 
   ```
   @Autowired
     public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
     auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
     }
   ```
   - Implementasi otorisasi pada class WebSecurityConfig:
   ```
   antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/user/viewall").hasAnyAuthority("ADMIN")
                .antMatchers("/user/add").hasAnyAuthority("ADMIN")
                .antMatchers("/penjaga/add/{noBioskop}").hasAnyAuthority("MANAGER")
                .antMatchers("/penjaga/update/{noPenjaga}").hasAnyAuthority("MANAGER")
                .antMatchers("/penjaga/delete").hasAnyAuthority("MANAGER")
                
   ```
   
2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
   - BCryptPasswordEncoder merupakan sebuah fungsi hashing yang digunakan untuk pengenkripsian password sehingga password tidak diketahui walaupun dapat dilihat di database.
   - BcryptPasswordEncoder mengenkripsi String raw password menjadi sebuah String yang diacak agar tidak mudah diketahui.
   
3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?
   - Informasi yang disimpan hashing secara general kecil dari sisi memori dan merupakan memori fixed length, sedangkan encryption menyimpan informasi yang bukan merupakan fixed length sehingga informasi tersebut bertumbuh seiring bertambahnya informasi password yang digunakan.
   - Untuk tingkat keamanan, hashing lebih aman dibandingkan encryption 

4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
   - Universally Unique Identifier (UUID) digunakan untuk mengidentifikasi secara unik beberapa objek atau entitas di internet. Bergantung pada mekanisme spesifik yang digunakan, UUID dijamin berbeda atau paling tidak sangat mungkin berbeda dari UUID lain yang ada. UUID digunakan untuk meningkatkan keamanan data pengguna dikarenakan id pengguna akan di-generate secara unik dengan hashing sebanyak 32 karakter secara acak sehingga id pengguna aman dan tidak mudah untuk diretas.

5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut?
   - UserDetailsService adalah antarmuka inti dalam kerangka kerja Spring Security, yang digunakan untuk mengambil informasi otentikasi dan otorisasi pengguna. Ini memiliki metode baca-saja tunggal bernama loadUserByUsername() yang mencari pengguna berdasarkan nama pengguna.

---

## Tutorial 5
1. Apa itu Postman? Apa kegunaannya?
   - Postman merupakan sebuah plugin atau aplikasi untuk browser sebagai REST Client. Aplikasi ini berguna untuk melakukan uji coba REST API yang telah dibuat.
   - Postman berguna sebagai salah satu tool wajib bagi developer pada pembuatan API karena fungsi utamanya sebagai GUI API Caller. Selain API Caller, Postman juga menyediakan fitur lain, seperti Sharing Collection API for Documentation, Testing API, Real Time Collaboration, Monitoring API, dan Integration.
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
   - @JsonIgnoreProperties digunakan untuk mengabaikan proses properti JSON yang dibaca saat deserialisasi JSON. Hal ini dapat mempermudah untuk memanggil REST dan menghasilkan suatu objek domain.
   - @JsonProperty digunakan untuk memetakan nama properti dengan JSON key saat serialisasi dan deserialisasi.
3. Apa kegunaan atribut WebClient?
   - WebClient digunakan untuk restserviceimpl yang digunakan untuk mengirim serta menerima data dari resource URI.
4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
   - ResponseEntity berguna untuk mewakili seluruh respons HTTP dan berguna untuk mengikonfigurasi response HTTP secara keseluruhan.
   - BindingResult biasanya berisikan informasi mengenai kesalahan, misalkan field yang diperlukan, adanya ketidakcocokan jenis atau kesalahan dalam melakukan pemanggilan method.

---

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
    - *A dependency is an essential functionality, library or piece of code that???s essential for a different part of the code to work. For example, a specific library that a given line of code depends on.*

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