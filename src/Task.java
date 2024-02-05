import java.io.IOException;
import java.util.*;


public class Task {
    Scanner scanner=  new Scanner(System.in);
    List<Teacher> teacherList= new ArrayList<>();
    List<Subject> subjectList= new ArrayList<>();

    List<Schedule> scheduleList = new ArrayList<>();

    Subject defaultSubject = new Subject("Math");
    Subject subject2= new Subject("Physic");

    int id=2;

    public void displayMenu() {
        //default teacher 1
        Teacher teacher = new Teacher(0,"Mann");
        teacherList.add(teacher);

        Subject defaultSubject = new Subject("Khmer");
        Subject defaultSubject2 = new Subject("English");

        teacher.setSubjects(defaultSubject);
        defaultSubject.setAvailable(false);
        Availability availabilitMorning= new Availability(DayOfWeek.MONDAY,8,12);
        Availability availabilityAfternoon= new Availability(DayOfWeek.MONDAY,1,5);
        Availability availability3= new Availability(DayOfWeek.WEDNESDAY,7,11);

        teacher.setAvailabilities(availabilitMorning);
        teacher.setAvailabilities(availabilityAfternoon);
        subjectList.add(this.defaultSubject);
        subjectList.add(subject2);
        subjectList.add(defaultSubject2);
        subjectList.add(defaultSubject);

        //default teacher 2
        Teacher teacher1= new Teacher(1,"Lorng");
        teacher1.setSubjects(defaultSubject2);
        defaultSubject2.setAvailable(false);
        teacher1.setAvailabilities(availability3);

        teacherList.add(teacher1);




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
            System.out.println("7. Delete Schedule");

            System.out.println("0. Exit");


            System.out.println("Please select any option: ");

            Scanner scanner= new Scanner(System.in);
            if(scanner.hasNextInt()){
                 option=scanner.nextInt() ;
                 scanner.nextLine();
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
                                    scanner.nextLine();
                                    if (teacherOption == 1) {
                                        addTeacher();
                                    } else if (teacherOption == 2) {
                                        editTeacher();
                                    } else if (teacherOption == 3) {
                                        viewAllTeacher();
                                    } else if (teacherOption == 4) {

                                        searchTeahcerByName();
                                    } else if (teacherOption == 5) {
                                        deleteTeacherByName();
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
                                scanner.nextLine();
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
                            } while (true);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter an integer.");
                            scanner.nextLine();
                            scanner.nextLine();

                        }
                    }
                    case 3 -> assignSubjectToTeacher();
                    case 4 -> setTeacherAvailability();
                    case 5 -> generateSchedule();

                    case 6 -> viewSchedule();
//                    case 7 -> deleteSchedule();

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

    private void searchSubject() {
        System.out.println("=== Search Subject by name: ");
        Subject subjectFound=new Subject();
        boolean check=false;
        while(subjectFound.getName()==null){
            System.out.println("input the subject name : ");
            String searched=scanner.nextLine();
        for (Subject subject : subjectList) {
            if (subject.getName().equalsIgnoreCase(searched)) {
                System.out.println(subject.getName());
                System.out.println("==================================================================================================================================================================================================================================");
                subjectFound.setName(searched);
                check=true;
            }
        }
            if(!check){
                System.out.println("Oops, this subject cannot be found.");

            }
        }

        System.out.println( subjectFound );

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
        System.out.println("==================================================================================================================================================================================================================================");

        System.out.println("Please input the correct subject name to delete👌.");
        String nameSubject=scanner.nextLine();
        Iterator<Subject> iterator = subjectList.iterator();
        while (iterator.hasNext()) {
            Subject subject = iterator.next();
            if (subject.getName().equalsIgnoreCase(nameSubject)) {
                iterator.remove();
                System.out.println("==================================================================================================================================================================================================================================");

                System.out.println("Subject removed successfully💕💕!");
                System.out.println("==================================================================================================================================================================================================================================");

                break;
            }
            // Additional check for teacher not found:
            if (!iterator.hasNext()) {
                System.out.println("==================================================================================================================================================================================================================================");
                System.out.println("Subject not found in the list 😭.");
                System.out.println("==================================================================================================================================================================================================================================");

            }
        }


    }





    // teacher -----------------------------------------------
    private void searchTeahcerByName() {
        System.out.println("=== Find teacher === ");
        System.out.println("Please input the correct name to find: ");

        String tempName = scanner.nextLine();
        System.out.println("==================================================================================================================================================================================================================================");
        boolean check=false;
        for(Teacher teacher: teacherList){
            if( teacher.getName().equalsIgnoreCase(tempName)){
                System.out.println(teacher);
                System.out.println("==================================================================================================================================================================================================================================");
           check=true;
            }
        }if(!check){
            System.out.println("Sorry, this name cannot be found.");
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
            Teacher teacher1= new Teacher(id++,teacherName);
            teacherList.add(teacher1);
            System.out.println("Teacher "+teacher1.getName()+" added successfully.");

        }

    }
    private void setTeacherAvailability() {


        System.out.println("==================================================================================================================================================================================================================================");
        System.out.println("enter the correct teacher's name");
        String name= scanner.nextLine();
        boolean check= true;
        for (Teacher teacher: teacherList) {
            if(teacher.getName().equalsIgnoreCase(name)){
                System.out.println(teacher);
                System.out.println("enter the day of week (ex: monday) : ");
                String dayOfWeek= scanner.nextLine().toUpperCase();
                while(!validDayOfWeek(dayOfWeek)){
                    System.out.println("enter the teaching day (monday-sunday):  ");
                    dayOfWeek= scanner.nextLine().toUpperCase();
                }
                    Availability availability = new Availability();
                    availability.setDateOfWeek(DayOfWeek.valueOf(dayOfWeek));

                System.out.println("enter the teaching start time (24-hour format):  ");
                int startTime;
                if (scanner.hasNextInt()) {
                     startTime = scanner.nextInt();
                     scanner.nextLine();
                }else{
                    System.out.println("Opps, please input the valid start time.");
                    break;

                };
                System.out.println("enter the teaching end time (24-hour format):  ");

                int endTime;
                if (scanner.hasNextInt()) {
                    endTime = scanner.nextInt();
                }else {
                    System.out.println("Opps, please input the valid end time.");
                    break;

                }
                //
                    availability.setStartTime(startTime);
                    availability.setEndTime(endTime);
                    teacher.setAvailabilities(availability);
                    System.out.println(" The availability added successfully! ");

                }
                check=false;
            }
        if(check){
            System.out.println("Opps, this name cannot be found.");
        }
        }



    private void deleteTeacherByName() {
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
        boolean check= false;
        for(Teacher teacher: teacherList){
            if(teacher.getName().equals(tempName)){
                System.out.println(teacher);
                System.out.println("please input the new name.");
                String newName = scanner.nextLine();
                teacher.setName(newName);
                System.out.println("the name has changed successfully.");

                check=true;
            }
        }if(!check){
            System.out.println("==================================================================================================================================================================================================================================");

            System.out.println("Name cannot be found😭!");
            System.out.println("==================================================================================================================================================================================================================================");

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
                          sub.setAvailable(false);
                          teacher.setSubjects(sub);
                          System.out.println("==================================================================================================================================================================================================================================");
                          System.out.println("Subject "+sub.getName()+ " have successfully set to teacher "+teacher.getName()+" ❤️" );
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


    private boolean validTimeFormat(int time){

        return time >= 1 && time <= 24;

    }
    private boolean validDayOfWeek(String dayOfWeek){

        try {
            DayOfWeek day = DayOfWeek.valueOf(dayOfWeek.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(dayOfWeek + " is not a valid day of the week.");
            return false;

        }
    }
    int scheduleId=0;

    private void generateSchedule() {
        System.out.println("=== Schedule Generator ===");
        System.out.println("enter teacher name: ");
        String teacherName= scanner.nextLine();
        boolean loopCheckOut2=false;
        for(Teacher teacher: teacherList){
            if(teacher.getName().equalsIgnoreCase(teacherName)){
                System.out.println("==================================================================================================================================================================================================================================");
                System.out.println(teacher);
                System.out.println("==================================================================================================================================================================================================================================");

                System.out.println("enter the subject name:  ");
                String input= scanner.nextLine();
                boolean loopCheckOut=false;
                for(Subject subject1: teacher.getSubjects()){
                    if(subject1.getName().equalsIgnoreCase(input)){

                                System.out.println("enter the teaching day (monday-sunday):  ");
                                String dayOfWeek= scanner.nextLine().toUpperCase();
                                while(!validDayOfWeek(dayOfWeek)){
                                    System.out.println("enter the teaching day (monday-sunday):  ");
                                    dayOfWeek= scanner.nextLine().toUpperCase();
                                }
                                System.out.println("enter the teaching start time (24-hour format):  ");
                                int startTime= scanner.nextInt();
                                scanner.nextLine();
                                while(!validTimeFormat(startTime)){
                                    System.out.println("Please input the correct start time in 24-hour format");
                                    startTime= scanner.nextInt();
                                }
                                System.out.println("enter the teaching end time (24-hour format):  ");
                                int endTime= scanner.nextInt();
                                scanner.nextLine();
                                while(!validTimeFormat(endTime)){
                                    System.out.println("Please input the correct end time in 24-hour format");
                                    endTime= scanner.nextInt();
                                }
                                boolean check= false;
                                for(Availability availability2: teacher.getAvailabilities()){
                                    if((     startTime<endTime&&
                                            availability2.getStartTime() <= startTime && availability2.getStartTime() < endTime ) &&
                                            (      (availability2.getEndTime() > startTime) && availability2.getEndTime() >= endTime)&&
                                                availability2.isAvailability()

                                    ){
                                        Schedule schedule = new Schedule(scheduleId++,DayOfWeek.valueOf(dayOfWeek),startTime,endTime,teacher,input);
                                        System.out.println("==================================================================================================================================================================================================================================");

                                        System.out.println("Successfully generated a "+schedule);
                                        scheduleList.add(schedule);
                                        System.out.println("==================================================================================================================================================================================================================================");

                                        availability2.setAvailability(false);
                                        check=true;
                                    }

                                }

                        if(!check){
                                    System.out.println("teacher "+teacher.getName()+" is busy at that time, please kindly check for another time.");
                            scanner.nextLine();

                        }

                        scanner.nextLine();
                        loopCheckOut=true;
                            }
                        }
                   if(!loopCheckOut){
                    System.out.println("Subject not found");
                       System.out.println("back...");

                       scanner.nextLine();
                }
                loopCheckOut2=true;




                    }

                }
             if(!loopCheckOut2){
            System.out.println("Opps, this name cannot be found.");
            scanner.nextLine();
        }
        }





    private void viewSchedule() {

        if(scheduleList.isEmpty() ){
            System.out.println("==================================================================================================================================================================================================================================");
            System.out.println("Currently empty.");
            scanner.nextLine();

        }else{
            System.out.println("==================================================================================================================================================================================================================================");
            System.out.println("=== Schedule list ===");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            for(Schedule schedule:scheduleList){

                System.out.println(schedule);
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
            scanner.nextLine();

        }


    }




}
