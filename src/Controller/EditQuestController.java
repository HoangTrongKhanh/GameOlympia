package Controller;

import BLL.*;
import EntityOlympia.*;
import Utils.FadeTransitionUtil;
import Utils.FetchDataUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditQuestController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button btnBack;

    @FXML
    private TabPane tabPaneEdit;

    //region Login
    @FXML
    private GridPane gridPaneLogin;

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;
    //endregion


    //region tabKhoiDong
    @FXML
    private Tab tabKhoiDong;

    @FXML
    private TableView<EKhoiDong> tableKhoiDong;

    @FXML
    private TableColumn<EKhoiDong, Integer> colKDSTT;

    @FXML
    private TableColumn<EKhoiDong, String> colKDCauHoi;

    @FXML
    private TableColumn<EKhoiDong, Boolean> colKDDapAn;

    @FXML
    private TextArea txtKDCauHoi;

    @FXML
    private RadioButton rabKDTrue;

    @FXML
    private RadioButton rabKDFalse;

    @FXML
    private ToggleGroup group;

    @FXML
    private Button btnKDInsert;

    @FXML
    private Button btnKDUpdate;

    @FXML
    private Button btnKDDelete;

    @FXML
    private ProgressIndicator khoiDongActivityIndicator;

    private FetchDataUtil fetchDataUtil = new FetchDataUtil();

    private void hanldeTabKhoiDong() {
        colKDSTT.setCellValueFactory(new PropertyValueFactory<>("stt"));
        colKDCauHoi.setCellValueFactory(new PropertyValueFactory<>("question"));
        colKDDapAn.setCellValueFactory(new PropertyValueFactory<>("answer"));

        fetchDataUtil.fetchKhoiDongDataFromDataBaseToTableView(tabKhoiDong, khoiDongActivityIndicator, tableKhoiDong);

        tableKhoiDong.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showEKhoiDongDetails(newValue));

        btnKDInsert.setOnAction(event1 -> handleKDInsert());
        btnKDUpdate.setOnAction(event1 -> handleKDUpdate());
        btnKDDelete.setOnAction(event1 -> handleKDDelete());

    }

    private void handleKDInsert() {
        EKhoiDong newKhoiDong = new EKhoiDong();

        if(isKDInputValid()) {
            newKhoiDong.setStt(BKhoiDong.LastSTT() + 1);
            newKhoiDong.setQuestion(txtKDCauHoi.getText());
            newKhoiDong.setAnswer(getKDRabSelected());

            BKhoiDong.Insert(newKhoiDong);
            tableKhoiDong.getItems().add(newKhoiDong);
            tableKhoiDong.refresh();
        }
    }

    private void handleKDUpdate() {
        EKhoiDong khoiDong = tableKhoiDong.getSelectionModel().getSelectedItem();

        if(khoiDong != null) {
            if(isKDInputValid()) {
                khoiDong.setQuestion(txtKDCauHoi.getText());
                khoiDong.setAnswer(getKDRabSelected());

                showEKhoiDongDetails(khoiDong);
                BKhoiDong.Update(khoiDong);
                tableKhoiDong.refresh();
            }
        } else {
            noSelectionAlert();
        }
    }

    private boolean getKDRabSelected() {
        if(rabKDTrue.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    private void handleKDDelete() {
        EKhoiDong khoiDong = tableKhoiDong.getSelectionModel().getSelectedItem();

        if(khoiDong != null) {
            BKhoiDong.Delete(khoiDong.getStt());
            tableKhoiDong.getItems().remove(khoiDong);
            tableKhoiDong.refresh();
        } else {
            noSelectionAlert();
        }
    }

    private void showEKhoiDongDetails(EKhoiDong eKhoiDong) {
        if(eKhoiDong != null) {
            txtKDCauHoi.setText(eKhoiDong.getQuestion());
            if(eKhoiDong.getAnswer()) {
                rabKDTrue.setSelected(true);
            } else {
                rabKDFalse.setSelected(true);
            }
        }
    }

    private boolean isKDInputValid() {
        String errMsg = "";
        if(txtKDCauHoi.getText() == null || txtKDCauHoi.getText().length() == 0) {
            errMsg += "Câu hỏi không hợp lệ\n";
        }
        if(!rabKDTrue.isSelected() && !rabKDFalse.isSelected()) {
            errMsg += "Đáp án không hợp lệ\n";
        }

        if(errMsg.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errMsg);

            alert.showAndWait();

            return false;
        }
    }

    //endregion

    //region tabVCNV

    @FXML
    private Tab tabVCNV;

    @FXML
    private TableView<EVuotChuongNgaiVat> tableVCNV;

    @FXML
    private TableColumn<EVuotChuongNgaiVat, Integer> colVCNVSTT;

    @FXML
    private TableColumn<EVuotChuongNgaiVat, Integer> colVCNVSTTHN;

    @FXML
    private TableColumn<EVuotChuongNgaiVat, Integer> colVCNVSoOHN;

    @FXML
    private TableColumn<EVuotChuongNgaiVat, String> colVCNVCauHoi;

    @FXML
    private TableColumn<EVuotChuongNgaiVat, String> colVCNVDapAn;

    @FXML
    private TextArea txtVCNVCauHoi;

    @FXML
    private Button btnVCNVInsert;

    @FXML
    private Button btnVCNVUpdate;

    @FXML
    private Button btnVCNVDelete;

    @FXML
    private ComboBox<String> cbbVCNVTuKhoa;

    @FXML
    private TextField txtVCNVOHN;

    @FXML
    private TextField txtVCNVDapAn;

    @FXML
    private ProgressIndicator VCNVActivityIndicator;

    private void hanldeTabVCNV() {
        ObservableList<EKeyVCNV> keyVCNVData = BKeyVCNV.SelectAll();
        ObservableList<String> cbbTuKhoaData = FXCollections.observableArrayList();

        for(EKeyVCNV keyVCNV : keyVCNVData ) {
            cbbTuKhoaData.add(keyVCNV.getAnswer());
        }

        cbbVCNVTuKhoa.setItems(cbbTuKhoaData);

        colVCNVSTT.setCellValueFactory(new PropertyValueFactory<>("stt"));
        colVCNVSTTHN.setCellValueFactory(new PropertyValueFactory<>("sttHN"));
        colVCNVSoOHN.setCellValueFactory(new PropertyValueFactory<>("soOHN"));
        colVCNVCauHoi.setCellValueFactory(new PropertyValueFactory<>("question"));
        colVCNVDapAn.setCellValueFactory(new PropertyValueFactory<>("answer"));

        fetchDataUtil.fetchVCNVDataFromDataBaseToTableView(tabVCNV, VCNVActivityIndicator, tableVCNV);

        tableVCNV.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showEVCNVDetails(newValue));

        btnVCNVInsert.setOnAction(event1 -> handleVCNVInsert());
        btnVCNVUpdate.setOnAction(event1 -> handleVCNVUpdate());
        btnVCNVDelete.setOnAction(event1 -> handleVCNVDelete());

    }

    private void handleVCNVInsert() {
//        EVuotChuongNgaiVat newVCNV = new EVuotChuongNgaiVat();
//
//        if(isVCNVInputValid()) {
//            newVCNV.setQuestion(txtKDCauHoi.getText());
//            newVCNV.setSoOHN(Integer.parseInt(txtVCNVOHN.getText()));
//            newVCNV.setAnswer(txtVCNVDapAn.getText());
//
//            BVuotChuongNgaiVat.Insert(newVCNV);
//            tableVCNV.refresh();
//        }
    }

    private void handleVCNVUpdate() {
        EVuotChuongNgaiVat vuotChuongNgaiVat = tableVCNV.getSelectionModel().getSelectedItem();

        if(vuotChuongNgaiVat != null) {
            if(isVCNVInputValid()) {
                vuotChuongNgaiVat.setQuestion(txtVCNVCauHoi.getText());
                vuotChuongNgaiVat.setSoOHN(Integer.parseInt(txtVCNVOHN.getText()));
                vuotChuongNgaiVat.setAnswer(txtVCNVDapAn.getText());
                vuotChuongNgaiVat.setStt(colVCNVSTT.getCellData(tableVCNV.getSelectionModel().getSelectedIndex()));

                showEVCNVDetails(vuotChuongNgaiVat);
                BVuotChuongNgaiVat.Update(vuotChuongNgaiVat);
                tableVCNV.refresh();
            }
        } else {
            noSelectionAlert();
        }
    }

    private void handleVCNVDelete() {
        EVuotChuongNgaiVat selectedVCNV = tableVCNV.getSelectionModel().getSelectedItem();

        if(selectedVCNV != null) {
            BVuotChuongNgaiVat.Delete(selectedVCNV);
            tableVCNV.getItems().remove(selectedVCNV);
            tableVCNV.refresh();
        } else {
            noSelectionAlert();
        }
    }

    private void showEVCNVDetails(EVuotChuongNgaiVat vuotChuongNgaiVat) {
        if(vuotChuongNgaiVat != null) {
            txtVCNVCauHoi.setText(vuotChuongNgaiVat.getQuestion());
            txtVCNVDapAn.setText(vuotChuongNgaiVat.getAnswer());
            txtVCNVOHN.setText(String.valueOf((vuotChuongNgaiVat.getSoOHN())));

            EKeyVCNV temp = BKeyVCNV.SelectById(vuotChuongNgaiVat.getStt());

            cbbVCNVTuKhoa.setValue(temp.getAnswer());

        }
    }

    private boolean isVCNVInputValid() {
        String errMsg = "";
        if(txtVCNVCauHoi.getText() == null || txtVCNVCauHoi.getText().length() == 0) {
            errMsg += "Câu hỏi không hợp lệ\n";
        }
        if(txtVCNVDapAn.getText() == null || txtVCNVDapAn.getText().length() == 0) {
            errMsg += "Đáp án không hợp lệ\n";
        }
        if(txtVCNVOHN.getText() == null || txtVCNVOHN.getText().length() == 0) {
            errMsg += "Số ô hàng ngang không hợp lệ\n";
        }
        if(cbbVCNVTuKhoa.getSelectionModel().isEmpty() || cbbVCNVTuKhoa.getValue() == null) {
            errMsg += "Từ khoá không hợp lệ\n";
        }

        if(errMsg.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errMsg);

            alert.showAndWait();

            return false;
        }
    }

    //endregion

    //region tabTangToc

    @FXML
    private Tab tabTangToc;

    @FXML
    private TableView<ETangToc> tableTangToc;

    @FXML
    private TableColumn<ETangToc, Integer> colTTSTT;

    @FXML
    private TableColumn<ETangToc, String> colTTCauHoi;

    @FXML
    private TableColumn<ETangToc, String> colTTDapAnA;

    @FXML
    private TableColumn<ETangToc, String> colTTDapAnB;

    @FXML
    private TableColumn<ETangToc, String> colTTDapAnC;

    @FXML
    private TableColumn<ETangToc, String> colTTDapAnD;

    @FXML
    private TableColumn<ETangToc, String> colTTDapAn;

    @FXML
    private TextArea txtTTCauHoi;

    @FXML
    private Button btnTTInsert;

    @FXML
    private Button btnTTUpdate;

    @FXML
    private Button btnTTDelete;

    @FXML
    private TextField txtTTDapAnA;

    @FXML
    private TextField txtTTDapAnB;

    @FXML
    private TextField txtTTDapAnC;

    @FXML
    private TextField txtTTDapAnD;

    @FXML
    private TextField txtTTDapAn;

    @FXML
    private ProgressIndicator tangTocActivityIndicator;

    private void handleTabTangToc() {

        colTTSTT.setCellValueFactory(new PropertyValueFactory<>("stt"));
        colTTCauHoi.setCellValueFactory(new PropertyValueFactory<>("question"));
        colTTDapAnA.setCellValueFactory(new PropertyValueFactory<>("ansA"));
        colTTDapAnB.setCellValueFactory(new PropertyValueFactory<>("ansB"));
        colTTDapAnC.setCellValueFactory(new PropertyValueFactory<>("ansC"));
        colTTDapAnD.setCellValueFactory(new PropertyValueFactory<>("ansD"));
        colTTDapAn.setCellValueFactory(new PropertyValueFactory<>("answer"));

        fetchDataUtil.fetchTangTocDataFromDataBaseToTableView(tabTangToc, tangTocActivityIndicator, tableTangToc);

        tableTangToc.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showETangTocDetails(newValue));

        btnTTInsert.setOnAction(event -> handleTTInsert());
        btnTTUpdate.setOnAction(event -> handleTTUpdate());
        btnTTDelete.setOnAction(event -> handleTTDelete());

    }

    private void handleTTInsert() {
        ETangToc newTangToc = new ETangToc();
        if(isTTInputValid()) {
            newTangToc.setStt(BTangToc.LastSTT() + 1);
            newTangToc.setQuestion(txtTTCauHoi.getText());
            newTangToc.setAnsA(txtTTDapAnA.getText());
            newTangToc.setAnsB(txtTTDapAnB.getText());
            newTangToc.setAnsC(txtTTDapAnC.getText());
            newTangToc.setAnsD(txtTTDapAnD.getText());
            newTangToc.setAnswer(txtTTDapAn.getText());

            BTangToc.Insert(newTangToc);
            tableTangToc.getItems().add(newTangToc);
            tableTangToc.refresh();
        }
    }

    private void handleTTUpdate() {
        ETangToc tangToc = tableTangToc.getSelectionModel().getSelectedItem();
        if(tangToc != null) {
            if(isTTInputValid()) {
                tangToc.setQuestion(txtTTCauHoi.getText());
                tangToc.setAnsA(txtTTDapAnA.getText());
                tangToc.setAnsB(txtTTDapAnB.getText());
                tangToc.setAnsC(txtTTDapAnC.getText());
                tangToc.setAnsD(txtTTDapAnD.getText());
                tangToc.setAnswer(txtTTDapAn.getText());

                showETangTocDetails(tangToc);
                BTangToc.Update(tangToc);
                tableTangToc.refresh();
            }
        }
    }

    private void handleTTDelete() {
        ETangToc tangToc = tableTangToc.getSelectionModel().getSelectedItem();
        if(tangToc != null) {
            BTangToc.Delete(tangToc.getStt());
            tableTangToc.getItems().remove(tangToc);
            tableTangToc.refresh();
        } else {
            noSelectionAlert();
        }
    }

    private void showETangTocDetails(ETangToc eTangToc) {
        if(eTangToc != null) {
            txtTTCauHoi.setText(eTangToc.getQuestion());
            txtTTDapAnA.setText(eTangToc.getAnsA());
            txtTTDapAnB.setText(eTangToc.getAnsB());
            txtTTDapAnC.setText(eTangToc.getAnsC());
            txtTTDapAnD.setText(eTangToc.getAnsD());
            txtTTDapAn.setText(eTangToc.getAnswer());
        }
    }

    private boolean isTTInputValid() {
        String errMsg = "";
        if(txtTTCauHoi.getText() == null || txtTTCauHoi.getText().length() == 0) {
            errMsg += "Câu hỏi không hợp lệ\n";
        }
        if(txtTTDapAnA.getText() == null || txtTTDapAnA.getText().length() == 0) {
            errMsg += "Đáp án A không hợp lệ\n";
        }
        if(txtTTDapAnB.getText() == null || txtTTDapAnB.getText().length() == 0) {
            errMsg += "Đáp án B không hợp lệ\n";
        }
        if(txtTTDapAnC.getText() == null || txtTTDapAnC.getText().length() == 0) {
            errMsg += "Đáp án C không hợp lệ\n";
        }
        if(txtTTDapAnD.getText() == null || txtTTDapAnD.getText().length() == 0) {
            errMsg += "Đáp án D không hợp lệ\n";
        }
        if(txtTTDapAn.getText() == null || txtTTDapAn.getText().length() == 0) {
            errMsg += "Đáp án không hợp lệ\n";
        }

        if(errMsg.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errMsg);

            alert.showAndWait();

            return false;
        }
    }

    //endregion

    //region tabVeDich

    @FXML
    private Tab tabVeDich;

    @FXML
    private TableView<EVeDich> tableVeDich;

    @FXML
    private TableColumn<EVeDich, Integer> colVDSTT;

    @FXML
    private TableColumn<EVeDich, String> colVDCauHoi;

    @FXML
    private TableColumn<EVeDich, String> colVDDapAnA;

    @FXML
    private TableColumn<EVeDich, String> colVDDapAnB;

    @FXML
    private TableColumn<EVeDich, String> colVDDapAnC;

    @FXML
    private TableColumn<EVeDich, String> colVDDapAnD;

    @FXML
    private TableColumn<EVeDich, String> colVDDapAn;

    @FXML
    private TableColumn<EVeDich, Integer> colVDDiem;

    @FXML
    private TextArea txtVDCauHoi;

    @FXML
    private Button btnVDInsert;

    @FXML
    private Button btnVDUpdate;

    @FXML
    private Button btnVDDelete;

    @FXML
    private TextField txtVDDapAnA;

    @FXML
    private TextField txtVDDapAnB;

    @FXML
    private TextField txtVDDapAnC;

    @FXML
    private TextField txtVDDapAnD;

    @FXML
    private TextField txtVDDapAn;

    @FXML
    private ComboBox<Integer> cbbDiem;

    @FXML
    private ProgressIndicator veDichActivityIndicator;

    private void handleTabVeDich() {
        cbbDiem.getItems().add(10);
        cbbDiem.getItems().add(20);
        cbbDiem.getItems().add(30);

        colVDSTT.setCellValueFactory(new PropertyValueFactory<>("stt"));
        colVDCauHoi.setCellValueFactory(new PropertyValueFactory<>("question"));
        colVDDapAnA.setCellValueFactory(new PropertyValueFactory<>("ansA"));
        colVDDapAnB.setCellValueFactory(new PropertyValueFactory<>("ansB"));
        colVDDapAnC.setCellValueFactory(new PropertyValueFactory<>("ansC"));
        colVDDapAnD.setCellValueFactory(new PropertyValueFactory<>("ansD"));
        colVDDapAn.setCellValueFactory(new PropertyValueFactory<>("answer"));
        colVDDiem.setCellValueFactory(new PropertyValueFactory<>("point"));

        fetchDataUtil.fetchVeDichDataFromDataBaseToTableView(tabVeDich, veDichActivityIndicator, tableVeDich);

        tableVeDich.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showEVeDichDetails(newValue));

        btnVDInsert.setOnAction(event -> handleVDInsert());
        btnVDUpdate.setOnAction(event -> handleVDUpdate());
        btnVDDelete.setOnAction(event -> handleVDDelete());

    }

    private void showEVeDichDetails(EVeDich veDich) {
        if(veDich != null) {
            txtVDCauHoi.setText(veDich.getQuestion());
            txtVDDapAnA.setText(veDich.getAnsA());
            txtVDDapAnB.setText(veDich.getAnsB());
            txtVDDapAnC.setText(veDich.getAnsC());
            txtVDDapAnD.setText(veDich.getAnsD());
            txtVDDapAn.setText(veDich.getAnswer());
            cbbDiem.setValue(veDich.getPoint());
        }
    }

    private void handleVDInsert() {
        EVeDich newVeDich = new EVeDich();
        if(isVDInputValid()) {
            newVeDich.setStt(BVeDich.LastSTT() + 1);
            newVeDich.setQuestion(txtVDCauHoi.getText());
            newVeDich.setAnsA(txtVDDapAnA.getText());
            newVeDich.setAnsB(txtVDDapAnB.getText());
            newVeDich.setAnsC(txtVDDapAnC.getText());
            newVeDich.setAnsD(txtVDDapAnD.getText());
            newVeDich.setAnswer(txtVDDapAn.getText());
            newVeDich.setPoint(cbbDiem.getSelectionModel().getSelectedItem());

            BVeDich.Insert(newVeDich);
            tableVeDich.getItems().add(newVeDich);
            tableVeDich.refresh();
        }
    }

    private void handleVDUpdate() {
        EVeDich veDich = tableVeDich.getSelectionModel().getSelectedItem();
        if(veDich != null) {
            if(isVDInputValid()) {
                veDich.setQuestion(txtVDCauHoi.getText());
                veDich.setAnsA(txtVDDapAnA.getText());
                veDich.setAnsB(txtVDDapAnB.getText());
                veDich.setAnsC(txtVDDapAnC.getText());
                veDich.setAnsD(txtVDDapAnD.getText());
                veDich.setAnswer(txtVDDapAn.getText());
                veDich.setPoint(cbbDiem.getSelectionModel().getSelectedItem());

                showEVeDichDetails(veDich);
                BVeDich.Update(veDich);
                tableVeDich.refresh();
            }
        }
    }

    private void handleVDDelete() {
        EVeDich selectedVeDich = tableVeDich.getSelectionModel().getSelectedItem();
        if(selectedVeDich != null) {
            BVeDich.Delete(selectedVeDich);
            tableVeDich.getItems().remove(selectedVeDich);
            tableVeDich.refresh();
        } else {
            noSelectionAlert();
        }
    }

    private boolean isVDInputValid() {
        String errMsg = "";

        if(txtVDCauHoi.getText() == null || txtVDCauHoi.getText().length() == 0) {
            errMsg += "Câu hỏi không hợp lệ\n";
        }
        if(txtVDDapAnA.getText() == null || txtVDDapAnA.getText().length() == 0) {
            errMsg += "Đáp án A không hợp lệ\n";
        }
        if(txtVDDapAnB.getText() == null || txtVDDapAnB.getText().length() == 0) {
            errMsg += "Đáp án B không hợp lệ\n";
        }
        if(txtVDDapAnC.getText() == null || txtVDDapAnC.getText().length() == 0) {
            errMsg += "Đáp án C không hợp lệ\n";
        }
        if(txtVDDapAnD.getText() == null || txtVDDapAnD.getText().length() == 0) {
            errMsg += "Đáp án D không hợp lệ\n";
        }
        if(txtVDDapAn.getText() == null || txtVDDapAn.getText().length() == 0) {
            errMsg += "Đáp án đúng không hợp lệ\n";
        }
        if(cbbDiem.getSelectionModel().isEmpty() || cbbDiem.getValue() == null) {
            errMsg += "Điểm không hợp lệ\n";
        }

        if(errMsg.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errMsg);

            alert.showAndWait();

            return false;
        }

    }

    //endregion

    //region Diem
    @FXML
    private Tab tabDiem;

    @FXML
    private TableView<EPoint> tableDiem;

    @FXML
    private TableColumn<EPoint, Integer> colDiemSTT;

    @FXML
    private TableColumn<EPoint, String> colDiemTen;

    @FXML
    private TableColumn<EPoint, Integer> colDiemDiem;

    @FXML
    private Button btnDInsert;

    @FXML
    private Button btnDUpdate;

    @FXML
    private Button btnDDelete;

    @FXML
    private TextField txtDiemTen;

    @FXML
    private TextField txtDiemDiem;

    @FXML
    private ProgressIndicator diemActivityIndicator;

    private void handleTabDiem() {

        colDiemSTT.setCellValueFactory(new PropertyValueFactory<>("stt"));
        colDiemTen.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDiemDiem.setCellValueFactory(new PropertyValueFactory<>("diem"));

        fetchDataUtil.fetchDiemDataFromDataBaseToTableView(tabDiem, diemActivityIndicator, tableDiem);

        tableDiem.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showPointDetails(newValue));

        btnDInsert.setOnAction(event -> handleDiemInsert());
        btnDUpdate.setOnAction(event -> handleDiemUpdate());
        btnDDelete.setOnAction(event -> handleDiemDelete());
    }

    private void showPointDetails(EPoint point) {
        if(point != null) {
            txtDiemTen.setText(point.getName());
            txtDiemDiem.setText(String.valueOf(point.getDiem()));
        }
    }

    private void handleDiemInsert() {
        EPoint newPoint = new EPoint();
        if(isDiemInputValid()) {
            newPoint.setDiem(Integer.parseInt(txtDiemDiem.getText()));
            newPoint.setName(txtDiemTen.getText());

            BPoint.Insert(newPoint);
            tableDiem.getItems().add(newPoint);
            tableDiem.refresh();
        }
    }

    private void handleDiemUpdate() {
        EPoint point = tableDiem.getSelectionModel().getSelectedItem();
        if(point != null) {
            if(isDiemInputValid()) {
                point.setName(txtDiemTen.getText());
                point.setDiem(Integer.parseInt(txtDiemDiem.getText()));

                showPointDetails(point);
                BPoint.Update(point);
                tableDiem.refresh();
            }
        }
    }

    private void handleDiemDelete() {
        EPoint selectedPoint = tableDiem.getSelectionModel().getSelectedItem();
        if(selectedPoint != null) {
            BPoint.Delete(selectedPoint.getStt());
            tableDiem.getItems().remove(selectedPoint);
            tableDiem.refresh();
        } else {
            noSelectionAlert();
        }
    }

    private boolean isDiemInputValid() {
        String errMsg = "";

        if(txtDiemTen.getText() == null || txtDiemTen.getText().length() == 0) {
            errMsg += "Tên không hợp lệ\n";
        }
        if(txtDiemDiem.getText() == null || txtDiemDiem.getText().length() == 0) {
            errMsg += "Điểm không hợp lệ\n";
        }

        if(errMsg.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errMsg);
            alert.showAndWait();
            return false;
        }

    }


    //endregion

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootPane.setOpacity(0);
        FadeTransitionUtil.FadeIn(rootPane);

        btnBack.setOnAction(event -> handleBack());
        btnLogin.setOnAction(event -> handleLogin());
        txtPassword.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)) {
                handleLogin();
            }
        });

        tabPaneEdit.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue == tabKhoiDong) {
                hanldeTabKhoiDong();
            }
            if(newValue == tabVCNV) {
                hanldeTabVCNV();
            }
            if(newValue == tabTangToc) {
                handleTabTangToc();
            }
            if(newValue == tabVeDich) {
                handleTabVeDich();
            }
            if(newValue == tabDiem) {
                handleTabDiem();
            }
        });
    }

    public void handleBack() {
        try {
            Parent secondView = FXMLLoader.load(getClass().getClassLoader().getResource("Controller/View/Main.fxml"));
            FadeTransitionUtil.FadeOut(secondView, rootPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleLogin() {
        if(txtUser.getText().equalsIgnoreCase("admin") &&
                txtPassword.getText().equalsIgnoreCase("admin")) {
            gridPaneLogin.setVisible(false);
            tabPaneEdit.setVisible(true);
            hanldeTabKhoiDong();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Login Alert");
            alert.setHeaderText("Login Error");
            alert.setContentText("User and Password Incorrect");

            alert.showAndWait();
        }
    }

    private void noSelectionAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Selection");
        alert.setHeaderText("No Person Selected");
        alert.setContentText("Please select a person in the table.");

        alert.showAndWait();
    }

}
