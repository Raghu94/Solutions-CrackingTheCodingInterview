package Chapter01_Arrays_and_Strings.Q_1_05_One_Away;

import java.util.Hashtable;

/**
 * Created by Raghu Mulukutla on 10/10/17.
 */
public class Question {
    public static boolean isOneAway(String str1, String str2) {
        if(Math.abs(str1.length() - str2.length())>1)
            return false;
        Hashtable<Character, Integer> hashtable = new Hashtable<>();
        for(char c : str1.toCharArray()) {
            if(hashtable.containsKey(c)) {
                int count = hashtable.get(c);
                hashtable.remove(c);
                count++;
                hashtable.put(c, count);
            }
            else {
                hashtable.put(c,1);
            }

        }

        System.out.print(hashtable.toString());
        boolean isEdited = false;

        for(char c: str2.toCharArray()) {
            if(hashtable.containsKey(c)) {
                int count = hashtable.get(c);
                hashtable.remove(c);
                count--;
                if(count != 0){
                    hashtable.put(c, count);
                }
            }
            else if(!hashtable.containsKey(c) && !isEdited)
                isEdited = true;
            else
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println( "Result: " + isOneAway("pale","ple"));
    }
}
