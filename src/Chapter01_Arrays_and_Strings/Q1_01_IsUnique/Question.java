package Chapter01_Arrays_and_Strings.Q1_01_IsUnique;

/**
 * Created by Raghu Mulukutla on 10/10/17.
 */
public class Question {
    public static boolean isUnique(String str) {
        char[] myArray = str.toCharArray();
        int len = str.length();
        for(int i=0; i<len; i++) {
            for(int j = i; (j+1) < len; j++) {
                int index1 = i;
                int index2 = j+1;
                if(myArray[index1]==myArray[index2]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Result : " + isUnique(args[0]));
    }


}