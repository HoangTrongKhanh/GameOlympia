package Utils;

import BLL.BKhoiDong;
import EntityOlympia.EKhoiDong;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class DelayUtil {
    public static void delay(long delayMs, Runnable toRun) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException e) {e.printStackTrace();}
            Platform.runLater(toRun);
        });
        t.setDaemon(true);
        t.start();
    }
}
