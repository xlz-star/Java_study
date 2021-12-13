package com.xlz.demo01;

import java.util.HashMap;
import java.util.Scanner;

public class demo01 {
    public static void main(String[] args) {
        FanYi fanYi = new FanYi();
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        System.out.println(fanYi.fanyi(word));
    }
}

class FanYi {
    HashMap<String, String> map = new HashMap<>();

    public FanYi() {
        /**
         * 构造函数，可在后面用put方法继续添加翻译
         */
        this.map.put("Hello", "你好");
        this.map.put("World", "世界");
        this.map.put("name", "姓名");
    }

    public String fanyi(String word) {
        /**
         * 输入：word 需要翻译的单词
         * 输出：chinese 翻译单词的中文释义，若map集合中没有对应释义则返回 “查询失败！ ”
         */
        String chinese = this.map.get(word);
        if (chinese == null) {
            chinese = "查询失败！";
        }
        return chinese;
    }
}

