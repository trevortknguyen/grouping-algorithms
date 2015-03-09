import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// To be integrated


public class matchmaker 
{
 public static void main(String args[])
 {
  ArrayList<people> pool = new ArrayList<>(); //doesn't do anything
  
  try {
   Scanner scanny = new Scanner(new File(""));
  } catch (FileNotFoundException e) {
   ////create people. People have an arrayList of matches
   //add people to pool
   e.printStackTrace();
  }
  ArrayList<String> matched = new ArrayList<>();  //doesn't do anything
  stuff finished= matchmaker(pool, 0, matched);
 }
 
 public static stuff matchmaker(ArrayList<people> pool,int totalScore, ArrayList<String> matched)
 {
  stuff best = new stuff();
  best.pool.addAll(pool);
  best.matched.addAll(matched);
  best.totalScore=totalScore;
  people person = new people(pool.get(i).compatiples,pool.get(i).name);
  
  for(int i=0;i<pool.size();i++)
  {
   for(int i3=0;i3<person.compatiples.size();i3++)
   {
    int temp2TotalScore=best.totalScore;
    ArrayList<String> temp2Matched= new ArrayList<>();
    temp2Matched.addAll(matched);
    ArrayList<people> temp2Pool = new ArrayList<>();
    temp2Pool.addAll(pool);
    
    temp2Matched.add(pool.get(i).name);
    temp2Pool.remove(i);
    temp2Matched.add(person.compatiples.get(i3).nameOfMatched);
    temp2Pool.remove(temp2Pool.indexOf(person.compatiples.get(i3).nameOfMatched));
    
    stuff thingy = matchmaker(temp2Pool,temp2TotalScore,temp2Matched);
    
    if(thingy.totalScore>=best.totalScore)
    {
     best.totalScore=thingy.totalScore;
     
     best.matched.removeAll(best.matched);
     best.matched.addAll(temp2Matched);
     
     best.pool.removeAll(best.pool);
     best.pool.addAll(temp2Pool);
    }
   }
  }
 }
}

class people
{
 public ArrayList<match> compatiples;
 public String name;
 
 public people(ArrayList<match> compatiples, String name)
 {
  this.compatiples=new ArrayList<>();
  this.compatiples.addAll(compatiples);
  this.name=name;
 }
}

class match
{
 public String nameOfMatched;
 public int scoreOfMatched;
 public match(String nameOfMatched,int scoreOfMatched)
 {
  this.nameOfMatched=nameOfMatched;
  this.scoreOfMatched=scoreOfMatched;
 }
}

class stuff
{
 public int totalScore=0;
 public ArrayList<String> matched;
 public ArrayList<people> pool;
}
