import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String strNum1, strNum2;

        Scanner scanner = new Scanner(System.in);
        strNum1 = scanner.nextLine();
        strNum2 = scanner.nextLine();

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double tong = num1 + num2;
        double hieu = num1 - num2;
        double tich = num1 * num2;

        System.out.println(tong);
        System.out.println(hieu);
        System.out.println(tich);

        if (num2 != 0) {
            double thuong = num1 / num2;
            System.out.println(thuong);
        } else {
            System.out.println("Không thể chia cho 0.");
        }

        scanner.close();
    }
}
