import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Description:#49
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 * [
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        int size = strs.length;
        if(size == 0) return new ArrayList();
        Map<String,List> map = new HashMap<String,List>();
        for(String str:strs) {
        		char[] ca = str.toCharArray();
        		Arrays.sort(ca);
        		String key = String.valueOf(ca);
        		if(!map.containsKey(key)) map.put(key, new List());
        			map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
