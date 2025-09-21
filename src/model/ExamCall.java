/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Deusto
 */
public class ExamCall {
    private String call;
    private String description;
    private LocalDate date;
    private String course;
    private int idE;

    public ExamCall(String call, String description, LocalDate date, String course, int idE) {
        this.call = call;
        this.description = description;
        this.date = date;
        this.course = course;
        this.idE = idE;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

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
