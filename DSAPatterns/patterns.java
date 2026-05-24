import java.util.*;

public class patterns {
    public static void main(String[] args) {
//        hollow_rectangle(4, 5);
//        inverted_rotated_half_pyramid(4, 5);
//        inverted_half_pyramid_numbers(7);
//        flodys_triangle(5);
//        zero_one_triangle(5);
//        butterfly(4);
//        rhombus(5);
//        hollow_rhombus(5);
//        diamond(7);
    }

    public static void diamond(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= (rows - i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= ((2 * i) - 1); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= (rows - i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= ((2 * i) - 1); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void hollow_rhombus(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= (rows - i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= rows; j++) {
                if (i == 1 || i == rows || j == 1 || j == rows) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void rhombus(int rows) {
        int counter = rows;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= counter; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= rows; j++) {
                System.out.print("* ");
            }
            counter--;
            System.out.println();
        }
    }

    public static void butterfly(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <= (2 * (rows - i)); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <= (2 * (rows - i)); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void zero_one_triangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static void flodys_triangle(int rows) {
        int counter = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void inverted_half_pyramid_numbers(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void inverted_rotated_half_pyramid(int rows, int cols) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollow_rectangle(int rows, int cols) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (i == 1 || i == rows || j == 1 || j == cols) {
                    System.out.print("*");

                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
