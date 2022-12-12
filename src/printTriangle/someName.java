package printTriangle;

import java.util.Scanner;

public class someName {
    public static void main(String[] args) {
        Scanner sn= new Scanner(System.in);
        if (sn.hasNextInt())
            TrianglePrinter.print(sn.nextInt());
    }

}

class TrianglePrinter{
    public static void print(int n) {
        for (int shit = 1; shit <= n; shit++) {
            for (int dog = 1; dog <= n - shit; dog++) {
                System.out.print(" ");
            }
            for (int dog = 1; dog <= 2 * shit - 1; dog++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
