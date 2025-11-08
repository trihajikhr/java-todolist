import java.awt.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Parent {
    public String label;
    Scanner scan = new Scanner(System.in);
    ArrayList<Workspace> workspaces = new ArrayList<>();
    Helper help = new Helper();

    Parent(){
        Workspace temp = new Workspace("My Workspace", Color.blue, "-", "My daily todolist begins here!", false, LocalDateTime.now());
        workspaces.add(temp);
    }

    void printWorkspaces(){
        for(int i=0; i< workspaces.size(); i++){
            System.out.println((i+1) + ". " + workspaces.get(i).label);
        }
        help.skip();
    }
}
