// Sam Badovinac
// Final project

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class subTrans
{
    public static void main(String [] args)
	{
        // Variables
        String userInput;        
        int length;

        // Get message to be encypted from user
        System.out.println("Enter a message for encryption:");
        Scanner input = new Scanner(System.in); 
        userInput = input.nextLine();
        length = userInput.length();

        // Arrays to hold values of messages
        int [] asciiArray = new int[length];
        int [] encryptedArray = new int[length];

        // put input into ascii array
        for(int i = 0; i < length; i++)
            asciiArray[i] = (int)userInput.charAt(i);
        
        input.close();
        
        encryptedArray = encrypt(asciiArray);
        System.out.println("\nEncrypted Message:");

        for(int i = 0; i < length; i++)
        {
            if (encryptedArray[i] == 32)
                System.out.print(" ");
            else
                System.out.print((char)encryptedArray[i]);
        }
        System.out.println(" ");
    }

    // Encrypt the message using a combination of substitution and transposition
    public static int [] encrypt (int [] cipher)
    {
        // array to hold substitution values
        table [] tableArray = new table[55];
        tableArray[0] = new table(32, 136);

        // fill table array
        for (int i = 1; i < 55; i++)
        {
            // fill the lower case ascii entries
            if (i < 28)
            {
                tableArray[i] = new table(i + 96, i + 32);
                //System.out.println(tableArray[i].cipherVal);
            }
            // fill the upper case ascii entries
            else
            {
                tableArray[i] = new table(i + 36, 154 - i);  
                //System.out.println(tableArray[i].cipherVal);  
            }
        }

        // do substitution cypher
        for (int i = 0; i < cipher.length; i++)
        {
            // dont encrypt spaces
            if (cipher[i] == 32)
                continue;
            // encrypt lower case letters
            if (cipher[i] > 96 && cipher[i] < 123)
                cipher[i] = tableArray[cipher[i] - 96].cipherVal;
            // encrypt upper case letters
            else
                cipher[i] = tableArray[cipher[i] - 36].cipherVal;
        }

        return cipher;
    }
}