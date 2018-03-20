package mx.overcode.sintomasapp.models;


/**
 * Created by aldo on 3/17/18.
 */

public class Enfermedad {
    private int id;
    private String name;
    private double[] matrix;

    public Enfermedad(int id, String name, double[] matrix) {
        this.id = id;
        this.name = name;
        this.matrix = matrix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[] matrix) {
        this.matrix = matrix;
    }
}
