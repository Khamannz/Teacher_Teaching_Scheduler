

public class Schedule {
    private int id ;
    private DayOfWeek dateOfWeek;
    private int startTime;
    private int endTime;

    private Teacher teacher;
    private String subject;

    public Schedule(int id, DayOfWeek dateOfWeek, int startTime, int endTime, Teacher teacher, String subject) {
        this.id=id+1;
        this.dateOfWeek = dateOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacher = teacher;
        this.subject = subject;
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Schedule() {

    }


    public DayOfWeek getDateOfWeek() {
        return dateOfWeek;
    }

    public void setDateOfWeek(DayOfWeek dateOfWeek) {
        this.dateOfWeek = dateOfWeek;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }


    @Override
    public String toString() {
        return "Schedule{" +
                " id= " + id+
                ", subject= " + subject.toUpperCase()+
                ", dateOfWeek= " + dateOfWeek +
                ", startTime= " + startTime +
                ", endTime= " + endTime +
                " teacher: id= "+ teacher.getId() +" name: "+teacher.getName()+
                '}';
    }
}
