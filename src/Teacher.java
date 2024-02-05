import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int id;
    private String name;
    private List<Availability> availabilities;
    private List<Subject> subjects;


    public List<Availability> getAvailabilities() {
        return availabilities;
    }

    public Teacher(int id, String name) {
        this.id = id+1;
        this.name = name;
        availabilities = new ArrayList<>();
        subjects = new ArrayList<>();
    }

    public void setAvailabilities(Availability availability) {
      availabilities.add(availability);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject subject) {
        subjects.add(subject);
    }

    public Teacher() {
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Availability> availabilities() {
        return availabilities;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Teacher: ");
        stringBuilder.append("id='").append(id).append('\'');
        stringBuilder.append(", name='").append(name).append('\'');

        if (availabilities.isEmpty()) {
            stringBuilder.append(", availabilities=No data");
        } else {
            stringBuilder.append(", availabilities=").append(availabilities);

        }

        if (subjects.isEmpty()) {
            stringBuilder.append(", subjects=No data");
        } else {
            for(Subject subject: subjects){
                stringBuilder.append(", subjects=").append(subject.getName());
            }
        }
        stringBuilder.append('.');
        return stringBuilder.toString();
    }



}
