import java.io.*;

public class FileAdapter implements Adapter {

    private BufferedWriter bufferedWriter;

    public FileAdapter(String path) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(path), true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message, Level level) {
        try {
            bufferedWriter.append(getDateTime())
                    .append(" ")
                    .append(String.valueOf(level
                    ))
                    .append(" ")
                    .append(message)
                    .append("\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
