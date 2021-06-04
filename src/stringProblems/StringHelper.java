package stringProblems;

public class StringHelper {


    public static void main(String[] args) {

        System.out.println(isSharedSubstring("art", "ammo"));
        System.out.println(isSharedSubstring("be", "cat"));
        System.out.println(getLongestMatchingSubstringLength("wonderful", "fulsome"));
    }

    /**
     * Given two strings, determine if they share a common substring. A substring may be as small as one character.
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isSharedSubstring(String str1, String str2) {
        char[] firstArray = str1.toLowerCase().toCharArray();
        char[] secondArray = str2.toLowerCase().toCharArray();

        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < secondArray.length; j++) {
                if (firstArray[i] == secondArray[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Bonus: Can you return the length of the longest substring shared by the two strings?
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int getLongestMatchingSubstringLength(String str1, String str2) {
        int stringLength1 = str1.length();
        int stringLength2 = str2.length();
        int max = 0;

        int[][] axis = new int[stringLength1][stringLength2];
        for (int i = 0; i < stringLength1; i++) {
            for (int j = 0; j < stringLength2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {

                    if (i == 0 || j == 0) {
                        axis[i][j] = 1;
                    } else {
                        axis[i][j] = axis[i - 1][j - 1] + 1;
                    }

                    if (max < axis[i][j]) {
                        max = axis[i][j];
                    }
                }
            }
        }
        return max;
    }
}