package Controller;

import BLL.BPoint;
import EntityOlympia.EPoint;
import Utils.FadeTransitionUtil;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainAppController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button btnHighScore;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnEditQuest;

    @FXML
    private TableView<EPoint> tableDiem;

    @FXML
    private TableColumn<EPoint, Integer> colSTT;

    @FXML
    private TableColumn<EPoint, String> colName;

    @FXML
    private TableColumn<EPoint, Integer> colDiem;

    private void handleEditQuest() {
        try {
            Parent secondView = FXMLLoader.load(getClass().getClassLoader().getResource("Controller/View/EditQuest.fxml"));
            FadeTransitionUtil.FadeOut(secondView, rootPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleHighScore() {
        loadTableView();
    }

    private void handleStart() {
        try {
            Parent secondView = FXMLLoader.load(getClass().getClassLoader().getResource("Controller/View/KhoiDong.fxml"));
            FadeTransitionUtil.FadeOut(secondView, rootPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnStart.setOnAction(event -> handleStart());
        btnEditQuest.setOnAction(event -> handleEditQuest());
        btnHighScore.setOnAction(event -> handleHighScore());
    }

    private void loadTableView() {

        ObservableList<EPoint> pointData =  BPoint.SelectAll();

        colSTT.setCellValueFactory(new PropertyValueFactory<>("stt"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDiem.setCellValueFactory(new PropertyValueFactory<>("diem"));
        colDiem.setCellValueFactory(new PropertyValueFactory<>("diem"));

        tableDiem.setItems(pointData);

        if(tableDiem.getOpacity() == 0) {
            tableDiem.setOpacity(1);
        } else {
            tableDiem.setOpacity(0);
        }

    }
}
