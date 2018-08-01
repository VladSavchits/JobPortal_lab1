package by.bsuir.jobproject.model;


import java.io.Serializable;


public class Employer implements Serializable {

    private int employer_id;
    private int user_id;
    private String employer_name;
    private String employer_information;

    public int getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(int employer_id) {
        this.employer_id = employer_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmployer_name() {
        return employer_name;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public String getEmployer_information() {
        return employer_information;
    }

    public void setEmployer_information(String employer_information) {
        this.employer_information = employer_information;
    }
}