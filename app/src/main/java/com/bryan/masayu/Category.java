package com.bryan.masayu;

public class Category {
    String namaKategori;
    Integer image;

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Category() {
        this.namaKategori = namaKategori;
        this.image = image;
    }
}
