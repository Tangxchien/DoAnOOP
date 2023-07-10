package controller;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class GioHang {
    private ArrayList<SanPham> gioHang;
    private int tongGiaTien;
    private int soLuongSanPham;
    private int giaTienSanPham;

    public GioHang() {
        gioHang = new ArrayList<SanPham>();
        tongGiaTien = 0;
        soLuongSanPham = 0;
    }

    public void themSanPham(SanPham sanPham) {
        for (SanPham sp : gioHang) {
            if (sp.getMaSanPham().equals(sanPham.getMaSanPham())) {
                sp.setSoLuong(sp.getSoLuong() + sanPham.getSoLuong());
                giaTienSanPham = sp.getGiaSanPham() * sp.getSoLuong();
                tongGiaTien += sanPham.getGiaSanPham() * sanPham.getSoLuong();
                return;
            }
        }
        gioHang.add(sanPham);
        giaTienSanPham = sanPham.getGiaSanPham() * sanPham.getSoLuong();
        tongGiaTien += sanPham.getGiaTongSanPham();
        soLuongSanPham++;
    }

    public boolean xoaSanPhamTheoMa(SanPham sanPham) {
        giaTienSanPham = 0;
        for (int i = 0; i < soLuongSanPham; i++) {
            SanPham sp = gioHang.get(i);
            if(sp.getMaSanPham().equals(sanPham.getMaSanPham()) && sp.getSoLuong() < sanPham.getSoLuong()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Errol");
                alert.setHeaderText("Số lượng sản phẩm không hợp lệ");
                alert.show();
            }
            else{
                if (sp.getMaSanPham().equals(sanPham.getMaSanPham()) && sp.getSoLuong() == sanPham.getSoLuong()) {
                    tongGiaTien -= sanPham.getGiaTongSanPham();
                    gioHang.remove(i);
                    soLuongSanPham--;
                    return true;
                } else if (sp.getMaSanPham().equals(sanPham.getMaSanPham()) && sp.getSoLuong() != sanPham.getSoLuong()) {
                    sp.setSoLuong(sp.getSoLuong() - sanPham.getSoLuong());
                    tongGiaTien -= sanPham.getGiaTongSanPham();
                    return true;
                }
            }
        }
        return false;
    }
    public void thanhToan(){
        gioHang.clear();
        tongGiaTien = 0;
        soLuongSanPham = 0;
        giaTienSanPham = 0;

    }
    public String getCart() {
        StringBuilder productsString = new StringBuilder();
        for (SanPham sanPham : gioHang) {
            productsString.append("+ ").append(sanPham.getTenSanPham()).append(" x").append(sanPham.getSoLuong()).append("\n");
        }
        return productsString.toString();
    }

    public String getTotal() {
        return "THÀNH TIỀN: " + giaTienSanPham + " VND" + "    Tổng: " + tongGiaTien + "VND";
    }
    public String getTongGiaTien() {
         return tongGiaTien + " VND";
    }

}
