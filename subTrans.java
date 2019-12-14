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
        String key;
        
        
        // Get message to be encypted from user
        System.out.println("Enter a message for encryption:");
        Scanner input = new Scanner(System.in); 
        userInput = input.nextLine();
        length = userInput.length();

        // Arrays to hold values of messages
        int [] asciiArray = new int[length];
        int [] encryptedArray = new int[length];

        // Get the shift from user
        System.out.println("\nEnter a shift key:");
        Scanner shiftInput = new Scanner(System.in); 
        key = shiftInput.nextLine();
        shiftInput.close();
        input.close();

        // array to store shift values
        int [] keyArray = new int [key.length()];

        // put input into ascii array
        for(int i = 0; i < length; i++)
            asciiArray[i] = (int)userInput.charAt(i);

        // put key into array
        for (int i = 0; i < key.length(); i++) 
            keyArray[i] = (int)key.charAt(i) - 96;
        
        //encryptedArray = encrypt(asciiArray, keyArray, length);
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
}