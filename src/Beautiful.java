public class Beautiful {

    public static boolean isPalindrome(String string) {
        int length = string.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = string.charAt(forward++);
            char backwardChar = string.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }

    public static boolean isSameCharacters(String string) {
        char c = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) != c) {
                return false;
            }
        }
        return true;
    }

    public static boolean inOrder(String string) {
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i - 1) == 'b') {
                if (string.charAt(i) == 'a')
                    return false;
            } else if (string.charAt(i - 1) == 'c') {
                if (string.charAt(i) != 'c') {
                    return false;
                }
            }
        }
        return true;
    }
}
