import java.io.*;
import java.util.*;

public class InfectionSpread_Graph {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   public static class Pair{
       int vertex;
       int time;
       
       Pair(int vertex, int time){
           this.vertex = vertex;
           this.time = time;
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
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
      ArrayDeque<Pair> queue = new ArrayDeque<>();
      queue.add(new Pair(src,1));
      int[] visited = new int[vtces];
      int count = 0;
      while(queue.size()>0){
          Pair remove = queue.remove();
          
          if(visited[remove.vertex] > 0){
          continue;    
          }
          visited[remove.vertex] = remove.time;
          if(remove.time > t){
              break;
          }
          count++;
          
          for(Edge e:graph[remove.vertex]){
              if(visited[e.nbr]==0){
                  queue.add(new Pair(e.nbr,remove.time+1));
              }
          }
      }
      System.out.println(count);
      
      
      
      
      
      
      
   }

}