package Lab1_1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hiep
 */
public class Entry {
    private int point;
    private String email;

    public Entry(int point, String email) {
        this.point = point;
        this.email = email;
    }

    public Entry() {
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" + email  + "," + point + '}';
    }
   
}
