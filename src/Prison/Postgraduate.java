package Prison;

import java.util.ArrayList;

public class Postgraduate extends Student {
    private String tutor, topic;
    private ArrayList<String> thesis;

    Postgraduate(String name, int id, Gender gender, String homeTown, float height, ArrayList<Course> courses, String major, String college, String department, String tutor, String topic, ArrayList<String> thesis) {
        super(name, id, gender, homeTown, height, courses, major, college, department);
        this.tutor = tutor;
        this.topic = topic;
        this.thesis = thesis;
    }

    void updateTutor(String leader)
    {
        this.tutor = leader;
    }

    void updateTopic(String topic)
    {
        this.topic = topic;
    }

    void updateThesis(ArrayList<String> thesis)
    {
        this.thesis = thesis;
    }

    public String toString() {
        StringBuilder thesis = new StringBuilder();
        for (String s : this.thesis) {
            thesis.append(s).append(", ");
        }
        return super.toString() +  "\nTopic: " +topic+"\nLeader: " + tutor + "\nThesis: " + thesis;
    }

}
