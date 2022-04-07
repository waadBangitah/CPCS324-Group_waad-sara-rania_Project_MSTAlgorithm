package application;
//////////////////////////////
///waad  Bangitah  /////
///sara  hadef    /////
///rania altonisi/////
//////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author waadb
 */
public class Application {
/**
 * 
 */
     static File file = new File("result.txt");

    /**
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        int n = 0;
        int m = 0;
        int Choice = -1;
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(file);
          
        
       System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////");
       System.out.println("///////***************** Copmare of Different Minimum Spanning Tree Algorithms ***********///////");
       System.out.println("///////1- Kruskal's Algorithm & Prim's Algorithm (based on Priority Queue)                ///////");
       System.out.println("////// 2- Prim's Algorithm (based on Min Heap) & Prim's Algorithm (based on Priority Queue //////");
       System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////\n");
       System.out.print("choice btween (1 or 2): ");
       Choice = input.nextInt();
       
       if (Choice == 1 || Choice == 2) {
         System.out.println("*** where n = number of vertices and m = number of edges ***");
         System.out.println("*** These are the available cases ***");
        System.out.println("      __________________________");
        System.out.println("      1|  n=1,000 |  m=10,000  |");
        System.out.println("      2|  n=1,000 |  m=15,000  |");
        System.out.println("      3|  n=1,000 |  m=25,000  |");
        System.out.println("      4|  n=5,000 |  m=15,000  |");
        System.out.println("      5|  n=5,000 |  m=25,000  |");
        System.out.println("      6|  n=10,000| m=15,000   |");
        System.out.println("      7|  n=10,000| m=25,000   |");
        System.out.println("      8|  n=20,000| m=200,000  |");
        System.out.println("      9|  n=20,000| m=300,000  |");
        System.out.println("     10|  n=50,000| m=1,000,000|");
        System.out.println("      __________________________");
        
        for (int iteration = 1; iteration < 11; iteration++) {
	     System.out.println("\niteration no: " + iteration);
            switch (iteration) { 
                case 1: {
		  n = 1000;
		  m = 10000;
		}break;
		case 2: {
		  n = 1000;
		  m = 15000;
		}break;
		case 3: {
		  n = 1000;
		  m = 25000;
		}break;
		case 4: {
		  n = 5000;
		  m = 15000;
		}break;
		case 5: {
		  n = 5000;
		  m = 25000;
		}break;
		case 6: {
		  n = 10000;
		  m = 15000;
		}break;
		case 7: {
		  n = 10000;
		  m = 25000;
		}break;
		case 8: {
		  n = 20000;
		  m = 200000;
		}break;
		case 9: {
		  n = 20000;
		  m = 300000;
		}break;
		case 10: {
		  n = 50000;
		  m = 1000000;
		}break;
		    }
            // make graph
		Graph graph = new Graph(n, m, false);
		graph.make_graph();
                /////////Algorethems////////////
                PQPrimAlg pQ=new PQPrimAlg(graph);
                MHPrimAlg MH= new MHPrimAlg(graph);
                KruskalAlg K=new KruskalAlg(graph);
            if (Choice == 1) {
                ///////////start Kruskal///////////////
		double StartTimeK = System.currentTimeMillis();
                K.kruskal(graph);
                double FinishTimeK = System.currentTimeMillis();
                double kTime=FinishTimeK - StartTimeK;
                System.out.println("Total runtime of Kruskal's Algorithm: " + kTime + "  ms");
                System.out.println("__________________________");
                ////////////end Kruskal/////////////////
                //////PQPrim start////////////////////////
                double StartTimePQ = System.currentTimeMillis();
               pQ.PQPrim(graph);
                double FinishTimePQ = System.currentTimeMillis();
                double PQTime=FinishTimePQ - StartTimePQ;
                System.out.println("Total runtime of PQ Algorithm: " + PQTime + "  ms");
                System.out.println("____________________________________________________");
              output.println(iteration+" "+(int)kTime+" "+(int)PQTime)  ;
            }
             if (Choice == 2) {
                //////PQPrim start////////////////////////
                double StartTimePQ = System.currentTimeMillis();
               pQ.PQPrim(graph);
                double FinishTimePQ = System.currentTimeMillis();
                 double PQTime=FinishTimePQ - StartTimePQ;
                System.out.println("Total runtime of PQ Algorithm: " + PQTime + "  ms");
                System.out.println("__________________________");
                //////PQPrim end////////////////////////
                //////MHrim start////////////////////////
                double StartTimeMH = System.currentTimeMillis();
               MH.MHPrim(graph);
                double FinishTimeMH = System.currentTimeMillis();
                 double MHTime=FinishTimeMH - StartTimeMH;
                System.out.println("Total runtime of MH Algorithm: " + MHTime + "  ms");
                //////MHPrim end////////////////////////
                     System.out.println("____________________________________________________");
                output.println(iteration+" "+(int)PQTime+" "+(int)MHTime)  ;
                
                
            }
       
       }
      output.close(); 
       
        
        
     
        
    }
    
}}
