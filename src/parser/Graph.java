package parser;

import java.util.ArrayList;

public class Graph {

	private int citiesNumber;
	private int infiniteNumber;
	private int firstNode;
	private int data[][];

	public Graph(int citiesNumber, int infiniteNumber, int firstNode, int data[][]){
		this.citiesNumber = citiesNumber;
		this.infiniteNumber = infiniteNumber;
		this.firstNode = firstNode;
		this.data = data;
	}

	public void setCitiesNumber(int citiesNumber) { this.citiesNumber = citiesNumber; }

	public void setInfiniteNumber(int infiniteNumber) { this.infiniteNumber = infiniteNumber; }

	public void setFirstPoint(int firstNode) { this.firstNode = firstNode; }
	
	public void setData(int data[][]) { this.data = data; }
	
	public int getCitiesNumber() { return this.citiesNumber; }
	
	public int getInfiniteNumber() { return this.infiniteNumber; }
	
	public int getFirstPoint() { return this.firstNode; }
	
	public int[][] getData() { return this.data; }


}
