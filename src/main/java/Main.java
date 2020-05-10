import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Connection connection;
//        String url = "jdbc:sqlite:log.db";
        String url = "jdbc:postgresql://localhost:5432/{databaseName}";

        String login = "";
        String password = "";

        Logger logger = new Logger();

        try {
            connection = DriverManager.getConnection(url, login, password);
            logger.put(new ConsoleAdapter(), Level.INFO);
            logger.put(new FileAdapter("log.txt"), Level.WARN);
            logger.put(new DatabaseAdapter(connection), Level.ERROR);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        logger.log("Debug", Level.DEBUG);
        logger.log("Message", Level.INFO);
        logger.log("You've got an off", Level.OFF);
        logger.log("I'm warning you", Level.WARN);
    }
}
