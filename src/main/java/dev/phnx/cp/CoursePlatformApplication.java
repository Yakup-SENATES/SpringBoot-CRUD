package dev.phnx.cp;

import dev.phnx.cp.dao.DAO;
import dev.phnx.cp.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CoursePlatformApplication {

    private static DAO<Course> dao;

    public CoursePlatformApplication(DAO<Course> dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(CoursePlatformApplication.class, args);

        System.out.println("\n Create Course.........................\n");
        Course springVue = new Course("Sprign Boot + Vue", "New Course", "youtube.com");
        dao.create(springVue);


        System.out.println("\n Get One Course.........................\n");
        Optional<Course> firstOne = dao.get(1);
        System.out.println(firstOne.get());

        springVue.setDescription("Learn To build Vue Apps that talk to spring boot JC");
        dao.update(springVue,6);

        dao.delete(4);

        System.out.println("\n All Courses.........................\n");
        List<Course> courses = dao.list();
        courses.forEach(System.out::println);




    }

}
