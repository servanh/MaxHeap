
import MaxHeap.MaxHeapImpl;


import java.util.Scanner;

public class MaxHeapMain {
    public static void main(String args[])
    {
        MaxHeapImpl m = new MaxHeapImpl();


       Scanner scan = new Scanner(System.in);
       System.out.println("Enter your input file name: ");
       String input = scan.next();

       System.out.println();
       System.out.println("Input: ");
       m.parseInput(input);
       MaxHeapImpl l = MaxHeapImpl.instance;


       System.out.println();
       System.out.println("Output: ");
       l.runInstructions();
       l.print();

    }

}
