package graphs;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * http://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
 *
 * Base Case: table[i][j] = wij;
 * 
 * Recursive case: table[i][j] = min(table[i][k], table[k][j]);
 *
 */
public class FloydWarshallShortestPath {
	
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
		
		public Edge getEdgeFor(Vertex src, Vertex dest) {
			for(Edge e : edges_) {
				if(src.id_ == e.source_.id_ && dest.id_ == e.destination_.id_) {
					return e;
				}
			}
			return null;
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
	
	private static int findShortestPath(Graph g, Vertex src, Vertex dest) {
		
		int[][] table = new int[g.vertexCount_][g.vertexCount_];
		
		for(Vertex i : g.vertices_) {
			for(Vertex j : g.vertices_) {
				table[i.id_][j.id_] = Integer.MAX_VALUE;
			}
		}
		
		for(Vertex v : g.vertices_) {
			table[v.id_][v.id_] = 0;
		}
		
		for(Edge e : g.edges_) {
			table[e.source_.id_][e.destination_.id_] = e.weight_;
		}
		
		for(Vertex k : g.vertices_) {
			for(Vertex i : g.vertices_) {
				for(Vertex j : g.vertices_) {
					if(table[i.id_][k.id_] != Integer.MAX_VALUE && table[k.id_][j.id_] != Integer.MAX_VALUE) {
						table[i.id_][j.id_] = Math.min(table[i.id_][j.id_], table[i.id_][k.id_]+table[k.id_][j.id_]);
					}
				}
			}
		}

		return table[src.id_][dest.id_];
		
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
		
		System.out.println(findShortestPath(gr, v0, v4));
		
	}

}
