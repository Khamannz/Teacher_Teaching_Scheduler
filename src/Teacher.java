import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String name;
    private List<Availability> availabilities;
    private List<Subject> subjects;


    public List<Availability> getAvailabilities() {
        return availabilities;
    }

    public Teacher(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
        this.availabilities = new ArrayList<>();
    }

    public void setAvailabilities(Availability availability) {
      availabilities.add(availability);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Teacher() {
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
        stringBuilder.append("name='").append(name).append('\'');

        if (availabilities.isEmpty()) {
            stringBuilder.append(", availabilities=No data");
        } else {
            stringBuilder.append(", availabilities=").append(availabilities);

        }

        if (subjects.isEmpty()) {
            stringBuilder.append(", subjects=No data");
        } else {
                stringBuilder.append(", subjects=").append(subjects);
        }
        stringBuilder.append('.');
        return stringBuilder.toString();
    }


//    @Override
//    public String toString() {
//        return "Teacher: " +
//                "name='" + name + '\'' +
//                ", availabilities=" + availabilities +
//                ", subjects=" + subjects +
//                '.';
//    }
}
