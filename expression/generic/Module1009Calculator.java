package expression.generic;

import expression.exceptions.ZeroDivisionException;

public class Module1009Calculator implements Calculator<Integer> {
    private final  int MOD = 1009;
    private final int[] opposites = new int[MOD];
    private boolean calculated = false;

    private Integer checkNegative(int x) {
        if (x == Integer.MIN_VALUE) {
            return 313;
        }
        if (x < 0) {
            x = MOD - (-x % MOD);
        }
        return x;
    }

    private void precalculate() {
        if (calculated) {
            return;
        }
        for (int i = 1; i < MOD; i++) {
            int cur = MOD + 1;
            while (cur % i > 0) {
                cur += 1009;
            }
            opposites[i] = cur / i;
        }
        calculated = true;
    }

    private int opposite(int y) {
        precalculate();
        y = checkNegative(y);
        return opposites[y % MOD];
    }

    @Override
    public Integer add(Integer x, Integer y) {
        int ans = x + y;
        ans = checkNegative(ans);
        return ans % MOD;
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        int ans = x - y;
        ans = checkNegative(ans);
        return ans % MOD;
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        int ans = x * y;
        ans = checkNegative(ans);
        return ans % MOD;
    }

    @Override
    public Integer divide(Integer x, Integer y) {
        if (y == 0) {
            throw new ZeroDivisionException();
        }
        int ans = x * opposite(y);
        ans = checkNegative(ans);
        return ans % MOD;
    }

    @Override
    public Integer negate(Integer x) {
        int ans = -x;
        ans = checkNegative(ans);
        return ans % MOD;
    }

    @Override
    public Integer parse(String source) {
        int ans = Integer.parseInt(source);
        ans = checkNegative(ans);
        return ans % MOD;
    }

    @Override
    public Integer convertConstType(int x) {
        int ans = x;
        ans = checkNegative(ans);
        return ans;
    }

    @Override
    public Integer abs(Integer x) {
        return x < 0 ? -x % MOD : x % MOD;
    }

    @Override
    public Integer square(Integer x) {
        int ans = x * x;
        ans = checkNegative(ans);
        return ans % MOD;
    }

    @Override
    public Integer mod(Integer x, Integer y) {
        int ans = x % y;
        ans = checkNegative(ans);
        return ans % MOD;
    }

    @Override
    public Integer convertVarType(Integer x) {
        int ans = x;
        ans = checkNegative(ans);
        return ans % MOD;
    }
}
