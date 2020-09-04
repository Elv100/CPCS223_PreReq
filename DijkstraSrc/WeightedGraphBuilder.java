import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Elven Shum
 * Mar 6 2020
 * WeightedGraph Class/Builder
 */

public class WeightedGraphBuilder {
    private final int INF = Integer.MAX_VALUE;  //used for Denoting: Connected, but no specified Weight
    private int vertexNum;
    private int edgesNum;
    public City[] cityList;

    //makes empty graph/adjMatrix with vertexNum size
    public WeightedGraphBuilder(int vertexNum) {
        if (vertexNum < 1) return;
        this.vertexNum = vertexNum;
        this.edgesNum = 0;
        this.cityList = new City[vertexNum];
    }

    //connects VertA and VertB
    public void addEdge(int vertA, int vertB) {
        cityList[vertA].connectWith(vertB);
        cityList[vertB].connectWith(vertA);
        edgesNum++;
    }

    //adds City w/ cityName
    public void addCity(int vertIndex, int x, int y, String name){
        cityList[vertIndex] = new City(x,y, name);
    }

    //adds City, defaults CityName to vertex Index
    public void addCity(int vertIndex, int x, int y){
        cityList[vertIndex] = new City(x,y, Integer.toString(vertIndex));
    }

    //returns num of vert
    public int getVertexNum() {
        return vertexNum;
    }

    //returns num of edges
    public int getEdgesNum() {
        return edgesNum;
    }

    //returns if Vert A and B are connected by edge
    public boolean isConnected(int vertA, int vertB) {
        return cityList[vertA].isConnected(vertB);
    }

    //lists all Verticies and Edges (connections)
    public void print(){
        for(int i = 0; i < vertexNum; i++){
            StdOut.print("Vertex "+ i + ", named "+ cityList[i].getName() + " -> ");
            cityList[i].connections.printList();
        }
    }


    // test client
    public static void main(String[] args) {
        int vertexNum = 4;
        WeightedGraphBuilder currGraph = new WeightedGraphBuilder(vertexNum);
        currGraph.cityList[0] = new City(0,0);
        currGraph.cityList[1] = new City(1,1);
        currGraph.cityList[2] = new City(2,2, "Asgard");
        currGraph.cityList[3] = new City(3,3);
        currGraph.addEdge(1, 2);
        currGraph.addEdge(0, 2);
        currGraph.addEdge(1, 3);
        currGraph.addEdge(0, 1);
        currGraph.print();

        //StdOut.println(Integer.parseInt("10 "));
    }
}
