package Controller;

import BLL.BPoint;
import BLL.BVeDich;
import EntityOlympia.EPoint;
import EntityOlympia.EVeDich;
import Singleton.Point;
import Utils.DelayUtil;
import Utils.FadeTransitionUtil;
import Utils.Toast;
import javafx.animation.*;
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
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class VeDichController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private VBox vBoxGoiCauHoi;

    @FXML
    private AnchorPane Pane40;

    @FXML
    private AnchorPane goi40;

    @FXML
    private AnchorPane Pane60;

    @FXML
    private AnchorPane goi60;

    @FXML
    private AnchorPane Pane80;

    @FXML
    private AnchorPane goi80;

    @FXML
    private VBox vBoxCauHoi;

    @FXML
    private Label lblSttCauHoi;

    @FXML
    private Label lblDiemCauHoi;

    @FXML
    private ProgressBar prsbVD;

    @FXML
    private Label lblDiem;

    @FXML
    private Label lblCauHoi;

    @FXML
    private Button btnBack;

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
    private TextField txtEndGame;

    @FXML
    private Button btnEndGame;

    private RotateTransition transition;

    private ObservableList<EVeDich> veDichData = FXCollections.observableArrayList();
    private ArrayList<Integer> cauHoiDaQua = new ArrayList<Integer>();

    private Random rand = new Random();
    private Point point = Point.Instance();
    private int goiCauHoi;
    private int maxCauHoi = 0;
    private int stt;
    private boolean DaChonNgoiSaoHyVong = false;
    private int soDiemCuaCau;
    private String dapAnCuaCauHoi;
    private Timeline timeline;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootPane.setOpacity(0);
        FadeTransitionUtil.FadeIn(rootPane);

        lblDiem.setText(String.valueOf(point.getPoint()));

        Pane40.setOnMouseEntered(event -> RotateTransition(goi40));
        Pane40.setOnMouseExited(event -> {
            transition.stop();
            goi40.setRotate(0);
        });
        Pane60.setOnMouseEntered(event -> RotateTransition(goi60));
        Pane60.setOnMouseExited(event -> {
            transition.stop();
            goi60.setRotate(0);
        });
        Pane80.setOnMouseEntered(event -> RotateTransition(goi80));
        Pane80.setOnMouseExited(event -> {
            transition.stop();
            goi80.setRotate(0);
        });

        Pane40.setOnMouseClicked(event -> showCauHoiPane(40));
        Pane60.setOnMouseClicked(event -> showCauHoiPane(60));
        Pane80.setOnMouseClicked(event -> showCauHoiPane(80));

        btnA.setOnAction(event -> hanldeBtnA());
        btnB.setOnAction(event -> hanldeBtnB());
        btnC.setOnAction(event -> hanldeBtnC());
        btnD.setOnAction(event -> hanldeBtnD());
        btnBack.setOnAction(event -> handleBack());
    }

    private void RotateTransition(AnchorPane pane) {
        transition = new RotateTransition(Duration.millis(3000), pane);
        transition.setByAngle(360);
        transition.setCycleCount(Animation.INDEFINITE);
        pane.setTranslateZ(pane.getBoundsInLocal().getWidth() / 2.0);
        pane.setRotationAxis(Rotate.Y_AXIS);
        transition.play();
        pane.setRotate(180);
    }

    private void showCauHoiPane(int goiCauHoi) {
        this.goiCauHoi = goiCauHoi;
        vBoxGoiCauHoi.setVisible(false);
        vBoxCauHoi.setOpacity(0);
        FadeTransitionUtil.FadeIn(vBoxCauHoi);
        vBoxCauHoi.setVisible(true);
        DelayUtil.delay(1000, ()->nextQuestion(goiCauHoi));
    }

    private void nextQuestion(int goiCauHoi) {
        if(cauHoiDaQua.size() < 3) {
            switch (goiCauHoi) {
                case 40:
                    if(cauHoiDaQua.size() < 2) {
                        veDichData = BVeDich.SelectByPoint(10);
                    } else {
                        veDichData = BVeDich.SelectByPoint(20);
                    }
                    maxCauHoi = veDichData.size();
                    loadCauHoi();
                    break;
                case 60:
                    if(cauHoiDaQua.size() == 0) {
                        veDichData = BVeDich.SelectByPoint(10);
                    }
                    if(cauHoiDaQua.size() == 1) {
                        veDichData = BVeDich.SelectByPoint(20);
                    }
                    if(cauHoiDaQua.size() == 2) {
                        veDichData = BVeDich.SelectByPoint(30);
                    }
                    maxCauHoi = veDichData.size();
                    loadCauHoi();
                    break;
                case 80:
                    if(cauHoiDaQua.size() == 0) {
                        veDichData = BVeDich.SelectByPoint(20);
                    } else {
                        veDichData = BVeDich.SelectByPoint(30);
                    }
                    maxCauHoi = veDichData.size();
                    loadCauHoi();
                    break;
            }
        } else {
            endGame();
        }
    }

    private void hanldeBtnA() {
        if(dapAnCuaCauHoi.equalsIgnoreCase("A")) {
            //Tra Loi Dung
            point.add(soDiemCuaCau);
            lblDiem.setText("Điểm " + point.getPoint());
            Toast.makeText(rootPane, "Đúng rồi");
            DelayUtil.delay(1000, ()->nextQuestion(goiCauHoi));
        } else {
            //Tra Loi Sai
            point.minus(soDiemCuaCau/2);
            lblDiem.setText("Điểm " + point.getPoint());
            Toast.makeText(rootPane, "Sai rồi");
            DelayUtil.delay(1000, ()->nextQuestion(goiCauHoi));
        }
    }

    private void hanldeBtnB() {
        if(dapAnCuaCauHoi.equalsIgnoreCase("B")) {
            //Tra Loi Dung
            point.add(soDiemCuaCau);
            lblDiem.setText("Điểm " + point.getPoint());
            Toast.makeText(rootPane, "Đúng rồi");
            DelayUtil.delay(1000, ()->nextQuestion(goiCauHoi));
        } else {
            //Tra Loi Sai
            point.minus(soDiemCuaCau/2);
            lblDiem.setText("Điểm " + point.getPoint());
            Toast.makeText(rootPane, "Sai rồi");
            DelayUtil.delay(1000, ()->nextQuestion(goiCauHoi));
        }
    }

    private void hanldeBtnC() {
        if(dapAnCuaCauHoi.equalsIgnoreCase("C")) {
            //Tra Loi Dung
            //Tra Loi Dung
            point.add(soDiemCuaCau);
            lblDiem.setText("Điểm " + point.getPoint());
            Toast.makeText(rootPane, "Đúng rồi");
            DelayUtil.delay(1000, ()->nextQuestion(goiCauHoi));
        } else {
            //Tra Loi Sai
            point.minus(soDiemCuaCau/2);
            lblDiem.setText("Điểm " + point.getPoint());
            Toast.makeText(rootPane, "Sai rồi");
            DelayUtil.delay(1000, ()->nextQuestion(goiCauHoi));
        }
    }

    private void hanldeBtnD() {
        if(dapAnCuaCauHoi.equalsIgnoreCase("D")) {
            //Tra Loi Dung
            //Tra Loi Dung
            point.add(soDiemCuaCau);
            lblDiem.setText("Điểm " + point.getPoint());
            Toast.makeText(rootPane, "Đúng rồi");
            DelayUtil.delay(1000, ()->nextQuestion(goiCauHoi));
        } else {
            //Tra Loi Sai
            point.minus(soDiemCuaCau/2);
            lblDiem.setText("Điểm " + point.getPoint());
            Toast.makeText(rootPane, "Sai rồi");
            DelayUtil.delay(1000, ()->nextQuestion(goiCauHoi));
        }
    }

    private void loadCauHoi() {
        int index = 0;
        do {
            index = rand.nextInt(maxCauHoi);
            stt = veDichData.get(index).getStt();
        } while (cauHoiDaQua.contains(stt));

        cauHoiDaQua.add(stt);
        soDiemCuaCau = veDichData.get(index).getPoint();

        lblSttCauHoi.setText("Câu hỏi số " + cauHoiDaQua.size());
        lblDiemCauHoi.setText("Câu hỏi " + soDiemCuaCau + " điểm");

        if(!DaChonNgoiSaoHyVong) {
            if (isNgoiSaoHyVong()) {
                lblDiemCauHoi.setText(lblDiemCauHoi.getText() + ". Đã chọn ngôi sao hy vọng.");
                lblCauHoi.setText(veDichData.get(index).getQuestion());
                btnA.setText(veDichData.get(index).getAnsA());
                btnB.setText(veDichData.get(index).getAnsB());
                btnC.setText(veDichData.get(index).getAnsC());
                btnD.setText(veDichData.get(index).getAnsD());
                dapAnCuaCauHoi = veDichData.get(index).getAnswer().trim();
                soDiemCuaCau *= 2;
                countTime();
            }
            else {
                lblCauHoi.setText(veDichData.get(index).getQuestion());
                btnA.setText(veDichData.get(index).getAnsA());
                btnB.setText(veDichData.get(index).getAnsB());
                btnC.setText(veDichData.get(index).getAnsC());
                btnD.setText(veDichData.get(index).getAnsD());
                dapAnCuaCauHoi = veDichData.get(index).getAnswer().trim();
                countTime();
            }
        } else {
            lblCauHoi.setText(veDichData.get(index).getQuestion());
            btnA.setText(veDichData.get(index).getAnsA());
            btnB.setText(veDichData.get(index).getAnsB());
            btnC.setText(veDichData.get(index).getAnsC());
            btnD.setText(veDichData.get(index).getAnsD());
            dapAnCuaCauHoi = veDichData.get(index).getAnswer().trim();
            countTime();
        }
    }

    private void countTime() {
        IntegerProperty time = new SimpleIntegerProperty();
        prsbVD.progressProperty().bind(time.divide(30.0));
        KeyFrame[] keyFrames = new KeyFrame[31];
        for(int i = 0; i < keyFrames.length - 1; i++) {
            keyFrames[i] = new KeyFrame(Duration.seconds(i), event -> {
            }, new KeyValue(time, i));
        }
        keyFrames[30] = new KeyFrame(Duration.seconds(30), event -> {
            Toast.makeText(rootPane, "Hết giờ");
            DelayUtil.delay(1000, ()->nextQuestion(goiCauHoi));
        }, new KeyValue(time, 30));

        timeline = new Timeline(keyFrames);
        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.play();
    }

    private boolean isNgoiSaoHyVong() {
        if(timeline != null) {
            timeline.pause();
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Lựa chọn ngôi sao hy vọng");
        alert.setHeaderText("Câu hỏi này " + soDiemCuaCau +" Điểm. Bạn có muốn lựa chọn ngôi sao hy vọng không?");
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == ButtonType.OK) {
            DaChonNgoiSaoHyVong = true;
            return true;
        } else if (option.get() == ButtonType.CANCEL) {
            DaChonNgoiSaoHyVong = false;
            return false;
        } else {
            return false;
        }
    }

    private void endGame() {
        vBoxEndGame.setVisible(true);
        timeline.pause();
        lblEndGame.setText("Chúc mừng bạn đã hoàn thành phần thi Về Đích với số điểm là: " + point.getPoint() +
                "\nVui lòng nhập tên của bạn để lưu điểm số");

        btnEndGame.setOnAction(event -> {
            nhapDiem();
            try {
                Parent secondView = FXMLLoader.load(getClass().getClassLoader().getResource("Controller/View/Main.fxml"));
                FadeTransitionUtil.FadeOut(secondView, rootPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void nhapDiem() {
        ObservableList<EPoint> points = BPoint.SelectAll();
        for(EPoint point : points) {
            if(point.ExistName(txtEndGame.getText())) {
                //ten da ton tai
                //thong bao nhap ten khac
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Loi");
                alert.setHeaderText("Ten da ton tai");
                return;
            }
        }
        EPoint newPoint = new EPoint();
        newPoint.setName(txtEndGame.getText());
        newPoint.setDiem(point.getPoint());
        BPoint.Insert(newPoint);
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

}
