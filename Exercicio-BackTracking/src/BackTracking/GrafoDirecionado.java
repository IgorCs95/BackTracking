package BackTracking;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirecionado {


	      
	    // Numero de Vertices verificados
	    private int V;  
	  
	    // Matriz de listas para representa��o da lista de adjac�ncias
	    private LinkedList<Integer> adj[]; 
	  
	    @SuppressWarnings("unchecked") 
	    GrafoDirecionado(int v)  
	    { 
	        V = v; 
	        adj = new LinkedList[v]; 
	        for (int i = 0; i < v; ++i) 
	            adj[i] = new LinkedList<>(); 
	    } 
	  
	    // M�todo para adicionar uma aresta no gr�fico
	    void addEdge(int v, int w) 
	    { 
	          
	        // Adicione w � lista de v.
	        adj[v].add(w);  
	    } 
	  
	      
	    // Um m�todo recursivo para contar todos os caminhos de 'u' para 'd'. 
	    int countPathsUtil(int u, int d, 
	                    boolean visited[],  
	                    int pathCount) 
	    { 
	          
	        // Marcar o n� atual como visitado e imprimi-lo 
	        visited[u] = true; 
	  
	        // Se o v�rtice atual for o mesmo que destino, a contagem de incremento 
	        if (u == d)  
	        { 
	            pathCount++; 
	        } 
	              
	        // Recorrente para todos os v�rtices adjacentes a este v�rtice
	        else
	        { 
	            Iterator<Integer> i = adj[u].listIterator(); 
	            while (i.hasNext())  
	            { 
	                int n = i.next(); 
	                if (!visited[n])  
	                { 
	                    pathCount = countPathsUtil(n, d, 
	                                            visited, 
	                                            pathCount); 
	                } 
	            } 
	        } 
	  
	        visited[u] = false; 
	        return pathCount; 
	    } 
	  
	    // Retorna a contagem de caminhos de 's' para 'd' 
	    int countPaths(int s, int d) 
	    { 
	          
	        // Marcar todos os v�rtices como n�o visitados 
	        boolean visited[] = new boolean[V]; 
	        Arrays.fill(visited, false); 
	  
	        // Chame o m�todo recursivo para contar todos os caminhos 
	        int pathCount = 0; 
	        pathCount = countPathsUtil(s, d, 
	                                visited,  
	                                pathCount); 
	        return pathCount; 
	    } 
	  
	    // metodo Main
	    public static void main(String args[])  
	    { 
	    	GrafoDirecionado g = new GrafoDirecionado(4); 
	        g.addEdge(0, 1); 
	        g.addEdge(0, 2); 
	        g.addEdge(0, 3); 
	        g.addEdge(2, 0); 
	        g.addEdge(2, 1); 
	        g.addEdge(1, 3); 
	  
	        int s = 2, d = 3; 
	        System.out.println(g.countPaths(s, d)); 
	    } 
	  
}
