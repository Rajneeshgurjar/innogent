import javax.swing.plaf.synth.SynthFormattedTextFieldUI;
import java.util.*;
public class Sms {
    Map<Integer,StdClass> classes = new HashMap<>();
    Map<Integer, Student> students = new HashMap<>();
    Map<Integer,Address> addresses = new HashMap<>();

    //adding new class
    public void addClass(StdClass stdClass){
        classes.put(stdClass.getId(),stdClass);
    }

    //adding new student with address
    public void addStudent(Student student, Address address){
        if(student.getAge()>20){
            System.out.println("we can not add "+student.getName()+" because it is overAge");
            return;
        }
        students.put(student.getId(),student);
        addresses.put(student.getId(),address);
    }

    //removing student and also address
    public void deleteStudent(int studentId) {
        Student s=null;
        if (students.containsKey(studentId)) {
            s=students.get(studentId);
            students.remove(studentId);
            addresses.remove(studentId);
            System.out.println("Deleted Student and their Address (id=" + studentId + ")");
        } else {
            System.out.println("Student not found with id=" + studentId);
            return;
        }
        //no students left in a class -> class remove
        int classId=s.getClass_id();
        boolean flag=true;
        for(Student std:students.values()){
            if(classId==std.getClass_id()){
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println("class ->"+classes.get(classId)+"is deleted because No student is left");
            classes.remove(classId);
        }
    }

    //all the student in sms
    public void showAllStudents() {
        for (Student s : students.values()) {
            StdClass c = classes.get(s.getClass_id());
            Address a = addresses.get(s.getId());
            System.out.println(s + " \t Class=" + (c != null ? c.getName() : "N/A") +
                    " \t Address=" + (a != null ? a.toString() : "N/A"));
        }
    }


    //ranking of all student
    public void showRanking() {
        System.out.println("\nStudent Ranking by Marks =>>");
        List<Student> sortedList = new ArrayList<>(students.values());

        sortedList.sort((s1, s2) -> Integer.compare(s2.getMarks(), s1.getMarks()));

        int rank = 1;
        for (int i = 0; i < sortedList.size(); i++) {
            Student s = sortedList.get(i);


            if (i > 0 && s.getMarks() == sortedList.get(i - 1).getMarks()) {

                System.out.println("Rank " + --rank + " → " +
                        s.getName() + "\t Marks=" + s.getMarks() +
                        " \t Result_Status=" + s.getResult_status());

            } else {
                System.out.println("Rank " + rank + " → " +
                        s.getName() + "\t Marks=" + s.getMarks() +
                        " \t Result_Status=" + s.getResult_status());
            }
            rank++;
        }
    }

    //filter pincode
    public void findStudentsByPincode(int pincode, char gender, Integer age, Integer classId) {
        System.out.println("\nStudents with Pincode " + pincode + ":");

        for (Student s : students.values()) {
            Address a = addresses.get(s.getId());
            StdClass c = classes.get(s.getClass_id());

            // Check pincode first
            if (a != null && a.getPin_code() == pincode) {

                // Apply optional filters
                if ((gender == '\0' || s.getGender() == gender) &&
                        (age == null || s.getAge() == age) &&
                        (classId == null || s.getClass_id() == classId)) {

                    System.out.println(s + " \t Class=" + (c != null ? c.getName() : "N/A") +
                            " \t Address=" + a);
                }
            }
        }
    }


    //filter city
    public void findStudentsByCity(String city, char gender, Integer age, Integer classId) {
        System.out.println("\nStudents with City " + city + ":");

        for (Student s : students.values()) {
            Address a = addresses.get(s.getId());
            StdClass c = classes.get(s.getClass_id());

            // Check pincode first
            if (a != null && a.getCity().equals(city)) {

                // Apply optional filters
                if ((gender == '\0' || s.getGender() == gender) &&
                        (age == null || s.getAge() == age) &&
                        (classId == null || s.getClass_id() == classId)) {

                    System.out.println(s + " \t Class=" + (c != null ? c.getName() : "N/A") +
                            " \t Address=" + a);
                }
            }
        }
    }

    //filter Class
    public void findStudentsByClass(String className, char gender, Integer age, String city, Integer pincode) {
        System.out.println("\nStudents of Class = " + className + ":");

        for (Student s : students.values()) {
            StdClass c = classes.get(s.getClass_id());
            Address a = addresses.get(s.getId());

            if (c != null && c.getName().equalsIgnoreCase(className)) {

                // Apply optional filters
                if ((gender == '\0' || s.getGender() == gender) &&
                        (age == null || s.getAge() == age) &&
                        (city == null || (a != null && a.getCity().equalsIgnoreCase(city))) &&
                        (pincode == null || (a != null && a.getPin_code() == pincode))) {

                    System.out.println(s + " \t Class=" + c.getName() +
                            " \t Address=" + (a != null ? a : "N/A"));
                }
            }
        }
    }

    //filter pass
    public void findStudentsWhoArePassed(char gender, Integer age, String city, Integer pincode, String stdClass){
        System.out.println("\nStudents who Passed :");
        for (Student s : students.values()) {
            StdClass c = classes.get(s.getClass_id());
            Address a = addresses.get(s.getId());
            if(s.getResult_status().equals("Passed")){
                if ((gender == '\0' || s.getGender() == gender) &&
                        (age == null || s.getAge() == age) &&
                        (city == null || (a != null && a.getCity().equalsIgnoreCase(city))) &&
                        (pincode == null || (a != null && a.getPin_code() == pincode)) &&
                        (stdClass == null || c.getName().equalsIgnoreCase(stdClass))) {

                    System.out.println(s + " \t Class=" + c.getName() +
                            " \t Address=" + (a != null ? a : "N/A"));
                }
            }
        }
    }

    public void findStudentsWhoAreFailed(char gender, Integer age, String city, Integer pincode, String stdClass){
        System.out.println("\nStudents who Failed :");
        for (Student s : students.values()) {
            StdClass c = classes.get(s.getClass_id());
            Address a = addresses.get(s.getId());
            if(s.getResult_status().equals("Failed")){
                if ((gender == '\0' || s.getGender() == gender) &&
                        (age == null || s.getAge() == age) &&
                        (city == null || (a != null && a.getCity().equalsIgnoreCase(city))) &&
                        (pincode == null || (a != null && a.getPin_code() == pincode)) &&
                        (stdClass == null || c.getName().equalsIgnoreCase(stdClass))) {

                    System.out.println(s + " \t Class=" + c.getName() +
                            " \t Address=" + (a != null ? a : "N/A"));
                }
            }
        }
    }

    //read students in a paginated way
    public void pagination(int start,int end, String orderBy){
        System.out.println("\nStudents data according paginated way with filters : ");
        List<Student> stdList=new ArrayList<>(students.values());

        if ("name".equalsIgnoreCase(orderBy)) {
            stdList.sort(Comparator.comparing(Student::getName));
        }
        else if ("marks".equalsIgnoreCase(orderBy)) {
            stdList.sort((s1, s2) -> Integer.compare(s2.getMarks(), s1.getMarks())); // highest first
        }
        int size = stdList.size();
        int startIndex=Math.min(0,start-1);
        int endIndex=Math.min(end,size);
        if(startIndex>size){
            System.out.println("There is no student available for this indexes");
            return;
        }
        List<Student> finalList=stdList.subList(startIndex,endIndex);
        System.out.println("Students from index "+start+" to "+end+" and order by "+orderBy+" : ");
        for(Student s:finalList){
            System.out.println(s);
        }

    }



}
