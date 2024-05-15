# BookKu App Books Service

### *Developers*:
- Emir Mohamad Fathan (2206081982)
- Fazle Ilahi Bimo Aji (2206081446)

## *Design Pattern*
Ref: 
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

Dalam proyek ini, kami mengadopsi Arsitektur Perangkat Lunak berbasis Microservices. Kami telah memisahkan aplikasi 
kami menjadi beberapa layanan yang termasuk Layanan Pengguna & Autentikasi, Layanan Kupon, Layanan Cart & Riwayat, 
Layanan Buku, dan Layanan Front-End.
