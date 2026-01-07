// 方法1

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 创建哈希表，依旧查找是否匹配，入表字符串
        // 什么样的哈希表？ key：字符串  value：字符串数组
        Map<String, List<String>> hashtable = new HashMap <String, List<String>>();
        // 遍历每个字符串，如果此前存在加入到value中，如果不存在的话就新建
        for (String str : strs) {
            // 先处理字符串
            char[] array1 = str.toCharArray();
            Arrays.sort(array1);
            String key = new String(array1);
            List<String> list1 = hashtable.getOrDefault( key, new ArrayList<String>());
            list1.add(str);
            System.out.println(list1);
            hashtable.put( key, list1);

        }
        return new ArrayList<List<String>>(hashtable.values());

    }
}

// 方法2

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 创建哈希表，依旧查找是否匹配，入表字符串
        // 什么样的哈希表？ key：包含字母数字数量的字符串  value：字符串数组
        Map<String, List<String>> hashtable = new HashMap <String, List<String>>();
        // 遍历每个字符串，如果此前存在加入到value中，如果不存在的话就新建
        for (String str : strs) {
            // 先处理字符串
            int[] tmpInt = new int[26];
            for (int i = 0; i < str.length(); i++) {
                tmpInt[str.charAt(i) - 'a']++;
            }
            StringBuilder keybf = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                if (tmpInt[i] != 0) {
                    keybf.append((char)('a' + i));
                    keybf.append(tmpInt[i]);
                }

            }

            String key = keybf.toString();
            List<String> list1 = hashtable.getOrDefault( key, new ArrayList<String>());
            list1.add(str);
            System.out.println(list1);
            hashtable.put( key, list1);

        }
        return new ArrayList<List<String>>(hashtable.values());

    }
}














// 题解:
 

// 方法一：排序

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

// 方法二：计数

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
