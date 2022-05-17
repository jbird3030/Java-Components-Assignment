package edu.cscc;

import java.io.*;

/**
 * @author Jason McGee
 */

public class Main {

    static final String INPUTFILE = "components.txt";
    /*This sets the String INPUTFILE to equal the text file "components.txt
    * found in this directory.  The file location can also be entered at the FileReader*/


    public static void main(String[] args) {
        //Initializing variables
        double total = 0;
        int units = 0;
        double runningTotal;
        double price;
        String component;


        System.out.printf("%s%n","           Component Units Price");
        //Shows a whole bunch of spaces, then Component Units Price

        try (
                BufferedReader br = new BufferedReader(new FileReader(new File (INPUTFILE)))
                /*Creates a Buffered Reader object, br, which layers with FileReader to read - create? -
                * a file, INPUT file.  Could also just enter the path of the file here like:
                * BufferedReader br = new BufferedReader(C:\\Users\\somedude\\Desktop\\somefile.txt*/
                ) {
            String line;

            //While we haven't reached the end of the file
            while ((line = br.readLine()) != null) {

                String [] array = line.split(",");
                /*The String array called array is going to be made up of
                * the elements from the file that come between commas*/

                //For every third item in the array
                for (int i = 0; i < array.length; i = i+3) {
                    component = array [i];
                    System.out.print("           " +component + " ");
                }

                for (int j = 1; j < array.length; j=j+3) {
                    units = Integer.parseInt(array[j]);
                    //Converts every array element at index i into an Integer

                    System.out.print(units + " ");
                }

                for (int k = 2; k < array.length; k = k+3) {
                    price = Double.parseDouble(array [k]);
                    //Converts every array element at index k into a double

                    System.out.print (price + "\n");
                    //Prints price and creates a line break

                    runningTotal = units*price;
                    total += runningTotal;
                    //Total is equal to the runningTotal added to itself
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error opening file " + INPUTFILE + ": " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error opening file " + INPUTFILE + ": " + ex.getMessage());
        }

        System.out.println("Total cost: "+total);

    }
}
