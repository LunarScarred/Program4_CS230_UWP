/**

 @author Elizabeth Harasymiw, Hannah Mozdzen, and Edward VanDerJagt
 */
public class Prog4
{
   /**
    @param args is not used
    */
   public static void main(String[] args)
   {
      try
      {
         new ConsoleSimulator().run();
      }
      catch (Exception e)
      {
         System.out.println("Couldn't run ConsoleSimulator! " + e);
      }
   }
}
