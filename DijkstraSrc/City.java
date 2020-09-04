import edu.princeton.cs.algs4.StdOut;

/*
 * Elven Shum
 * Mar 6 2020
 * City Class
 */


public class City {
    private int xcoord;                         //City's X coordinate
    private int ycoord;                         //City's Y coordinate
    private String name;                        //City's Name (not currently used)
    public LinkedList<Integer> connections;     //Linked List of Connected cities

    //constructor, defaults CityName
    public City(int x, int y) {
        xcoord = x;
        ycoord = y;
        name = "def";
        connections = new LinkedList<Integer>();
    }

    //constructor, set name
    public City(int x, int y, String name) {
        xcoord = x;
        ycoord = y;
        this.name = name;
        connections = new LinkedList<Integer>();
    }

    public int getX() {
        return xcoord;
    }

    public int getY() {
        return ycoord;
    }

    public String getName() {
        return name;
    }

    //connects City with other CityIndex
    public void connectWith(int CityIndex) {
        connections.addItem(CityIndex);
    }

    //returns true if City & otherCityIndex are connected
    public boolean isConnected(int CityIndex) {
        return connections.contains(CityIndex);
    }
}
