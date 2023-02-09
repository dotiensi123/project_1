package vn.co.your.dotiensi.Springboottutorial.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.co.your.dotiensi.Springboottutorial.springboot.models.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
