import java.util.HashMap;
import java.util.Map;

public class Schedule {
    private DayOfWeek dateOfWeek;
    private int startTime;
    private int endTime;

    Map<String, Teacher> teacherSchedule;

    public Schedule(DayOfWeek dateOfWeek, int startTime, int endTime) {
        this.dateOfWeek = dateOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacherSchedule = new HashMap<>();
    }

    public void setTeacherSchedule(String subject, Teacher teacher) {
        teacherSchedule.put(subject,teacher);
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

    public Map<String, Teacher> getTeacherSchedule() {
        return teacherSchedule;
    }



    @Override
    public String toString() {
        return "Schedule{" +
                "dateOfWeek='" + dateOfWeek + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", teacherSchedule=" + teacherSchedule +
                '}';
    }
}
