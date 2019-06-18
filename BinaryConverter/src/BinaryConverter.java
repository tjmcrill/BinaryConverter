import java.util.Scanner;

public final class BinaryConverter {

    private BinaryConverter() {
    }

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("Hello! Welcome to the Binary Converter.\n");
            System.out.println(
                    "Enter a binary sequence which you want to be converted: ");
            Scanner scan = new Scanner(System.in);
            String binSeq = scan.nextLine();
            int byteLen = binSeq.length() / 4;
            System.out.println(
                    "Enter the number corresponding to the conversion type(1,2,3, or 0 to Exit):\n"
                            + "1. Integer\n" + "2. Hexadecimal\n" + "3. Both"
                            + " ");
            choice = scan.nextInt();
            if (choice == 1) {
                int numero = binaryToInt(binSeq);
                System.out.println("The " + byteLen + " byte binary sequence "
                        + binSeq + " converted to an integer is: " + numero);
                System.out.println("");
            } else if (choice == 2) {
                String answer = binaryToHecz(binSeq);
                System.out.println("The " + byteLen + " byte binary sequence "
                        + binSeq + " converted to hexadecimal is: " + answer);
                System.out.println("");
            } else if (choice == 3) {
                int numero = binaryToInt(binSeq);
                System.out.println("The " + byteLen + " byte binary sequence "
                        + binSeq + " converted to an integer is: " + numero);
                System.out.println("");
                String answer = binaryToHecz(binSeq);
                System.out.println("The " + byteLen + " byte binary sequence "
                        + binSeq + " converted to hexadecimal is: " + answer);
                System.out.println("");
            } else if (choice == 0) {
                System.out
                        .println("Thank you for using the converter. Goodbye!");
                break;
            } else {
                System.out.println("Invalid Input");
                System.out.println("");
            }
            System.out.println(
                    "Do you want to use the converter again? (Yes or No) ");
            Scanner scan1 = new Scanner(System.in);
            String yoNo = scan1.nextLine();
            System.out.println("");
            if (yoNo.toLowerCase().equals("yes")) {
                choice = 1;
            } else if (yoNo.toLowerCase().equals("no")) {
                System.out
                        .println("Thank you for using the converter. Goodbye!");
                choice = 0;
            } else {
                System.out.println(
                        "You didn't type yes or no. Because of this, I'll assume you want to use this fabulous converter again!\n");
                choice = 1;
            }
        } while (choice != 0);
    }

    public static int binaryToInt(String binNum) {
        int len = binNum.length();
        int finalNum = 0;
        String temp1 = binNum;
        for (int i = 0; i < len; i++) {
            String val = temp1.substring(temp1.length() - 1);
            int oneOrZero = Integer.parseInt(val);
            temp1 = binNum.substring(0, temp1.length() - 1);
            if (oneOrZero == 1) {
                finalNum += Math.pow(2, i);
            }
        }
        return finalNum;
    }

    public static String binaryToHecz(String binNum) {
        int len = binNum.length() / 4;
        int testNum = 0;
        String temp = binNum;
        String hecz = "";
        StringBuffer buf = new StringBuffer();
        int tempNumber = 0;
        char letter = 'a';
        for (int i = 0; i < len; i++) {
            String part = temp.substring(0, 4);
            for (int j = 0; j < 4; j++) {
                String oneOrZero = part.substring(part.length() - 1);
                int unoOrZero = Integer.parseInt(oneOrZero);
                if (unoOrZero == 1) {
                    testNum += Math.pow(2, j);
                }
                part = part.substring(0, part.length() - 1);
            }
            tempNumber = testNum;
            testNum = 0;
            if (tempNumber > 9) {
                if (tempNumber == 10) {
                    letter = 'A';
                } else if (tempNumber == 11) {
                    letter = 'B';
                } else if (tempNumber == 12) {
                    letter = 'C';
                } else if (tempNumber == 13) {
                    letter = 'D';
                } else if (tempNumber == 14) {
                    letter = 'E';
                } else if (tempNumber == 15) {
                    letter = 'F';
                }
                buf.append(letter);
            } else {
                String tempNum = Integer.toString(tempNumber);
                buf.append(tempNum);
            }
            temp = temp.substring(4, temp.length());
        }
        hecz = buf.toString();
        return hecz;
    }

}
