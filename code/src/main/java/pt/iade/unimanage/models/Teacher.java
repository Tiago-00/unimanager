package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Teacher extends Person {

    private static int nextNumber;
    private int mecNumber;
    private ArrayList<Unit> units;

    public Teacher(String name, LocalDate birthDate, String email, char gender, int mecNumber, ArrayList<Unit> units) {
        super(name, birthDate, email, gender);
        this.mecNumber = nextNumber;
        this.units = units;
        nextNumber++;
        units = new ArrayList<Unit>();
        
    }

    public int getMecNumber() {
        return mecNumber;
    }

    
    public ArrayList<Unit> getUnits() {
        return units;
    }

    

    

    

   
    
}
