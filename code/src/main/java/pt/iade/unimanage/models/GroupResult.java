package pt.iade.unimanage.models;

public class GroupResult {
    
    private Object object;
    private double average;
    private int size;

    public GroupResult(Object object, double average, int size) {
        this.object = object;
        this.average = average;
        this.size = size;
    }

    public Object getObject() {
        return object;
    }

    public double getAverage() {
        return average;
    }

    public int getSize() {
        return size;
    }
 

}
