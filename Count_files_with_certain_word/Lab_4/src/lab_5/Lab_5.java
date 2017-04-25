
package lab_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab_5 {
    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File("C:\\Users\\Vlad\\AndroidStudioProjects\\YandexProject\\YandexTranslator\\MyTranslatorWithYandex_v1.01");
        String word = "for";
         Utils u = new Utils(word);

        long startTime = System.currentTimeMillis();
//        
//        try {
//            System.out.println("Слово '"+u.getW()+"' встречается в директории: " + u.searchCountWord(u.AllFiles(file))+" раз(а)");
//            long timeSpent = System.currentTimeMillis() - startTime;
//            System.out.println("Программа выполнялась " + timeSpent + " миллисекунд");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Lab_5.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.out.println("");
        
        System.out.println("Слово '"+u.getW()+"' встречается в директории: " + u.searchCountWord(u.AllFiles(file))+" раз(а)");
        System.out.println("Файлов,содержащих слово '"+u.getW()+"' всего: " + u.searchCountFiles(u.AllFiles(file))+" файл(ов)");
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("Программа выполнялась " + timeSpent + " миллисекунд");       
    }    
}