package by.bsuir.jobproject.model;


import java.io.Serializable;


public class Vacancy implements Serializable {

    private int vacancy_id;
    private int employer_id;
    private String vacancy_name;
    private String vacancy_requirements;
    private String vacancy_payment;

    public int getVacancy_id() {
        return vacancy_id;
    }

    public void setVacancy_id(int vacancy_id) {
        this.vacancy_id = vacancy_id;
    }

    public int getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(int employer_id) {
        this.employer_id = employer_id;
    }

    public String getVacancy_name() {
        return vacancy_name;
    }

    public void setVacancy_name(String vacancy_name) {
        this.vacancy_name = vacancy_name;
    }

    public String getVacancy_requirements() {
        return vacancy_requirements;
    }

    public void setVacancy_requirements(String vacancy_requirements) {
        this.vacancy_requirements = vacancy_requirements;
    }

    public String getVacancy_payment() {
        return vacancy_payment;
    }

    public void setVacancy_payment(String vacancy_payment) {
        this.vacancy_payment = vacancy_payment;
    }
}
