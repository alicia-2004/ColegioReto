/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Class representing the relationship between teaching units and statements.
 *
 * @author Deusto
 */
public class TeachingUnitStatement {
    private int teachingUnitId;
    private int statementId;

    /**
     * Default constructor.
     */
    public TeachingUnitStatement() {
    }

    

    /**
     * Constructor with all parameters.
     * @param teachingUnitId the teaching unit ID
     * @param statementId the statement ID
     */
    public TeachingUnitStatement(int teachingUnitId, int statementId) {
        this.teachingUnitId = teachingUnitId;
        this.statementId = statementId;
    }

    /**
     * Gets the teaching unit ID.
     * @return the teachingUnitId
     */
    public int getTeachingUnitId() {
        return teachingUnitId;
    }

    /**
     * Sets the teaching unit ID.
     * @param teachingUnitId the teachingUnitId to set
     */
    public void setTeachingUnitId(int teachingUnitId) {
        this.teachingUnitId = teachingUnitId;
    }

    /**
     * Gets the statement ID.
     * @return the statementId
     */
    public int getStatementId() {
        return statementId;
    }

    /**
     * Sets the statement ID.
     * @param statementId the statementId to set
     */
    public void setStatementId(int statementId) {
        this.statementId = statementId;
    }
    

    /**
     * Returns a string representation of the object.
     * @return string representation
     */
    @Override
    public String toString() {
        return "TeachingUnit_Statement{" +
                "teachingUnitId=" + teachingUnitId +
                ", statementId=" + statementId +
                '}';
    }
}
