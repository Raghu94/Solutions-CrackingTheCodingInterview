package Chapter01_Arrays_and_Strings.Q1_01_IsUnique;

import java.util.Hashtable;

/**
 * Created by Raghu Mulukutla on 10/10/17.
 *  O(1) - Hash Table
 */
public class Question_Hash_Table {
    public static boolean isUnique(String str) {
        Hashtable<Character, Integer> myHashtable = new Hashtable<Character, Integer>();
        for(char c : str.toCharArray()) {
            if(myHashtable.containsKey(c))
                return false;
            else
                myHashtable.put(c, 1);

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Result : " + isUnique("Sta"));
    }

}
