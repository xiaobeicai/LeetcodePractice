import java.util.HashMap;
import java.util.Map;

/*#383
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {
	/*HashMap
	 * 
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
        int len = ransomNote.length();
        if(len == 0) return true;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char ch: magazine.toCharArray()) {
        		if(!map.containsKey(ch))
        			map.put(ch, 1);
        		else
        			map.put(ch, map.get(ch)+1);
        }
        
        for(char ch: ransomNote.toCharArray()) {
        		if(map.containsKey(ch) && map.get(ch) > 0)
        			map.put(ch, map.get(ch)-1);
        		else
        			return false;
        }
        return true;
    }
}
