public class Availability {
    private DayOfWeek dateOfWeek;
    private int startTime;
    private int endTime;

    public Availability(DayOfWeek dateOfWeek, int startTime, int endTime) {
        this.dateOfWeek = dateOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Availability() {

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
        return "Availability{" +
                "dateOfWeek=" + dateOfWeek +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
