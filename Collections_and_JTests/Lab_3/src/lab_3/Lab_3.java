
package lab_3;

public abstract class Lab_3 {
     public static void main(String[] args) {
        String s = "Collection of some letters.";
        System.out.println(s);
        
        Letters l = new Letters("LalaLoLo");
        System.out.println(l.toString());
        
        System.out.println(l.removeAll("a"));
        System.out.println(l.toString());
        
        System.out.println(l.contains('o'));
        
        System.out.println(l.containsAll("lo"));
        System.out.println(l.toString());
        
        System.out.println(l.toArray()[3]);
        
        System.out.println(l.add('k'));
        System.out.println(l.toString());
        
        System.out.println(l.addAll("ko"));
        System.out.println(l.toString());
        
        System.out.println(l.size());
        
        System.out.println(l.retainAll("lo"));
        System.out.println(l.toString());
        
        String ss = "lalala";
        System.out.println(ss.substring(0, ss.length()-1));
     }
     
}
