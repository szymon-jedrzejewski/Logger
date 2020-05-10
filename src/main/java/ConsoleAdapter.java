public class ConsoleAdapter implements Adapter {

    public void log(String message, Level level) {
            System.out.println(getDateTime() + " " + level + " " + message);
    }
}
