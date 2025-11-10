package todolist;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parent {
    public String label;
    Scanner scan = new Scanner(System.in);
    ArrayList<Workspace> workspaces = new ArrayList<>();
    Helper help = new Helper();

    Parent(){
        Workspace temp = new Workspace("My Workspace", "My daily todolist begins here!");
        workspaces.add(temp);
    }

    public void mainMenu(){
        int a;
        do {
            System.out.println("===== PROGRAM TODOLIST =====");
            System.out.println("1. Menuju Workspace");
            System.out.println("2. Daftar Workspace");
            System.out.println("3. Tambah Workspace");
            System.out.println("0. Keluar");
            a = help.safeInput("Pilihan Anda: ", 0, 3);
            help.skip();
            switch (a) {
                case 1:
                    printWorkspaces();
                    int b = help.safeInput("Pilih workspace: ", workspaces);
                    break;
                case 2:
                    workspaceDetail();
                    break;
                case 3:
                    addWorkspace();
                    break;
            }
        } while (a != 0);
        System.out.println("Get the thiings done!");
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
            System.out.println("Description : " +  workspaces.get(i).description);
            System.out.println("Date created: " +  workspaces.get(i).dateCreated.format(
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
            ));
            help.skip();
        }
    }

    public void addWorkspace(){
        System.out.println("=== TAMBAH WORKSPACE ===");
        Workspace temp = new Workspace();
        temp.label = help.safeStringInput("Nama Workspace    : ", 20);
        System.out.print("Deskripsi tambahan: ");
        temp.description = scan.nextLine();
        temp.dateCreated = LocalDateTime.now();
        workspaces.add(temp);
        System.out.println("Workspace added [" + temp.label +"] successfully");
        help.skip();
    }
}