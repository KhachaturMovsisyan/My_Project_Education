package education.data;



import education.model.Lesson;
import education.model.Student;
import education.model.User;

import java.io.*;
import java.util.List;
import java.util.Map;

public class DataClass {
    private static String path = "E:\\java 2021\\java.2021\\MyProjectEducation\\src\\main\\resources";

    public static void serializeStudents(List<Student> studentList) {
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(path+"\\"+"students.txt"))){
            out.writeObject(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void serializeLessons(List<Lesson> lessonList){
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(path+"\\"+"lessons.txt"))){
            out.writeObject(lessonList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializeUsers(Map<String, User> userMap){
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(path+"\\"+"users.txt"))){
            out.writeObject(userMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Student> deSerializeStudents(){
        File studentFile = new File(path +"\\" +"students.txt");
        if (!studentFile.exists()) {
            try {
                studentFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(studentFile))) {
                Object obj = in.readObject();
                return (List<Student>) obj;
            } catch (EOFException e){

            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static List<Lesson> deSerializeLessons(){File lessonsFile = new File(path + "\\"+"lessons.txt");
        if (!lessonsFile.exists()) {
            try {
                lessonsFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(lessonsFile))) {
                Object obj = in.readObject();
                return (List<Lesson>) obj;
            } catch (EOFException e){

            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return null;}

    public static Map<String,User> deSerializeUsers(){
        File usersFile = new File(path + "\\"+"users.txt");
        if (!usersFile.exists()) {
            try {
                usersFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(usersFile))) {
                Object obj = in.readObject();
                return (Map<String, User>)  obj;
            } catch (EOFException e){

            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}
