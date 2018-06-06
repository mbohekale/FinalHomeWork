import java.util.*;
import java.io.*;
import java.net.*;

class Client
{
    public static void main(String[] args)
        throws Exception
    {
        int port = 1234;
        String computer = "localhost";
		
		
        Transaction transaction1 = new Transaction("Peter", "Sam", 100L);
        Transaction transaction2 = new Transaction("Sam", "Ryan", 1000L);
        Transaction transaction3 = new Transaction("Sam", "Ryan", 1000L);
        Transaction transaction4 = new Transaction("Ryan", "Peter", 150L);
		
		System.out.println();
		System.out.println("HealthCare BlockChain\n ");
		System.out.println("The Access code to the patient database are: ");
        
        Block b1 = new Block(0, Arrays.asList(transaction1, transaction2));
        System.out.println("Diagnosic Doctor: "+b1.hashCode());
		
		 Block b2 = new Block(b1.hashCode(), Arrays.asList(transaction3));
        System.out.println("Pharmace Doctor: "+b2.hashCode());
		
        Block b3 = new Block(b2.hashCode(), Arrays.asList(transaction4));
        System.out.println("laboritory Doctor: "+b3.hashCode());
        
        try {
            Socket s = new Socket(computer, port);


            ObjectOutputStream oos
              = new ObjectOutputStream(s.getOutputStream());

            ObjectInputStream inputObject
              = new ObjectInputStream(s.getInputStream());
            // = new ObjectOutputStream(new FileOutputStream("a.txt"));
            oos.writeObject(b1);
			oos.writeObject(b2);
            oos.flush();
            
            b1 =(Block) inputObject.readObject();
            System.out.println(b1.hashCode());
			b2 =(Block) inputObject.readObject();
            System.out.println("Code of B2"+b2.hashCode());
			b3 =(Block) inputObject.readObject();
            System.out.println(b3.hashCode());
            //pw.println(p);
            //pw.flush();



            //int textLength = sc.nextInt();
            //  System.out.println(textLength);
        }catch(Exception e){

        }

    }
}
