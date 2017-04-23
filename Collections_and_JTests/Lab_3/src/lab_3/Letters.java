
package lab_3;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Letters extends AbstractCollection  {
    
    private String str;

    public Letters(String str) {
        this.str = str;
    }

    public Letters() {
    }
    

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    
    @Override
    public String toString() {
        return this.str;
    }

    @Override
    public void clear() {
        this.str = "";
    }

    public boolean retainAll(String s) {
        
        boolean b = false;
        int i = 0;
        while (i<this.str.length()) {
            if (s.indexOf(this.str.charAt(i)) == -1) {
                this.str = this.str.substring(0, i) + this.str.substring(i+1);
                i--;
                b = true;
            }
            i++;
        };
        return b;          
    }
    public boolean retainAll(Collection c) {
        
        return retainAll(c.toString());
    }
    

    public boolean addAll(String s) {
         this.str += s;
        return true;
    }
    
    public boolean addAll(Collection c) {
         this.str += c.toString();
        return true;
    }

    public boolean containsAll(String s) {
        s = s.toLowerCase();
        int c = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (contains(s.charAt(i)))
            {
                c += 1;
            }
        }
        return (c == s.length());
    }

     public boolean removeAll(String s) {
        s = s.toLowerCase();
        boolean b = false;
       
        for (int i = 0; i < s.length(); i++)
        {
            if (remove(s.charAt(i)))
                b = true;
        }
        return b;
    }
     
    public boolean remove(Character c) {
        c = Character.toLowerCase(c);
        boolean b = false;
        int i = this.str.indexOf(c);
        while(i!=-1){
            this.str = this.str.substring(0, i) + this.str.substring(i+1);
            i = this.str.indexOf(c);
            b = true;  
        }  
        return b;
    }

    public boolean add(Character c) {
      
        this.str += c;
        return true; 
    }

    @Override
    public Character[] toArray() {
        Character[] arr = new Character[this.str.length()];
        for (int i = 0; i<this.str.length(); i++)
        {
            arr[i] = this.str.charAt(i);
        }
        return arr;
    }

    public boolean contains(Character c) {
       return (this.str.indexOf(Character.toLowerCase(c)) != -1);
    }

    @Override
    public boolean isEmpty() {
        return (this.str == "");
    }
 
    @Override
    public int size() {
        if(this.str == null)
        {
            return 0;
        }
        else{
         return this.str.length();   
        }
        
    }
    
    public Iterator<Character> iterator(){
    ArrayList a = new ArrayList();
    if(this.str == null){
        char[] arrChar = new char[0]; 
    }
    else{
     char[] arrChar = new char[this.str.length()];
    arrChar = this.str.toCharArray();   
 
        for (int i = 0; i< this.str.length();i++){
           a.add(arrChar[i]);
        } 
    }
    return a.iterator();
    }
    
   
}
