import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Students {

    public Integer id;
    public ArrayList<String> students;
    public HashMap<String, HashMap<String, Double>> journal;

    public Students(Integer id, ArrayList<String> students, HashMap<String, HashMap<String, Double>> journal) {
        this.id = id;
        this.students = students;
        this.journal = journal;
    }
    public void addStudent(String newStudent, HashMap<String,Double> newGradesOfSubjects) {
        this.students.add(newStudent);
        this.journal.put(newStudent, newGradesOfSubjects);
    }

     public void deleteStudent(String newStudent) {
         this.students.remove(newStudent);
         this.journal.remove(newStudent);
     }

     public void addSubject(String newSubject, Double newGrade, String student) {
        this.journal.get(student).put(newSubject, newGrade);
     }

     public void deleteSubject(String newSubject, String student) {
        this.journal.get(student).remove(newSubject);
     }

     public void changeGrade(String student, String subject, Double newGrade) {
        this.journal.get(student).put(subject, newGrade);
     }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", students=" + students +
                ", journal=" + journal +
                '}';
    }
}


class Test {

    public static void main(String[] args) {
        Students students1 = new Students(1, new ArrayList<>(), new HashMap<>());
        System.out.println(students1);
        HashMap<String, Double> marks1 = new HashMap<>();
        marks1.put("History", 5.0);
        marks1.put("Geo", 3.0);
        marks1.put("Math", 4.0);
        marks1.put("Rus", 5.0);

        String name = "Ilya Zhukov";
        students1.addStudent(name, marks1);
        System.out.println(students1);
        students1.addSubject("Bio", 2.0, name);
        students1.deleteSubject("Rus", name);
        System.out.println(students1);

        students1.addSubject("Bio", 4.0, name);
        System.out.println(students1);
        students1.changeGrade(name, "Bio", 5.0);
        System.out.println(students1);



    }
}
