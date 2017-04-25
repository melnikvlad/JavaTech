
package thread_word;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        long startTime = System.currentTimeMillis();
        String word = "if";
        Thread_word wd;
        
        wd = new Thread_word(word);
        
        wd.read("C:\\Users\\Vlad\\AndroidStudioProjects\\SocialMediaApp\\Scruji");
        int files = wd.countFiles();
        int words = wd.countWords();
        System.out.println("C:/Users/Vlad/AndroidStudioProjects/YandexProject/YandexTranslator/MyTranslatorWithYandex_v1.01");
        System.out.println("Количество файлов в директории со словом '" + word + "': " + files);
        System.out.println("Количество слов '" + word + "' в директории: " + words);
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Программа выполнялась " + timeSpent/1000000000.0 + " миллисекунд");
        
    }
}
