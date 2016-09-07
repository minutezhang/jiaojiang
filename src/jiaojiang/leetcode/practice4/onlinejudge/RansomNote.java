package jiaojiang.leetcode.practice4.onlinejudge;

/**
 * @author zhang
 *
 * Created on Aug 10, 2016
 */
public class RansomNote {
    /*
    Given? an ?arbitrary? ransom? note? string ?and ?another ?string ?containing ?letters from? all ?the ?magazines,? write ?a
    ?function ?that ?will ?return ?true ?if ?the ?ransom ? note ?can ?be ?constructed ?from ?the ?magazines ; ?otherwise, ?it ?will ?return ?false. ??

    Each ?letter? in? the? magazine ?string ?can? only ?be? used ?once? in? your ?ransom? note.

    Note:
    You may assume that both strings contain only lowercase letters.

    canConstruct("a", "b") -> false
    canConstruct("aa", "ab") -> false
    canConstruct("aa", "aab") -> true
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] letterCount = new int[256];
        for (char c : magazine.toCharArray()) {
            letterCount[c]++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (letterCount[c] == 0) {
                return false;
            }
            letterCount[c]--;
        }

        return true;
    }
}
