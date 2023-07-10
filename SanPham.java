package controller;

public class SanPham {
    private String tenSanPham;
    private String maSanPham;
    private int giaSanPham;
    private int soLuong;

    public SanPham(String maSanPham, String tenSanPham, int giaSanPham, int soLuong) {
        this.tenSanPham = tenSanPham;
        this.maSanPham = maSanPham;
        this.giaSanPham = giaSanPham;
        this.soLuong = soLuong;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setGiaSanPham(int giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public int getGiaSanPham() {
        return giaSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }
    public int getGiaTongSanPham(){
        return giaSanPham * soLuong;
    }
}
