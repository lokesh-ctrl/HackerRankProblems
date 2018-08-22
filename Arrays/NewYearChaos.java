import jdk.nashorn.internal.ir.BlockLexicalContext;

import java.awt.SystemTray;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos{
        static void minimumBribes(int[] q) {
            int n=q.length;
            int total=0;
                int[] bribes=new int[n];
                int[] idealArray = new int[n];
                for(int i=0;i<n;i++){
                    idealArray[i]=i+1;
                }
            for(int i=0;i<n-1;i++){
                if(q[i]<q[i+1]){

                }
                else{
                    int temp= q[i];
                    bribes[q[i]-1]++;
                    q[i]=q[i+1];
                    q[i+1]=temp;
                    total++;
                    i=0;
                    if(total>=n){
                        break;
                    }
                }
            }                
            if(checkArray(idealArray, q)){
                
                    int count=0;
                    for(int i=0;i<bribes.length;i++){
                        System.out.print("bribe:"+i+bribes[i]);
                        if(bribes[i]>2){
                            count++;
                           System.out.println("Too chaotic");
                            break;
                        }
                    }
                    if(count==0){
                        System.out.println(total);
                    }
                }
                else{
                    System.out.print(total);

                    System.out.println("Too chaotic");
                }
        
        
        }
        static boolean checkArray(int[] ideal,int[] real){
            System.out.println("calling checking");
            int count=0;
            for(int i=0;i<ideal.length;i++){
                if(ideal[i]==real[i])
                    count++;
            }
            if(count==ideal.length){
                System.out.print("true");
                return true;
                
            }
            
            else {System.out.print("false");
            return false;}
           
        }
    
        private static final Scanner scanner = new Scanner(System.in);
    
        public static void main(String[] args) {
            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
            for (int tItr = 0; tItr < t; tItr++) {
                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
                int[] q = new int[n];
    
                String[] qItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
                for (int i = 0; i < n; i++) {
                    int qItem = Integer.parseInt(qItems[i]);
                    q[i] = qItem;
                }
    
                minimumBribes(q);
            }
    
            scanner.close();
        }
}