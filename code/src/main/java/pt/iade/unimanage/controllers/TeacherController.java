package pt.iade.unimanage.controllers;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanage.models.exceptions.NotFoundException;
import pt.iade.unimanage.models.Response;
import pt.iade.unimanage.models.Teacher;
import pt.iade.unimanage.models.TeacherRepository;
import pt.iade.unimanage.models.Unit;



@RestController
    @RequestMapping(path="/api/teachers")
public class TeacherController {
    
    private Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Teacher> getTeachers() {
        logger.info("Sending all teachers");
        return TeacherRepository.getTeachers();
}

@GetMapping(path = "{mecNumber}",
produces= MediaType.APPLICATION_JSON_VALUE)
    public Teacher getStudent(@PathVariable("mecNumber") int mecNumber)throws NotFoundException {
        logger.info("Sending a teacher with number " +mecNumber);
        Teacher teacher = TeacherRepository.getTeacher(mecNumber);

     if (teacher != null) {
            return teacher;
    }else{ 
        throw new NotFoundException(""+mecNumber, "Teacher", "mecNumber");
    }

}

@GetMapping(path = "{mecNumber}/units",
produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Unit> getUnits(@PathVariable("mecNumber") int mecNumber) throws NotFoundException{
        logger.info("Sending units of teacher with number "+mecNumber);
        Teacher teacher = TeacherRepository.getTeacher(mecNumber);

  if (teacher != null) 
    return teacher.getUnits();

else 
    throw new NotFoundException(""+mecNumber, "teacher", "mecNumber");

}

@PostMapping(path = "",
        produces= MediaType.APPLICATION_JSON_VALUE)
            public void addUnit(@RequestBody Unit unit,@PathVariable("number")int number) {
                logger.info("add a unit to teacher "+number);
                TeacherRepository.addUnit(unit,number);
                        
}


@DeleteMapping(path = "{removeunit}",
        produces= MediaType.APPLICATION_JSON_VALUE)
            public Response removeUnit(@PathVariable int unitId,@PathVariable("number")int number) {
            logger.info("remove unit of teacher "+number);
            if (TeacherRepository.removeUnit( unitId,number)){
                return new Response(number+" was remove.",null);
            }
            else{
                return new Response(number+" wasnt remove.",null);
            } 
    
        }

    }



