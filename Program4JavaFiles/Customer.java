/**
 *
 * @author Edward VanDerJagt
 */
public class Customer
{
   private static int numCustomer = 0; //total number of customers
   private int CustomerNo; //customer arrival sequence
   private int timeStamp; // when the customer arrives

   /**
    * Default constructor.
    */
   public Customer(int time)
   {
      numCustomer = 0;
      CustomerNo = 0;
      timeStamp = time;
   }

   /**
    * A constructor for an inputed customer
    *
    * @param c
    * @param n
    * @param t
    */
   Customer(int c, int n, int t)
   {
      numCustomer = c;
      CustomerNo = n;
      timeStamp = t;
   }

   /**
    * a method that can be called to find a customer's timestamp
    *
    * @return timeStamp
    */
   public int getTimeStamp()
   {
      return timeStamp;
   }

   /**
    * toString() method, which returns a String with the following format:
    * Customer#n arrives @time t, where n is the CustomerNo, and t is the
    * timeStamp. -2 points if these are not done.
    */
   public String toString()
   {
      return ("Customer#" + CustomerNo + " arrives @time " + timeStamp);
   }
   /*
    Customer.java—keep the information of a customer:
    (1) a time stamp when the customer arrives,
    (2) a customer arrival sequence number, and
    (3) the total number of customer arrival during the simulation.

    You MUST implement one constructor, which increments numCustomer by 1 each
    time an instance of Customer is created. And you must implement
    getTimeStamp() method and
    public class Customer  {
   private static int numCustomer = 0;
   private int customerNo;
   private int timeStamp;
   public Customer(int time)    {       ...    }
   public int getTimestamp()    {       ...    }
   public String toString()    {       ...    } }
    */
}
