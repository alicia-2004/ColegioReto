/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Class representing a teaching unit.
 *
 * @author Deusto
 */
public class TeachingUnit {
    private int id;
    private String acronym;
    private String title;
    private String assessment;
    private String description;

    /**
     * Constructor with all parameters.
     * @param id the ID
     * @param acronym the acronym
     * @param title the title
     * @param assessment the assessment
     * @param description the description
     */
    public TeachingUnit(int id, String acronym, String title, String assessment, String description) {
        this.id = id;
        this.acronym = acronym;
        this.title = title;
        this.assessment = assessment;
        this.description = description;
    }

    /**
     * Gets the ID.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID.
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the acronym.
     * @return the acronym
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * Sets the acronym.
     * @param acronym the acronym to set
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    /**
     * Gets the assessment.
     * @return the assessment
     */
    public String getAssessment() {
        return assessment;
    }

    /**
     * Sets the assessment.
     * @param assessment the assessment to set
     */
    public void setAssessment(String assessment) {
        this.assessment = assessment;
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
     * Gets the title.
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns a string representation of the object.
     * @return string representation
     */
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
