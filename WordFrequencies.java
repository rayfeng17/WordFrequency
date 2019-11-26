/*
Raymond Feng | 23408598
Java Assignment 3
 */

import java.io.*;
import java.util.*;

class WordFrequencies {

    public static void main(String[] args) {

        // reading input file name
        System.out.println("Enter a txt file name:");
        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();
 
        // opening file
        File File = new File(file);
        HashMap<String, Integer> frequency = new HashMap<>();
        
        try {
            // creating reader to read file
            FileReader fr = new FileReader(File);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            // reading file word by word
            while ((line = br.readLine()) != null) {

                // removes puncuation and converts to lowercase
                String[] words = line.replaceAll("\\p{Punct}+", "").toLowerCase().split("\\s+");

                // for loop; goes through every word
                for (int i = 0; i < words.length; i++) {
                    // if the HashMap already contains the key = increment
                    if (frequency.containsKey(words[i])) {
                        int n = frequency.get(words[i]);
                        frequency.put(words[i], ++n);
                    } // Otherwise, puts the word into the HashMap
                    else {
                        frequency.put(words[i], 1);
                    }
                }
            }
            // redirects the output to a txt file
            PrintStream op = new PrintStream(new FileOutputStream("output.txt"));
            System.setOut(op);
            
            // print contents
            for (HashMap.Entry<String, Integer> entry : frequency.entrySet()) {
                System.out.println(entry.getValue() + " : " + entry.getKey());
            }

            // closing the reader
            fr.close();
            
            //catch errors 
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        } catch (NullPointerException e) {
            System.err.println("File is empty.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
