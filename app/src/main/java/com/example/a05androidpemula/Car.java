package com.example.a05androidpemula;

public class Car {
    private String nama,detail,kapasitas,tranmisi, bahanBakar;
    private int sewa, foto;
    private String keterangan = "Jarak tempuh maksimal yang diperbolehkan 300 KM perhari, " +
            "jika lebih akan dikenakan sebesar Rp.2000 per km";


    public Car(String nama, int sewa, String detail, String kapasitas, String tranmisi,
               String bahanBakar, int foto) {
        this.nama = nama;
        this.detail = detail;
        this.kapasitas = kapasitas;
        this.tranmisi = tranmisi;
        this.bahanBakar = bahanBakar;
        this.sewa = sewa;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }
    public String getDetail() {
        return detail;
    }
    public String getKapasitas() {
        return kapasitas;
    }
    public String getTranmisi() {
        return tranmisi;
    }
    public String getBahanBakar() {
        return bahanBakar;
    }
    public String getKeterangan() {
        return keterangan;
    }
    public int getSewa() {
        return sewa;
    }
    public int getFoto() {
        return foto;
    }
}
