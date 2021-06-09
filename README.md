# AsyncTask

Contoh implementasi multi-threading yang menunjukan eksekusi suatu background task.
Pada aplikasi, task tersebut dijalankan saat klik tombol "Start Task", yang akan 'execute()' satu buah thread.
Thread tersebut pun akan sleep dengan waktu yang random. Untuk menambah thread yang dieksekusi, tinggal mengubah parameter execute, contohnya : execute(5).

Pada thread dilakukan publishProgress untuk menampilkan hasil waktu yang di random. publishProgress sendiri dapat digunakan untuk mengumumkan
kepada pengguna mengenai tahap operasi yang sedang dilakukan pada thread saat thread tersebut berjalan. Contohnya untuk persentase proses, proses yang sedang berjalan, dll.
