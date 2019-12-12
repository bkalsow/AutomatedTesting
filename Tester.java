import java.util.*;
import java.io.*;
/**
 * @author Brandan Kalsow, Noah Hoberg, Matt Rotter
 * @verson December 11, 2019
 * 
 * This class runs the automated tester for our CS340 Project
 */
public class Tester {
  
  public Tester() {
    
  }
  
  public static void main(String[] args) 
  {
    
    /**
     * Reads in the grammar file name, name of program to test, and number of times to test 
     */
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a file path for a grammar: ");
    String grammar = scan.next();
    System.out.println("Enter the name of a java program: ");
    String program = scan.next();
    System.out.println("How many times would you like to test?");
    int numTests = scan.nextInt();
    
    try
    {
      Generator gen = new Generator(new File(grammar));
      
      

      for(int i = 0; i < numTests; i++)
      {
        runProcess("pwd");
        System.out.println("*******");
        String testValue = gen.generate();
        System.out.println("Testing with value: " + testValue);
        System.out.println("*******");
        runProcess("java " + program + " " + testValue);
        System.out.println("End of test " + (i + 1));
        System.out.println("*******************************");
      }
    }
    catch(FileNotFoundException e)
    {
      System.err.println("Unable to find grammar file");
    } catch (Exception e) 
    {
      e.printStackTrace();
    }
    scan.close();
  }
  
  /**
   * This method runs the provided command in the terminal
   * @param command the command to run in the terminal
   * @throws Exception any errors the tested program may throw
   */
  public static void runProcess(String command) throws Exception
  {
    Process pro = Runtime.getRuntime().exec(command);
    pro.waitFor();
    System.out.println(command + " exitValue() " + pro.exitValue());
   // System.out.println("Result of test: " + pro.getInputStream());
  }
  
// code for complex grammars/ multi param programs    
//      System.out.println("How many inputs does the program?");
//      int l = scan.nextInt();
//      String[] arg = new String[l]; 
//      for(int j=0; j<l; j++)
//      {
//        System.out.println("Enter the type of input the program takes: ");
//        String type = scan.next();
//        if(type == "string")
//        {
//          arg[j] = gen.generate();
//        }
//        else if(type == "double")
//        {
//          arg[j] = gen.generateDouble();
//        }
//        else if(type == "int")
//        {
//          arg[j] = gen.generateInt();
//        }
//      }
      
      
      
  
}
