package pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReaderThread extends Thread{
    private PipedInputStream pipedInputStream;

    public ReaderThread(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        try{
            int data;

            while((data = pipedInputStream.read()) != -1){
                System.out.print((char) data + " ");
            }
            pipedInputStream.close();
        } catch (IOException e){
            System.out.println("IOException : " + e.getMessage());
        }
    }
}
