
/**
 *
 * @author Hannah Mozdzen and Edward VanDerJagt
 */
public class Simulation
{

   private Customer customer;
   private static final int MAX_CUSTOMER = 5; //capacity of the line
   private Queue<Customer> q = new Queue<>(MAX_CUSTOMER);
   private int clock;
   private Customer being_served = null; //the customer being served

   private int finished; //number of customers finished
   private int noWait; //number of customers that didn't have to wait
   private int wait; //number of customers that had to wait
   private int totalWait; //total wait time for customers that waited in queue

   public Simulation() //default constructor
   {
      customer = new Customer(clock);
      clock = 0;
      being_served = null;
      finished = 0;
      noWait = 0;
      wait = 0;
      totalWait = 0;
      q = new Queue<>(MAX_CUSTOMER);
   }

   public boolean simNQ()
   {
      if (!q.isFull())
      {
         if (q.isEmpty())
            noWait++;
         else
            wait++;
         //clock = customer.getTimeStamp();
         int total = 0;
         total++;
         int customer_num = 0;
         customer_num++;
         Customer c = new Customer(customer_num, total, clock); //would we call get timestamp
         q.enqueue(c);
         return true;
      }
      return false;
   }

   public Customer gDQ()
   {
      Customer x;
      if (!q.isEmpty())
      {
         x = (Customer) q.dequeue();
         return x;
      }
      return null;
   }

   public boolean simDQ()
   {
      if (!q.isEmpty())
      {
         q.dequeue();
         return true;
      }
      // if this customer had 0 wait --> noWait++
      // else Wait++
      //    totalWait = clock/wait
      return false;
   }

   // process exists only for debugging purposes. It will need to be removed.
   public String simDebuggy()
   {
      return ("Clock::" + clock + "::being_served::" + being_served
         + "::finished::" + finished + "::noWait::" + noWait + "::wait::" + wait
         + "::totalWait::" + totalWait);

   }

   public void advanceTime(int time)
   {
      clock = clock + time;
   }

   public float getAve()
   {
      float x = 0;
      x = totalWait / finished;
      return x;
   }

   public String arrival()
   {
      int total = 0;

      if (!simNQ()) // if queue is full
      {
         return ("A customer couldn't get in line @time "
            + totalWait + " becasue the line was full."); //error message
      }
      return ("A customer has arrived @time" + wait
         + ". Number of customers waiting in line: " + total);
   }

   public String leave()
   {
      if (!simDQ()) // if queue is empty
      {
         return ("Nobody is being served @time "
            + totalWait); //error message
      }
      finished++;
      String x = customer.toString();
      wait = clock - customer.getTimeStamp();
      return (x + ". Number of customers waiting: " + q.size());
   }

   public String clock(int time)
   {
      advanceTime(time);
      return ("Time updated by " + time
         + " unit; current time is " + (clock + time) + ".");
   }

   public String stats()
   {
      return ("The average wait time for the customers who finished waiting: "
         + getAve() + "\n" + "The total wait time is " + totalWait
         + "\nThe number of customers finished: " + finished
         + "\nThe total number of customers who did not have "
         + "to wait " + noWait + ".");
   }

}
/*   
 Simulation class must maintain the following information: 
 o Average wait time—this is for those customers that had to wait in the 
 queue  
   
 o Total wait time—the sum of all wait time of customers who finished and 
 left the restaurant 
   
 o Number of customers did not have to wait 
   
 o Number of customers finished and left the restaurant 
 */


/*
 Methods? 
 SimAdd // adds a new customer
 --Check if Queue is full
 --if !isFull
 ---add an item of type customer into q 
 ---Calculate individual wait time, average wait, finished, noWait, wait, 
 and totalWait. May need to call new methods. 
 SimDepart
 SimAdvanceClock
 SimIsFull
 */
