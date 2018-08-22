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
            int[] bribes = new int[n];
            int[] idealArray = new int[n];
            for(int i=0;i<n;i++){
                idealArray[i]=i+1;
            }
            int j=0;int k=0;
            while((j+k)<=n){
                if(checkArray(idealArray, q)){break;}
                    if(idealArray[j]==q[j]){
                    j++;
                    }
                    else{
                            int val=q[j];
                            bribes[val-1]++;
                            int temp = q[val-1];
                            q[val-1]=val;
                            q[j]=temp;
                        if(checkArray(idealArray, q)){
                                break;
                            }
                        k++;
                    }
                    
            }
            int count=0;
            int sum=0;
            for(int i=0;i<n;i++){
                if(bribes[i]>2){
                    count++;
                    break;
                }
                else{
                    sum+=bribes[i];
                }
            }
            if(count==0){
                System.out.println(sum);
            }
            else{
                System.out.println("Too chaotic");
            }
                
        
        }
        static boolean checkArray(int[] ideal,int[] real){
            int count=0;
            for(int i=0;i<ideal.length;i++){
                if(ideal[i]==real[i])
                    count++;
            }
            if(count==ideal.length){
                return true;
            }
            else return false;
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