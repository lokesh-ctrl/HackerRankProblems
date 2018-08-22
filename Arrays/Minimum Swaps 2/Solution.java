import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int n= arr.length;
        int i=0;
        int k=0;
        int count=0;
        while(i+k<=n){
            if(arr[i]==(i+1)){
                i++;
            }
            else{
                int temp= arr[i];
                arr[i]= arr[temp-1];
                arr[temp-1]=temp;
                count++;
                k++;
                k=i+k;
                i=0;
            }
        }
        return count;

    }



    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        System.out.println(String.valueOf(res));

        scanner.close();
    }
}
