package pipedstream;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class WriterThreadTest {

    @Test
    void testWriterThread_WithRegularText() throws IOException {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        WriterThread writerThread = new WriterThread(pipedOutputStream);
        writerThread.start();

        StringBuilder result = new StringBuilder();
        int data;
        while ((data = pipedInputStream.read()) != -1) {
            result.append((char) data);
        }

        assertEquals("Hello guys. My name is Amber.\nHow are you All?", result.toString(),
                "Written content should match expected output");

        pipedInputStream.close();
    }

    @Test
    void testWriterThread_WithEmptyContent() throws IOException {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        // WriterThread with empty content
        WriterThread writerThread = new WriterThread(pipedOutputStream) {
            @Override
            public void run() {
                try {
                    pipedOutputStream.write("".getBytes());
                    pipedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        writerThread.start();

        assertEquals(-1, pipedInputStream.read(), "Empty content should result in EOF (-1).");

        pipedInputStream.close();
    }

    @Test
    void testWriterThread_WithSpecialCharacters() throws IOException {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        // WriterThread with special characters
        WriterThread writerThread = new WriterThread(pipedOutputStream) {
            @Override
            public void run() {
                try {
                    String content = "@#$%^&*()_+{}|:\"<>?";
                    pipedOutputStream.write(content.getBytes());
                    pipedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        writerThread.start();

        StringBuilder result = new StringBuilder();
        int data;
        while ((data = pipedInputStream.read()) != -1) {
            result.append((char) data);
        }

        assertEquals("@#$%^&*()_+{}|:\"<>?", result.toString(), "Special characters should be correctly written and read.");

        pipedInputStream.close();
    }
}
