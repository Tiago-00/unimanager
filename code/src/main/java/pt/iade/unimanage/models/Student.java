package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Person implements Statistical {
    private static int nextNumber = 0;
    private String name;
    private LocalDate birthDate;
    private String email;
    private char gender;
    private int number;

    private ArrayList<Enrolment> enrolments;
    private ArrayList<Unit> units;

    public Enrolment getEnrolmentByUnitId(int unitId) {
        for (Enrolment enr : enrolments)
            if (enr.getUnit().getId() == unitId)
                return enr;
        return null;
    }

    public Student(String name, LocalDate birthDate, char gender) {
        super(name, birthDate, gender);
        this.number = nextNumber;
        nextNumber++;
        email = "";
        units = new ArrayList<Unit>();
        enrolments = new ArrayList<Enrolment>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void enroll(Enrolment enrolment) {
        enrolments.add(enrolment);
        enrolment.getUnit().getEnrolments().add(enrolment);
    }

    public void enroll(Unit unit) {
        units.add(unit);
        unit.getStudents().add(this);
    }

    @Override
    public String getReference() {
        return "S<" + number + ">";
    }

    @Override
    public double getAverage() {
        double sum = 0; int n = 0;
        for (Enrolment enr: enrolments)
            if (enr.getGrade() > 0){
                n++;
                sum += enr.getGrade();
            }
        return  sum/n;
    }

    @Override
    public HistogramSlot[] getHistogram(int nSlots) {
        
        return null;
    }

    @Override
    public double getMax() {
       
        return 0;
    }

    @Override
    public double getMin() {

        return 0;
    }

    }       