import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MasterRunner {

    // text location
    private static String MAP;


    // main
    public static void main(String[] args) {
        System.out.println("Welcome to Elven's MapRoutining");
        System.out.println("Please select your desired Map");
        StdOut.println("Which algorithm would you like to test?");
        StdOut.println("1 : usaTiny.txt");
        StdOut.println("2 : usaMini.txt");
        StdOut.println("3 : usa.txt");
        StdOut.println("Please input the number corresponding to your chosen algorithm.");
        int mapSel = StdIn.readInt();
        if (!(mapSel >= 1 && mapSel <= 3)) {
            StdOut.println("You have failed to enter a valid input, defaulting to usa.txt \n");
            mapSel = 3;
        }
        switch (mapSel) {
            case 1:
                MAP = "src/usaTiny.txt";
                break;
            case 2:
                MAP = "src/usaMini.txt";
                break;
            case 3:
                MAP = "src/usa.txt";
                break;
        }

        //instantiate Encoder, Graph (representation of Map), Loads Map
        USAEncoder enc = new USAEncoder(MAP);
        WeightedGraphBuilder myGraph = new WeightedGraphBuilder(enc.mapSize);
        enc.loadMap(myGraph);

        //get start Index
        int vertMax = myGraph.getVertexNum();
        System.out.println("Enter your starting VertexIndex (0-" + vertMax + ")");
        int start = StdIn.readInt();
        if (!(start >= 0 && mapSel <= vertMax)) {
            StdOut.println("You have failed to enter a valid input, defaulting to 0");
            start = 0;
        }

        //get end Index
        System.out.println("Enter your ending VertexIndex (0-" + vertMax + ")");
        int end = StdIn.readInt();
        if (!(end >= 0 && mapSel <= vertMax)) {
            StdOut.println("You have failed to enter a valid input, defaulting to " + vertMax);
            end = vertMax;
        }

        DijkstrasAlg myAlg = new DijkstrasAlg(myGraph, end, start);
        myAlg.printShortestPath();
    }
}