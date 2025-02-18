import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //membaca input
        String A = scanner.next();
        String B = scanner.next();
        scanner.close();

        //1.jumlah panjang kedua string
        System.out.println(A.length() + B.length());

        //2. Perbandingan leksikografis
        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // 3.Mengubah huruf pertama menjadi huruf kecil
        String capA = A.substring(0, 1).toLowerCase() + A.substring(1);
        String capB = B.substring(0, 1).toLowerCase() + B.substring(1);
        System.out.println(capA + " " + capB);
    }
}
