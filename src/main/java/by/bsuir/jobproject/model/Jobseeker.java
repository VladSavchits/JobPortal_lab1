package by.bsuir.jobproject.model;

import java.io.Serializable;

/**
 * Created by AR on 30.04.2017.
 */
public class Jobseeker implements Serializable {
    private int jobseeker_id;
    private int user_id;
    private String jobseeker_lastname;
    private String jobseeker_name;
    private String jobseeker_status;

    public int getJobseeker_id() {
        return jobseeker_id;
    }

    public void setJobseeker_id(int jobseeker_id) {
        this.jobseeker_id = jobseeker_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getJobseeker_lastname() {
        return jobseeker_lastname;
    }

    public void setJobseeker_lastname(String jobseeker_lastname) {
        this.jobseeker_lastname = jobseeker_lastname;
    }

    public String getJobseeker_name() {
        return jobseeker_name;
    }

    public void setJobseeker_name(String jobseeker_name) {
        this.jobseeker_name = jobseeker_name;
    }

    public String getJobseeker_status() {
        return jobseeker_status;
    }

    public void setJobseeker_status(String jobseeker_status) {
        this.jobseeker_status = jobseeker_status;
    }
}
