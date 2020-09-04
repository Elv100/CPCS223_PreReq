# CPCS223_PreReq Code README
Included are two selected assignments that I coded for Deerfield Academy's COM600: Data Structures & Algorithms class, which I took from 2019-2020.

## Dijkstra's Algorithm/MapRouting 
### Overview
This program finds the shortest path between two user specified nodes. The there are three "USA maps," which are encoded as text files. The program will prompt the user to choose which map and which two points it will find the path between. This program utilizes concepts such as Dijkstra's shortest path first algorithm, minimum priority queues, linked lists, file readers, and custom nodes. 


### Files Overview

**Java Files:** `MasterRunner.java`, `WeightedGraphBuilder.java`, `USAEncoder.java`, `DijkstrasAlg.java`, `City.java`, `MinPQ.java`, `PairNode.java`, `LinkedList.java`

**Text Files:** `usa.txt`, `usaMini.txt`, `usaTiny.txt`

To use the program, run MasterRunner.java's main. The console will prompt you from there.


### Class Structure Overview
The class heirarchy/dependancies are as follows:

![](DijkstrasClasses.png)

`MasterRunner.java`, being the "front end," is what the user interacts with. To find a path from inputted start and end indices (not shown) utilizes  `DijkstrasAlg.java` which requires a Weighted Graph that's encoded with a map. `WeightedGraphBuilder.java` and `USAEncoder.java` work together to create this Map-encoded-graph. 
`WeightedGraphBuilder` encodes graphs as an adjacency matrix where an array of `City.java`'s are the cities, which each have a `LinkedList.java` of connections.
`USAEncoder.java` encodes any "map data" into a given graph. The three included are `usa.txt`, `usaMini.txt`, `usaTiny.txt`.
`MinPQ.java` is the priority queue used in Dijkstra's Algorithm. It's implemented with a heap. It's generic, but currently takes in `PairNode.java`'s which store a given city's Index and Weight. The weight is calculated based on pervious nodes.


### Notes
For more complicated solves, the algorithm can take several seconds. Please wait for it to solve. Upon trying to isolate why it's so slow, I believe it's due to the "visited" linkedlist searches. Though it saves space, a long array might be faster.



## Recursion Problem Set
I've included my solutions to a short recursion problem set, also from my aforementioned Data Strutures class. Each file is a solution to a unique problem.

As this was a while ago, I was unable to find the problems that were associated to these files; however, hopefully this suffice as non-trivial uses of recursion.
