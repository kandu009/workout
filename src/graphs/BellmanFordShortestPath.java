package graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class BellmanFordShortestPath {

	public static class Graph {
		
		ArrayList<Edge> edges_ = new ArrayList<Edge>();
		HashSet<Vertex> vertices_ = new HashSet<Vertex>();
		
		int vertexCount_;
		
		public Graph(int v) {
			vertexCount_ = v;
			// do nothing
		}
		
		public void addEdge(Edge e) {
			edges_.add(e);
			vertices_.add(e.source_);
			vertices_.add(e.destination_);
		}
		
	}
	
	public static class Edge {
		
		int weight_;
		Vertex source_;
		Vertex destination_;
		
		public Edge(int wt, Vertex src, Vertex dest) {
			weight_ = wt;
			source_ = src;
			destination_ = dest;
		}
		
	}
	
	public static class Vertex {
		
		int id_;
		ArrayList<Vertex> adjList = new ArrayList<Vertex>();
		
		public Vertex(int id) {
			id_ = id;
		}
		
		public void addAdjVertex(Vertex a) {
			adjList.add(a);
		}
		
	}
	
	private static boolean isCyclicUtil(Vertex v, int[] visited, int[] inRecStack) {
		
		if(1 == visited[v.id_] && 1 == inRecStack[v.id_]) {
			return true;
		}
		if(1 != visited[v.id_]) {
			visited[v.id_] = 1;
			inRecStack[v.id_] = 1;
			for(Vertex va : v.adjList) {
				if(isCyclicUtil(va, visited, inRecStack)) {
					return true;
				}
			}
		}
		inRecStack[v.id_] = 0;
		return false;
	}

	private static boolean isCyclic(Graph gr) {
		
		int[] visited = new int[gr.vertexCount_];
		int[] inRecStack = new int[gr.vertexCount_];
		
		for(int i = 0; i < gr.vertexCount_; ++i) {
			visited[i] = 0;
			inRecStack[i] = 0;
		}
		
		for(Vertex v : gr.vertices_) {
			if(isCyclicUtil(v, visited, inRecStack)) {
				return true;
			}
		}
		
		return false;
			
	}
	
	public static void BellmanFordImpl(Graph g, Vertex src, Vertex dest) {
		
		int[] distance = new int[g.vertexCount_];
		
		for(int i = 0; i < distance.length; ++i) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[src.id_] = 0;
		
		for(int j = 0; j < g.vertexCount_-1; ++j) {
			for(Edge e : g.edges_) {
				int sId = e.source_.id_;
				int dId = e.destination_.id_;
				if(distance[sId] != Integer.MAX_VALUE) {
					distance[dId] = Math.min(distance[dId], distance[sId]+e.weight_);
				}
			}
		}
		
		System.out.println(distance[dest.id_]);
		
	}
	
	public static void main(String[] args) {
		
		Graph gr = new Graph(5);
		Vertex v0 = new Vertex(0);
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Edge e01 = new Edge(2, v0, v1);
		Edge e02 = new Edge(3, v0, v2);
		Edge e13 = new Edge(4, v1, v3);
		Edge e23 = new Edge(1, v2, v3);
		Edge e34 = new Edge(5, v3, v4);
		
		v0.addAdjVertex(v1);
		v0.addAdjVertex(v2);
		v1.addAdjVertex(v3);
		v2.addAdjVertex(v3);
		v3.addAdjVertex(v4);
		
		gr.addEdge(e01);
		gr.addEdge(e02);
		gr.addEdge(e13);
		gr.addEdge(e23);
		gr.addEdge(e34);
		
		/*
		// for checking a cycle
		Edge e40 = new Edge(6, v4, v4);
		v4.addAdjVertex(v4);
		gr.addEdge(e40);
		*/
		
		if(isCyclic(gr)) {
			System.out.println("Found a cycle in the graph, cannot proceed !");
		} else {
			BellmanFordImpl(gr, v2, v4);
		}
		
	}

}
