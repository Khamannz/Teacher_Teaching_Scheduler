

public class Schedule {
    private DayOfWeek dateOfWeek;
    private int startTime;
    private int endTime;

    private Teacher teacher;

    public Schedule(DayOfWeek dateOfWeek, int startTime, int endTime, Teacher teacher) {
        this.dateOfWeek = dateOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacher = teacher;
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
                "dateOfWeek=" + dateOfWeek +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                " teacher: id= "+ teacher.getId() +" name: "+teacher.getName()+
                '}';
    }
}
