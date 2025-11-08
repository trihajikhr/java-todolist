import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;

class data{
     public String label;
     public int prior;
     public LocalDateTime createDate;
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

        int c = help.safeInput("Terapkan penambahan (1:ya, 0:batal): ");
        if(c==0){
            System.out.println("Penambahan dibatalkan!");
        } else {
            System.out.println("Inbox [" + temp.label + "] ditambahankan!");
            temp.createDate = LocalDateTime.now();
            inbox.add(temp);
        }
    }
}