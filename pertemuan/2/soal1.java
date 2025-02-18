import java.math.BigInteger;
import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Membaca jumlah testcase
        
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            try {
                BigInteger n = new BigInteger(s);
                System.out.println(s + " can be fitted in:");

                // Mengecek apakah n dapat disimpan dalam tipe data tertentu
                if (n.compareTo(BigInteger.valueOf(Byte.MIN_VALUE)) >= 0 
                        && n.compareTo(BigInteger.valueOf(Byte.MAX_VALUE)) <= 0)
                    System.out.println("* byte");
                
                if (n.compareTo(BigInteger.valueOf(Short.MIN_VALUE)) >= 0 
                        && n.compareTo(BigInteger.valueOf(Short.MAX_VALUE)) <= 0)
                    System.out.println("* short");
                
                if (n.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) >= 0 
                        && n.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0)
                    System.out.println("* int");
                
                if (n.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) >= 0 
                        && n.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0)
                    System.out.println("* long");
                
            } catch (NumberFormatException e) {
                System.out.println(s + " can't be fitted anywhere.");
            }
        }
        
        sc.close(); // Menutup scanner setelah selesai digunakan
    }
}
