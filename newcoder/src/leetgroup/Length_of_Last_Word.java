package leetgroup;

/**
 * Created by Gracecoder on 2017/9/12.
 */
public class Length_of_Last_Word {

    public int lengthOfLastWord(String s) {

        s=s.trim();
        int lastlen = 0;

        for (char c: s.toCharArray())
        {
            if (c == ' ')
                lastlen = 0;
            else
                lastlen ++;
        }
        return lastlen;

    }
}
