package DataSite;

import java.io.*;
import java.util.*;


public class median_unique{


public static void main(String[] args) throws IOException
{
  

                  Scanner sc = new Scanner("tweet_output\\unique.txt");
                   int scores[] = new int[100];
                   String s = sc.next();
                  while (sc.hasNext())
              
         
         {
             int i = 0;
             scores[i]=Integer.parseInt(s);
             s = sc.next();
         }
        
      Arrays.sort(scores);
      
      // Calculate median (middle number)
      double median = 0;
      double pos1 = Math.floor((scores.length - 1.0) / 2.0);
      double pos2 = Math.ceil((scores.length - 1.0) / 2.0);
      if (pos1!= pos2 ) {
         median = scores[(int)pos1];
      } else {
         median = (scores[(int)pos1] + scores[(int)pos2]) / 2.0 ;
      }
 PrintStream out = new PrintStream(new FileOutputStream("tweet_output\\ft2.txt"));
      out.println(median);
 
   }
}
    



