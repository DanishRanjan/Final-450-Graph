import java.io.*;
import java.util.*;

public class breadthFirstSearch {
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
      ArrayDeque<pair> queue = new ArrayDeque<>();
      queue.add(new pair(src, src+""));
      boolean[] visited = new boolean[vtces];
      while(queue.size()>0) {
//    	  4 step to be followed : -remove markStar print AddStar
    	  
    	  pair rem = queue.remove();//1st step Remove
    	  if(visited[rem.vertex]==true) {
    		  continue;   
    	  }
    	  visited[rem.vertex] = true; //2nd step mark star
    	  
    	  System.out.println(rem.vertex + "@" + rem.psf);//3rd step print(work)
    	  
    	  for(Edge e:graph[rem.vertex]) { //4t step: add star(means add unvisited path to queue)
    		  if(visited[e.nbr]==false) {
    			  queue.add(new pair(e.nbr,rem.psf+e.nbr));
    		  }
    	  }
      }
      
   }
}


//7
//8
//0 1 10
//1 2 10
//2 3 10
//0 3 10
//3 4 10
//4 5 10
//5 6 10
//4 6 10
//2