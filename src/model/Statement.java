/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Class representing a statement with its properties.
 *
 * @author Deusto
 */
public class Statement {
    private int id;
    private String description;
    private Difficulty level;
    private Boolean available;
    private String path;
        
    /**
     * Default constructor.
     */
    public Statement() {
        this.id = 0;
        this.description = "";
        this.level = Difficulty.HIGH;
        this.available = false;
        this.path = "";
    }

    /**
     * Constructor with all parameters.
     * @param id the ID
     * @param description the description
     * @param level the difficulty level
     * @param available availability
     * @param path the path
     */
    public Statement(int id, String description, Difficulty level, boolean available, String path) {
        this.id = id;
        this.description = description;
        this.level = level;
        this.available = available;
        this.path = path;
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
     * Gets the difficulty level.
     * @return the level
     */
    public Difficulty getLevel() {
        return level;
    }

    /**
     * Sets the difficulty level.
     * @param level the level to set
     */
    public void setLevel(Difficulty level) {
        this.level = level;
    }

    /**
     * Gets the path.
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path.
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Sets the availability.
     * @param available the available to set
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    /**
     * Gets the availability.
     * @return the available
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * Returns a string representation of the object.
     * @return string representation
     */
    @Override
    public String toString() {
        return "Statement{" + "id=" + id + ", description=" + description + ", level=" + level + ", available=" + available + ", path=" + path + '}';
    }
}
