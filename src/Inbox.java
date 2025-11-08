import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;

class data{
     protected String label;
     protected int prior;
     protected LocalDateTime createDate;
}

public class Inbox {
    ArrayList<data> inbox = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    Helper help = new Helper();

    Inbox() {
        data temp = new data();
        System.out.println("=== MEMBUAT INBOX BARU ===");
        System.out.print("Nama Inbox      : ");
        temp.label = scan.nextLine();
        System.out.print("Prioritas Inbox : ");
        temp.prior = scan.nextInt();
        help.skip();

        int c = help.safeInput("Terapkan penambahan (1:ya, 0:batal): ", 0, 1);
        if(c==0){
            System.out.println("Penambahan dibatalkan!");
        } else {
            System.out.println("Inbox [" + temp.label + "] ditambahankan!");
            temp.createDate = LocalDateTime.now();
            inbox.add(temp);
            help.skip();
        }
    }

    public void printInbox(){
        System.out.println("=== DAFTAR INBOX ===");
        for(int i=0; i<inbox.size(); i++){
            System.out.println((i+1) + ". " + inbox.get(i).label);
        }
    }

    public void changeLabel(){
        printInbox();
        int c = help.safeInput("Pilih nomor inbox yang ingin diganti: ", inbox);
        help.skip();
        scan.nextLine();
        System.out.println("Mengganti nama inbox: " + inbox.get(c).label);
        System.out.print("Masukan nama baru   : ");
        String newLabel = scan.nextLine();
        int a = help.safeInput("Terapkan perubahan (1:ya, 0:tidak): ", 0, 1);
        if(a == 0){
            System.out.println("Perubahan dibatalkan!");
        } else {
            help.skip();
            System.out.println("Nama inbox berhasil diperbarui!");
            System.out.println("Inbox: " + inbox.get(c).label + " -> " + newLabel);
            inbox.get(c).label = newLabel;
        }
    }
}