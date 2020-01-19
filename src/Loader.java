import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Loader
{
    public static void main(String[] args) throws Exception
    {
        long start = System.currentTimeMillis();
        int regionCode = 199;
        char letters[] = {'А','У', 'К', 'Е', 'Н', 'Х', 'В', 'Р', 'О', 'С', 'М', 'Т'};

        StringBuilder builder = new StringBuilder();

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
        Writer writer1 = new Writer(builder, start);
        Writer writer2 = new Writer(builder, start);
        writer1.start();
        writer2.start();
        System.out.println((System.currentTimeMillis() - start) + " ms" );
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
