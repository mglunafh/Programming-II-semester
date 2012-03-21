package fibonacci;

/**
 *
 * @author Dev
 */
public class Fibonacci {

    public static int fib(int n) {
        if (n < 1) {
            throw new FibonacciInvalidArgument();
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int fib1 = 1;
        int fib2 = 1;
        for (int i = 2; i < n; ++i) {
            int temp = fib2;
            fib2 += fib1;
            fib1 = temp;
        }

        return fib2;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int i = 1; i <= 15; ++i) {
            System.out.println((fib(i)));
        }
        int t = fib(0);
    }
}
