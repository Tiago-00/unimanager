package pt.iade.unimanage.models;

import java.time.LocalDate;

public abstract class Person {
            
            protected String name;
            protected  LocalDate birthDate;
            protected  String email;
            protected  char gender;

            public Person(String name, LocalDate birthDate, char gender) {
                this.name = name;
                this.birthDate = birthDate;
                this.gender = gender;
                this.email = "";
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


			public abstract String getReference();

           

}
