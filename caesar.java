// Sam Badovinac
// Caesar cypher

import java.io.*;
import java.util.*;

public class caesar
{
    public static void main(String [] args)
	throws IOException 
	{
        // Variables
        String userInput;
        int length;
        int shift = 0;
        int asciiArray[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int encryptedArray[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        // Get message to be encypted from user
        System.out.println("Enter a message for encryption:");
        Scanner input = new Scanner(System.in); 
        userInput = input.nextLine();
        length = userInput.length();

        // Get the shift from user
        System.out.println("\nEnter a shift value:");
        Scanner shiftInput = new Scanner(System.in); 
        shift = shiftInput.nextInt();
        shiftInput.close();
        input.close();

        // put input into ascii array
        for(int i = 0; i < length; i++)
        {
            asciiArray[i] = (int)userInput.charAt(i);
        }
        
        encryptedArray = encrypt(asciiArray, shift, length);
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
    public static int [] encrypt (int [] cypher, int shift, int length)
    {
        // Shift each character except for spaces
        for(int i = 0; i < length; i++)
            if (cypher[i] != 32 && cypher[i] + shift < 123)
                cypher[i] += shift;
            // if the shift increases the ascii value past z, wrap around to a
            else if (cypher[i] != 32 && cypher[i] + shift > 122)
            {
                int newSpot;
                newSpot =  (cypher[i] + shift) - 122;
                cypher[i] = newSpot + 96;
            }
            // dont shift the spaces 
            else
                cypher[i] = 32;

        return cypher;   
    }
}