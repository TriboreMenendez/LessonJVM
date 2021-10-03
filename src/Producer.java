import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Producer extends Thread{

    String foundWord;
    Scanner scanner;
    {
        try {
            scanner = new Scanner(Main.file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run () {
        String s = Main.searchWord.substring(0,Main.searchWord.length()-2);
        int x =0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Pattern pattern = Pattern.compile(s,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                foundWord = matcher.group();
                try {
                    Main.word.put(Main.searchWord);
                }
                catch (InterruptedException e){
                }
            }
        }
    }
}
