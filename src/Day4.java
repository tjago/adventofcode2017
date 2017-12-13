import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jagod on 08/12/2017.
 */
public class Day4 {
    public static void main(String[] args) {
        try {
            int counter = 0;
            List<String> passphrases = new Day4().getStringArraysOutOfFile("res/Day4passwords.txt");
            for (String pass : passphrases) {
//                System.out.println(pass);
                String[] words = pass.split("\\W+");
                int originalWords = words.length;
                Set<String> set = new HashSet<>();
                for (String s : words) {
                    set.add(s);
                }
                System.out.println(" original words/in set = " + originalWords + "/" + set.size());
                if (set.size() != originalWords) {
                    counter++;
                }

            }
            System.out.println("Solution: " + (passphrases.size() - counter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getStringArraysOutOfFile(String filename) throws IOException {
        List<String> passwordsPassphrases = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        try {
            String line = br.readLine();

            while (line != null) {
                passwordsPassphrases.add(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return passwordsPassphrases;
    }
}

