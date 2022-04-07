/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.util.Random;

/**
 *
 * @author waadb
 */
public class Graph {
int veticesNo;
int edgeNo;
boolean isDigraph;
//array to add vertex
Vertex[] addvertices;

/////////////////////////methods/////////////////////////////////////////////
public Graph(int vertices, int edges,boolean isDigraph) {
        this.veticesNo = vertices;
        this.edgeNo = edges;
        this.isDigraph = isDigraph;
        this.addvertices = new Vertex[vertices];
        ///loop to add vertex in to array
        for (int i = 0; i < vertices; i++) {
            addvertices[i] = new Vertex(i);
        }
    }
/////////////////////////////
//////make graph////
    public void make_graph() {
        Random randomNum = new Random();///create random class
        for (int i = 0; i < veticesNo - 1; i++) {//Make sure that the resulting graph is connected. 
            int RandomNum = randomNum.nextInt(20) + 1;//generate random weights for edge between 0-20
            addEdge(addvertices[i], addvertices[i + 1], RandomNum);
        }

        int remaningEdge = edgeNo - (veticesNo - 1);//generate remaining edges 

        for (int i = 0; i < remaningEdge; i++) {
            Vertex source = addvertices[randomNum.nextInt(veticesNo)];
            Vertex Destination = addvertices[randomNum.nextInt(veticesNo)];
            int weight = randomNum.nextInt(20) + 1; //generate random weights 
            if (source == Destination || checksedge(source, Destination)) { // to sure no duplicate edges
                i--;
                continue;
            } else {
                addEdge(source, Destination, weight);//add edge
            }
        }
    }
 ////////////////////////////////
 /////////// method for checks edges exists in the graph and the graph connected///// 
    public boolean checksedge(Vertex Source, Vertex target) {
        for (Edge edge : Source.adjlist) {
            if (edge.target == target) {
                return true;
            }
        }
        /////else
        return false;
    }
/////////////////////////////
////////method for add edge//////////
  
public void addEdge(Vertex v, Vertex u, int w) {
        Edge edge1 = new Edge(v, u, w);
        v.adjlist.add(edge1);
        //f the graph is undirected then it will add the source vertex to the adjacent list of the target vertex
        if (!isDigraph) {
            edge1 = new Edge(u, v, w);
            u.adjlist.add(edge1);
        }
    }
/////////////////////////
////////////method to show graph/////////

 public void printGraph() {
        System.out.println("Graph with " + veticesNo + " verticies and " + edgeNo + " edges");
        for (Vertex v : addvertices) {
            for (Edge e : v.adjlist) {
                System.out.println(e.source.label + "->" + e.target.label + "(w=" + e.weight + ")");
            }
        }
    }


///////////////end class graph/////////////////////////////


}
