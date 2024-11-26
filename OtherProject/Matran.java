import java.util.Scanner;
public class Matran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Số hàng: ");
        int n = scanner.nextInt();
        System.out.println("Số cột: ");
        int m = scanner.nextInt();
        int[][] matran1 = new int[n][m];
        int[][] matran2 = new int[n][m];
        int[][] tong = new int[n][m];
        System.out.println("Ma trận 1: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matran1[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Ma trận 2: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matran2[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tong[i][j] = matran1[i][j] + matran2[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(tong[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
