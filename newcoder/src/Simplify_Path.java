import java.util.Stack;

/**
 * Created by Gracecoder on 2017/9/8.
 */
public class Simplify_Path {

    public static String simplifyPath(String path) {

        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();



        for (String str : dirs)
        {
            if (str.equals(".")||str.equals(""))            //过滤空字符
                continue;
            else if (str.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(str);
        }

        StringBuilder res = new StringBuilder("");


        //如果dirs长度为0 或者 stack为空的话 需要返回"/"
        //临界path = "/."需要返回"/"   path="/home//user" 返回"/home/user"
        if (dirs.length == 0 || stack.isEmpty())
            return "/";

        while (!stack.isEmpty())
        {
            res.insert(0,stack.pop());
            res.insert(0,"/");
        }


        return res.toString();
    }

    public static void main(String[] args){

        String path = "/home/";

        String res1 =simplifyPath(path);
        System.out.println(res1);


        String[] res  = path.split("/");

        for (String str : res)
            System.out.println(str);



    }
}
