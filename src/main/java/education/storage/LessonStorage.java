package education.storage;



import education.data.DataClass;
import education.model.Lesson;

import java.util.LinkedList;
import java.util.List;

public class LessonStorage {
    private List<Lesson> list = new LinkedList<>();


    public void add(Lesson lesson) {
        list.add(lesson);
        serial();

    }


    public void printLessons() {
        for (Lesson lesson : list) {
            System.out.println(lesson);
            //System.out.println("The lesson has been deleted");
        }
    }

    public void deleteLessonByName(String name) {
        for (Lesson lesson : list) {
            if (lesson.getName().equals(name)) {
                list.remove(lesson);
                serial();
                System.out.println("The lesson has been deleted");
            }
        }
    }

    public Lesson getLessonByName(String name) {
        for (Lesson lesson : list) {
            if (lesson.getName().equals(name)) {
                return lesson;
            }
        }
        return null;
    }

    public void serial() {
        DataClass.serializeLessons(list);
    }

    public void initData() {
        List<Lesson> lessonList = DataClass.deSerializeLessons(); // java mava c++
        if (lessonList != null) {
            list = lessonList;
        }
    }
}
