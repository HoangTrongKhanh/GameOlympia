package Controller;

import BLL.BKhoiDong;
import EntityOlympia.EKhoiDong;
import Singleton.Point;
import Utils.DelayUtil;
import Utils.FadeTransitionUtil;
import Utils.Toast;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class KhoiDongController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button btnBack;

    @FXML
    private Label lblSTTCauHoi;

    @FXML
    private Label lblDiem;

    @FXML
    private Label lblCauHoi;

    @FXML
    private Label lblTime;

    @FXML
    private ProgressBar prsbKD;

    @FXML
    private Button btnDung;

    @FXML
    private Button btnSai;

    @FXML
    private VBox vBoxEndGame;

    @FXML
    private Label lblEndGame;

    @FXML
    private Button btnOkVCNV;

    @FXML
    private Button btnCancel;

    private ObservableList<EKhoiDong> khoiDongData = FXCollections.observableArrayList();
    private Timeline timeline;
    private Random rand = new Random();
    private int STT = 0;
    private Point point = Point.Instance();
    private int maxCauHoi = 0;
    private ArrayList<Integer> cauhoidaqua = new ArrayList<>();
    private boolean answer = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootPane.setOpacity(0);
        FadeTransitionUtil.FadeIn(rootPane);

        khoiDongData = BKhoiDong.SelectAll();

        if(khoiDongData != null) {
            maxCauHoi = khoiDongData.size();
            DelayUtil.delay(1000, () -> {
                NextQuestion();
                loadProgressBar();
            });
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText("Không truy xuất được dữ liệu. Xem lại kết nối database");
            return;
        }
        btnBack.setOnAction(event -> handleBack());
        btnDung.setOnAction(event -> handleBtnTrue());
        btnSai.setOnAction(event -> handleBtnFalse());
    }

    private void NextQuestion() {
        lblSTTCauHoi.setText("Câu hỏi số " + sttCauHoi() + "");
        int n = sttCauHoi();
        if(n >= 12 || n > maxCauHoi) {
            timeline.stop();
            alertEndGame();
        } else {
            do{
                STT = rand.nextInt(maxCauHoi) + 1;
            } while (cauhoidaqua.contains(STT));
            cauhoidaqua.add(STT);
            EKhoiDong cauhoi = BKhoiDong.SelectById(STT);
            if(cauhoi != null && sttCauHoi() <= maxCauHoi) {
                    lblCauHoi.setText(cauhoi.getQuestion());
                    answer = cauhoi.getAnswer();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText("Không tìm thấy câu hỏi. Xem lại kết nối database và dữ liệu.");
            }
        }
    }

    private int sttCauHoi() {
        return cauhoidaqua.size();
    }

    private void alertEndGame() {
        vBoxEndGame.setVisible(true);
        btnDung.setVisible(false);
        btnSai.setVisible(false);
        lblEndGame.setText("Chúc mừng bạn đã hoàn thành phần thi Khởi Động với số điểm là: " + point.getPoint() +
                            "\nBạn có muốn tiếp tục phần thi Vượt Chướng Ngại Vật không?");
        btnOkVCNV.setOnAction(event -> {
            try {
                Parent secondView = FXMLLoader.load(getClass().getClassLoader().getResource("Controller/View/VCNV.fxml"));
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

    private void handleBtnTrue() {
        if(answer) {
            point.add(10);
            lblDiem.setText("Điểm " + point.getPoint() + "");
            Toast.makeText(rootPane, "Đúng rồi");
        } else {
            Toast.makeText(rootPane, "Sai rồi");
        }
        DelayUtil.delay(1000, this::NextQuestion);
    }

    private void handleBtnFalse() {
        if(!answer) {
            point.add(10);
            lblDiem.setText("Điểm " + point.getPoint() + "");
            Toast.makeText(rootPane, "Đúng rồi");
        } else {
            Toast.makeText(rootPane, "Sai rồi");
        }
        DelayUtil.delay(1000, this::NextQuestion);
    }

    private void loadProgressBar() {
        IntegerProperty time = new SimpleIntegerProperty();
        prsbKD.progressProperty().bind(time.divide(60.0));
        KeyFrame[] keyFrames = new KeyFrame[61];
        for(int i = 0; i < keyFrames.length - 1; i++) {
            int finalI = i;
            keyFrames[i] = new KeyFrame(Duration.seconds(i), event -> {lblTime.setText(String.valueOf(60-finalI));}, new KeyValue(time, i));
        }
        keyFrames[60] = new KeyFrame(Duration.seconds(60), event -> {
                    lblTime.setText("0");
                    DelayUtil.delay(1000, this::alertEndGame);
                }, new KeyValue(time, 60));

        timeline = new Timeline(keyFrames);

        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.play();
    }
}
