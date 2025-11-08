package todolist;

import java.time.LocalDateTime;
import java.awt.Color;
import java.util.ArrayList;

class theColor {
    String colName;
    Color color;
}

public class Workspace {
    public String label;
    public theColor color =  new theColor();
    public String parent;
    public String description;
    boolean isFavorite;
    public LocalDateTime dateCreated;

    ArrayList<Project> projek = new ArrayList<>();

    Workspace(String label, Color color, String colName, String parent, String description, boolean isFavorite, LocalDateTime dateCreated) {
        this.label = label;
        this.color.colName = colName;
        this.color.color = color;
        this.parent = parent;
        this.description = description;
        this.isFavorite = isFavorite;
        this.dateCreated = dateCreated;
    }

    Workspace(){}
}
