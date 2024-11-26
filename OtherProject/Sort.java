import java.util.Arrays;
import java.util.Scanner;

public class Sort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] mang = new double[n];
        for (int i = 0; i < n; i++) {
            mang[i] = scanner.nextDouble();
        }
        Arrays.sort(mang);
        double tong = 0;
        for (double x : mang) {
            tong += x;
        }
        double tb = tong / n;
        System.out.println(Arrays.toString(mang));
        System.out.println(tong);
        System.out.println(tb);
        scanner.close();
    }
}
