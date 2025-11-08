import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {
    Scanner scan = new Scanner(System.in);

    void skip() {
        System.out.println("\n");
    }

    void skip(int val){
        for(int i=0; i<val; i++){
            System.out.println("\n");
        }
    }

    public int safeInput(String prompt) {
        int ans;
        while(true){
            System.out.print(prompt);
           if(scan.hasNextInt()){
               ans = scan.nextInt();
               if(ans == 0 || ans == 1){
                   break;
               } else {
                   System.out.println("Invalid input! Tidak sesuai!");
               }
           } else {
               System.out.println("Invalid input! Harus angka!" );
               scan.next(); // buang token non-angka
           }
        }
        return ans;
    }
}

