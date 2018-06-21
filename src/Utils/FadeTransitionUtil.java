package Utils;

import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeTransitionUtil {

    public static void FadeOut(Parent secondView ,Pane rootPane) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setOnFinished(event -> loadSecond(secondView, rootPane));
        fadeTransition.play();
    }

    private static void loadSecond(Parent secondView, Pane rootPane) {
        Scene newScene = new Scene(secondView);
        Stage curStage = (Stage) rootPane.getScene().getWindow();
        curStage.setScene(newScene);
    }

    public static void FadeIn(Pane rootPane) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }
}
