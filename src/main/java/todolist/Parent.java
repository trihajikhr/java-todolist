package todolist;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Parent {
    public String label;
    Scanner scan = new Scanner(System.in);
    ArrayList<Workspace> workspaces = new ArrayList<>();
    Helper help = new Helper();
    Map<Integer, Color> colMap = new HashMap<>();

    Parent(){
        Workspace temp = new Workspace("My Workspace", Color.blue, "BLUE", "-", "My daily todolist begins here!", false, LocalDateTime.now());
        workspaces.add(temp);
    }

    public void printWorkspaces(){
        for(int i=0; i< workspaces.size(); i++){
            System.out.println((i+1) + ". " + workspaces.get(i).label);
        }
        help.skip();
    }

    public void workspaceDetail() {
        System.out.println("============= WORKSPACE DETAIL =============");
        for(int i=0; i< workspaces.size(); i++){
            System.out.println((i+1) + ") Workspace -> [" + workspaces.get(i).label + "]");
            System.out.println("Warna       : " + workspaces.get(i).color.colName);
            System.out.println("Parent      : " + workspaces.get(i).parent);
            System.out.println("Description : " +  workspaces.get(i).description);
            System.out.println("IsFavorite  : " +  workspaces.get(i).isFavorite);
            System.out.println("Date created: " +  workspaces.get(i).dateCreated);
            help.skip();
        }
    }

    public void addWorkspace(){
        System.out.println("=== TAMBAH WORKSPACE ===");
        Workspace temp = new Workspace();
        System.out.print("Nama Workspace  : ");
        temp.label = scan.nextLine();
        System.out.println("Label warna     : ");
        colMap.put(1, Color.RED);
        colMap.put(2, Color.GREEN);
        colMap.put(3, Color.BLUE);
        colMap.put(4, Color.YELLOW);
        colMap.put(5, Color.WHITE);
        colMap.put(6, Color.BLACK);

        ArrayList<String> colList = new ArrayList<>();
        colList.add("RED");
        colList.add("GREEN");
        colList.add("BLUE");
        colList.add("YELLOW");
        colList.add("WHITE");
        colList.add("BLACK");

        for(int i=0; i<colMap.size(); i++){
            System.out.println((i+1) + ". " + colList.get(i));
        }
        int a = help.safeInput("Pilihan warna: ", colList);
        temp.color.colName = colList.get(a);
        temp.color.color = colMap.get(a);
        System.out.println("Parent          : ");
        for(int i=0; i< workspaces.size(); i++){
            System.out.println((i+1) + ". " + workspaces.get(i).label);
        }
        System.out.println((workspaces.size()+1) + ". - ");
        int b = help.safeInput("Pilihan anda: ", 1, workspaces.size()+1);
        if(b==workspaces.size()+1){
            System.out.println("Workspace tidak memiliki parent!");
            temp.parent = "-";
        } else {
            b--;
            System.out.println("Parent adalah: " + workspaces.get(b).label);
            temp.parent = workspaces.get(b).parent;
        }
        System.out.print("Deskripsi tambahan: ");
        temp.description = scan.nextLine();
        int c = help.safeInput("Tetapkan sebagai favorit (1:ya, 0:tidak): ", 0, 1);
        if(c==1){
            temp.isFavorite = true;
        } else {
            temp.isFavorite = false;
        }
        temp.dateCreated = LocalDateTime.now();
        workspaces.add(temp);
        help.skip();
    }
}