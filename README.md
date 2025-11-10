# Dev Log | Terminal Version

![todoist webpage](todoist_page.png)

Project todolist sederhana dari Java, yang mencoba mengikuti fitur-fitur yang ada dari salah salah satu aplikasi Todolist desktop yang sering dipaka, yaitu [Todoist](https://www.todoist.com/).

Made by 💖

## V0.0.1 (8/11/2025)

- Menambahkan fitur `Workspaces` untuk membungkus daftar `Project`. Menerima opsi `Color` untuk membedakan beberapa workspaces berdasarkan warna.
- Membuat fitur `Project` untuk membungkus daftar `Inbox`. Opsi yang mengelompokan (grouping) daftar `Inbox`. 
- Menambahkan opsi `Inbox` sebagai grouping `Task`, dengan fitur ganti nama Inbox, prioritas, dan urutkan berdasarkan pembuatan (date created).
- Mengatasi beberapa file `jar` tambahan, maka digunakan project build yaitu Maven.
- Menambahkan beberapa library penting (_dependencies berasal dari [Maven Repository](https://mvnrepository.com/)_), seperti:
  1. [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson), library Java yang berguna untuk melakukan pembacaan dan penulisan data dengan file eksternal JSON.
  2. [Flatlaf](https://central.sonatype.com/artifact/com.formdev/flatlaf), Javax.swing memiliki tampilan yang kurang modern, sehingga digunakan library Flatlaf yang menawarkan tampilan yang lebih modern dan smooth.
  3. [SQLite JDBC](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc), library Java untuk mengkoneksikan aplikasi Java dengan SQLite.
  4. [JFreeChart](https://mvnrepository.com/artifact/org.jfree/jfreechart), library Java untuk menanmpilkan dan mengenerate chart atau grafik, support beberapa desain dan tipe chart.
  5. [OpenCVS](https://mvnrepository.com/artifact/com.opencsv/opencsv), Java bisa melakukan pembacaan dan penulisan file dengan file CSV tanpa library tambahan. Namun library ini bisa digunakan untuk menangani beberapa konfigurasi yang mungkin belum ada di Java.

## V0.0.2 (10/11/2025)

- Menyederhanakan fitur `workspace`, dan mengalihkan opsi-opsi yang sebelumnya dimiliki oleh `workspace` menjadi milik fitur `project`.
- Penanganan kesalahan inputan lebih baik dengan Try Catch, dan menggunakan DateTimeFormatter untuk menampilkan tanggal dengan format custom.