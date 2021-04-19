/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalexamsandeepdangol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

/**
 *
 * @author zerof
 */
public class FinalExamSandeepDangol {

  
    
    public static int EncryptTxt(char[] chars, int randomKey, char[] char2, int a) {
        for (char c : chars) {
            c += randomKey;
            
            char2[a] = c;
            a++;
        }
        return a;
    }

    public static void DecryptTxt(char[] chars6, int randomKey, char[] char2, int a) {
        for (char c : chars6) {
            c -= randomKey;
            
            char2[a] = c;
            a++;
        }
    }

    public static char[] FinalChar(int s, int i, int k, char[] char2) {
        char[] finalChar = new char[s];
        for (i = 0, k = 0; i < char2.length; i++) {
            if (i < s) {
                finalChar[k] = char2[i];
                k++;
            }
        }
        return finalChar;
    }

    public static int RandomKeyGen() {
        int randomKey;
        //Random Key generated "randomKey"
        Random r = new Random(8);
        randomKey = r.nextInt(9);
        return randomKey;
    }

    public static void main(String[] args) {

        String origin = "";
        String encrypt = "";
        
        char[] chars;
        char[] char2 = new char[1000];
        char[] char3 = new char[1000];
        char[] char4 = new char[1000];
        char[] char5 = new char[1000];
        char[] chars6 = new char[1000];
        String zxc = "";
        int a = 0, randomKey;
        int k, i;
        
        String header = "A1B2";
        String trailer = "END";

        randomKey = RandomKeyGen();
 

        // read originalText.txt
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("originalText.txt"));
            origin = br.readLine();
        } catch (Exception e) {
            return;
        }

        System.out.println("Original Text : \n"+origin);

        chars = origin.toCharArray();
        
        a = EncryptTxt(chars, randomKey, char2, a);
        
        //saving index size of original text
        int s = a;
        
        
        
        zxc = new String(char2);
        System.out.println("");
        System.out.println("Encrypted Text : \n"+ zxc);
        // reverse string
        StringBuilder sb = new StringBuilder(zxc);
        sb.reverse();
        
        System.out.println("");
        System.out.println("Reversed Text : \n"+ sb);
        // encapsulate string
        encrypt = header + sb + trailer;
        
        
        // Write on ecnryptText.txt
        char3 = encrypt.toCharArray();
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("ecnryptedText.txt"));
            for (char c : char3) {
              
                bw.write(c);
            }
            bw.close();
        } catch (Exception ex) {
            return;
        }

        // Read encryptText.txt
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("ecnryptedText.txt"));
            encrypt = br.readLine();
        } catch (Exception e) {
            return;
        }
        System.out.println("");
        System.out.println("Encrypted, Reversed and Encapsilated Text : \n"+ encrypt);
        
        
        //Decrypting encryptText.txt
        char4 = encrypt.toCharArray();

        int ss = char4.length;
        ss -= 3;

        
        for (i = 0, k = 0; i < char4.length; i++) {
            if (i > 3 && i < ss) {
                char5[k] = char4[i];
                k++;
            }
        }

   
        zxc = new String(char5);
        sb = new StringBuilder(zxc);
        sb.reverse();
        encrypt = sb + "";

        // resultText.txt
        a = 0;
        chars6 = encrypt.toCharArray();
        DecryptTxt(chars6, randomKey, char2, a);
        

        String result = new String(char2);
 
        
        char[] finalChar = FinalChar(s, i, k, char2);

        result = new String(finalChar);
        System.out.println("");
        System.out.println("Result of Decryption Text : \n"+ result);
        
        char3 = result.toCharArray();
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("resultText.txt"));
            for (char c : char3) {
              
                bw.write(c);
            }
            bw.close();
        } catch (Exception ex) {
            return;
        }
        // Write on ecnryptText.txt

    }


}
