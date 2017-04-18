
package lab_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Utils {
    private String w;

    public Utils(String w) {
        this.w = w;
    }

    public String getW() {
        return w;
    }
    
     public List<File> AllFiles(File file){
        File[] listOfFiles = file.listFiles();
        List<File> result = new ArrayList<>();
        
        for (int i = 0; i < listOfFiles.length; i++) {
          if (listOfFiles[i].isFile()) {
            System.out.println("____________________________________________________");
            System.out.println(listOfFiles[i].getName());
            result.add(listOfFiles[i]);
          }
          else if (listOfFiles[i].isDirectory()) {
              result.addAll(AllFiles(listOfFiles[i]));
            }
          }
    return result;
    }
     
    public int searchCount(List<File> list) throws FileNotFoundException{
    int count = 0;
    
    for (int i=0;i<list.size();i++){
    Scanner scanner = new Scanner(list.get(i));
        while (scanner.hasNext()) 
        {
            String nextWord = scanner.next().trim();
            if (nextWord.equals(this.getW())) { 
                ++count; 
            }
        }
    }
    return count;
    }
}
