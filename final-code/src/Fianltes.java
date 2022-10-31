public class Fianltes {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(rec(a));
        System.out.println(rec1(a));
    }

    public static int rec(int data) {
        int out = 0;
        int a = out;
        while (data > 0) {
            out = data + a * 2 + 1;
            a = out-1;

            data--;
        }

        System.out.println(data + " " + out);
        return out;
    }

    public static int rec1(int data) {
        int out = 0;
        if (data > 0) {
            //
            out = data + rec1(data - 1) * 2 + 1;
            //
        }
        System.out.println(data + " " + out);
        return out;
    }
}