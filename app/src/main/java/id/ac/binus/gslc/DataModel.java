package id.ac.binus.gslc;

public class DataModel {
    private int image;
    private String nama;
    private String harga;

    public DataModel(int image, String nama, String harga) {
        this.image = image;
        this.nama = nama;
        this.harga = harga;
    }

    public int getImage() {
        return image;
    }

    public String getNama() {
        return nama;
    }

    public String getHarga() {
        return harga;
    }
}
