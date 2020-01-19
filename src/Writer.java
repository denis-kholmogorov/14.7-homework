import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Writer extends Thread {

    StringBuilder builder;

    long start;

    public Writer(StringBuilder builder, long start){
        this.builder = builder;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            PrintWriter writer = new PrintWriter("res/numbers" + Thread.currentThread().getName() +".txt");
            writer.write(builder.toString());
            writer.flush();
            writer.close();
            System.out.println((System.currentTimeMillis() - start) + " ms " + Thread.currentThread().getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
