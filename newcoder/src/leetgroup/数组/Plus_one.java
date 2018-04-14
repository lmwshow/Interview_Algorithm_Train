package leetgroup.数组;

/**
 * Created by Gracecoder on 2017/8/15.
 * 由于这题是比较特殊的大数处理，只有从低位开始全是9，才会不断产生进位，
 * 而且进位后数字为0。当且仅当说有数位全是9的时候，才会多进出1位，此时最高位是1，其他所有位全是0（由于多出1位，因此需要在最后添加1个0）。
 */
public class Plus_one {

    public int[] plusOne(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;


    }

}
