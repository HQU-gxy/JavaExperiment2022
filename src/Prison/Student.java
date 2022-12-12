package Prison;


import java.util.ArrayList;

class Student {
    public void printCourses() {
        for (Course course : courses) {
            System.out.println(course);
            System.out.println();
        }
    }

    public void printCredits() {
        for (Course course : courses) {
            System.out.println(course.getName() + ": " + course.getCredit());
        }
    }

    enum Gender {
        Male, Female
    }

    protected final String name;
    protected final int id;
    protected Gender gender;
    protected final String homeTown;
    protected float height;
    protected ArrayList<Course> courses;
    protected String major;
    protected final String college;
    protected String department;

    Student(String name, int id, Gender gender, String homeTown, float height, ArrayList<Course> courses, String major, String college, String department) {
        this.name = name;
        this.id = id;
        this.college = college;
        this.department = department;
        this.gender = gender;
        this.homeTown = homeTown;
        this.height = height;
        this.major = major;
        this.courses = new ArrayList<>(courses);

    }

    public short getCreditById(int id) {
        for (Course c : courses) {
            if (c.getId() == id)
                return c.getCredit();
        }
        return 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void checkFuckedUpCourses() {
        for (Course c : courses) {
            if (c.getCredit() < 60) {
                System.out.println(name + ", your " + c.getName() + " course is fucked up!");
            }
        }
    }


    public String toString() {
        return "Name: " + name + "\nID:" + id + "\nGender:" + gender + "\nHomeTown:" + homeTown + "\nHeight:" + height + "\nMajor:" + major + "\nCollege:" + college + "\nDepartment:" + department;
    }
}
