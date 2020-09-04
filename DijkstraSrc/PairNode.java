import javafx.scene.Node;

/*
 * Elven Shum
 * Mar 10 2020
 * PairNodes, used for Specific PQ which takes in (City Index, DistanceToOrigin Weights)
 */
public class PairNode implements Comparable <PairNode> {
    public int index;
    public double weight;

    // constructor
    public PairNode(int index, double weight) {
        this.index = index;
        this.weight = weight;
    }

    // compareTo() method for use in MinPQ
    @Override
    public int compareTo(PairNode nodeB) {
        if (weight < nodeB.weight)
            return -1;
        else if (weight > nodeB.weight)
            return 1;
        return 0;
    }

    // equals() method for use in MinPQ
    @Override
    public boolean equals(Object obj) {
        PairNode n = (PairNode) obj;
        return n.index == index;
    }

    // toString() method
    @Override
    public String toString() {
        return "node " + index;
    }
}