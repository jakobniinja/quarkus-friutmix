package org.acme.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Objects;

public class Fruit {

    @Schema(name = "_id", example = "1", required = true)
    private String _id;

    @Schema(name = "name", example = "Apple", required = true)
    private String name;

    @Schema(name = "description", example = "A green fruit that grows on trees", required = true)
    private String description;

    public Fruit() {
    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fruit)) {
            return false;
        }

        Fruit other = (Fruit) obj;

        return Objects.equals(other.name, this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
