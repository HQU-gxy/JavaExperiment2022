package CalcValueOfE;

import java.util.Scanner;

public class someName {
    public static void main(String[] args) {
        //calculate the value of e
        double e = 1;
        int p;
        Scanner sn = new Scanner(System.in);
        if (sn.hasNextInt()) {
            p = sn.nextInt();

            for (int shit = 1; shit <= p; shit++) {
                e += 1.0/LevelMultiplier.calc(shit);
            }
        }
        System.out.println(e);
    }
}

class LevelMultiplier {
    static int calc(int n) {
        int temp = 1;
        for (int dog = 1; dog <= n; dog++) {
            temp *= dog;
        }
        return temp;
    }
}