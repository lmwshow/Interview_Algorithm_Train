package offer2.again;

/**
 * @Auther: minGW
 * @Date: 2018/5/19 10:09
 * @Description: https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&tPage=3&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 思维太固定了，认为只剩下移位运算可以使用
 *
 * 通常我们计算1+2+....n 除了使用公式n(n+1)/2,无外乎循环和递归两种方法
 * 由于已经明确限制for和while的使用，循环已经不能使用了
 * 只能使用递归，而递归也需要if来判断递归是否进行下去，那么如何可以做到不使用if呢？
 *
 * 其实只要先看我们手里有什么牌就能一步一步想到利用短路特性了
 * 我们手里现在可以使用（按优先级高低）单目运算符：++和--,双目运算符：+,-，移位运算符<<和>>，关系运算符>,<等，逻辑运算符&&，||,&,|,^，赋值=
 * 单目和双目的作用是一样的，移位显然没有规律性，因为一个二进制位并不能区分某个数和其他数，这也就排除了&,|,^,因为不需要做位运算了
 * 关系运算符要和if匹配，但这是不行的，这时看看剩下的运算符只能选&&,||了
 * 如果做过Java笔试题，会对这两个运算符非常敏感，他们有短路特性，前面的条件判真（或者假）了，就不会再执行后面的条件了
 * 这时就能联想到--n,直到等于0就能返回值。
 */
public class 求1到n的和 {

    public int Sum_Solution(int n) {

        int ans = n;
        //利用到&&的短路性质
        boolean res = (n > 0) && ((ans+=Sum_Solution(n-1))>0);

        return ans;

    }
}
