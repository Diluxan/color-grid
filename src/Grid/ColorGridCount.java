package Grid;

import java.util.Scanner;

public class ColorGridCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input N, X, Y");
        int n,x,y;
        n=input.nextInt();
        x=input.nextInt();
        y=input.nextInt();
        ColorGrid cg = new ColorGrid(n, x, y);
        System.out.println("Sample grid");
        cg.printGrid();
        System.out.println("\nSample grid with largest continous block marked by '0' symbol");
        int maxCount = cg.findMaxCount();
        System.out.println("Largest Continous Block Count: "+maxCount);
        cg.printGrid();
    }
}
