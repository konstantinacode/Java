import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        
        String[] tokens = new String[s.length()];
        tokens = s.trim().split("[\\\\'.!,?_@ \\s  ]+");
        int t = 0;
        for(int i=0; i<tokens.length; i++) {
        	if(tokens[i].equals("")) {
        		break;
        	}
        	if(tokens[i] != null) {
        		t++; 
        	}
        }
        System.out.println(t);
        for(int i=0; i<t; i++) {
        	System.out.println(tokens[i]);
        }
        
        scan.close();
    }
}

