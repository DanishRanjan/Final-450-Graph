import java.io.*;
import java.util.*;

public class Iterative_DepthFIrstSearch {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   static class pair{
       int vertex;
       String psf;
       
       pair(int vertex, String psf){
           this.vertex = vertex;
           this.psf = psf;
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here
      boolean[] visited = new boolean[vtces];
      Stack<pair> st = new Stack<>();
      st.push(new pair(src,src+""));
      
      while(st.size()>0){
          pair remove = st.pop();
          
          if(visited[remove.vertex]==true){
              continue;
          }
          visited[remove.vertex] = true;
          
          System.out.println(remove.vertex+"@"+remove.psf);
          
          for(Edge e: graph[remove.vertex]){
              if(visited[e.nbr]==false){
                  st.push(new pair(e.nbr, remove.psf+e.nbr));
              }
          }
      }
   }
}