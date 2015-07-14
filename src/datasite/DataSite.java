/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasite;

//import java.io.*;

import java.io.*;

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
public class DataSite {
  public static void main(String[] args) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("ConsumerKey");
        cb.setOAuthConsumerSecret("ConsumerSecret");
        cb.setOAuthAccessToken("AccessToken");
        cb.setOAuthAccessTokenSecret("AccessTokenSecret");

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

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
              User user = status.getUser();
              
              // gets Username
              String username = status.getUser().getScreenName();
              
              try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tweet_input\\tweets.txt", true))))
                  
              {
                  //out.println(username);
                  
                  String content = status.getText();
                  out.println(content +"\n");
                  //System.out.append( content +"\n");
                                    
           
              } catch (IOException ex) {
                  Logger.getLogger(DataSite.class.getName()).log(Level.SEVERE, null, ex);
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
