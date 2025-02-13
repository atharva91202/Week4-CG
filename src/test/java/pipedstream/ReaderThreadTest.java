package pipedstream;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class ReaderThreadTest {

    @Test
    void testReaderThread_WithRegularText() throws IOException, InterruptedException {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        WriterThread writerThread = new WriterThread(pipedOutputStream);
        ReaderThread readerThread = new ReaderThread(pipedInputStream);

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();

        assertEquals(0, pipedInputStream.available(), "PipedInputStream should be empty after reading.");
    }

    @Test
    void testReaderThread_WithEmptyContent() throws IOException, InterruptedException {
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

        ReaderThread readerThread = new ReaderThread(pipedInputStream);

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();

        assertEquals(0, pipedInputStream.available(), "PipedInputStream should be empty after reading empty content.");
    }

    @Test
    void testReaderThread_WithLargeData() throws IOException, InterruptedException {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        // WriterThread with large content
        WriterThread writerThread = new WriterThread(pipedOutputStream) {
            @Override
            public void run() {
                try {
                    String largeContent = "A".repeat(1000); // 1000 'A' characters
                    pipedOutputStream.write(largeContent.getBytes());
                    pipedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        ReaderThread readerThread = new ReaderThread(pipedInputStream);

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();

        assertEquals(0, pipedInputStream.available(), "PipedInputStream should be empty after reading large content.");
    }
}

