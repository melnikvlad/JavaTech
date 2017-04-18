
package lab_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab_4 {

    public static void main(String[] args) {
        File file = new File("C:/Users/Vlad/Documents/NetBeansProjects/Lab_3");
        String word = "private";
        Utils u = new Utils(word);
        
        try {
            System.out.println("Слово '"+u.getW()+"' встречается в директории: " + u.searchCount(u.AllFiles(file))+" раз");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lab_4.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
