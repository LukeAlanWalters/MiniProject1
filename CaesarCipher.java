/**
 * Author Luke Walters
 * File for the CaesarCipher class Encodes or decodes a given string
 */

import java.io.PrintWriter;

public class CaesarCipher {


    /**
     * 
     * @param holder
     * @param codeType
     * @return int
     * Takes in a holder and either "encode" or "decode" and wraps around the alphabet in the appropriate manner.
     */
    public static int wrapAround(int holder, String codeType){

        if(codeType.equals("encode")){

            if (holder >= 26){
                holder -= 26;
            }
            return holder;
        }

        else{

            if (holder < 0){
                holder = 26 + holder;
            }
            return holder;
        }
    }

    /**
     * 
     * @param inputString
     * @param pen
     * @param codeType
     * Takes in an input String and the given encode or decode directive and then proceeds to print out all of the encoded or deoded possibilities for a CaesarCipher.
     */
    public static void code(String inputString, PrintWriter pen, String codeType){

            int holder = 0;
            int base = 97; // The base used to bring down char values into a range where they can be transformed for wrap around purposes
            if(codeType.equals("encode")){

                pen.println("Encode");

                for (int j = 0; j < 26; j++){ //j iterates through for each letter in the alphabet
                    pen.print("n = " + j + ": ");

                    for (int i = 0; i < inputString.length(); i++){ //i iterates through for each char in the string

                        holder = inputString.charAt(i);
                        holder -= base;
                        holder += j;

                        holder = wrapAround(holder, codeType);

                        holder += base;
                        char holderchar = (char) holder;
                    
                        pen.print(holderchar);
                    }
                pen.println();
                }
            
            }else if (codeType.equals("decode")){
                pen.println("Decode");

                for (int j = 0; j < 26; j++){//j iterates through for each letter in the alphabet
                    pen.print("n = " + j + ": ");

                     for (int i = 0; i < inputString.length(); i++){//i iterates through for each char in the string

                    holder = inputString.charAt(i);
                    holder -= base;
                    holder -= j;

                    holder = wrapAround(holder, codeType);

                    holder += base;
                    char holderchar = (char) holder;
                
                pen.print(holderchar);
            }
            pen.println();
            }
        }
    }


    //Expects two command line arguments as input the first being either "encode" or "decode" and the second being a string with only lower case alphabeticals and no whitespace.
    // This program will encode and decode a given string using the Caesar Cipher with every possible combo printed out.
    // Returns nothing
    public static void main(String[] args) throws Exception {

        PrintWriter pen = new java.io.PrintWriter(System.out, true);
        // Checks to ensure that there are an appropiate number of command line arguments.
        if (args.length != 2){
            pen.println("Incorrect Number of Statements");
            return;
        }
        //Checks to ensure that either "encode" or "decode" is given
        else if ((args[0].equals("encode")) == (args[0].equals("decode"))){
            pen.println("Incorrect input valid options are 'encode' or 'decode'");
            return;
            
        } 
        
        else {
            // Clause that checkss to see whether it should encode or decode then calls those two functions
            if(args[0].equals("encode")){
                code(args[1], pen, "encode");
            }
            if (args[0].equals("decode")){
              code(args[1], pen, "decode");
            }

        
                    
        }
    }
}



