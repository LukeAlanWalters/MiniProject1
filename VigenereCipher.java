import java.io.PrintWriter;

public class VigenereCipher {
    
    // used to encode a given string by a give keyWord expects two lowercase strings and a PrinWriter object as input
    public static void encode(String inputString, String keyWord, PrintWriter pen){
        int holder = 0;
        int keyCount = 0;
        int base = 97;
        for (int i = 0; i < inputString.length(); i++){
            int keyHolder = keyWord.charAt(keyCount);
            keyHolder -= base;
            holder = inputString.charAt(i);
            holder -= base;
            //pen.println("test 3.2");
            holder += keyHolder;
            holder = holder % 26;
            holder += base;
            char holderchar = (char) holder;
            //loops through the keyWord
            keyCount += 1;
            keyCount = keyCount % keyWord.length();
            
            pen.print(holderchar);
        }
        pen.println();
    }
    // used to decode a given string by a give keyWord expects two lowercase strings and a PrinWriter object as input
    public static void decode(String cipherText, String keyWord, PrintWriter pen){
        int holder;
        int keyCount = 0;
        int base = 97;
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

    // Expects three command line arguments one that is either "encode" or "decode" and two other strings that are both lowercase alphabetical with not whitespace. args[1] must be greater than args[2]
    public static void main(String[] args) throws Exception {
        PrintWriter pen = new java.io.PrintWriter(System.out, true);
        if (args.length != 3){
            pen.println("Incorrect Number of Statements");
            return;
        }
        //Checks to ensure that either "encode" or "decode" is given
        else if ((args[0].equals("encode")) == (args[0].equals("decode"))){
            pen.println("Incorrect input valid options are 'encode' or 'decode'");
            return;  
        } 
        //Checks to see if the keyWord is longer than the string to be encoded or decoded.
        else if (args[1].length() < args[2].length()){
            pen.println("Please enter a keyword shorter in length than the encoded word");
            return;
        }
        
        else {
            // Clause that checks to see whether it should encode or decode then calls those two functions
            if(args[0].equals("encode")){
                encode(args[1], args[2], pen);
            }
            if (args[0].equals("decode")){
              decode(args[1], args[2], pen);
            }
        }
    }
}