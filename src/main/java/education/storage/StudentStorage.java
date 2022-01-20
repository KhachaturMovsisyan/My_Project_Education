package education.storage;



import education.data.DataClass;
import education.exception.UserNotFoundException;
import education.model.Student;

import java.util.LinkedList;
import java.util.List;

public class StudentStorage {
    private List<Student> studentList = new LinkedList<>();

    public void add(Student student) {
        studentList.add(student);
        serial();
    }

    public void printStudent() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }


    public void deleteStudentByEmail(String email) {
        for (Student student : studentList) {
            if (student.getEmail().equals(email)) {
                studentList.remove(student);
                serial();
            }
        }
    }


    public Student getByEmail(String email) throws UserNotFoundException {
        for (Student student : studentList) {
            if (student.getEmail().equals(email)){
                return student;
            }
        }
        throw new UserNotFoundException();
    }

    public void printStudentByLesson(String name) {
        for (Student student : studentList) {
            for (int j = 0; j < student.getLessons().length; j++) {
                if (student.getLessons()[j].getName().equals(name)) {
                    System.out.println(student);
                }
            }
        }
    }

    public  void serial() {
        DataClass.serializeStudents(studentList);
    }
    public void initData() {
        List<Student> students = DataClass.deSerializeStudents();
        if (students!= null) {
            studentList = students;
        }
    }
}
