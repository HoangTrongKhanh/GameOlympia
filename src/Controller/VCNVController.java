package Controller;

import BLL.BKeyVCNV;
import BLL.BVuotChuongNgaiVat;
import EntityOlympia.EKeyVCNV;
import EntityOlympia.EVuotChuongNgaiVat;
import Singleton.Point;
import Utils.DelayUtil;
import Utils.FadeTransitionUtil;
import Utils.Toast;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

public class VCNVController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private HBox hBox1;

    @FXML
    private Button btnHangNgang1;

    @FXML
    private HBox hBox2;

    @FXML
    private Button btnHangNgang2;

    @FXML
    private HBox hBox3;

    @FXML
    private Button btnHangNgang3;

    @FXML
    private HBox hBox4;

    @FXML
    private Button btnHangNgang4;

    @FXML
    private Button btnTuKhoa;

    @FXML
    private Label lblDiem;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblCauHoi;

    @FXML
    private Label lblTuKhoa;

    @FXML
    private ImageView imgTuKhoa;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnEndGame;

    @FXML
    private VBox vBoxEndGame;

    @FXML
    private Label lblEndGame;

    @FXML
    private Button btnOkTangToc;

    @FXML
    private Button btnCancel;

    @FXML
    private Label lblSoOTuKhoa;

    private EVuotChuongNgaiVat hang1;
    private EVuotChuongNgaiVat hang2;
    private EVuotChuongNgaiVat hang3;
    private EVuotChuongNgaiVat hang4;
    private EKeyVCNV tuKhoa;
    private Point point = Point.Instance();
    private int soOHNDaMo;
    private int hangNgang;
    private Timeline timeline;

    private TextField[] txtHang1;
    private TextField[] txtHang2;
    private TextField[] txtHang3;
    private TextField[] txtHang4;

    private int[] arrPos = {0, 50, 110, 170, 230};
    private Random rand = new Random();
    private Button btnTraLoiHangNgang1;
    private Button btnTraLoiHangNgang2;
    private Button btnTraLoiHangNgang3;
    private Button btnTraLoiHangNgang4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootPane.setOpacity(0);
        FadeTransitionUtil.FadeIn(rootPane);

        int STT = rand.nextInt(6) + 1;
        hang1 = BVuotChuongNgaiVat.SelectBy2Id(STT, 1);
        hang2 = BVuotChuongNgaiVat.SelectBy2Id(STT, 2);
        hang3 = BVuotChuongNgaiVat.SelectBy2Id(STT, 3);
        hang4 = BVuotChuongNgaiVat.SelectBy2Id(STT, 4);
        tuKhoa = BKeyVCNV.SelectById(STT);
        if(tuKhoa != null) {
            DelayUtil.delay(1000, () -> lblTuKhoa.setText(tuKhoa.getQuestion()));
            imgTuKhoa.setImage(new Image(tuKhoa.getPath()));
            lblSoOTuKhoa.setText("Câu hỏi từ khoá. " + "Số chữ cái: " + tuKhoa.getSoOHN());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Không truy xuất được dữ liệu. Xem lại kết nối database.");
        }

        lblDiem.setText("Điểm " + point.getPoint());
        soOHNDaMo = 0;

        btnHangNgang1.setOnAction(event -> handleHangNgang1(true));
        btnHangNgang2.setOnAction(event -> handleHangNgang2(true));
        btnHangNgang3.setOnAction(event -> handleHangNgang3(true));
        btnHangNgang4.setOnAction(event -> handleHangNgang4(true));
        btnBack.setOnAction(event -> handleBack());
        btnTuKhoa.setOnAction(event -> handleTraLoiTuKhoa());
        btnEndGame.setOnAction(event -> alertEndGame());
    }

    private void handleTraLoiTuKhoa() {
        if(timeline != null) {
            timeline.pause();
        }
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Trả lời từ khoá");
        dialog.setHeaderText(tuKhoa.getQuestion());
        dialog.setContentText("Câu trả lời của bạn (Viết liền không dấu)");

        Optional<String> result = dialog.showAndWait();
        if(result.isPresent()) {
            if(tuKhoa.IsCorrect(result.get())) {
                KeywordAnswered();
                switch (soOHNDaMo) {
                    case 0:
                    case 1:
                        point.add(80);
                        break;
                    case 2:
                        point.add(60);
                        break;
                    case 3:
                        point.add(40);
                        break;
                    case 4:
                        point.add(20);
                        break;
                }
                lblDiem.setText("Điểm " + point.getPoint());
                Toast.makeText(rootPane, "Đúng rồi");
            } else {
                Toast.makeText(rootPane, "Sai rồi");
                DelayUtil.delay(1000, this::alertEndGame);
            }
        }
    }

    private void KeywordAnswered() {
        //Mở các hàng 1,2,3,4
        btnHangNgang1.setOnAction(event -> handleHangNgang1(false));
        btnHangNgang2.setOnAction(event -> handleHangNgang2(false));
        btnHangNgang3.setOnAction(event -> handleHangNgang3(false));
        btnHangNgang4.setOnAction(event -> handleHangNgang4(false));

        //mở hình
        pane1.setVisible(false);
        pane2.setVisible(false);
        pane3.setVisible(false);
        pane4.setVisible(false);
    }

    private void handleBack() {
        Point.Deinit();
        try {
            Parent secondView = FXMLLoader.load(getClass().getClassLoader().getResource("Controller/View/Main.fxml"));
            FadeTransitionUtil.FadeOut(secondView, rootPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleHangNgang1(boolean showButton) {
        soOHNDaMo++;
        if(showButton) {hideButton(hangNgang);}
        hangNgang = 1;
        if(timeline != null) {
            timeline.stop();
        }
        DelayUtil.delay(1000, ()->lblCauHoi.setText(hang1.getQuestion()));
        int soOHN = hang1.getSoOHN();
        int pos = arrPos[rand.nextInt(arrPos.length)];

        if((soOHN > 11 && pos >= 170) || pos == 0) {
            hBox1.getChildren().remove(btnHangNgang1);
        } else {
            btnHangNgang1.setPrefWidth(pos);
            btnHangNgang1.setVisible(false);
        }

        txtHang1 = new TextField[soOHN];
        addTextFieldsToHBox(txtHang1, hBox1);

        if(showButton) {
            DelayUtil.delay(1000, this::countDownTime);
            btnTraLoiHangNgang1 = new Button("Trả lời");
            btnTraLoiHangNgang1.setMinSize(100, 50);
            btnTraLoiHangNgang1.setPrefSize(100, 50);
            btnTraLoiHangNgang1.setStyle("-fx-font-size: 20");
            btnTraLoiHangNgang1.setOnAction(event -> handleTraLoiHangNgang1());
            hBox1.getChildren().add(btnTraLoiHangNgang1);
        } else {
            for(int i = 0; i < txtHang1.length; i++) {
                txtHang1[i].setText(String.valueOf(hang1.getAnswer().charAt(i)));
            }
        }
    }

    private void handleTraLoiHangNgang1() {
        timeline.stop();
        String ansOfUser = "";
        for (int i = 0; i < txtHang1.length; i++) {
            ansOfUser += txtHang1[i].getText();
        }
        checkAnswerOfUser(hang1, ansOfUser, pane1, btnTraLoiHangNgang1);
    }

    private void handleHangNgang2(boolean showButton) {
        soOHNDaMo++;
        if(showButton) {hideButton(hangNgang);}
        hangNgang = 2;
        if(timeline != null) {
            timeline.stop();
        }
        DelayUtil.delay(1000, ()->lblCauHoi.setText(hang2.getQuestion()));
        int soOHN = hang2.getSoOHN();
        int pos = arrPos[rand.nextInt(arrPos.length)];

        if((soOHN > 11 && pos >= 170) || pos == 0) {
            hBox2.getChildren().remove(btnHangNgang2);
        } else {
            btnHangNgang2.setPrefWidth(pos);
            btnHangNgang2.setVisible(false);
        }

        txtHang2 = new TextField[soOHN];
        addTextFieldsToHBox(txtHang2, hBox2);

        if(showButton) {
            DelayUtil.delay(1000, this::countDownTime);
            btnTraLoiHangNgang2 = new Button("Trả lời");
            btnTraLoiHangNgang2.setMinSize(100, 50);
            btnTraLoiHangNgang2.setPrefSize(100, 50);
            btnTraLoiHangNgang2.setStyle("-fx-font-size: 20");
            btnTraLoiHangNgang2.setOnAction(event -> handleTraLoiHangNgang2());
            hBox2.getChildren().add(btnTraLoiHangNgang2);
        } else {
            for(int i = 0; i < txtHang2.length; i++) {
                txtHang2[i].setText(String.valueOf(hang2.getAnswer().charAt(i)));
            }
        }
    }

    private void handleTraLoiHangNgang2() {
        timeline.stop();
        String ansOfUser = "";
        for (int i = 0; i < txtHang2.length; i++) {
            ansOfUser += txtHang2[i].getText();
        }
        checkAnswerOfUser(hang2, ansOfUser, pane2, btnTraLoiHangNgang2);
    }

    private void handleHangNgang3(boolean showButton) {
        soOHNDaMo++;
        if(showButton) {hideButton(hangNgang);}
        hangNgang = 3;
        if(timeline != null) {
            timeline.stop();
        }
        DelayUtil.delay(1000, ()->lblCauHoi.setText(hang3.getQuestion()));
        int soOHN = hang3.getSoOHN();
        int pos = arrPos[rand.nextInt(arrPos.length)];

        if((soOHN > 11 && pos >= 170) || pos == 0) {
            hBox3.getChildren().remove(btnHangNgang3);
        } else {
            btnHangNgang3.setPrefWidth(pos);
            btnHangNgang3.setVisible(false);
        }
        txtHang3 = new TextField[soOHN];
        addTextFieldsToHBox(txtHang3, hBox3);
        if(showButton) {
            DelayUtil.delay(1000, this::countDownTime);
            btnTraLoiHangNgang3 = new Button("Trả lời");
            btnTraLoiHangNgang3.setMinSize(100, 50);
            btnTraLoiHangNgang3.setPrefSize(100, 50);
            btnTraLoiHangNgang3.setStyle("-fx-font-size: 20");
            btnTraLoiHangNgang3.setOnAction(event -> handleTraLoiHangNgang3());
            hBox3.getChildren().add(btnTraLoiHangNgang3);
        } else {
            for(int i = 0; i < txtHang3.length; i++) {
                txtHang3[i].setText(String.valueOf(hang3.getAnswer().charAt(i)));
            }
        }
    }

    private void handleTraLoiHangNgang3() {
        timeline.stop();
        String ansOfUser = "";
        for (int i = 0; i < txtHang3.length; i++) {
            ansOfUser += txtHang3[i].getText();
        }
        checkAnswerOfUser(hang3, ansOfUser, pane3, btnTraLoiHangNgang3);
    }

    private void handleHangNgang4(boolean showButton) {
        soOHNDaMo++;
        if(showButton) {hideButton(hangNgang);}
        hangNgang = 4;
        if(timeline != null) {
            timeline.stop();
        }
        DelayUtil.delay(1000, ()->lblCauHoi.setText(hang4.getQuestion()));
        int soOHN = hang4.getSoOHN();
        int pos = arrPos[rand.nextInt(arrPos.length)];

        if((soOHN > 11 && pos >= 170) || pos == 0) {
            hBox4.getChildren().remove(btnHangNgang4);
        } else {
            btnHangNgang4.setPrefWidth(pos);
            btnHangNgang4.setVisible(false);
        }

        txtHang4 = new TextField[soOHN];
        addTextFieldsToHBox(txtHang4, hBox4);
        if(showButton) {
            DelayUtil.delay(1000, this::countDownTime);
            btnTraLoiHangNgang4 = new Button("Trả lời");
            btnTraLoiHangNgang4.setMinSize(100, 50);
            btnTraLoiHangNgang4.setPrefSize(100, 50);
            btnTraLoiHangNgang4.setStyle("-fx-font-size: 20");
            btnTraLoiHangNgang4.setOnAction(event -> handleTraLoiHangNgang4());
            hBox4.getChildren().add(btnTraLoiHangNgang4);
        } else {
            for(int i = 0; i < txtHang4.length; i++) {
                txtHang4[i].setText(String.valueOf(hang4.getAnswer().charAt(i)));
            }
        }
    }

    private void handleTraLoiHangNgang4() {
        timeline.stop();
        String ansOfUser = "";
        for (int i = 0; i < txtHang4.length; i++) {
            ansOfUser += txtHang4[i].getText();
        }
        checkAnswerOfUser(hang4, ansOfUser, pane4, btnTraLoiHangNgang4);
    }

    private void hideButton(int i) {
        switch (i) {
            case 1:
                btnTraLoiHangNgang1.setVisible(false);
                break;
            case 2:
                btnTraLoiHangNgang2.setVisible(false);
                break;
            case 3:
                btnTraLoiHangNgang3.setVisible(false);
                break;
            case 4:
                btnTraLoiHangNgang4.setVisible(false);
                break;
        }
    }

    private void addTextFieldsToHBox(TextField[] textFields, HBox hBox) {
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new TextField();
            textFields[i].setMinSize(50, 50);
            textFields[i].setPrefSize(50, 50);
            textFields[i].setStyle("-fx-font-size: 24");
            hBox.getChildren().add(textFields[i]);
        }
    }

    private void checkAnswerOfUser(EVuotChuongNgaiVat hang, String ans, Pane pane, Button btn) {
        if(hang.IsCorrect(ans)) {
            point.add(10);
            lblDiem.setText("Điểm " + point.getPoint());
            pane.setVisible(false);
            Toast.makeText(rootPane, "Đúng rồi");
        } else {
            Toast.makeText(rootPane, "Sai rồi");
        }
        btn.setVisible(false);
    }

    private void countDownTime() {
        IntegerProperty time = new SimpleIntegerProperty();
        KeyFrame[] keyFrames = new KeyFrame[31];
        for (int i = 0; i < keyFrames.length - 1; i++) {
            int finalI = i;
            keyFrames[i] = new KeyFrame(Duration.seconds(i), event -> {
                lblTime.setText(String.valueOf(30 - finalI));
            }, new KeyValue(time, i));
        }
        keyFrames[30] = new KeyFrame(Duration.seconds(30), event -> {
            lblTime.setText("0");
            Toast.makeText(rootPane, "Hết giờ");
            hideButton(hangNgang);
        }, new KeyValue(time, 20));

        timeline = new Timeline(keyFrames);

        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.play();
    }

    private void alertEndGame() {
        vBoxEndGame.setVisible(true);
        btnTuKhoa.setVisible(false);
        btnEndGame.setVisible(false);
        lblEndGame.setText("Chúc mừng bạn đã hoàn thành phần thi Vượt Chướng Ngại Vật với số điểm là: " + point.getPoint() +
                "\nBạn có muốn tiếp tục phần thi Tăng Tốc không?");
        btnOkTangToc.setOnAction(event -> {
            try {
                Parent secondView = FXMLLoader.load(getClass().getClassLoader().getResource("Controller/View/TangToc.fxml"));
                FadeTransitionUtil.FadeOut(secondView, rootPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnCancel.setOnAction(event -> handleBack());
    }

}
