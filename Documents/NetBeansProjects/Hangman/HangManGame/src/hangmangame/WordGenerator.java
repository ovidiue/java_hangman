/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author enesc
 */
public class WordGenerator {

    private String fileLocation;
    private ArrayList<String> words;

    public WordGenerator(String fileLocation) {
        this.fileLocation = fileLocation;
        this.words = new ArrayList<>();
        fillWords();
    }

    private void fillWords() {

        Scanner sc = null;

        try {
            sc = new Scanner(new File(fileLocation));
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getStackTrace());
        }

        while (sc != null && sc.hasNext()) {
            String word = sc.next();
            words.add(word);
        }
    }

//    private void fillWords() {
//
//        try {
//            
//            
//            InputStream in = getClass().getResourceAsStream(fileLocation);
//            BufferedReader br = new BufferedReader(new InputStreamReader(in));
//            
//
//            String line;
//
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//                String[] temp = line.split(" ");
//                words.addAll(Arrays.asList(temp));
//            }
//        } catch (IOException ioe) {
//            System.out.println(ioe.getMessage());
//        }
//    }

    public String getRandomWord() {
        String word;
        Random rand = new Random();       
        System.out.println(words.size());
        word = words.get(rand.nextInt(words.size()));

        return word;
    }

}
