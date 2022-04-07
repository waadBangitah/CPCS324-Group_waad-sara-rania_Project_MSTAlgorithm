package application;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MHPrimAlg extends MSTAlgorithm {
 public MHPrimAlg(Graph graph) {
        super(graph);
    }
  int totalcost = 0;///create MST Cost
  ////////////////////////////
  ///classes to make heap////
  //////////////////////////
  static class HeapNode {
        int node;
        int key;
    }
  /////////////////////
  static class MinHeap {
        int capacity;
        int currentSize;
        HeapNode[] minHeap;
        int[] dKey; //used to decrease the key
//////////////////////////////////////////
        public MinHeap(int capacity) {
            this.capacity = capacity;
            minHeap = new HeapNode[capacity + 1];
            dKey = new int[capacity];
            minHeap[0] = new HeapNode();
            minHeap[0].key = Integer.MIN_VALUE;
            minHeap[0].node = -1;
            currentSize = 0;
        }
/////////////////////////insert heapNode/////////////
        public void insert(HeapNode Node) {
            currentSize++;
            int idNode = currentSize;
            minHeap[idNode] = Node;
            dKey[Node.node] = idNode;
            bubbleUp(idNode);
        }
/////////////////////////////bubbleUp Position /////////  

        public void bubbleUp(int posNode) {
            int parentIdNode = posNode / 2;
            int currentIdNode = posNode;
            while (currentIdNode > 0 && minHeap[parentIdNode].key > minHeap[currentIdNode].key) {
                HeapNode currentNode = minHeap[currentIdNode];
                HeapNode parentNode = minHeap[parentIdNode];
                dKey[currentNode.node] = parentIdNode;
                dKey[parentNode.node] = currentIdNode;
                 //to swap positions between them
                swap(currentIdNode, parentIdNode);
                currentIdNode = parentIdNode;
                parentIdNode = (parentIdNode / 2);
            }
        }
        //////////////////////exttract the min node/////////

        public HeapNode extractMinNode() {
            HeapNode minN = minHeap[1];
            HeapNode lastN = minHeap[currentSize];
            dKey[lastN.node] = 1;//update the decreaseKey[]
            minHeap[1] = lastN;
            minHeap[currentSize] = null;
            sinkDown(1);
            currentSize--;
            return minN;
        }
        ///////////////////sink down the min heap/////////
        public void sinkDown(int nodeP) {
            int smallestNode = nodeP;
            int lChildIdN = 2 * nodeP;
            int rChildIdN = 2 * nodeP + 1;
            if (lChildIdN < heapSize() && minHeap[smallestNode].key > minHeap[lChildIdN].key) {
                smallestNode = lChildIdN;
            }
            if (rChildIdN < heapSize() && minHeap[smallestNode].key > minHeap[rChildIdN].key) {
                smallestNode = rChildIdN;
            }
            if (smallestNode != nodeP) {
                HeapNode theSmallest = minHeap[smallestNode];
                HeapNode kNode = minHeap[nodeP];

                //swap the positions
                dKey[theSmallest.node] = nodeP;
                dKey[kNode.node] = smallestNode;
                swap(nodeP, smallestNode);
                sinkDown(smallestNode);
            }
        }
 ////////////////////////////       
          public boolean isEmpty() {
            return currentSize == 0;
        }
///////////////////////////
        public void swap(int FNode, int SNode) {
            HeapNode temp = minHeap[FNode];
            minHeap[FNode] = minHeap[SNode];
            minHeap[SNode] = temp;
        }
//////////////////////////////
        public int heapSize() {
            return currentSize;
        }
    }
 
  ////////////////////////////////////////////////////////////////
     public void MHPrim(Graph graph) {
     int vertices=graph.veticesNo;
     boolean[] isHeap = new boolean[vertices];
     MSTresultList = new LinkedList<>();
     HeapNode[] heapNodes = new HeapNode[vertices];//create heapNode 
     int[] key = new int[vertices];
     Edge[] result=new Edge[vertices];
/////////////////////////////////////
for (int i = 0; i < vertices; i++) {
                heapNodes[i] = new HeapNode();
                heapNodes[i].node = i;
                heapNodes[i].key = Integer.MAX_VALUE;
                result[i] = new Edge();
                result[i].parent=new Vertex();
                result[i].parent.label = -1;
                isHeap[i] = true;
                key[i] = Integer.MAX_VALUE;
            }
//////////////////////////////////
  heapNodes[0].key = 0;
  MinHeap minHeap = new MinHeap(vertices);
   for (int i = 0; i < vertices; i++) {
                minHeap.insert(heapNodes[i]);
            }
 ///////////////////////while not minHeapisEmpty()
 while (!minHeap.isEmpty()) {
     HeapNode extractedNode = minHeap.extractMinNode();//extractMinNode() 
   int extractedVertex = extractedNode.node;
   isHeap[extractedVertex] = false;
   PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
   for(int i = 0 ; i < graph.addvertices[extractedVertex].adjlist.size() ; i++)
                {
                    Edge edge = graph.addvertices[extractedVertex].adjlist.get(i);
                    int node = edge.target.label;
                         pq.add(edge);
                      if (isHeap[edge.target.label]) {
                        int target = edge.target.label;
                        int newKey = edge.weight;    
                         if (key[target] > newKey) {
                            decreaseKey(minHeap, newKey, target);
                            result[target].parent.label = extractedVertex;
                            result[target].weight = newKey;
                            key[target] = newKey;
      
     }
                      }
                }
 }
 for(int i =1;i<graph.veticesNo;i++){
 totalcost+=result[i].weight;
 }
 DisplayResultingMST(MSTresultList);
 
     }
      /////////////////////////////////////////////////////////////////////
  public void decreaseKey(MinHeap minHeap, int newKey, int vertex) {

            int index = minHeap.dKey[vertex];
            HeapNode node = minHeap.minHeap[index];
            node.key = newKey;
            minHeap.bubbleUp(index);
        }
                      
    @Override
    public void DisplayResultingMST(LinkedList<Edge> MSTresultList) {
        System.out.println("Minimum Spanning Tree Cost of MHPrim  = " + totalcost);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
