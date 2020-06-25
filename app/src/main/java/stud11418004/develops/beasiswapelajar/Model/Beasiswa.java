package stud11418004.develops.beasiswapelajar.Model;

public class Beasiswa {
    private String nama, deskripsi, nominal;

    public Beasiswa(String nama, String deskripsi, String nominal) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.nominal = nominal;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getNominal() {
        return nominal;
    }
}
