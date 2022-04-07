package application;

import java.util.LinkedList;

public class Vertex {
    int label;
    boolean isVisited =false;
     LinkedList<Edge>adjlist= new LinkedList<>();
     /////////////////////////////////////////////////////////////
     public Vertex() {
       this.adjlist = new LinkedList<Edge>();
       }
     ////
     public Vertex(int label) {
    this.label = label;
      }  
}
