package pt.iade.unimanage.models;

import java.util.ArrayList;
import java.util.List;

public class UnitRepository {

	private static ArrayList<Unit> units = new ArrayList<Unit>();

    public static void populate() {
      
        Unit u;

        u = new Unit(1,"POO",6);
        units.add(u);
        u = new Unit(2,"MAT",6);
        units.add(u);
		u = new Unit(3,"BD",6);
        units.add(u);
        u = new Unit(4,"TI2",3);
        units.add(u);
        

    }

    public static List<Unit> getunits() {
        return units;
    }
	
	public static Unit getUnit(int id) {
        for (Unit unit : units) {
            if (unit.getId() == id)
                return unit;
        }
			return null;
	}

}

