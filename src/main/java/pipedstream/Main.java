package pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
    public static void main(String[] args) {
        try{
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

            WriterThread writer = new WriterThread(pipedOutputStream);
            ReaderThread reader = new ReaderThread(pipedInputStream);

            writer.start();
            reader.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
