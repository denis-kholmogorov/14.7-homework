import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Loader
{
    public static void main(String[] args) throws Exception
    {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        int proc =Runtime.getRuntime().availableProcessors();
        int regionCode = 199;
        char letters[] = {'А','У', 'К', 'Е', 'Н', 'Х', 'В', 'Р', 'О', 'С', 'М', 'Т'};
        StringBuilder builder = new StringBuilder();
        long start = System.currentTimeMillis();
        for(int number = 1; number < 1000; number++)
        {
            for (char firstLetter : letters)
            {
                for (char secondLetter : letters)
                {
                    for (char thirdLetter : letters)
                    {
                        builder.append(firstLetter);
                        builder.append(padNumber(number));
                        builder.append(secondLetter);
                        builder.append(thirdLetter);
                        builder.append(regionCode);
                        builder.append("\n");

                    }
                }
            }
        }
        System.out.println((System.currentTimeMillis() - start) + " ms builder end \n" );
        long execut = System.currentTimeMillis();
        executor.execute(()->{
            try {
                for(int i = 0; i < proc; i++){
                    PrintWriter writer = new PrintWriter("res/numbers" + i + ".txt");
                    writer.write(builder.toString());
                    writer.flush();
                    writer.close();
                    System.out.println((System.currentTimeMillis() - execut) + " ms executor end " + i);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            executor.shutdown();
        });
        Thread.sleep(2000);
        long forTime = System.currentTimeMillis();
        for(int i = 0; i < proc; i++){
            Writer writer = new Writer(builder, forTime);
            writer.start();
        }
    }

    private static String padNumber(int number) {
        String numberStr = Integer.toString(number);
        int padSize = numberStr.length();
        if (padSize == 1) {
            return "00" + numberStr;
        } else if (padSize == 2) {
            return "0" + numberStr;
        } else {
            return numberStr;
        }
    }
}
/*Writer writer1 = new Writer(builder, start);
        Writer writer2 = new Writer(builder, start);
        writer1.start();
        writer2.start();
        */

/* executor.execute(()->{
            try {
                PrintWriter writer = new PrintWriter("res/numbers1.txt");
                PrintWriter writer1 = new PrintWriter("res/numbers2.txt");
                writer.write(builder.toString());
                writer1.write(builder.toString());
                writer1.flush();
                writer1.close();
                writer.flush();
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            executor.shutdown();
            System.out.println((System.currentTimeMillis() - start1) + " ms starr1" );
        });*/