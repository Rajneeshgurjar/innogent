class Student{
    private int id;
    private String name;
    private int class_id;
    private int marks;
    private char gender;
    private  int age;
    private  String result_status;

    public Student() {
    }

    public Student(int id, String name, int class_id, int marks, char gender, int age) {
        this.id = id;
        this.name = name;
        this.class_id = class_id;
        this.marks = marks;
        this.gender = gender;
        this.age = age;
        this.result_status = (marks < 50) ? "Failed" : "Passed";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getMarks() {
        return marks;
    }



    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void updateMarks(int newMarks) {
        this.marks = newMarks;
        this.result_status = (marks < 50) ? "Failed" : "Passed"; // auto-update
    }

    public String getResult_status() {
        return result_status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", class_id=" + class_id +
                ", marks=" + marks +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}