import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayRotateLeft {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int i,temp,k,j;
        int n=a.length;
        int count = gcd(a.length, d);
        for(i=0;i<count;i++){
            temp=a[i];
            j=i;
            while(true){
                k=j+d;
                if(k>=n){
                    k=k-n;
                }
                if(k==i)
                    break;
                a[j]=a[k];
                j=k;
            }
            a[j]=temp;

        }

        return a;
    }
    static int gcd(int a, int b){
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
