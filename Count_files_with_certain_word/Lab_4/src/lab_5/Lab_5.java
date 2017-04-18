
package lab_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab_5 {

    public static void main(String[] args) {
        
        File file = new File("C:/Users/Vlad/Documents/NetBeansProjects/JavaTech/Collections_and_JTests/Lab_3");
        String word = "@Test";
        Utils u = new Utils(word);
        
         System.out.println("Все файлы директории :");
         System.out.println("");
         u.viewAllFiles(u.AllFiles(file));
         System.out.println("");
         
         long startTime = System.currentTimeMillis();
        try {
            System.out.println("Слово '"+u.getW()+"' встречается в директории: " + u.searchCountWord(u.AllFiles(file))+" раз(а)");
            long timeSpent = System.currentTimeMillis() - startTime;
            System.out.println("Программа выполнялась " + timeSpent + " миллисекунд");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lab_5.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");
         try {
            System.out.println("Файлов,содержащих слово '"+u.getW()+"' всего: " + u.searchCountFiles(u.AllFiles(file))+" файл(ов)");
            long timeSpent = System.currentTimeMillis() - startTime;
            System.out.println("Программа выполнялась " + timeSpent + " миллисекунд");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lab_5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
