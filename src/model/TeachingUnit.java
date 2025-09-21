/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Deusto
 */
public class TeachingUnit {
    private int id;
    private String acronym;
    private String title;
    private String assessment;
    private String description;

    public TeachingUnit(int id, String acronym, String title, String assessment, String description) {
        this.id = id;
        this.acronym = acronym;
        this.title = title;
        this.assessment = assessment;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TeachingUnit{" +
                "id=" + id +
                ", acronym=" + acronym +
                ", title=" + title +
                ", assessment=" + assessment +
                ", description=" + description +
                '}';
    }
}
