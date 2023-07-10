
package controller;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.stage.Stage;

        import java.io.IOException;
        import java.util.Optional;

public class GioHangController {
    @FXML
    private Label NumberLabel;
    @FXML
    private Label notification;
    @FXML
    private TextField CodeProduct;
    @FXML
    private Label CartLabel;
    @FXML
    private Label Total;
    @FXML
    private Label Payment;

    private GioHang gioHang;

    public void initialize() {
        gioHang = new GioHang();
    }

    public void themNhieuSanPham(ActionEvent event) {
        String maSanPham = CodeProduct.getText();
        String sNumber = NumberLabel.getText();
        int soLuong = Integer.parseInt(sNumber);

        SanPham sanPham = LoaiSanPham.loaiSanPham(maSanPham, soLuong);
        if (sanPham == null) {
            notification.setText("Mã sản phẩm không hợp lệ!");
            return;
        }

        gioHang.themSanPham(sanPham);

        CartLabel.setText(gioHang.getCart());
        Total.setText(gioHang.getTotal());
    }



    public void xoaSanPham(ActionEvent event) {
        String productCode = CodeProduct.getText();
        String sNumber = NumberLabel.getText();
        int soLuong = Integer.parseInt(sNumber);

        SanPham product = LoaiSanPham.loaiSanPham(productCode, soLuong);
        if (product == null) {
            notification.setText("Mã sản phẩm không hợp lệ!");
            return;
        }

        if (gioHang.xoaSanPhamTheoMa(product)) {
            CartLabel.setText(gioHang.getCart());
            Total.setText(gioHang.getTotal());
        }
    }

    public void thanhToanGioHang(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Bạn xác nhận thanh toán giỏ hàng này ?"+ "\n" + "Vui lòng nạp vào "+ gioHang.getTongGiaTien());
        alert.setTitle("Thông báo thanh toán");
        alert.setContentText("Nhấn hai lần để xác nhận !");

        ButtonType buttonTypeYes = new ButtonType("Có", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("Không", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();

        if(result.get()== buttonTypeYes)
        {
            System.out.println("Giỏ hàng đã được thanh toán");
            gioHang.thanhToan();
            CartLabel.setText(gioHang.getCart());
            Total.setText(gioHang.getTotal());
            }
        else if(result.get().getButtonData() == ButtonBar.ButtonData.NO)
            System.out.println("Giỏ hàng chưa được thanh toán");
        alert.show();
    }
    public void thanhToanSanPham(ActionEvent event){
        String sNumber = NumberLabel.getText();
        int soLuong = Integer.parseInt(sNumber);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Bạn xác nhận thanh toán giỏ hàng này ?"+ "\n" + "Vui lòng nạp vào "+ soLuong * 12000 + "VND");
        alert.setTitle("Thông báo thanh toán");
        alert.setContentText("Nhấn hai lần để xác nhận !");

        ButtonType buttonTypeYes = new ButtonType("Có", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("Không", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();

        if(result.get()== buttonTypeYes)
        {
            System.out.println("Giỏ hàng đã được thanh toán");
            NumberLabel.setText("0");
        }
        else if(result.get().getButtonData() == ButtonBar.ButtonData.NO) {
            System.out.println("Giỏ hàng chưa được thanh toán");
        }
    }

    public void ButtonUp(ActionEvent event) {
        String sNumber = NumberLabel.getText();
        int iNumber = Integer.parseInt(sNumber);
        sNumber = String.valueOf(iNumber + 1);
        NumberLabel.setText(sNumber);
    }

    public void ButtonDown(ActionEvent event) {
        String sNumber = NumberLabel.getText();
        int iNumber = Integer.parseInt(sNumber);
        if (iNumber > 0) {
            sNumber = String.valueOf(iNumber - 1);
            notification.setText("");
        } else {
            notification.setText("Số lượng sản phẩm không hợp lệ !");
        }
        NumberLabel.setText(sNumber);
    }


    public void returnMainView(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        returnOOPView();
    }

    private void returnOOPView() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/OOPView.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}