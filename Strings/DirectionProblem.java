package Strings;

import java.util.*;

public class DirectionProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string containing the directions: ");
        String str = sc.next();
        System.out.println("The shortest distance from the origin is: ");
        System.out.print(shortestdist(str));

    }

    public static float shortestdist(String str) {
        int x = 0, y = 0;
        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.charAt(i) == 'S') {
                y--;
            } else if (str.charAt(i) == 'N') {
                y++;
            } else if (str.charAt(i) == 'E') {
                x++;
            } else {
                x--;
            }
        }
        int X = x * x;
        int Y = y * y;
        float dist = (float) (Math.sqrt((X + Y)));
        return dist;
    }
}
