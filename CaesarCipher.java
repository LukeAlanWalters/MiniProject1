import java.io.PrintWriter;

public class CaesarCipher {


    // used to encode a given string expects a lowercase string and a PrinWriter object as input
    public static void encode(String inputString, PrintWriter pen){
            int holder = 0;
            int base = 97;    
            pen.println("Encode");
            //j iterates through for each letter in the alphabet
            for (int j = 0; j < 26; j++){
                pen.print("n = " + j + ": ");
                //i iterates through for each char in the string
                for (int i = 0; i < inputString.length(); i++){
                    holder = inputString.charAt(i);
                    holder -= base;
                    holder += j;
                    if (holder >= 26){
                        holder -= 26;
                    }
                    holder += base;
                    char holderchar = (char) holder;
                    
                    pen.print(holderchar);
                }
                pen.println();
            }
    }
    // used to decode a given string expects a lowercase string and a PrinWriter object as input
    public static void decode(String cipherText, PrintWriter pen){
        int holder = 0;
        int base = 97;    
        pen.println("Decode");
        for (int j = 0; j < 26; j++){
            //j iterates through for each letter in the alphabet
            pen.print("n = " + j + ": ");
            //i iterates through for each char in the string
            for (int i = 0; i < cipherText.length(); i++){
                holder = cipherText.charAt(i);
                holder -= base;
                holder -= j;
                if (holder < 0){
                    holder = 26 + holder;
                }
                holder += base;
                char holderchar = (char) holder;
                
                pen.print(holderchar);
            }
            pen.println();
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
                encode(args[1], pen);
            }
            if (args[0].equals("decode")){
              decode(args[1], pen);
            }

        
                    
        }
    }
}



