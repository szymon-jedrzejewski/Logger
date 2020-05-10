import java.sql.*;

public class DatabaseAdapter implements Adapter {

    private Connection connection;

    public DatabaseAdapter(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void log(String message, Level level) {

        String sqlQuery = "INSERT INTO log(date, message, level) VALUES(?,?,?)";

        try (PreparedStatement statement = connection
                .prepareStatement(sqlQuery)) {

            statement.setString(1, getDateTime());
            statement.setString(2, message);
            statement.setString(3, level.toString());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Cannot established connection");
        }
    }
}
