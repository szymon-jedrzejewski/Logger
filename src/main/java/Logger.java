import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logger {

    private Map<Adapter, Level> adapters;

    public Logger() {
        adapters = new HashMap<>();
    }

    public void put(Adapter adapter, Level level){
        adapters.put(adapter, level);
    }

    public void log(String message, Level level) {
        for (Map.Entry<Adapter, Level> configPair : adapters.entrySet()) {
            if (level.getLevelValue() >= configPair.getValue().getLevelValue()) {
                configPair.getKey().log(message, level);
            }
        }
    }
}
