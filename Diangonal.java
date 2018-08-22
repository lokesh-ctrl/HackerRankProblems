import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Diangonal {
// Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    int[] sumArray = new int[16];
    int counter=0;
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            sumArray[counter]=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
            counter++;
        }
    }
    for(int i=0;i<sumArray.length;i++){
        System.out.print(sumArray[i]+"  ");
    }
      int result = maxfind(sumArray);
        return result;
    }
        
    static int maxfind(int[] suma){
        int max=0;
        for(int k=0;k<suma.length;k++){
            if(max<suma[k]){
                max=suma[k];
            }
        }
        System.out.print("hello"+max);
        return max;
    }
    
    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(System.in);
       
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println("hi"+String.valueOf(result));
        
    }
}