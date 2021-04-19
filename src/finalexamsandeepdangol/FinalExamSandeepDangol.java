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

  
    // method for Encrypting Text
    public static int EncryptTxt(char[] chars, int randomKey, char[] char2, int a) {
        for (char c : chars) {
            c += randomKey;
            
            char2[a] = c;
            a++;
        }
        return a;
    }

    // method for Decrypting Text
    public static void DecryptTxt(char[] chars6, int randomKey, char[] char2, int a) {
        for (char c : chars6) {
            c -= randomKey;
            
            char2[a] = c;
            a++;
        }
    }

    // method for removing extra unwanted index from  array
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
    // method for generating Random Key
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
        
        char[] charOrigin;
        char[] charEncText = new char[1000];
        char[] charStore = new char[1000];
        char[] charDecToEnc1 = new char[1000];
        char[] charEncToDec = new char[1000];
        char[] charDecyp = new char[1000];
        String zxc = "";
        int a = 0, randomKey;
        int k, i;
        
        String header = "A1B2";
        String trailer = "END";

        randomKey = RandomKeyGen();
 

        // reading  originalText.txt file
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("originalText.txt"));
            origin = br.readLine();
        } catch (Exception e) {
            return;
        }

        System.out.println("Original Text : \n"+origin);

        charOrigin = origin.toCharArray();
        
        a = EncryptTxt(charOrigin, randomKey, charEncText, a);
        
        //saving index size of original text
        int s = a;
        
        
        
        zxc = new String(charEncText);
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
        charStore = encrypt.toCharArray();
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("ecnryptedText.txt"));
            for (char c : charStore) {
              
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
        charDecToEnc1 = encrypt.toCharArray();

        int ss = charDecToEnc1.length;
        ss -= 3;

            // Removing Header And Trailer from Encrypted Text
        for (i = 0, k = 0; i < charDecToEnc1.length; i++) {
            if (i > 3 && i < ss) {
                charEncToDec[k] = charDecToEnc1[i];
                k++;
            }
        }

            // RE-Reversing String 
        zxc = new String(charEncToDec);
        sb = new StringBuilder(zxc);
        sb.reverse();
        encrypt = sb + "";

        // resultText.txt
        a = 0;
        charDecyp = encrypt.toCharArray();
        
        DecryptTxt(charDecyp, randomKey, charEncText, a);
        

        String result = new String(charEncText);
 
        
        char[] finalChar = FinalChar(s, i, k, charEncText);

        result = new String(finalChar);
        System.out.println("");
        System.out.println("Result of Decryption Text : \n"+ result);
        
        charStore = result.toCharArray();
        
        // Write on resultText.txt
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("resultText.txt"));
            for (char c : charStore) {
              
                bw.write(c);
            }
            bw.close();
        } catch (Exception ex) {
            return;
        }
        

    }


}
