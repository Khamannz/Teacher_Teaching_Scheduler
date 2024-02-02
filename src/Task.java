import javax.print.attribute.standard.SheetCollate;
import java.io.IOException;
import java.util.*;

public class Task {
    Scanner scanner=  new Scanner(System.in);
    List<Teacher> teacherList= new ArrayList<>();
    List<Subject> subjectList= new ArrayList<>();



    Subject subject= new Subject("Math");
    Subject subject2= new Subject("Physic");



    public void displayMenu() {
        Teacher teacher = new Teacher("Mann");
        teacherList.add(teacher);


        subjectList.add(subject);
        subjectList.add(subject2);

        boolean flag=true;
        int option;

        do{
            System.out.println("==================================================================================================================================================================================================================================");

            System.out.println("==== Teacher Scheduler ====");
            System.out.println("1. Teacher");
            System.out.println("2. Subject");
            System.out.println("3. Assign Subject to Teacher");
            System.out.println("4. Set Teacher Availability");
            System.out.println("5. Generate Schedules");
            System.out.println("6. View Schedules");
            System.out.println("0. Exit");


            System.out.println("Please select any option: ");

            Scanner scanner= new Scanner(System.in);
            if(scanner.hasNextInt()){
                 option=scanner.nextInt() ;
                switch (option) {
                    case 0 -> {
                        System.out.println("==================================================================================================================================================================================================================================");

                        System.out.println("Application closed. Thank You ❤️❤️");
                        System.out.println("==================================================================================================================================================================================================================================");

                        flag = false;
                    }
                    case 1 -> {
                        boolean caseFlag = true;

                            do {
                                try {

                                    System.out.println("==== Teacher Section ====");
                                    System.out.println("1. Add Teacher");
                                    System.out.println("2. Edit Teacher By Name");
                                    System.out.println("3. View Teacher");
                                    System.out.println("4. Search Teacher By Name");
                                    System.out.println("5. Delete Teacher");
                                    System.out.println("0. Back");


                                    System.out.println("Please pick a valid option: ");
                                    int teacherOption = scanner.nextInt();
                                    if (teacherOption == 1) {
                                        addTeacher();
                                    } else if (teacherOption == 2) {
                                        editTeacher();
                                    } else if (teacherOption == 3) {
                                        viewAllTeacher();
                                    } else if (teacherOption == 4) {
                                        System.out.println("== Find teacher: ");
                                        System.out.println("Please input the correct name😭.");
                                        scanner.nextLine(); // Consume the newline character

                                        String tempName = scanner.nextLine();
                                        searchTeahcerByName(tempName);
                                    } else if (teacherOption == 5) {
                                        deleteTeahcerByName();
                                    } else if (teacherOption == 0) {
                                        System.out.println("==================================================================================================================================================================================================================================");
                                        caseFlag = false;
                                    } else {
                                        System.out.println("==================================================================================================================================================================================================================================");

                                        System.out.println("please select the valid number😭.");

                                    }
                                }catch(InputMismatchException e){
                                    System.out.println("==================================================================================================================================================================================================================================");
                                    System.out.println("please select the valid option 😭.");
                                    System.out.println("==================================================================================================================================================================================================================================");
                                    scanner.nextLine();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            } while (caseFlag);

                    }
                    case 2 -> {
                        boolean case2Flag = true;
                        try {
                            do {
                                System.out.println("==== Subject Section ====");
                                System.out.println("1. Add Subject");
                                System.out.println("2. Edit Subject By Name");
                                System.out.println("3. View Subject");
                                System.out.println("4. Search Subject");
                                System.out.println("5. Delete Subject");
                                System.out.println("0. Back");
                                System.out.println("Please pick a valid option: ");
                                int subjectOption = scanner.nextInt();
                                if (subjectOption == 1) {
                                    addSubject();
                                } else if (subjectOption == 2) {
                                    editSubject();
                                } else if (subjectOption == 3) {
                                    viewAllSubject();
                                } else if (subjectOption == 4) {
                                    searchSubject();
                                } else if (subjectOption == 5) {
                                    deleteSubjectByName();
                                } else if (subjectOption == 0) {
                                    System.out.println("==================================================================================================================================================================================================================================");
                                    break;
                                } else {
                                    System.out.println("please select the valid number.");
                                }
                            } while (case2Flag);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter an integer.");
                        }
                    }
                    case 3 -> assignSubjectToTeacher();
                    case 4 -> setTeacherAvailability();
                    case 5 -> generateSchedule();
                    case 6 -> viewSchedule();
                    default -> System.out.println("Invalid option. Please choose a valid option.");

                    // Additional logic or instructions can be added here
                }
            }else {
                System.out.println("==================================================================================================================================================================================================================================");

                System.out.println("invalid input.");
                System.out.println("==================================================================================================================================================================================================================================");

            }

        }while(flag);

    }


    // subject -----------------------------------------------

    private void searchSubject(){
        try{
            System.out.println("==================================================================================================================================================================================================================================");

            System.out.println("input the subject name : ");
            String searched=scanner.nextLine();
            for (Subject subject:subjectList){
                if(subject.getName().contains(searched)){
                    System.out.println(subject.getName());
                    System.out.println("==================================================================================================================================================================================================================================");
                }
            }
        }catch (InputMismatchException e){
            System.out.println("==================================================================================================================================================================================================================================");

            System.out.println("Invalid input! Please enter an integer.");
            System.out.println("==================================================================================================================================================================================================================================");


        }

    }
    private void addSubject() {
        System.out.println("==================================================================================================================================================================================================================================");

        System.out.println("Please the subject name.");
        String subjectName= scanner.nextLine();
        subjectList.add(new Subject(subjectName));
    }
    private void editSubject() {
        System.out.println("==================================================================================================================================================================================================================================");

        System.out.println("please input the old subject name correctly.");
        String inputName= scanner.nextLine();
        for(Subject subject : subjectList){
            if(subject.getName().equalsIgnoreCase(inputName)){
                System.out.println("please input the new name.");
                String newName= scanner.nextLine();
                subject.setName(newName);
            }
            else{
                System.out.println("==================================================================================================================================================================================================================================");

                System.out.println("Opps, this name cannot be found");
                System.out.println("==================================================================================================================================================================================================================================");

                break;
            }

        }

    }

    private void viewAllSubject() {
        System.out.println("==================================================================================================================================================================================================================================");

        for(Subject subject: subjectList){
            if(subject.isAvailable()){
                System.out.println(subject.getName()+" available ✅");
            }
            else{
                System.out.println(subject.getName()+" available ❌");

            }
            System.out.println("==================================================================================================================================================================================================================================");

        }
    }

    private void deleteSubjectByName() {
    }





    // teacher -----------------------------------------------
    private void searchTeahcerByName(String nameTeacher) {
        System.out.println("==================================================================================================================================================================================================================================");

        for(Teacher teacher: teacherList){
            if( teacher.getName().contains(nameTeacher)){
                System.out.println(teacher);
                System.out.println("==================================================================================================================================================================================================================================");
            }
        }
    }



    private void addTeacher() {
        System.out.println("==================================================================================================================================================================================================================================");

        System.out.print("enter the teacher's name: ");
        String teacherName= scanner.nextLine();
        boolean nameRedundancy=false;
        for(Teacher teacher:teacherList){
            if(teacher.getName().equalsIgnoreCase(teacherName)){
                System.out.println("Opps, this name is already exist 🥲");
                nameRedundancy=true;
            }
        }
        if(!nameRedundancy){
            Teacher teacher1= new Teacher(teacherName);
            teacherList.add(teacher1);
            System.out.println("Teacher "+teacher1.getName()+" added successfully.");

        }

    }
    private void setTeacherAvailability() {


        System.out.println("==================================================================================================================================================================================================================================");
        System.out.println("enter the correct teacher's name");
        String name= scanner.nextLine();
        for (Teacher teacher: teacherList) {
            if(teacher.getName().equalsIgnoreCase(name)){
                System.out.println(teacher);
                String dayOfWeek;
                try{
                    System.out.println("enter the day of week (ex: monday) : ");
                     dayOfWeek= scanner.nextLine().toUpperCase();
                    DayOfWeek day= DayOfWeek.valueOf(dayOfWeek);
//                    System.out.println("dayOfWeek"+ dayOfWeek+ " " + DayOfWeek.valueOf(dayOfWeek) );
                    Availability availability = new Availability();
                    availability.setDateOfWeek(day);
                    System.out.println("enter the start time: ");
                    int startTime=scanner.nextInt();
                    System.out.println("enter the end time: ");
                    int endTime=scanner.nextInt();

                    availability.setStartTime(startTime);
                    availability.setEndTime(endTime);
                    teacher.setAvailabilities(availability);
                    System.out.println(" The availability added successfully! ");

                }catch (IllegalArgumentException e) {
                    System.out.println("Invalid day entered. Please enter one of the seven days, hint: Monday.");
                }

            }
        }

    }

    private void deleteTeahcerByName() {
        System.out.println("==================================================================================================================================================================================================================================");

        System.out.println("Please input the correct teacher name to find them and delete👌.");
        String searchedName=scanner.nextLine();
        Iterator<Teacher> iterator = teacherList.iterator();
        while (iterator.hasNext()) {
            Teacher teacher = iterator.next();
            if (teacher.getName().equals(searchedName)) {
                iterator.remove();
                System.out.println("==================================================================================================================================================================================================================================");

                System.out.println("Teacher removed successfully💕💕!");
                System.out.println("==================================================================================================================================================================================================================================");

                break;
            }
            // Additional check for teacher not found:
            if (!iterator.hasNext()) {
                System.out.println("==================================================================================================================================================================================================================================");

                System.out.println("Teacher not found in the list 😭.");
                System.out.println("==================================================================================================================================================================================================================================");

            }
        }

    }

    private void viewAllTeacher() throws IOException{
        System.out.println("==================================================================================================================================================================================================================================");
        if(teacherList.isEmpty()){
            System.out.println("There is no teacher in the list currently😭.");
            System.out.println("==================================================================================================================================================================================================================================");
            System.out.println("Press any key to continue...");
            scanner.nextLine();

        }
        else{
            System.out.println("List of all the teachers: ");

            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for(Teacher teacher: teacherList){
                System.out.println(teacher.toString());
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            }
            scanner.nextLine();


        }

    }

    private void editTeacher() {
        System.out.println("Please input the correct teacher name to find them👌.");
        String tempName= scanner.nextLine();
        for(Teacher teacher: teacherList){
            if(teacher.getName().equals(tempName)){
                System.out.println(teacher);
                System.out.println("please input the new name.");
                String newName = scanner.nextLine();
                teacher.setName(newName);
            }else{
                System.out.println("==================================================================================================================================================================================================================================");

                System.out.println("Name cannot be found😭!");
                System.out.println("==================================================================================================================================================================================================================================");

            }
        }
    }




    //core -------------------------------------------------



    private void assignSubjectToTeacher() {

        System.out.println("== Assign subject to teacher ==");
        for(Teacher teacher: teacherList){
            System.out.println(teacher);
            System.out.println("==================================================================================================================================================================================================================================");
        }

        System.out.println("enter the teacher name: ");
        String name= scanner.nextLine();
        boolean bb=true;
        for(Teacher teacher: teacherList){
            if(teacher.getName().equalsIgnoreCase(name)){
                System.out.println("==================================================================================================================================================================================================================================");
                System.out.println(teacher);
                System.out.println("==================================================================================================================================================================================================================================");




                System.out.println("Available Subjects:");
                //displayAvailableSubjects();
                viewAllSubject();
                System.out.println("enter the available subject you want to assign to this teacher.");
                String tempSubject= scanner.nextLine();
                boolean tempCheck=false;
                for(Subject sub: subjectList){
                  if(sub.getName().equalsIgnoreCase(tempSubject)){
                      if(sub.isAvailable()){
                          Subject assignedSubject= new Subject();
                          List<Subject> subjects= new ArrayList<>();
                          sub.setAvailable(false);
                          subjects.add(sub);
                          teacher.setSubjects(subjects);
                          System.out.println("==================================================================================================================================================================================================================================");
                          System.out.println("Subject "+sub.getName()+ " have successfully set to teacher "+teacher.getName()+" ✅" );
                          tempCheck=true;
                      }
                    else{
                          System.out.println("==================================================================================================================================================================================================================================");

                          System.out.println("this subject is unavailable😭.");
                          System.out.println("==================================================================================================================================================================================================================================");

                          tempCheck=true;

                      }
                  }

               }
                if(!tempCheck){
                    System.out.println("==================================================================================================================================================================================================================================");

                    System.out.println("subject cannot be found😭.");
                    scanner.nextLine();  // Wait for the user to press Enter
                    System.out.println("==================================================================================================================================================================================================================================");

                }
                bb=false;
            }
        }if(bb) {
            System.out.println("==================================================================================================================================================================================================================================");

            System.out.println("teacher cannot be found 🥲.");
            scanner.nextLine();
            System.out.println("==================================================================================================================================================================================================================================");

        }


    }

    private void generateSchedule() {

        Schedule schedule = new Schedule(DayOfWeek.MONDAY,12,14);
        schedule.setTeacherSchedule("Math",new Teacher("kha mann"));
        System.out.println(schedule);

    }


    private void viewSchedule() {

    }




}
