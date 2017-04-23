package thread_word;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Thread_word {
    String word = "";
    private int count,words;
    private List<String> result = new ArrayList<>();
    
    Thread_word(String w){
        this.word = w;
        count = 0;
    }
    
     public void read(String path) throws FileNotFoundException 
    {
            File rootDir = new File(path);
            Queue<File> fileTree = new PriorityQueue<>();
            Collections.addAll(fileTree, rootDir.listFiles());

            while (!fileTree.isEmpty())
            {
                File currentFile = fileTree.remove();
                if(currentFile.isDirectory()){
                    Collections.addAll(fileTree, currentFile.listFiles());
                } else {
                    result.add(currentFile.getAbsolutePath());
                }
            }
    }
     //Первое вхождение в файл и выход -> вывод: кол-во файлов с данным словом
    public int countFiles () throws IOException
    {
        String line;
        boolean found;
        for (String file : result)
        {
            found = false;
            try (
                    BufferedReader reader = new BufferedReader(
             new InputStreamReader( new FileInputStream(file), StandardCharsets.UTF_8))){
            
            while (((line = reader.readLine()) != null)&& found == false) {
                if (line.contains(this.word)) {
                    found = true;
                    count +=1;
                }
            }   
        } catch (IOException e) {}                
        }
        return count;       
    }
    
    //Вход в файл и выход,когда конец файла -> вывод: кол-во данных слов в данном файле
    public int countWords () throws IOException
    {
        String line;
        for (String file : result)
        {
            
            try (
                    BufferedReader reader = new BufferedReader(
             new InputStreamReader( new FileInputStream(file), StandardCharsets.UTF_8))){
            
            while (((line = reader.readLine()) != null)) {
                if (line.contains(this.word)) {
                    words +=1;
                }
            }   
        } catch (IOException e) {}                
        }
        return words;       
    }
}
