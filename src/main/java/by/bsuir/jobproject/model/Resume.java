package by.bsuir.jobproject.model;


import java.io.Serializable;


public class Resume implements Serializable{

    private int resume_id;
    private int jobseeker_id;
    private int specialty_id;
    private int skill_id;
    private String resume_information;

    public int getResume_id() {
        return resume_id;
    }

    public void setResume_id(int resume_id) {
        this.resume_id = resume_id;
    }

    public int getJobseeker_id() {
        return jobseeker_id;
    }

    public void setJobseeker_id(int jobseeker_id) {
        this.jobseeker_id = jobseeker_id;
    }

    public int getSpecialty_id() {
        return specialty_id;
    }

    public void setSpecialty_id(int specialty_id) {
        this.specialty_id = specialty_id;
    }

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public String getResume_information() {
        return resume_information;
    }

    public void setResume_information(String resume_information) {
        this.resume_information = resume_information;
    }
}
