# BookKu App Books Service

### *Developers*:
- Emir Mohamad Fathan (2206081982)
- Fazle Ilahi Bimo Aji (2206081446)

## *Design Pattern*
Ref: 
- https://refactoring.guru/design-patterns/singleton
- https://refactoring.guru/design-patterns/chain-of-responsibility
- https://refactoring.guru/design-patterns/builder

### *Book Service*


### *Book List Service*
Service ini menerapkan _Chain of Responsibility_ (CoR) _Pattern_ terutama untuk menangani layanan penyaringan dan 
pengurutan tampilan buku untuk pengguna.

- _Chain of Responsibility pattern_ digunakan karena pengguna nantinya akan memiliki beberapa pilihan layanan yang 
berbeda namun harus ditangani secara berurutan dan sistematis.
- Berurutan pada kasus ini menandakan bahwa akan ada _link_ pada _handler_ yang satu dengan _handler_ lainnya.
- _Handler_ yang memiliki kapasitas untuk melayani permintaan pengguna akan langsung mengeksekusi permintaannya. 
- Sementara _handler_ yang belum memiliki kapabilitas untuk memenuhi permintaan akan mengirimkan permintaan tersebut 
ke handler lainnya.

Dengan menggunakan _Chain of Responsibility_, kami dapat mengatur urutan dari permintaan atau _request_ yang beragam dari 
pengguna serta dapat memastikan bahwa setiap permintaan dapat ditangani oleh _handler_ yang ada. 

### *CRUD Book Services*
Service ini menggunakan _Builder Pattern_. Builder pattern menguntungkan kita agar saat membuat dummy objek yang tidak memiliki atribut tertentu, kita tidak perlu men-set default nilai pada classnya atau tidak perlu membuat null di atributnya. Contoh implementasinya adalah saat pembuatan test model book. Disini ada dummy book yang dibuat dengan id dan tanpa id.

## *Software Architecture*

_Software architecture_ merupakan perencanaan konsep yang berhubungan dalam _software development_. Ada beberapa aspek yang 
diperhatikan oleh _software architecture_, ada aspek teknis dan nonteknis. Aspek teknis contohnya adalah fungsionalitas 
dan kompleksitas program, skalabilitas, keamanan. Sedangkan aspek nonteknis lebih mencakup kepada sumber daya, seperti 
ketersediaan anggaran, waktu, dan lain-lain. Ada beberapa jenis _software architecture_ contohnya adalah _microservices_ dan
_event-driven architecture_.

Pada proyek kali ini, kami menerapkan _microservices architecture_ dengan berbagai pertimbangan sebagai berikut,

- Dependensi layanan menjadi minimal sehingga apabila suatu layanan mengalami kendala, kecil kemungkinannya layanan 
lain juga akan terdampak mengalami kendala yang serupa.
- Bagian yang sudah stabil dapat terus berkembang tanpa harus menunggu bagian lain selesai. Tim yang bertanggung jawab 
atas bagian tertentu dapat fokus pada pengembangan dan peningkatan fitur tanpa terhambat oleh tim lain.
- Arsitektur _microservices_ memungkinkan aplikasi untuk lebih mudah diskalakan dan dipelihara. Setiap layanan dapat 
dikembangkan, di-_deploy_, dan diskalakan secara independen.

Dengan pertimbangan-pertimbangan tersebut, microservices memberikan keuntungan signifikan dalam pengelolaan, 
pengembangan, dan skalabilitas aplikasi dibandingkan dengan pendekatan monolitik. Dalam menerapkan arsitektur ini, 
kami membagi aplikasi kami ke dalam beberapa bagian sebagai berikut,

- _Dashboard_ admin + layanan buku (Fathan & Bimo)
- Keranjang, _checkout_ + riwayat (Ilham)
- _Authentication_ + _profile_ (Fadhil)
- _Landing page_ + kupon (Zaidan)

## *Deployment*
Berikut merupakan tautan _deployment_ API Book: http://34.87.170.153/
