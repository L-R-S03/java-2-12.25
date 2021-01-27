/*
 * Project: Exercise 12.25
 * Lauren Smith
 * 12/3/20
 * reads from a large dataset of faculity types and computes total salary's
 * and avaerage of each faculity type and faculity as a whole 
 */
package pkg1225;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MalformedURLException, IOException {
        //declares and inits all vars to 0 or empty strings
        float assistant = 0;
        float associate = 0;
        float full = 0;
        float all = 0;
        float num = 0;
        int numAssi = 0;
        int numAsso = 0;
        int numFull = 0;
        float av = 0;
        String title = "";
        String line = "";
        //makes file and sets it to Salary.txt
        File file = new File("Salary.txt");
        //makes scanner to read the file and sets it to the file
        Scanner read = new Scanner(file);
        //makes i 1 to keep track of what piece of information we're at in the file
        int i = 1;
        //while the scanner has more pieces of the file to read
        while (read.hasNext()) {
            //reads in the next piece of data and sets it to piece
            String piece = read.next();
            //switch statement for if i is set to 3 or 4 so if it's the job type 
            //or salary
            switch (i) {
                //when at the job type collumn (3) sets the data to title var 
                case 3: {
                    title = piece;
                }
                break;
                //if it's at collumn 4 (salary) uses a switch with the title 
                //to input salary under proper job type
                case 4: {
                    //each switch parses the string into a float, adds it to the 
                    //totlal for that job, adds it to the total for all faculity
                    //and increments the number of that specific faculity
                    switch (title) {
                        case "assistant": {
                            num = Float.parseFloat(piece);
                            assistant += num;
                            all += num;
                            numAssi++;
                        }
                        break;
                        case "associate": {
                            num = Float.parseFloat(piece);
                            associate += num;
                            all += num;
                            numAsso++;
                        }
                        break;
                        case "full": {
                            num = Float.parseFloat(piece);
                            full += num;
                            all += num;
                            numFull++;
                        }
                        break;
                    }
                }
            }
            //at the end of the loop if i isn't 4 it's still on the same row so 
            //i is incremented to move on to the next collumn 
             if (i == 1 || i == 2 || i == 3) {
                    i++;
             //otherwise i is 4 and needs to move onto the next row so i is set 
             //back to one
             } else {
                    i = 1;
                } 
        } 
        //gets av for associates by dividing associate total by num of associates
        av=associate/numAsso; 
        //prints total and average salary for associates and makes a new line at
        //the end
        System.out.printf("total salary for associates is $%.2f, with an average "
                + "salary of $%.2f %n",associate,av);
        //does the same for assitants and full time faculity
        av=assistant/numAssi; 
        System.out.printf("total salary for assistants is $%.2f, with an average "
                + "salary of $%.2f %n",assistant,av); 
        av=full/numFull; 
        System.out.printf("total salary for full time is $%.2f, with an average "
                + "salary of $%.2f %n",full,av); 
        //finds number of all faculity by adding all specific job numbers together
        int fac=numAssi+numAsso+numFull; 
        //finds average and prints out the same string as the others
        av=all/fac; 
        av=associate/numAsso; 
        System.out.printf("total salary for all faculity is $%.2f, with an average "
                + "salary of $%.2f",all,av);
    } 
    
}
