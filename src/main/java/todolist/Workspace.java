package todolist;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Workspace {
    public String label;
    public String description;
    public LocalDateTime dateCreated;
    ArrayList<Project> projek = new ArrayList<>();

    Workspace(String label, String description) {
        this.label = label;
        this.description = description;
        this.dateCreated = LocalDateTime.now();
    }

    Workspace(){}
}
