/**
 * Author: Luke Walters
 * The VigenereCipher class which encodes and decodes a given string through the command line with a given key
 */
import java.io.PrintWriter;

public class VigenereCipher {
    
    /**
     * 
     * @param inputString
     * @param keyWord
     * @param pen
     * Takes in a key and a string to be encoded and prints out the encoded string
     * Expects lower case alphabetic character only
     */
    public static void encode(String inputString, String keyWord, PrintWriter pen){

        int holder = 0;
        int keyCount = 0;
        int base = 97;//the char value of 'a' in the ascii table

        for (int i = 0; i < inputString.length(); i++){

            int keyHolder = keyWord.charAt(keyCount);

            keyHolder -= base;
            holder = inputString.charAt(i);
            holder -= base;
            holder += keyHolder;
            holder = holder % 26;
            holder += base;

            char holderchar = (char) holder;

            keyCount += 1;
            keyCount = keyCount % keyWord.length();//loops through the keyWord
            
            pen.print(holderchar);
        }
        pen.println();
    }
    /**
     * 
     * @param cipherText
     * @param keyWord
     * @param pen
     * Takes in a key and a string to be decoded and prints out the decoded string
     * Expects lower case alphabetic character only
     */
    public static void decode(String cipherText, String keyWord, PrintWriter pen){

        int holder;
        int keyCount = 0;
        int base = 97;//the char value of 'a' in the ascii table

        for (int i = 0; i < cipherText.length(); i++){

            int keyHolder = keyWord.charAt(keyCount);

            keyHolder -= base;
            holder = cipherText.charAt(i);
            holder -= base;
            holder -= keyHolder;
            holder = (holder + 26) % 26;
            holder += base;

            char holderchar = (char) holder;

            keyCount ++;
            keyCount = keyCount % keyWord.length();
            
            pen.print(holderchar);
        }
        pen.println();
    }

    /**
     * 
     * @param args
     * @throws Exception
     * Expects three command line arguments one that is either "encode" or "decode" and two other strings that are both lowercase alphabetical with no whitespace. 
     * Will call the enocde and decode functions
     */
    public static void main(String[] args) throws Exception {
        
        PrintWriter pen = new java.io.PrintWriter(System.out, true);
        

        if (args.length != 3){
            pen.println("Incorrect Number of Statements");
            return;
            
        }

      else if(args[2].equals("".toString())){
            pen.println(args[1]);
            return;
        }

        else if(args[1].equals("".toString())){
            return;
        }

        else if ((args[0].equals("encode")) == (args[0].equals("decode"))){//Checks to ensure that either "encode" or "decode" is given
            pen.println("Incorrect input valid options are 'encode' or 'decode'");
            return;  
        } 
        
        else {
            if(args[0].equals("encode")){// Clause that checks to see whether it should encode or decode then calls those two functions
                encode(args[1], args[2], pen);
            }
            if (args[0].equals("decode")){
              decode(args[1], args[2], pen);
            }
        }
    }
}