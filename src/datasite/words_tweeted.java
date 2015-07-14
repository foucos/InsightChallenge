/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasite;

import java.io.*;
import java.util.TreeMap;
/*
 * @author maggie
 **/

public class words_tweeted {
    

    public static TreeMap<String, Integer> generateFrequencyList()
    throws IOException {
    TreeMap<String, Integer> wordsFrequencyMap = new TreeMap<>();
    String file = "tweet_input\\tweets.txt";
    BufferedReader br = new BufferedReader(new FileReader(file));
    String line;
    while( (line = br.readLine()) != null){
         String [] tokens = line.split("\\s+");
      for (String token : tokens) {
        token = removePunctuation(token);
        if (!wordsFrequencyMap.containsKey(token.toLowerCase())) {
          wordsFrequencyMap.put(token.toLowerCase(), 1);
        } else {
          int count = wordsFrequencyMap.get(token.toLowerCase());
          wordsFrequencyMap.put(token.toLowerCase(), count + 1);
        }
      }
    }
    return wordsFrequencyMap;
  }

  private static String removePunctuation(String token) {
    token = token.replaceAll("[^a-zA-Z]", "");
    return token;
  }

 public static void main(String[] args) {
    try {
       
      int totalWords = 0;   
      
       PrintStream out = new PrintStream(new FileOutputStream("tweet_output\\ft1.txt"));
       TreeMap<String, Integer> freqMap = generateFrequencyList();
      for (String key : freqMap.keySet()) {
        totalWords += freqMap.get(key);
      }

      out.println("Word\tNumber of Counts");
      for (String key : freqMap.keySet()) {
         out.println(key+"\t"+freqMap.get(key)+"\t");    
      }
    } catch (Exception e) {
    }
  }
}