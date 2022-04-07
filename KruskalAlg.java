package application;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class KruskalAlg extends MSTAlgorithm {
    public KruskalAlg(Graph graph) {
        super(graph);
    }
    int totalcost = 0;///create MST Cost

    public void kruskal(Graph graph) {
        //create PriorityQueue with Comparator between weight
        PriorityQueue<Edge> PQK = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        //invok the linkedlist for stor the cost
        MSTresultList = new LinkedList<>();
        for (int i = 0; i < graph.addvertices.length; i++) {
            for (int j = 0; j < graph.addvertices[i].adjlist.size(); j++) {
                PQK.add(graph.addvertices[i].adjlist.get(j));
            }
        }
        // create a parent []
        Edge[] parent = new Edge[graph.addvertices.length];
        for (int i = 0; i < graph.addvertices.length; i++) {
            parent[i] = new Edge();
        }
        for (int i = 0; i < parent.length; i++) {
            parent[i].source = new Vertex();
            parent[i].source.label = i;

        }
        int index = 0;
        while (index < graph.veticesNo - 1 && !PQK.isEmpty()) {
            Edge edge = PQK.remove();
            // check if adding this edge creates a cycle
            int source_set = find(parent, edge.source.label);
            int target_set = find(parent, edge.target.label);

            if (source_set == target_set) {
                // ignore
            } else {
                totalcost += edge.weight;//adding to MST cost
                MSTresultList.add(new Edge(edge.source, edge.target, edge.weight));
                index++;
                union(parent, source_set, target_set);
            }
        }
        DisplayResultingMST(MSTresultList);
    }

    /////////////////find method//////////////////////
    public int find(Edge[] parent, int vertex) {
        if (parent[vertex].source.label != vertex) {
            return find(parent, parent[vertex].source.label);
        }
        return vertex;
    }

    //////////////////////union method///////////////////
    public void union(Edge[] parent, int source, int target) {
        int sourceSetParent = find(parent, source);
        int targetSetParent = find(parent, target);
        // to make parent
        parent[targetSetParent].source.label = sourceSetParent;
    }

    @Override
    public void DisplayResultingMST(LinkedList<Edge> MSTresultList) {
        System.out.println("Minimum Spanning Tree Cost of Kruskal = " + totalcost);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
