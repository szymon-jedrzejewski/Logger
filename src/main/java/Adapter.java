import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface Adapter {
    void log(String message, Level level);

    default String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
