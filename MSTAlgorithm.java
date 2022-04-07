package application;

import java.util.LinkedList;

public abstract class MSTAlgorithm {
    Graph graph;
    int weight;
    LinkedList<Edge> MSTresultList = new LinkedList<>();
    /////////////////////////////////////////////
    
     public MSTAlgorithm(Graph graph) {
       this.graph=graph;
    }
     //////////////////
     public abstract void DisplayResultingMST(LinkedList<Edge> MSTresultList);
}
