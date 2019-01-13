package BellmanFord;

import java.util.List;
import java.util.ArrayList;

public class Vertex {
	private String name;
	private boolean visited;
	private List<Edge> adjacenciesList;
	private double minDistance = Double.MAX_VALUE;
	private Vertex previousVertex;//predecessor

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}

	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}

	public Vertex(String name) {
		this.name = name;
		this.adjacenciesList = new ArrayList<Edge>();
	}
	
	public void addEdge(Edge edge) {
		this.adjacenciesList.add(edge);
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
