import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import static edu.princeton.cs.algs4.StdDraw.show;

public class Sierpinski {
    public static void main (String[]args){
        drawSierpinskiTriangle(0.1,0.1,0.8,10);
    }

    public static void drawSierpinskiTriangle( double x, double y, double sideLength, int order){
        double sqrt3 = Math.sqrt(3);
        if(order==0){
            StdDraw.line(x,y,x+sideLength/2, y + sqrt3/2*sideLength);
            StdDraw.line(x+ sideLength/2, y + sqrt3/2*sideLength, x+sideLength, y);
            StdDraw.line(x,y,x+sideLength,y);
        } else {
            drawSierpinskiTriangle(x,y,sideLength/2,order-1);
            drawSierpinskiTriangle(x+sideLength/2,y,sideLength/2,order-1);
            drawSierpinskiTriangle(x+sideLength/4,y + sqrt3/4*sideLength,sideLength/2,order-1);
        }
    }
}
