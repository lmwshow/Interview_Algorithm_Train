package leetgroup.字符串;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Gracecoder on 2017/9/20.
 * <p>
 * 滑动窗口
 */
public class substring_with_concatenation_of_all_words {


    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0 || s == null || s.length() == 0)
            return res;

        //初始化hashMap
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);              //说明words数组 并不是一定无重复
            else
                map.put(word, 1);
        }


        int word_len = words[0].length();

        for (int i = 0; i < word_len; i++) {
            HashMap<String, Integer> currentMap = new HashMap<>();

            int left = i;
            int count = 0;          //满足条件，开始移动左边界

            for (int j = i; j <= s.length() - word_len; j += word_len) {
                String tmp = s.substring(j, j + word_len);

                if (map.containsKey(tmp))               //map中含有，说明该窗口还有可能具有解， 如果穿过不包含可能解，就需要移动左边界了
                {
                    if (currentMap.containsKey(tmp))
                        currentMap.put(tmp, currentMap.get(tmp) + 1);
                    else
                        currentMap.put(tmp, 1);

                    if (currentMap.get(tmp) <= map.get(tmp))        //+1后仍小于 map中的值，说明这是一个未重复的word
                        count++;
                    else                                            //出现重复，窗口已经不具备解，移动左边界，直到可能含有解
                    {
                        while (currentMap.get(tmp) > map.get(tmp)) {
                            String str = s.substring(left, left + word_len);
                            if (currentMap.containsKey(str)) {
                                currentMap.put(str, currentMap.get(str) - 1);
                                if (currentMap.get(str) < map.get(str))           // -1后.currentMap中的元素不可能小于0,因为移走的是之前加进去的，所以map中只要需要最小值就是1
                                    count--;
                            }

                            left += word_len;
                        }
                    }

                    if (count == words.length) {
                        res.add(left);
                        String str = s.substring(left, left + word_len);
                        if (currentMap.containsKey(str))
                            currentMap.put(str, currentMap.get(str) - 1);
                        count--;
                        left += word_len;

                    }
                }
                else
                {
                    left = j + word_len;
                    currentMap.clear();
                    count = 0;
                }
            }
        }

        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {

        List<Integer> res = new ArrayList<>();


        for (Integer i : res)
            System.out.println(i);

    }
}
