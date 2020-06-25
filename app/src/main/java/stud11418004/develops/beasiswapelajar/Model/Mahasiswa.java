package stud11418004.develops.beasiswapelajar.Model;

public class Mahasiswa {

    private String email, nama, jurusan, asal_univ, alamat, gender, tempat_lahir, tanggal_lahir;

    public Mahasiswa(String email, String nama, String asal_univ, String jurusan, String gender, String tempat_lahir, String tanggal_lahir, String alamat) {
        this.email = email;
        this.nama = nama;
        this.asal_univ = asal_univ;
        this.jurusan = jurusan;
        this.gender = gender;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getAsal_univ() {
        return asal_univ;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getGender() {
        return gender;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }
}
