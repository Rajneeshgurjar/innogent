public class SchoolApp {
    public static void main(String ar[]){
        Sms sms=new Sms();

        StdClass class_1=new StdClass(1,"class10th");
        StdClass class_2=new StdClass(2,"class11thPCM");
        StdClass class_3=new StdClass(3,"class12thCOMM");

        sms.addClass(class_1);
        sms.addClass(class_2);
        sms.addClass(class_3);

        Student student_1=new Student(101,"Rudra",2,80,'M',18);
        Address add_1=new Address(1001,452010,"Indore",101);
        sms.addStudent(student_1,add_1);

        Student student_2=new Student(102,"Sourabh",1,85,'M',16);
        Address add_2=new Address(1002,455001,"Dewas",102);
        sms.addStudent(student_2,add_2);

        Student student_3=new Student(103,"Jyoti",3,15,'F',20);
        Address add_3=new Address(1003,452001,"Indore",103);
        sms.addStudent(student_3,add_3);

        Student student_4=new Student(104,"Rajneesh",2,80,'M',12);
        Address add_4=new Address(1004,452010,"Indore",104);
        sms.addStudent(student_4,add_4);

        Student student_5=new Student(105,"Raghav",1,90,'M',13);
        Address add_5=new Address(1005,462001,"Bhopal",105);
        sms.addStudent(student_5,add_5);

        Student student_6=new Student(106,"Kirtan",3,70,'M',22);
        Address add_6=new Address(1006,461441,"Khirkiya",106);
        sms.addStudent(student_6,add_6);

        Student student_7=new Student(107,"Shruti",2,77,'M',17);
        Address add_7=new Address(1007,462002,"Bhopal",107);
        sms.addStudent(student_7,add_7);

        Student student_8=new Student(108,"Fake",3,10,'M',0);
        Address add_8=new Address(1008,4661331,"Harda",108);
        sms.addStudent(student_8,add_8);

        sms.showAllStudents();
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
        sms.showRanking();
        System.out.println("--------------------------------------------------------------");
        sms.findStudentsByPincode(452010,'\0',null,null);

        System.out.println("--------------------------------------------------------------");
        sms.findStudentsByCity("Indore",'\0',null,null);

        System.out.println("--------------------------------------------------------------");
        sms.findStudentsByClass("class10th",'\0',null,null,null);

        System.out.println("--------------------------------------------------------------");
        sms.findStudentsWhoArePassed('\0',null,null,null,null);

        System.out.println("--------------------------------------------------------------");
        sms.findStudentsWhoAreFailed('\0',null,null,null,null);

        System.out.println("--------------------------------------------------------------");
        sms.deleteStudent(108);

        System.out.println("--------------------------------------------------------------");
        sms.pagination(2,5,"name");


   }
}
