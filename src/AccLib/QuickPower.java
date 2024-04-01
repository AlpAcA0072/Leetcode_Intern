package AccLib;

public class QuickPower {
    //递归快速幂
    long quickRecursivePower(long a, long n) {
        if (n == 0)
            return 1;
        else if (n % 2 == 1)
            return quickRecursivePower(a, n - 1) * a;
        else {
            long temp = quickRecursivePower(a, n / 2);
            return temp * temp;
        }
    }

    //递归快速幂（对大素数取模）
    long quickRecursivePowerWithMod(long a, long n) {
        long MOD = 1000000007;
        if (n == 0)
            return 1;
        else if (n % 2 == 1)
            return quickRecursivePowerWithMod(a, n - 1) * a % MOD;
        else {
            long temp = quickRecursivePowerWithMod(a, n / 2) % MOD;
            return temp * temp % MOD;
        }
    }

    //非递归快速幂
    long quickPower(long a, long n) {
        long ans = 1;
        while (n != 0) {
            // 位运算判断奇偶性
            if ((n & 1) == 1)
                ans *= a;  //ans乘上当前的a
            a *= a;        //a自乘
            n >>= 1;       //n往右移一位
        }
        return ans;
    }
}
