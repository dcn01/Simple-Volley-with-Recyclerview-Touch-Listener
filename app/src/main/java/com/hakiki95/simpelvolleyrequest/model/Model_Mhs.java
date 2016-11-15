package com.hakiki95.simpelvolleyrequest.model;

/**
 * Created by hakiki95 on 14/11/2016.
 */

public class Model_Mhs {
    String ImageUrl,npm, nama, prodi, fakultas;


    public Model_Mhs(){}

    public Model_Mhs(String imageUrl, String npm, String nama, String prodi, String fakultas) {
        ImageUrl = imageUrl;
        this.npm = npm;
        this.nama = nama;
        this.prodi = prodi;
        this.fakultas = fakultas;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
}
