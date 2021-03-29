public class Palindrome {
    public static void main(String[] args){
        for (int i = 0; i < args.length; i++){
            System.out.println(isPalindrome(args[i]));
        }
    }

    public static String revrseString(String origin){
        String reversed = "";
        for (int i = 0; i<origin.length(); i++){
            reversed += origin.charAt(origin.length()-1-i);
        }
        return reversed;
    }
    public static boolean isPalindrome(String s){
        return s.equalsIgnoreCase(revrseString(s));
    }
}