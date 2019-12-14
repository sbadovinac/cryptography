// Sam Badovinac
// Final project

import java.io.*;
import java.util.Scanner;

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
        
        //encryptedArray = encrypt(asciiArray);
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
    public int [] encrypt (int [] cipher)
    {
        // local variables
        int length = cipher.length;

        // array to hold substitution values
        int [] asciiArray = new int[27];

        return cipher;
    }
}