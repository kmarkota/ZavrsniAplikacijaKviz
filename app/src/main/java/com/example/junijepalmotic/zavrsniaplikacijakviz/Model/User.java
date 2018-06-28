package com.example.junijepalmotic.zavrsniaplikacijakviz.Model;

public class User {
    private String spol;
    private String dob;
    private String obrazovanje;


    public User() {
    }

    public User(String spol, String dob, String obrazovanje) {
        this.spol = spol;
        this.dob = dob;
        this.obrazovanje = obrazovanje;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getObrazovanje() {
        return obrazovanje;
    }

    public void setObrazovanje(String obrazovanje) {
        this.obrazovanje = obrazovanje;
    }
}
