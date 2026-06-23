package program.utils;

final public class Utils {
    public static void print(Object str) {
        System.out.print(String.valueOf(str));
    }

    public static void println(Object str) {
        print(String.valueOf(str) + '\n');
    }
}
