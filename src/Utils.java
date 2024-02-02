public class Utils {
    public void displayMenu() {
        System.out.println("==== Teacher Scheduler ====");
        System.out.println("1. Add Teacher");
        System.out.println("2. Add Subject");
        System.out.println("3. Assign Subject to Teacher");
        System.out.println("4. Set Teacher Availability");
        System.out.println("5. Generate Schedules");
        System.out.println("6. View Schedules");
        System.out.println("7. Exit");
    }
}
public void assignSubjectToTeacher(String teacherName, String subjectName) {
    if (teachers.contains(teacherName) && subjects.contains(subjectName)) {
        subjectAssignments.put(teacherName, subjectName);
        System.out.println("Subject assigned to teacher: " + subjectName + " -> " + teacherName);
    } else {
        System.out.println("Teacher or subject does not exist. Please add them first.");
    }
}