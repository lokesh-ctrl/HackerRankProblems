import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DecodingMessage{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your message");
        String[] message = scanner.nextLine().split(" ");
        decodeMessage(message);
    }

    static void decodeMessage(String[] messageArray){
        System.out.println(helper(messageArray, messageArray.length));
    }

    static int helper(String[] code,int k){
        int result =0;
        if(k==0) return 1;
        int starting = code.length-k;
        if(Integer.parseInt(code[starting])==0) return 0;
        result=helper(code, k-1);
        if(k>=2&&(Integer.parseInt(code[starting])<=2)&&(Integer.parseInt(code[starting+1])<=6)){
            result+=helper(code, k-2);
        }
		return result;
	}
}