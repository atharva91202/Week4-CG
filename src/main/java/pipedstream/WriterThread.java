package pipedstream;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriterThread extends Thread{
    private PipedOutputStream pipedOutputStream;

    public WriterThread(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        try{
            String content = "Hello guys. My name is Atharva.\n" +
                    "How are you All?";
            pipedOutputStream.write(content.getBytes());

            pipedOutputStream.close();
        } catch (IOException e){
            System.out.println("IOException : " + e.getMessage());
        }
    }
}
