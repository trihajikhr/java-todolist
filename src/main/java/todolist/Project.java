package todolist;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Project {
    public String label;
    public String description;
    public int prior;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    ArrayList<Inbox> inbox = new ArrayList<>();

    Project(String label, String description, int prior, LocalDateTime startTime, LocalDateTime endTime){
        this.label = label;
        this.description = description;
        this.prior = prior;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    Project() {}
}
