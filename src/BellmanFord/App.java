package BellmanFord;

import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String[] args) {
		List<Vertex> vertexList = new ArrayList<>();
		
		 vertexList.add(new Vertex("A"));
		 vertexList.add(new Vertex("B"));
		 vertexList.add(new Vertex("C"));
		 vertexList.add(new Vertex("D"));
		 
		 List<Edge> edgeList = new ArrayList<>();
		 
		 edgeList.add(new Edge(1,vertexList.get(0),vertexList.get(1)));
		 edgeList.add(new Edge(1,vertexList.get(1),vertexList.get(2)));
		 edgeList.add(new Edge(1,vertexList.get(2),vertexList.get(3)));
		 edgeList.add(new Edge(-5,vertexList.get(3),vertexList.get(1)));
		 edgeList.add(new Edge(10,vertexList.get(0),vertexList.get(3)));
		 
		 Algorithm algorithm = new Algorithm(edgeList,vertexList);
		 
		 algorithm.shortestPath(vertexList.get(0), vertexList.get(3));
		 
		 
	}

}
