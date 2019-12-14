// Sam Badovinac
// Polyalhabetic cypher

import java.io.*;
import java.util.*;

public class polycypher
{
    public static void main(String [] args)
	throws IOException 
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
        
        encryptedArray = encrypt(asciiArray, keyArray, length);
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

    // do the cyper
    public static int [] encrypt (int [] cypher, int [] key, int length)
    {
        int shiftIndex = 0; // holds place of value in shift key being used
        for (int i = 0; i < cypher.length; i++)
        {
            if (shiftIndex % key.length == 0 && shiftIndex != 0)
                shiftIndex = 0;
            if (cypher[i] != 32 && cypher[i] + key[shiftIndex] < 123)
            {
               cypher[i] += key[shiftIndex];
               shiftIndex++;
            }
            else if (cypher[i] != 32 && cypher[i] + key[shiftIndex] > 122) 
            {
                int newSpot;
                newSpot = (cypher[i] + key[shiftIndex]) - 122;
                cypher[i] = newSpot + 96;
                shiftIndex++;
            }
            // dont shift the spaces
            else
                cypher[i] = 32; 
            
        } 
        return cypher;

    }
}