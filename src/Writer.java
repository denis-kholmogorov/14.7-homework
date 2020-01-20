import java.io.PrintWriter;

public class Writer extends Thread {

    private final StringBuilder builder;
    private final PrintWriter writer;
    private long start;

    public Writer(StringBuilder builder, PrintWriter writer, long start) {
        this.builder = builder;
        this.start = start;
        this.writer = writer;

    }

    @Override
    public void run() {
        writer.write(builder.toString());
        writer.flush();
        writer.close(); // закрываю writer в конце после записи всех данныхж
        System.out.println((System.currentTimeMillis() - start) + " ms " + Thread.currentThread().getName());
    }
}
