/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 * Class representing an exam call with its details.
 *
 * @author Deusto
 */
public class ExamCall {
    private String call;
    private String description;
    private LocalDate date;
    private String course;
    private int idE;

    /**
     * Constructor with all parameters.
     * @param call the call name
     * @param description the description
     * @param date the date
     * @param course the course
     * @param idE the statement ID
     */
    public ExamCall(String call, String description, LocalDate date, String course, int idE) {
        this.call = call;
        this.description = description;
        this.date = date;
        this.course = course;
        this.idE = idE;
    }

    /**
     * Default constructor.
     */
    public ExamCall() {
        this.call = "";
        this.description = "";
        this.date = null;
        this.course = "";
        this.idE = 0;
    }
    
    /**
     * Gets the call name.
     * @return the call
     */
    public String getCall() {
        return call;
    }

    /**
     * Sets the call name.
     * @param call the call to set
     */
    public void setCall(String call) {
        this.call = call;
    }

    /**
     * Gets the description.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the date.
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date.
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the course.
     * @return the course
     */
    public String getCourse() {
        return course;
    }

    /**
     * Sets the course.
     * @param course the course to set
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * Gets the statement ID.
     * @return the idE
     */
    public int getIdE() {
        return idE;
    }

    /**
     * Sets the statement ID.
     * @param idE the idE to set
     */
    public void setIdE(int idE) {
        this.idE = idE;
    }

    /**
     * Returns a string representation of the object.
     * @return string representation
     */
    @Override
    public String toString() {
        return "ExamCall{" +
                "call=" + call +
                ", description=" + description +
                ", date=" + date +
                ", course=" + course +
                ", idE=" + idE +
                '}';
    }
}
