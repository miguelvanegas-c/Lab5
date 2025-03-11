package edu.eci.cvds.Labtools.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashMap;


@Document(collection = "laboratories")
public class Lab {
    @Id
    private String labId;
    private String name;
    private HashMap<LocalDateTime, Boolean> isAvailable;
    public String getLabId() {
        return labId;
    }
    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<LocalDateTime, Boolean> getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(HashMap<LocalDateTime, Boolean> isAvailable) {
        this.isAvailable = isAvailable;
    }
}
