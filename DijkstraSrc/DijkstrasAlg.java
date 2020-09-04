import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
 * Elven Shum
 * Mar 6 2020
 * Dijkstra's Algorithm
 */

public class DijkstrasAlg {
    private WeightedGraphBuilder graph;
    private double[] distTo;                //Array: stores Distance from Start
    private MinPQ<PairNode> PQ;             //MinPQ for Algorithm
    private LinkedList<Integer> visited;    //LinkedList: stores Visited (Resolved) Nodes
    private int[] lastCity;                 //Array: Stores Previous City in the shortest path from Start, used to walk back & find solution nodes.
    private int start, end;                 //start, end indices

    //Constructor
    //requires: Num of vertices in Graph
    public DijkstrasAlg(WeightedGraphBuilder currGraph, int start, int end) {
        int vertexNum = currGraph.getVertexNum();

        this.graph = currGraph;
        distTo = new double[vertexNum];
        visited = new LinkedList<Integer>();
        lastCity = new int[vertexNum];
        PQ = new MinPQ<>();
        //set all Distances as "infinity"
        for (int i = 0; i < vertexNum; i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        this.start = start;
        this.end = end;

        StdOut.println("Graph Encoded. \n Now Solving...Please wait for at least 30 seconds");
        DijkstraSolve();
    }

    //Dijkstra's Algorithm Solve
    //req: Graph to be solved, start index, end index
    public void DijkstraSolve() {
        //Add source, which has dist 0 to PQ
        PQ.insert(new PairNode(start, 0));
        distTo[start] = 0;
        lastCity[start] = -1;

        //while End isnt visited & PQ isn't empty
        while (distTo[end] == Double.MAX_VALUE && !PQ.isEmpty()) {
            //remove shortest from PQ => currCity,
            PairNode currCity = PQ.delMin();
            //counts currCity as checked
            visited.addItem(currCity.index);
            //traverses currCity's neighbors
            travNeighbors(currCity.index);
        }
    }

    //Traverses thru Neighbors of current City
    //Helper method for Dijkstra's Algorithm
    private void travNeighbors(int currCity) {
        double edgeDist = -1;
        double newDist = -1;

        //Instantiates First Neighbor of currCity
        LinkedList.Node currNeighbor = graph.cityList[currCity].connections.origin;
        int neighIndex = (Integer) currNeighbor.data;

        //while CurrentNeighbor of currCity has more neighbors
        while (currNeighbor.next != null) {
            //if hasn't been visited yet
            if (!visited.contains(neighIndex)) {
                //determine distance from currCity to currNeighbor
                edgeDist = getDistance(currCity, neighIndex);
                //determine distance from Start to currNeighbor, set as newDist
                newDist = distTo[currCity] + edgeDist;

                //if new distance < prev distance, then update DistanceTo & update "LastCity"
                if (newDist < distTo[neighIndex]) {
                    distTo[neighIndex] = newDist;
                    lastCity[neighIndex] = currCity;

                    //add newly Updated Node to PQ
                    PQ.insert(new PairNode(neighIndex, distTo[neighIndex]));
                }
            }

            //go to next Neighbor
            currNeighbor = currNeighbor.next;
            neighIndex = (Integer) currNeighbor.data;
        }

        //deals with Final CurrrentNeighbor of currCity
        //if hasn't been visited yet, determine Distance to neighbors
        if (!visited.contains(neighIndex)) {
            edgeDist = getDistance(currCity, neighIndex);
            newDist = distTo[currCity] + edgeDist;

            //if new distance < prev distance, then Update Distance, update "LastCity"
            if (newDist < distTo[neighIndex]) {
                distTo[neighIndex] = newDist;
                lastCity[neighIndex] = currCity;

                //add newly Updated Node to PQ
                PQ.insert(new PairNode(neighIndex, distTo[neighIndex]));
            }

        }
    }


    //Computes Distance between two cities
    private double getDistance(int currCity, int currNeighbor) {
        int currX = graph.cityList[currCity].getX();
        int currY = graph.cityList[currCity].getY();
        int neighborX = graph.cityList[currNeighbor].getX();
        int neighborY = graph.cityList[currNeighbor].getY();

        double XsSquared = Math.pow(currX - neighborX, 2);
        double YsSquared = Math.pow(currY - neighborY, 2);
        //StdOut.println("Dist Calc:" + currCity + ", " + currNeighbor);
        return Math.sqrt(XsSquared + YsSquared);
    }

    //prints shortest path from end -> start
    //(which is why switched (end & start) when solving
    public void printShortestPath() {
        int currTravCity = end;
        StdOut.print("Shortest Path: " + end);
        //while currTravCity isn't the start city (who's index was -1)
        while (lastCity[currTravCity] != -1) {

            //print next Index, update city
            StdOut.print(" -> " + lastCity[currTravCity]);
            currTravCity = lastCity[currTravCity];
        }
        StdOut.print("\nDistance from Start to End: " + distTo[end]);
    }

    // TestClient
    public static void main(String[] args) {
        USAEncoder myEncoder = new USAEncoder("src/usa.txt");
        WeightedGraphBuilder myGraph = new WeightedGraphBuilder(myEncoder.mapSize);
        myEncoder.loadMap(myGraph);

        DijkstrasAlg myAlg = new DijkstrasAlg(myGraph, 11, 45356);
        myAlg.printShortestPath();
    }
}

