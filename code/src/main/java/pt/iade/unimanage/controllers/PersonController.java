package pt.iade.unimanage.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import pt.iade.unimanage.models.Person;
import pt.iade.unimanage.models.StudentRepository;
import pt.iade.unimanage.models.TeacherRepository;




public class PersonController {
    
    private Logger logger = LoggerFactory.getLogger(PersonController.class);


    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersons() {
    logger.info("Sending all persons");
    ArrayList<Person> persons = new ArrayList<>();
    persons.addAll(StudentRepository.getStudents());
    persons.addAll(TeacherRepository.getTeachers());
    return persons;


}



}