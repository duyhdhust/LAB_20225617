import java.util.Scanner;

public class Songay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = 0, y = 0;
        boolean hopLe = false;

        while (!hopLe) {
            System.out.print("Nhập tháng: ");
            String thangNhap = scanner.nextLine().trim();
            m = thang(thangNhap);
            if (m == -1) {
                System.out.println("Không hợp lệ!");
                continue;
            }
            System.out.print("Nhập năm: ");
            if (scanner.hasNextInt()) {
                y = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Không hợp lệ");
                scanner.next();
                continue;
            }
            if (y > 0) {
                hopLe = true;
            } else {
                System.out.println("Không hợp lệ!");
            }
        }
        int soNgay = ngay(m, y);
        System.out.println("Có " + soNgay + " ngày.");
        scanner.close();
    }

    public static int ngay(int m, int y) {
        switch (m) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return Nhuan(y) ? 29 : 28;
            default:
                return -1;
        }
    }

    public static boolean Nhuan(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    public static int thang(String input) {
        input = input.toLowerCase();
        switch (input) {
            case "1": case "january": case "jan": case "jan.":
                return 1;
            case "2": case "february": case "feb": case "feb.":
                return 2;
            case "3": case "march": case "mar": case "mar.":
                return 3;
            case "4": case "april": case "apr": case "apr.":
                return 4;
            case "5": case "may":
                return 5;
            case "6": case "june": case "jun": case "jun.":
                return 6;
            case "7": case "july": case "jul": case "jul.":
                return 7;
            case "8": case "august": case "aug": case "aug.":
                return 8;
            case "9": case "september": case "sep": case "sep.":
                return 9;
            case "10": case "october": case "oct": case "oct.":
                return 10;
            case "11": case "november": case "nov": case "nov.":
                return 11;
            case "12": case "december": case "dec": case "dec.":
                return 12;
            default:
                return -1;
        }
    }
}
