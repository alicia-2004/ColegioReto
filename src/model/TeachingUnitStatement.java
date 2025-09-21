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
public class TeachingUnitStatement {
    private int teachingUnitId;
    private int statementId;

    public TeachingUnitStatement(int teachingUnitId, int statementId) {
        this.teachingUnitId = teachingUnitId;
        this.statementId = statementId;
    }

    @Override
    public String toString() {
        return "TeachingUnit_Statement{" +
                "teachingUnitId=" + teachingUnitId +
                ", statementId=" + statementId +
                '}';
    }
}
