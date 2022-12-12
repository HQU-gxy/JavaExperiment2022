package Prison;

import org.json.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class someName {

    public static void main(String[] args) {
        ArrayList<Student> ss = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Postgraduate> ps = new ArrayList<>();

        Scanner sn = new Scanner(System.in);

        JSONObject studentsInfo = new JSONObject(new JSONTokener(Objects.requireNonNull(someName.class.getResourceAsStream("students.json"))));

        for (Object student : studentsInfo.getJSONArray("students")) {
            JSONObject s = (JSONObject) student;
            parseCourse(s.getJSONArray("courses"), courses);
            ss.add(new Student(s.getString("name"), s.getInt("id"),
                    s.getString("gender").equals("male") ? Student.Gender.Male : Student.Gender.Female,
                    s.getString("homeTown"), s.getInt("height"), courses, s.getString("major"),
                    s.getString("college"), s.getString("department")));
        }

        for (Object student : studentsInfo.getJSONArray("postgraduates")) {
            JSONObject s = (JSONObject) student;
            parseCourse(s.getJSONArray("courses"), courses);
            ArrayList<String> thesisList = new ArrayList<>();
            for (Object t : s.getJSONArray("thesis")) {
                thesisList.add((String) t);
            }
            ps.add(new Postgraduate(s.getString("name"), s.getInt("id"),
                    s.getString("gender").equals("male") ? Student.Gender.Male : Student.Gender.Female,
                    s.getString("homeTown"), s.getInt("height"), courses,
                    s.getString("major"), s.getString("college"), s.getString("department"),
                    s.getString("tutor"), s.getString("topic"), thesisList));
        }


        while (true) {
            System.out.println("##############################################");
            System.out.println("#  0. Print all students' info               #");
            System.out.println("#  1. Print all courses' info                #");
            System.out.println("#  2. Query student info by student ID       #");
            System.out.println("#  3. Query student info by student name     #");
            System.out.println("#  4. Query course info by course ID         #");
            System.out.println("#  5. Go sleep                               #");
            System.out.println("##############################################");
            System.out.print("Please enter your choice: ");
            if (sn.hasNextInt()) {
                int choice = sn.nextInt();
                switch (choice) {
                    case 0:
                        System.out.println("---------Undergraduates Info----------");
                        for (Student student : ss) {
                            System.out.println(student);
                            student.checkFuckedUpCourses();
                            student.printCredits();
                            System.out.println();

                        }

                        System.out.println("---------Postgraduates Info----------");
                        for (Postgraduate postgraduate : ps) {
                            System.out.println(postgraduate);
                            postgraduate.checkFuckedUpCourses();
                            postgraduate.printCredits();
                            System.out.println();
                        }

                        break;

                    case 1:
                        System.out.println("---------Courses Info----------");
                        ss.get(0).printCourses();
                        System.out.println();
                        for (Course c : courses) {
                            System.out.println(c.getName());
                            System.out.println("\tAvrCredit: " + c.getAvrCredit(ss));
                            System.out.println("\tMaxCredit: " + c.getMaxCredit(ss));
                            System.out.println("\tMinCredit: " + c.getMinCredit(ss));
                            System.out.println();
                        }
                        break;

                    case 2:
                        System.out.print("Please enter student ID: ");
                        if (sn.hasNextInt()) {
                            int id = sn.nextInt();
                            for (Student s : ss) {
                                if (s.getId() == id) {
                                    System.out.println(s);
                                    System.out.println();
                                }
                            }
                            for (Postgraduate s: ps) {
                                if (s.getId() == id) {
                                    System.out.println(s);
                                    System.out.println();
                                }
                            }
                        }

                        break;

                    case 3:
                        System.out.print("Please enter student name: ");
                        if (sn.hasNext()) {
                            sn.nextLine();
                            String name = sn.nextLine();

                            for (Student s : ss) {
                                if (s.getName().equals(name)) {
                                    System.out.println(s);
                                    System.out.println();
                                }
                            }
                            for (Postgraduate s : ps) {
                                if (s.getName().equals(name)) {
                                    System.out.println(s);
                                    System.out.println();
                                }
                            }
                        }

                        break;

                    case 4:
                        System.out.print("Please enter course ID: ");
                        if (sn.hasNextInt()) {
                            int cid = sn.nextInt();
                            for (Course c : courses) {
                                if (c.getId() == cid) {
                                    System.out.println(c);
                                    System.out.println("\tAvrCredit: " + c.getAvrCredit(ss));
                                    System.out.println("\tMaxCredit: " + c.getMaxCredit(ss));
                                    System.out.println("\tMinCredit: " + c.getMinCredit(ss));
                                    System.out.println();
                                }
                            }

                        }


                        break;

                    case 5:
                        System.out.println("Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }


    }


    private static void parseCourse(JSONArray coursesJSON, ArrayList<Course> courses) {
        courses.clear();
        for (Object course : coursesJSON) {
            JSONObject c = (JSONObject) course;

            courses.add(new Course(c.getString("name"), c.getInt("id"),
                    c.getString("type").equals("Optional") ? Course.Type.Optional : Course.Type.Necessary,
                    (short) c.getInt("credit")));
        }
    }


}


