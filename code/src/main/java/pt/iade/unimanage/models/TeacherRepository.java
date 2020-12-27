package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {

    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public static void populate() {
      
        Teacher t;

        t = new Teacher("Duncan",LocalDate.parse("1980-05-24"), 'M');
        teachers.add(t);
        t = new Teacher("Jane",LocalDate.parse("1987-08-03"),'F');
        teachers.add(t);
        t = new Teacher("Jose",LocalDate.parse("1985-02-15"), 'M');
        teachers.add(t);
        t = new Teacher("Pedro",LocalDate.parse("1984-06-27"), 'M');
        teachers.add(t);

    }

    public static List<Teacher> getTeachers() {
        return teachers;
    }

    public static Teacher getTeacher(int mecNumber) {
        for (Teacher teacher : teachers) {
            if (teacher.getMecNumber() == mecNumber)
                return teacher;
        }
			return null;
	}

    public static ArrayList<Unit> getTeacherUnits(int number) {
        for (Teacher teacher : teachers) {
          if (teacher.getMecNumber() == number) {
            return teacher.getUnits();
          }
        }
    
        return null;
      }

      public static void addUnit(Unit unit, int number) {
        for (Teacher teacher : teachers) {
          if (teacher.getMecNumber() == number) {
            teacher.getUnits().add(unit);
          }
        }
      }



    public static boolean removeUnit(int unitId,int mecNumber){
        for ( Teacher teacher: teachers){
         if(teacher.getMecNumber()== mecNumber){
        return teacher.getUnits().removeIf(
                    (r) -> r.getId()== unitId);
        }   
      }  
        return false;
    }
}
