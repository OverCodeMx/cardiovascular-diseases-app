package mx.overcode.sintomasapp.models;

/**
 * Created by aldo on 3/19/18.
 */

public class Sintoma {
    private int id;
    private String detail;
    private Integer imgLeft;
    private Integer imgRight;

    public Sintoma(int id, String detail, Integer imgLeft, Integer imgRight) {
        this.id = id;
        this.detail = detail;
        this.imgLeft = imgLeft;
        this.imgRight = imgRight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getImgLeft() {
        return imgLeft;
    }

    public void setImgLeft(Integer imgLeft) {
        this.imgLeft = imgLeft;
    }

    public Integer getImgRight() {
        return imgRight;
    }

    public void setImgRight(Integer imgRight) {
        this.imgRight = imgRight;
    }
}
