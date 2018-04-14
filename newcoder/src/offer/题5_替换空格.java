package offer;

/**
 * Created by Gracecoder on 2017/12/5.
 */
public class 题5_替换空格 {

    public static String replaceSpace(StringBuffer str) {

        StringBuilder sb = new StringBuilder("");

        if (str == null)
            return sb.toString();
        
        for (int i = 0 ; i < str.length() ; i++)
        {
            if (str.charAt(i)== ' ')
                sb.append("%20");
            else 
                sb.append(str.charAt(i));
        }
        
        return sb.toString();

    }
    
    
    public static void main(String[] args){
        
        System.out.println(replaceSpace(null));
        
    }
}
