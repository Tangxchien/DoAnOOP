package controller;

public class LoaiSanPham {
    public static SanPham loaiSanPham(String maSanPham, int soLuong) {
        switch (maSanPham) {
            case "101":
                return new SanPham(maSanPham, "COCACOLA", 12000, soLuong);
            case "102":
                return new SanPham(maSanPham, "FANTA", 10000, soLuong);
            case "103":
                return new SanPham(maSanPham, "SPRITE", 10000, soLuong);
            case "104":
                return new SanPham(maSanPham, "PEPSI", 12000, soLuong);
            case "105":
                return new SanPham(maSanPham, "AQUAFINA", 6000, soLuong);
            case "106":
                return new SanPham(maSanPham, "MONSTER", 35000, soLuong);
            default:
                return null;
        }
    }
}
