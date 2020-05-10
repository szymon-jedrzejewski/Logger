import java.util.HashMap;
import java.util.Map;

public enum Level {
    All(100), DEBUG(200), INFO(300),WARN(400), ERROR(500), FATAL(600), OFF(700), TRACE(800);

    private int levelValue;

    Level(int i) {
        levelValue = i;
    }

    int getLevelValue() {
        return levelValue;
    }
}
