
/**
 * This is the console version of the simulator and it handles all of the I/O
 * for the simulation. It handles commands including A, L, C, S, and K so
 * print and implement the Queue correctly.
 *
 * @author Hannah Mozdzen
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ConsoleSimulator
{

   private Scanner stdin;
   private Simulation sim;
   private Customer cust;

   /**
    * This method is a while loop that reads in the users input and does the
    * correct command based on what is entered. It also handles if the command
    * entered is a bad command. When K is pressed it will print the final
    * statistics then it will exit the loop.
    */
   public void run()
   {
      BufferedReader stdin
         = new BufferedReader(new InputStreamReader(System.in));
      sim = new Simulation();
      // stdin = new Scanner(System.in);
      cust = new Customer(0);
      boolean done = false;
      try
      {
         while (!done)
         {
            String command = stdin.readLine();
            // StringTokenizer st = new StringTokenizer(command, " ");
            
            switch (command.charAt(0))
            {
               case 'A':
                  System.out.println(sim.arrival());
                  break;
               case 'L':
                  System.out.println(sim.leave());
                  break;
               case 'C':
                  clock();
                  break;
               case 'S':
                  stats();
                  break;
               case 'Q':
                  done = true;
                  quit();
                  break;
               default:
                  break;
            }
         }
      }
      catch (Exception ex)
      {

      } // ~~~ End of Try / Catch ~~~
   }
   
   private void clock()
   {
      int c = stdin.nextInt();
      if (c > 0)
         sim.clock(c);
   }

   private void stats()
   {
      System.out.println("\n" + sim.stats() + "\n");
   }

   private void quit()
   {
      System.out.println("Simulation statistics");
      System.out.println(sim.stats() + "\n");
      System.out.println("Simulation terminated.");
   }
}
