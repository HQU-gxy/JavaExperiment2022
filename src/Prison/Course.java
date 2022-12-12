package Prison;

import java.util.ArrayList;

public class Course {
    public enum Type {
        Necessary , Optional
    }

    protected final String name;
    protected final int id;
    protected final Type type;
    protected short credit;

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    public void setCredit(short credit) {
        this.credit = credit;
    }

    Course(String name, int id, Type type,short credit) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.credit = credit;
    }

    public short getCredit() {
        return credit;
    }

    public float getAvrCredit(ArrayList<Student> students) {
        float sum = 0;
        for (Student stu : students) {
            sum += stu.getCreditById(id);
        }
        return sum / students.size();
    }

    public short getMaxCredit(ArrayList<Student> students) {
        short max = 0;
        for (Student stu : students) {
            short temp = stu.getCreditById(id);
            if (temp > max)
                max = temp;
        }
        return max;
    }

    public short getMinCredit(ArrayList<Student> students) {
        short min = 100;
        for (Student stu : students) {
            short temp = stu.getCreditById(id);
            if (temp < min)
                min = temp;
        }
        return min;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nID: " + id + "\nType: " + type;
    }

}