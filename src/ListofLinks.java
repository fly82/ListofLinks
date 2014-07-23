import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListofLinks {
    public static void main(String... args) throws IOException {
        List<String> ls = new ArrayList<>();

        try (FileReader fr = new FileReader(args[0])) {

            int b;
            boolean sw = true;
            String str = "";

            while ((b = fr.read()) != -1) {
                if (b > 47 && b < 59) {
                    sw = true;
                    str += ((char) b);
                }
                if ((b < 48 || b > 58) && sw) {
                    sw = false;
                    str = args[1] + str + args[2];
                    ls.add(str);
                    str = "";
                }
            }
        }
        ls.stream().forEach(System.out::println);
    }
}
