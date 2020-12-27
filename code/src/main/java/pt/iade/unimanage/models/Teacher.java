package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Teacher extends Person {

    private static int nextNumber;
    private int mecNumber;
    private ArrayList<Unit> units;

    public Teacher(String name, LocalDate birthDate, char gender) {
        super(name, birthDate, gender);
        this.mecNumber = nextNumber;
        nextNumber++;
        units = new ArrayList<Unit>();
        
    }

    public int getMecNumber() {
        return mecNumber;
    }

    
    public ArrayList<Unit> getUnits() {
        return units;
    }


        @Override
    public String getReference(){
        return "T<"+mecNumber+">";
    }

    

 
    
}
