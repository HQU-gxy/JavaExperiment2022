package FourCalculations;

import java.util.Scanner;

public class someName {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        if (sn.hasNextDouble()) {
            AdvancedDouble a = new AdvancedDouble(sn.nextDouble());
            if (sn.hasNextDouble()) {
                AdvancedDouble b = new AdvancedDouble(sn.nextDouble());
                System.out.println(a.add(b));
                System.out.println(a.sub(b));
                System.out.println(a.mul(b));
                System.out.println(a.div(b));

            }
        }

    }
}

class AdvancedDouble {
    private double val;

    AdvancedDouble(double v) {
        val = v;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public double getVal() {
        return val;
    }

    public static AdvancedDouble add(final AdvancedDouble a, final AdvancedDouble b) {
        return new AdvancedDouble(a.val + b.val);
    }

    public static AdvancedDouble sub(final AdvancedDouble a, final AdvancedDouble b) {
        return new AdvancedDouble(a.val - b.val);
    }

    public static AdvancedDouble mul(final AdvancedDouble a, final AdvancedDouble b) {
        return new AdvancedDouble(a.val * b.val);
    }

    public static AdvancedDouble div(final AdvancedDouble a, final AdvancedDouble b) {
        return new AdvancedDouble(a.val / b.val);
    }

    public AdvancedDouble add(final AdvancedDouble b) {
        return new AdvancedDouble(this.val + b.val);
    }

    public AdvancedDouble sub(final AdvancedDouble b) {
        return new AdvancedDouble(this.val - b.val);
    }

    public AdvancedDouble mul(final AdvancedDouble b) {
        return new AdvancedDouble(this.val * b.val);
    }

    public AdvancedDouble div(final AdvancedDouble b) {
        return new AdvancedDouble(this.val / b.val);
    }

    @Override
    public String toString() {
        return ""+this.val;
    }
}