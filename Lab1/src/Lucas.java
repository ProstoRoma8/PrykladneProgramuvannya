
public class Lucas {

    public static int lucasNumber(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;

        int L0 = 2;
        int L1 = 1;

        for (int i = 2; i <= n; i++) {
            int next = L0 + L1;
            L0 = L1;
            L1 = next;
        }
        return L1;
    }
}
