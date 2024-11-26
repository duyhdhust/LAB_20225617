import java.util.Scanner;

public class Solve {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Chọn loại phương trình:");
        System.out.println("1. Bậc 1");
        System.out.println("2. Hệ phương trình bậc 1");
        System.out.println("3. Phương trình bậc 2");
        
        int choice = input.nextInt();
        
        switch (choice) {
            case 1:
                bacnhat(input);
                break;
            case 2:
                hebacnhat(input);
                break;
            case 3:
                bachai(input);
                break;
            default:
                System.out.println("Chọn 1-3!");
        }
        
        input.close();
    }

    public static void bacnhat(Scanner input) {
        System.out.print("Nhập a: ");
        double a = input.nextDouble();
        System.out.print("Nhập b: ");
        double b = input.nextDouble();

        if (a == 0) {
            System.out.println("a phải khác 0");
        } else {
            double x = -b / a;
            System.out.println("x = " + x);
        }
    }

    public static void hebacnhat(Scanner input) {
        System.out.print("Nhập a11: ");
        double a11 = input.nextDouble();
        System.out.print("Nhập a12: ");
        double a12 = input.nextDouble();
        System.out.print("Nhập b1: ");
        double b1 = input.nextDouble();
        System.out.print("Nhập a21: ");
        double a21 = input.nextDouble();
        System.out.print("Nhập a22: ");
        double a22 = input.nextDouble();
        System.out.print("Nhạp b2: ");
        double b2 = input.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        } else if (D == 0 && D1 == 0 && D2 == 0) {
            System.out.println("Vô số nghiệm");
        } else {
            System.out.println("Vô nghiệm");
        }
    }

    public static void bachai(Scanner input) {
        System.out.print("Nhập a: ");
        double a = input.nextDouble();
        System.out.print("Nhập b: ");
        double b = input.nextDouble();
        System.out.print("Nhập c: ");
        double c = input.nextDouble();

        if (a == 0) {
            System.out.println("a phải khác 0");
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("x = " + x);
            } else {
                System.out.println("Vô nghiệm");
            }
        }
    }
}
