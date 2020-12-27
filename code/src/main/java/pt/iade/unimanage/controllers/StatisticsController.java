package pt.iade.unimanage.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import pt.iade.unimanage.models.HistogramSlot;
import pt.iade.unimanage.models.Statistical;
import pt.iade.unimanage.models.StudentRepository;
import pt.iade.unimanage.models.Teacher;
import pt.iade.unimanage.models.TeacherRepository;
import pt.iade.unimanage.models.Unit;
import pt.iade.unimanage.models.UnitRepository;



public class StatisticsController {
    private Logger logger = LoggerFactory.getLogger(TeacherController.class);
    private static final int NHISTSLOTS = 5;
    
    @GetMapping(path = "/histogram/{type}/{number}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public HistogramSlot[] getHistogram(@PathVariable("type")String type,
                                        @PathVariable("number") int number){
        logger.info("Obtaining histogram info");
         Statistical stats;
    if(type.equalsIgnoreCase("student"))
        stats = StudentRepository.getStudent(number);
    else stats = UnitRepository.getUnit(number);   
     return stats.getHistogram(NHISTSLOTS);
}








}
