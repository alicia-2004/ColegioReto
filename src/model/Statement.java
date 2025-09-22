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
public class Statement {
    private int id;
    private String description;
    private Difficulty level;
    private Boolean available;
    private String path;
        
    public Statement() {
        this.id = 0;
        this.description = "";
        this.level = Difficulty.HIGH;
        this.available = false;
        this.path = "";
    }

    public Statement(int id, String description, Difficulty level, boolean available, String path) {
        this.id = id;
        this.description = description;
        this.level = level;
        this.available = available;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Difficulty getLevel() {
        return level;
    }

    public void setLevel(Difficulty level) {
        this.level = level;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Statement{" + "id=" + id + ", description=" + description + ", level=" + level + ", available=" + available + ", path=" + path + '}';
    }
}
