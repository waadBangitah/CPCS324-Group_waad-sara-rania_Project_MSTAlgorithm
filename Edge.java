package application;

public class Edge {
 Vertex source;
 Vertex target;
 Vertex parent;
  int  weight;
  //////////////////////////////////////////
  public Edge(){
      };
  //////
  public Edge(Vertex source, Vertex target, int  weight) {
    this.source =source;
    this.parent=source;
    this.target = target;
    this.weight = weight;
  }
  //////
  public Edge (Vertex target ,int  weight){
  this.target = target;
    this.weight = weight;
  }
  
}
