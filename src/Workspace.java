import java.time.LocalDateTime;
import java.awt.Color;

public class Workspace {
    public String label;
    public Color color;
    public String parent;
    public String description;
    boolean isFavorite;
    public LocalDateTime dateCreated;

    Workspace(String label, Color color, String parent, String description, boolean isFavorite, LocalDateTime dateCreated) {
        this.label = label;
        this.color = color;
        this.parent = parent;
        this.description = description;
        this.isFavorite = isFavorite;
        this.dateCreated = dateCreated;
    }
}
