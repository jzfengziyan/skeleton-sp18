public class Palindrome{
    public Deque<Character> wordToDeque(String word){
        Deque<Character> res = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i ++){
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word){
        if (word.length() == 1 || word.length() == 0)
            return true;
        if (word == null)
            return false;
        Deque<Character> wordDeque = wordToDeque(word);
        int timeleft = word.length() / 2;
        while (timeleft != 0){
            if (wordDeque.removeFirst() != wordDeque.removeLast()){
                return false;
            }
            timeleft --;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if (word.length() == 1 || word.length() == 0)
            return true;
        if (word == null)
            return false;
        Deque<Character> wordDeque = wordToDeque(word);
        int timeleft = word.length() / 2;
        while (timeleft != 0){
            if (cc.equalChars(wordDeque.removeFirst(), wordDeque.removeLast()) != true){
                return false;
            }
            timeleft --;
        }
        return true;
    }
}