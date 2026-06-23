package BitManipulation;

public class LowerCaseConversion {
    public static void main(String[] args) {
        toLowerCase();
    }

    public static void toLowerCase() {
        for (char i = 'A'; i <= 'Z'; i++) {
            char result = (char) (i | ' ');
            System.out.print(result + " ");
        }
    }
}