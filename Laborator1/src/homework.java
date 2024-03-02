public class homework {
    static long startTime = System.nanoTime();

    static boolean kReductibil(int n, int k) {
        if (k >= 10 || k < 0) {
            System.out.println("k trebuie sa fie mai mic decat 10 si mai mare decat 0");
            return false;
        }
        while (n > 9) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return n == k;
    }

    static void kInterval(int a, int b, int k) {

        StringBuilder kNumbers = new StringBuilder();
        for (int i = a; i <= b; i++) {
            if (kReductibil(i, k)) {
                kNumbers.append(i).append(" ");
            }
        }
        System.out.println(kNumbers);

    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Nu ati introdus destule argumente");
            return;
        } else {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int k = Integer.parseInt(args[2]);

            kInterval(a, b, k);
            long endTime = System.nanoTime();
            System.out.println(startTime);
            System.out.println(endTime);
            System.out.println("runtime " + (endTime - startTime) + " nanosecunde");
        }
    }
}