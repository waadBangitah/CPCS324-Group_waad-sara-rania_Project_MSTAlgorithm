package application;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PQPrimAlg extends MSTAlgorithm {
     public PQPrimAlg(Graph graph){
    super(graph);
    } 
      int totalcost=0 ;///create MST Cost
/////////////////////////////////////////////
      public void PQPrim(Graph graph) {
         //create PriorityQueue with Comparator between weight
          PriorityQueue<Edge> PQ = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
          //invok the linkedlist for stor the cost
          MSTresultList = new LinkedList<>();
          //add first edge in PQ
          PQ.add(new Edge(graph.addvertices[0], 0));
          
          //chack the PQ is not empty
          while (!PQ.isEmpty()) {
              //remove the first element
              Edge edge = PQ.poll();
              int targetNode = edge.target.label;
              ///check if target is Visited then skip
              if (graph.addvertices[targetNode].isVisited) {
                  continue;
              }
              /////if else/////
              totalcost += edge.weight;//adding to MST cost
              graph.addvertices[targetNode].isVisited = true;//set vertex is Visit
              MSTresultList.add(new Edge(edge.source, edge.target, edge.weight)); //add the edge to linked list
              //lope for add edges for PQ
              for (int i = 0; i < graph.addvertices[targetNode].adjlist.size(); i++) {
                  Edge PEdge = graph.addvertices[targetNode].adjlist.get(i);
                  int node = PEdge.target.label;
                  if (graph.addvertices[node].isVisited == false) {
                      PQ.add(PEdge);
                  }
              }

          }
           DisplayResultingMST(MSTresultList); //invok the method to print the cost
        }
 //////////////////////////////////////////////////////////////     
    @Override
    public void DisplayResultingMST(LinkedList<Edge> MSTresultList) {
         System.out.println("Minimum Spanning Tree Cost of PQPrim: " + totalcost);
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     
    
    
}
