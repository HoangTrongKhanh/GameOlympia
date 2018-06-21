package Controller;

import BLL.BTangToc;
import EntityOlympia.ETangToc;
import Singleton.Point;
import Utils.DelayUtil;
import Utils.FadeTransitionUtil;
import Utils.Toast;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class TangTocController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ProgressBar prsbTT;

    @FXML
    private Label lblSTTCauHoi;

    @FXML
    private Label lblDiem;

    @FXML
    private Label lblCauHoi;

    @FXML
    private Button btnA;

    @FXML
    private Button btnB;

    @FXML
    private Button btnC;

    @FXML
    private Button btnD;

    @FXML
    private VBox vBoxEndGame;

    @FXML
    private Label lblEndGame;

    @FXML
    private Button btnOKVeDich;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnBack;

    private ObservableList<ETangToc> tangTocData;
    private ETangToc tangToc;
    private Timeline timeline;
    private int stt = 0;
    private Point point = Point.Instance();
    private int soThoiGianDaQua = 0;
    private ArrayList<Integer> cauHoiDaQua = new ArrayList<Integer>();
    private Random rand = new Random();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootPane.setOpacity(0);
        FadeTransitionUtil.FadeIn(rootPane);

        lblDiem.setText(String.valueOf(point.getPoint()));

        tangTocData = BTangToc.SelectAll();
        if(tangTocData != null) {
            stt = rand.nextInt(tangTocData.size()) + 1;
            DelayUtil.delay(1000, ()->loadContent(stt));
            cauHoiDaQua.add(stt);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Không truy xuất được dữ liệu. Xem lại kết nối database");
        }

        lblSTTCauHoi.setText(String.valueOf(cauHoiDaQua.size()));
        DelayUtil.delay(1000, this::loadTime);

        btnA.setOnAction(event -> handleBtnA());
        btnB.setOnAction(event -> handleBtnB());
        btnC.setOnAction(event -> handleBtnC());
        btnD.setOnAction(event -> handleBtnD());
        btnBack.setOnAction(event -> handleBack());
    }

    private void handleBtnA() {
        if(tangToc.IsCorrect("A")) {
            timeline.stop();
            updatePoint();
            Toast.makeText(rootPane, "Đúng rồi");
            DelayUtil.delay(1000, this::NextQuestion);
        } else {
            // Tra Loi Sai
            Toast.makeText(rootPane, "Sai rồi");
            DelayUtil.delay(1000, this::NextQuestion);
        }
    }

    private void handleBtnB() {
        if(tangToc.IsCorrect("B")) {
            timeline.stop();
            updatePoint();
            Toast.makeText(rootPane, "Đúng rồi");
            DelayUtil.delay(1000, this::NextQuestion);
        } else {
            // Tra Loi Sai
            Toast.makeText(rootPane, "Sai rồi");
            DelayUtil.delay(1000, this::NextQuestion);
        }
    }

    private void handleBtnC() {
        if(tangToc.IsCorrect("C")) {
            timeline.stop();
            updatePoint();
            Toast.makeText(rootPane, "Đúng rồi");
            DelayUtil.delay(1000, this::NextQuestion);
        } else {
            // Tra Loi Sai
            Toast.makeText(rootPane, "Sai rồi");
            DelayUtil.delay(1000, this::NextQuestion);
        }
    }

    private void handleBtnD() {
        if(tangToc.IsCorrect("D")) {
            timeline.stop();
            updatePoint();
            Toast.makeText(rootPane, "Đúng rồi");
            DelayUtil.delay(1000, this::NextQuestion);
        } else {
            // Tra Loi Sai
            Toast.makeText(rootPane, "Sai rồi");
            DelayUtil.delay(1000, this::NextQuestion);
        }
    }

    private void updatePoint() {
        if(soThoiGianDaQua < 6) {
            point.add(40);
        } else if(soThoiGianDaQua < 11) {
            point.add(30);
        } else if(soThoiGianDaQua < 16) {
            point.add(20);
        } else {
            point.add(10);
        }
        lblDiem.setText(String.valueOf(point.getPoint()));
    }

    private void NextQuestion() {
        if(cauHoiDaQua.size() < 4) {
            do {
                stt = rand.nextInt(tangTocData.size()) + 1;
            } while (cauHoiDaQua.contains(stt));
            cauHoiDaQua.add(stt);
            lblSTTCauHoi.setText(String.valueOf(cauHoiDaQua.size()));
            loadContent(stt);
            loadTime();
        } else {
            timeline.pause();
            DelayUtil.delay(1000, this::endGame);
        }
    }

    private void loadContent(int STT) {
        for (ETangToc temp : tangTocData) {
            if (temp.getStt() == STT) {
                lblCauHoi.setText(temp.getQuestion());
                btnA.setText(temp.getAnsA());
                btnB.setText(temp.getAnsB());
                btnC.setText(temp.getAnsC());
                btnD.setText(temp.getAnsD());
                tangToc = temp;
            }
        }
    }

    private void endGame() {
        vBoxEndGame.setVisible(true);
        lblEndGame.setText("Chúc mừng bạn đã hoàn thành phần thi Tăng Tốc với số điểm là: " + point.getPoint() +
                "\nBạn có muốn tiếp tục phần thi Về Đích không?");

        btnOKVeDich.setOnAction(event -> {
            try {
                Parent secondView = FXMLLoader.load(getClass().getClassLoader().getResource("Controller/View/VeDich.fxml"));
                FadeTransitionUtil.FadeOut(secondView, rootPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnCancel.setOnAction(event -> handleBack());
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

    private void loadTime() {
        IntegerProperty time = new SimpleIntegerProperty();
        prsbTT.progressProperty().bind(time.divide(30.0));
        KeyFrame[] keyFrames = new KeyFrame[31];
        for(int i = 0; i < keyFrames.length - 1; i++) {
            keyFrames[i] = new KeyFrame(Duration.seconds(i), event -> {
                soThoiGianDaQua++;
            }, new KeyValue(time, i));
        }
        keyFrames[30] = new KeyFrame(Duration.seconds(30), event -> {
            //Toast.makeText(rootPane, "Hết giờ");
            DelayUtil.delay(1000, this::NextQuestion);
        }, new KeyValue(time, 30));

        timeline = new Timeline(keyFrames);
        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.play();
    }

}
