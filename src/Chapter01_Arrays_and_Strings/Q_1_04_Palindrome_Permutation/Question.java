package Chapter01_Arrays_and_Strings.Q_1_04_Palindrome_Permutation;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Raghu Mulukutla on 10/11/17.
 */
public class Question {

    public static boolean isPalindromePermutation(String str) {
        String[] words = str.split("\\s+");
        Hashtable<Character,Integer> myHashtable = new Hashtable<>();
        int idx = 0;
        for(String word: words) {
            for(char c: word.toCharArray()){
                if(myHashtable.containsKey(c)) {
                    myHashtable.remove(c);
                }
                else
                    myHashtable.put(c, idx);
            }
        }
        if(myHashtable.size()==1 || myHashtable.size()==0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println("Result: " + isPalindromePermutation("tactcoapapa"));
    }
}
