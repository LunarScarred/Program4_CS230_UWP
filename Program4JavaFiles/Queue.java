
/**
 A generic Queue class to simulate the waiting line. Using the “circular
 array” implementation

 @author Elizabeth Harasymiw
 */
public class Queue<E>
{

   private E[] elements;
   private int front, rear, count;

   /**
    @param capacity
    */
   public Queue(int capacity)
   {
      elements = (E[]) new Object[capacity];
      //this is the constructor
   }

   /**
    @return
    */

   public boolean isEmpty()
   {
      return count == 0;
   }

   /**
    @return
    */
   public boolean isFull()
   {
      return count == elements.length;
   }

   /**
    @param x
    */
   public void enqueue(E x)
   {
      elements[rear] = x;
      rear = (rear + 1) % elements.length;
      count++;
   }

   /**
    @return
    */
   public Object dequeue()
   {
      Object x = elements[front];
      front = (front + 1) % elements.length;
      count--;
      return x;
   }

   /**
    */
   public void clear()
   {
      count = 0;
      front = 0;
      rear = 0;
   }

   /**
    @return
    */
   public int size()
   {
      return count;
   }
   
   public int getFront()
   {
      return front;
   }

}
