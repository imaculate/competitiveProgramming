import java.util.*;
import java.io.*;
class Main{
   static void debug(String a){
      System.out.println(a);
   }
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String line = br.readLine();
      String[] lineArray = line.split(" ");
      
       
      int N = Integer.parseInt(lineArray[0]);
      int M =Integer.parseInt(lineArray[1]);
      
      
      ArrayList<Vertex> vertexList  = new ArrayList<Vertex>();
      for(int i =0; i<N; i++){
          line = br.readLine();
          lineArray = line.split(" ");
         
         int z = Integer.parseInt(lineArray[0]);
         int x = Integer.parseInt(lineArray[1]);
         int y = Integer.parseInt(lineArray[2]);
        
         Vertex v = new Vertex(x,y,z, i);
         vertexList.add(v);
         
         
      }
      ArrayList<Edge> edgeList = new ArrayList<Edge>();
      for(int i =0; i<M; i++){
        line = br.readLine();
         lineArray = line.split(" ");
         int A =Integer.parseInt(lineArray[0]);
         int B = Integer.parseInt(lineArray[1]); 
         String method  = lineArray[2];
         
         
         
         
         
         if(method.equals("walking")|| method.equals("stairs")){
            double dist = vertexList.get(A).distance(vertexList.get(B));
            edgeList.add(new Edge(A, B,dist));
            edgeList.add(new Edge(B, A,dist));
            
            
         }
         else if(method.equals("lift")){
            edgeList.add(new Edge(A, B,1));
            edgeList.add(new Edge(B, A,1));
         }
         else if(method.equals("escalator")){
            double dist = vertexList.get(A).distance(vertexList.get(B));
            edgeList.add(new Edge(A, B,1));
            edgeList.add(new Edge(B, A,3*dist));
            
            
            
         }
         
      
      
      }
      Graph graph = new Graph(edgeList, vertexList);
      line = br.readLine();
     

      int tests = Integer.parseInt(line);
     
      
      String path ="";
      
      for(int i= 0; i< tests; i++){
          line = br.readLine();
         lineArray = line.split(" ");
         int start =Integer.parseInt(lineArray[0]);
         int end = Integer.parseInt(lineArray[1]);
         
         graph.dijkstra(start);
         path += graph.printPath(end)+ "\n";
        
         
      }
      
      br.close();
      System.out.print(path);
      
      
            
      
   }
   
   static class Graph{
      private final ArrayList< Vertex> graph;
      public Graph(ArrayList<Edge> edges, ArrayList<Vertex> vertices) {
         graph = vertices;
      
      
      
      //another pass to set neighbouring vertices
         for (Edge e : edges) {
            graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
         //graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); // also do this for an undirected graph
            }
         }
   
      public void dijkstra(int startName) {
         if (startName>= graph.size() || startName<0) {
            System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
            return;
         }
         final Vertex source = graph.get(startName);
         NavigableSet<Vertex> q = new TreeSet<>();
      
      // set-up vertices
         for (Vertex v : graph) {
            v.previous = v.equals(source) ? source : null;
            v.dist = v.equals(source) ? 0 : Integer.MAX_VALUE;
            q.add(v);
         }
      
         dijkstra(q);
      }
   
   /** Implementation of dijkstra's algorithm using a binary heap. */
      private void dijkstra(final NavigableSet<Vertex> q) {      
         Vertex u, v;
         while (!q.isEmpty()) {
         
            u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
            
            if (u.dist == Integer.MAX_VALUE) 
               break; // we can ignore u (and any other remaining vertices) since they are unreachable
         
         //look at distances to each neighbour
            for (Map.Entry<Vertex, Double> a : u.neighbours.entrySet()) {
               v = a.getKey(); //the neighbour in this iteration
            
               final double alternateDist = u.dist + a.getValue();
               if (alternateDist < v.dist) { // shorter path to neighbour found
                  q.remove(v);
                  v.dist = alternateDist;
                  v.previous = u;
                  q.add(v);
               } 
            }
         }
      }
        public String printPath(int endName) {
            if ((endName>=graph.size()) || (endName<0)) {
             System.err.printf("Graph doesn't contain end vertex \"%s\"\n", endName);
               return "error";
            }
            return graph.get(endName).printPath();
          
      }
 
   
   
      
   }
   
   static class Edge{
   
      public final int v1, v2;
      public final double dist;
      public Edge(int v1, int  v2, double dist) {
         this.v1 = v1;
         this.v2 = v2;
         this.dist = dist;
      }
   
   }
   static class Vertex implements Comparable<Vertex> {
      public  int name;
      public  int y =0 ;
      public int z = 0 ;
      public  int x = 0  ;
    
      public double dist = (double)Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
      public Vertex previous = null;
      public final Map<Vertex, Double> neighbours = new HashMap<>();
   
      public Vertex(int x, int y, int z, int  name) {
         this.x = x;
         this.y = y;
         this.z = z;
         this.name = name;
         
      }
      
      public Vertex(int name){
         this.name = name;
      }
   
      private String printPath() {
         if (this == this.previous) {
            return (this.name+ " ");
         
         } 
         else if (this.previous == null) {
            return (  this.name+ "(unreached) ");
            
         } 
         else {
            return (previous.printPath() + this.name + " ");
            
         }
      }
   
      public int compareTo(Vertex other) {
         return Double.compare(dist, other.dist);
      }
      
      public boolean equals(Vertex other){
         return name == other.name;
         
      }
      public double distance(Vertex other){
         int distx =  x - other.x;
         int disty = y-other.y;
         int distz = 5*(z-other.z);
         
         long l = (distx*distx) + (disty* disty)+ (distz * distz);
         return Math.pow(l, 0.5);
        
      }
   }
}