/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datasite;

//import java.io.*;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;

import java.io.PrintStream;

//import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;
// TODO code application logic here
/**
 *
 * @author maggie
 */
public class SortedUnique {
  public static void main(String[] args) {
        ConfigurationBuilder confb = new ConfigurationBuilder();
        confb.setDebugEnabled(true);
        confb.setOAuthConsumerKey("Consumer Key");
        confb.setOAuthConsumerSecret("Consumer Secret");
        confb.setOAuthAccessToken("Access Token");
        confb.setOAuthAccessTokenSecret("Access Token Secret");

        TwitterStream twitterStream = new TwitterStreamFactory(confb.build()).getInstance();

        StatusListener listener;
      listener = new StatusListener() {
          
          @Override
          public void onException(Exception arg0) {
              // TODO Auto-generated method stub
              
          }
          
          @Override
          public void onDeletionNotice(StatusDeletionNotice arg0) {
              // TODO Auto-generated method stub
              
          }
          
          @Override
          public void onScrubGeo(long arg0, long arg1) {
              // TODO Auto-generated method stub
              
          }
         
          @Override
          public void onStatus(Status status) {
              
                  
              PrintStream out = null;
              try {
                  User user = status.getUser();
                  // gets Username
           
                  String username = status.getUser().getScreenName();
                  String content = status.getText();
                  Set<String> userWrds = new HashSet<String>(); // HashSet implements Set
                  Scanner sc = new Scanner(content+user);
                  while (sc.hasNext())
                  {
                      String word = sc.next();
                      userWrds.add(word);
                      
                  }
                  out = new PrintStream(new FileOutputStream("tweet_output\\unique.txt",true));
                  Iterator<String> iter = userWrds.iterator();
                  for (int i = 1; i <= 1 && iter.hasNext(); i++)
                      //System.out.println(iter.next());
         out.println(userWrds.size());
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(SortedUnique.class.getName()).log(Level.SEVERE, null, ex);
              } finally {
                  out.close();
              }
             
                    
          }
          
          @Override
          public void onTrackLimitationNotice(int arg0) {
              // TODO Auto-generated method stub
              
          }
          
          @Override
          public void onStallWarning(StallWarning sw) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          }
          
      };
        FilterQuery fq = new FilterQuery();
    
        String keywords[] = {"africa"};

        fq.track(keywords);

        twitterStream.addListener(listener);
        twitterStream.filter(fq);  
        //twitterStream.();
    }
}