import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*
 * Elven Shum
 * Mar 6 2020
 * USA Map Encoder
 */

public class USAEncoder {
    public String file;
    public int mapSize;


    public USAEncoder(String mapFile){
        file = mapFile;
        setMapSize();
    }

    private void setMapSize(){
        try {
            //reads only 1 line, to determine number of Verticies/mapSize
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String currLine = bufferedReader.readLine();
            mapSize = firstRowElem(currLine);

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //get first RowElement
    private int firstRowElem(String line){
        int firstSpace = line.indexOf(' ');
        return Integer.parseInt(line.substring(0,firstSpace));
    }

    //load Map into WeightedGraph currGraph
    public void loadMap (WeightedGraphBuilder currGraph){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String currLine;
            Boolean isFirstLine = true;
            while ((currLine = bufferedReader.readLine()) != null) {
                //skips first Line
                if (isFirstLine){
                    isFirstLine = false;
                } else {
                    parseLine(currGraph, currLine);
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //parses line, selects relevant data
    //Helper method for LoadMap, called each line
    private void parseLine(WeightedGraphBuilder currGraph, String currline){
        int numOfElems = numOfElems(currline);
        int[] elems = getElems(currline);
        //encodes for newCities
        if (numOfElems == 3){
            //encoding scheme: [vertIndex, xcoord, ycoord]
            currGraph.addCity(elems[0], elems[1], elems[2]);
        }
        //encodes for Vertex Connections between vertA and vertB
        if (numOfElems == 2){
            //encoding scheme: [vertA, vertB]
            currGraph.addEdge(elems[0], elems[1]);
        }
        //note: if empty spacer line, ie numOfElems==0, then ignores.
    }

    //returns Num of Elements in the Line
    private int numOfElems(String line){
        int count = 0;
        String temp = line;
        while (!temp.equals("")){
            int firstSpace = temp.indexOf(' ');
            //if begins with spaces, rm space
            if (firstSpace == 0){
                temp = temp.substring(1);
            }
            //else, we're seeing an element.
            else if (firstSpace > 0) {
                count++;
                temp = temp.substring(firstSpace);
            }
            //finished line
            else{
                count++;
                temp = "";
            }
        }
        return count;
    }

    //returns array of Integers, with elements from line
    private int[] getElems(String line){
        int[] elems = new int[numOfElems(line)];
        int elemCount = 0;
        String temp = line;
        while (!temp.equals("")){
            int firstSpace = temp.indexOf(' ');
            //if begins with spaces, rm space
            if (firstSpace == 0){
                temp = temp.substring(1);
            }
            //if begins with elem
            else if (firstSpace > 0) {
                elems[elemCount] = Integer.parseInt(temp.substring(0,firstSpace));
                elemCount++;
                temp = temp.substring(firstSpace);
            }
            //if final elem
            else{
                elems[elemCount] = Integer.parseInt(temp);
                temp = "";
            }
        }
        return elems;
    }

    public static void main(String[] args) {
        USAEncoder myEncoder = new USAEncoder("src/tinyUSA.txt");
        WeightedGraphBuilder myGraph = new WeightedGraphBuilder(myEncoder.mapSize);
        myEncoder.loadMap(myGraph);
        myGraph.print();
        StdOut.println(myGraph.cityList[0].getX());
        //StdOut.print(Arrays.toString(myEncoder.getElems("      5    6000    1500")));
    }
}
