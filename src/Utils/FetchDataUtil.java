package Utils;

import BLL.*;
import EntityOlympia.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class FetchDataUtil {

    public void fetchKhoiDongDataFromDataBaseToTableView(
            final Tab tab,
            final ProgressIndicator databaseActivityIndicator,
            final TableView tableView) {
        final FetchKhoiDongData fetchKhoiDongData = new FetchKhoiDongData();
        tab.setDisable(true);
        databaseActivityIndicator.setVisible(true);
        databaseActivityIndicator.progressProperty().bind(fetchKhoiDongData.progressProperty());
        fetchKhoiDongData.setOnSucceeded(event -> tableView.setItems(fetchKhoiDongData.getValue()));
        fetchKhoiDongData.runningProperty().addListener((observable, wasRunning, isRunning) -> {
            if(!isRunning) {
                tab.setDisable(false);
                databaseActivityIndicator.setVisible(false);
            }
        });
        databaseExecutor.submit(fetchKhoiDongData);
    }

    public void fetchVCNVDataFromDataBaseToTableView(
            final Tab tab,
            final ProgressIndicator databaseActivityIndicator,
            final TableView tableView) {
        final FetchVCNVData fetchVCNVData = new FetchVCNVData();
        tab.setDisable(true);
        databaseActivityIndicator.setVisible(true);
        databaseActivityIndicator.progressProperty().bind(fetchVCNVData.progressProperty());
        fetchVCNVData.setOnSucceeded(event -> tableView.setItems(fetchVCNVData.getValue()));
        fetchVCNVData.runningProperty().addListener((observable, wasRunning, isRunning) -> {
            if(!isRunning) {
                tab.setDisable(false);
                databaseActivityIndicator.setVisible(false);
            }
        });
        databaseExecutor.submit(fetchVCNVData);
    }

    public void fetchTangTocDataFromDataBaseToTableView(
            final Tab tab,
            final ProgressIndicator databaseActivityIndicator,
            final TableView tableView) {
        final FetchTangTocData fetchTangTocData = new FetchTangTocData();
        tab.setDisable(true);
        databaseActivityIndicator.setVisible(true);
        databaseActivityIndicator.progressProperty().bind(fetchTangTocData.progressProperty());
        fetchTangTocData.setOnSucceeded(event -> tableView.setItems(fetchTangTocData.getValue()));
        fetchTangTocData.runningProperty().addListener((observable, wasRunning, isRunning) -> {
            if(!isRunning) {
                tab.setDisable(false);
                databaseActivityIndicator.setVisible(false);
            }
        });
        databaseExecutor.submit(fetchTangTocData);
    }

    public void fetchVeDichDataFromDataBaseToTableView(
            final Tab tab,
            final ProgressIndicator databaseActivityIndicator,
            final TableView tableView) {
        final FetchVeDichData fetchVeDichData = new FetchVeDichData();
        tab.setDisable(true);
        databaseActivityIndicator.setVisible(true);
        databaseActivityIndicator.progressProperty().bind(fetchVeDichData.progressProperty());
        fetchVeDichData.setOnSucceeded(event -> tableView.setItems(fetchVeDichData.getValue()));
        fetchVeDichData.runningProperty().addListener((observable, wasRunning, isRunning) -> {
            if(!isRunning) {
                tab.setDisable(false);
                databaseActivityIndicator.setVisible(false);
            }
        });
        databaseExecutor.submit(fetchVeDichData);
    }

    public void fetchDiemDataFromDataBaseToTableView(
            final Tab tab,
            final ProgressIndicator databaseActivityIndicator,
            final TableView tableView) {
        final FetchDiemData fetchDiemData = new FetchDiemData();
        tab.setDisable(true);
        databaseActivityIndicator.setVisible(true);
        databaseActivityIndicator.progressProperty().bind(fetchDiemData.progressProperty());
        fetchDiemData.setOnSucceeded(event -> tableView.setItems(fetchDiemData.getValue()));
        fetchDiemData.runningProperty().addListener((observable, wasRunning, isRunning) -> {
            if(!isRunning) {
                tab.setDisable(false);
                databaseActivityIndicator.setVisible(false);
            }
        });
        databaseExecutor.submit(fetchDiemData);
    }

    class FetchDiemData extends DBTask<ObservableList<EPoint>> {
        @Override
        protected ObservableList<EPoint> call() throws Exception {
            Thread.sleep(1000);
            return fetchData();
        }

        private ObservableList<EPoint> fetchData() {
            ObservableList<EPoint> data;
            data = BPoint.SelectAll();
            return data;
        }
    }

    class FetchVeDichData extends DBTask<ObservableList<EVeDich>> {

        @Override
        protected ObservableList<EVeDich> call() throws Exception {
            Thread.sleep(1000);
            return fetchData();
        }

        private ObservableList<EVeDich> fetchData() {
            ObservableList<EVeDich> data;
            data = BVeDich.SelectAll();
            return data;
        }
    }

    class FetchTangTocData extends DBTask<ObservableList<ETangToc>> {

        @Override
        protected ObservableList<ETangToc> call() throws Exception {
            Thread.sleep(1000);
            return fetchData();
        }

        private ObservableList<ETangToc> fetchData() {
            ObservableList<ETangToc> data;
            data = BTangToc.SelectAll();
            return data;
        }
    }

    class FetchVCNVData extends DBTask<ObservableList<EVuotChuongNgaiVat>> {

        @Override
        protected ObservableList<EVuotChuongNgaiVat> call() throws Exception {
            Thread.sleep(1000);
            return fetchData();
        }

        private ObservableList<EVuotChuongNgaiVat> fetchData() {
            ObservableList<EVuotChuongNgaiVat> data;
            data = BVuotChuongNgaiVat.SelectAll();
            return data;
        }
    }

    class FetchKhoiDongData extends DBTask<ObservableList<EKhoiDong>> {

        @Override
        protected ObservableList<EKhoiDong> call() throws Exception {
            Thread.sleep(1000);
            return fetchData();
        }

        private ObservableList<EKhoiDong> fetchData() {
            ObservableList<EKhoiDong> data;
            data = BKhoiDong.SelectAll();
            return data;
        }
    }

    abstract class DBTask<T> extends Task<T> {
        DBTask() {
            setOnFailed(t -> {
                //logger.log(Level.SEVERE, null, getException());
            });
        }
    }

    // executes database operations concurrent to JavaFX operations.
    private ExecutorService databaseExecutor = Executors.newFixedThreadPool(
            1,
            new DatabaseThreadFactory()
    );

    static class DatabaseThreadFactory implements ThreadFactory {
        static final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "Database-Connection-" + poolNumber.getAndIncrement() + "-thread");
            thread.setDaemon(true);

            return thread;
        }
    }
}