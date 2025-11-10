package todolist;
import java.util.ArrayList;
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

    // Safeinput normal
    public int safeInput(String prompt, int begin, int end) {
        int ans;
        while(true){
            System.out.print(prompt);
           if(scan.hasNextInt()){
               ans = scan.nextInt();
               if(ans >= begin && ans <= end){
                   break;
               } else {
                   System.out.println("Invalid input! Tidak sesuai!");
               }
           } else {
               System.out.println("Invalid input! Harus angka!" );
               scan.nextLine(); // buang token non-angka
           }
        }
        scan.nextLine();
        return ans;
    }

    // Safeinput pembacaan Arraylist
    public <T> int safeInput(String prompt,ArrayList<T>list) {
        int ans;
        while(true){
            System.out.print(prompt);
            if(scan.hasNextInt()){
                ans = scan.nextInt();
                ans--;
                if(ans >= 0 && ans < list.size()){
                    break;
                } else {
                    System.out.println("Invalid input! Tidak sesuai!");
                }
            } else {
                System.out.println("Invalid input! Harus angka!" );
                scan.nextLine(); // buang token non-angka
            }
        }
        scan.nextLine();
        return ans;
    }

    // cek panjang string aje
    public String safeStringInput(String prompt, int len){
        String ans;
        while(true) {
            System.out.print(prompt);
            ans = scan.nextLine();
            if(ans.length() <= len) {
                break;
            } else {
                System.out.println("Input terlalu panjang! Melebihi batas " + len + " karakter!");
                scan.nextLine();
            }
        }
        return ans;
    }
}

