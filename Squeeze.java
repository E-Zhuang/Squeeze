
/**
 * Lab 16.1 Squeeze
 * 
 * Emily Zhuang
 * Mr. Lantsberger
 * APCS:Period 4
 * 15 November 2016
 */

import apcslib.*;       //for Format.right()
import chn.util.*;      //for FileInput and FileOutput

public class Squeeze
{
    /**
     * This program will go through a text file and count how many spaces 
     * are before the line of text and prints the number of spaces while
     * removing the spaces and it prints the rest of the line of text
     * with no indentations. 
     */
    public static void main (String [] args)
    {
        FileInput inFile = new FileInput("before.txt");
        FileOutput outFile = new FileOutput("after.txt");
        
        String line;        //line read in from FileInput
        int loop = 0;       //how many spaces there are
        
        while (inFile.hasMoreLines())    //there are more lines of text
        {
            line = inFile.readLine();   //reads in next line from FileInput
            
            //adds to loop as long as there are more spaces
            while (loop < line.length() && line.charAt(loop) == ' ') 
            {
                loop++;     //increments loop
            }
            
            //if there are only spaces in the line
            if (loop == line.length() - 1 && line.charAt(loop) == ' ')
            {
                outFile.println(" 0");      //prints zero because there are no spaces
            }
            //if there is text in the line
            else
            {
                line = line.substring(loop);    //removes all the preceeding spaces
                //prints how many spaces there are
                outFile.println(Format.right((loop),2) + "  " + line);  
            }
            
            loop = 0;                   //resets loop to zero
        }
        
        outFile.close();                //finishes off FileOutput
    }
}
