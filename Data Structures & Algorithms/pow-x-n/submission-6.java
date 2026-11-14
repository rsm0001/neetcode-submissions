class Solution {
    private boolean preprocess(double x, int n, double[] res) {
        if (0 == x) { res[0] = 0; return true; }
        if (1 == x) { res[0] = 1; return true; }
        if (-1 == x) { res[0] = (0 == (n %2)) ? 1 : -1; return true; }
        if (0 == n) { res[0] = 1; return true; }
        if (1 == n) { res[0] = x; return true; }
        if (-1 == n) { res[0] = (1.0 / x); return true; }
        return false;
    }

    public double myPow1(double x, int n) {
        long N = n; // long avoids overflow at Integer.MIN_VALUE
        if (N < 0) { x = 1 / x; N = -N; }

        double res = 1;
        while (N > 0) {
            if ((N & 1) == 1) res *= x;   // this bit is set: include current power
            x *= x;                       // x, x^2, x^4, x^8, ...
            N >>= 1;                      // move to the next bit
        }
        return res;
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;
        double half = pow(x, n / 2);
        return (n % 2 == 0) ? half * half : half * half * x;
    }

    public double myPow(double x, int n) {
        double[] tmpres = new double[1];
        boolean done = preprocess(x, n, tmpres);
        if (done) {
            return tmpres[0];
        }

        if (n < 0) { x = (1.0 / x); n *= -1; }

        String bits = Integer.toBinaryString(n);
        int last = (bits.length() - 1);

        double res = 1, powres = x;

        for (int i=0; i < bits.length(); i++) {
            if ('1' == bits.charAt(last-i)) {
                res *= powres;
            }
            powres = (powres * powres);
        }
        
        return res;
    }
}
