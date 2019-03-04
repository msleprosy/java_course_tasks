/**
 * Created by veronika on 04.03.2019.
 */
import java.util.*;

public class Sorter {
    static String directors[] = new String[]{"kubrick", "fincher", "polanski", "aronofski", "hitchcock", "coppola", "refn"};
    static List<String> lst = new ArrayList<>();
    
    public static void main(String[] args) {
        Collections.addAll(lst, directors);
        sortWithoutComparator(lst);
        for (String s : lst)
            System.out.println(s);
    }

    public static void sortWithoutComparator(List<String> lst){

        Map<Character, Integer> priorityMap = new HashMap<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Integer priority = 1;
        for (char symbol : alphabet.toCharArray()) {
            priorityMap.put(symbol, priority);
            priority++;
        }

        for (int i =0; i < lst.size(); i++) {
            for (int k = 0; k < lst.size() - 1; k++) {
                int upperBorder;
                String string1 = lst.get(k);
                char[] string1Array = string1.toCharArray();
                String string2 = lst.get(k + 1);
                char[] string2Array = string2.toCharArray();
                if (string1Array.length < string2Array.length) {
                    upperBorder = string1Array.length;
                } else upperBorder = string2Array.length;
                for (int j = 0; j < upperBorder; j++) {
                    char charFromString1ToCheck = string1Array[j];
                    char charFromString2ToCheck = string2Array[j];
                    int priorityOfString1Character = priorityMap.get(charFromString1ToCheck);
                    int priorityOfString2Character = priorityMap.get(charFromString2ToCheck);
                    if (priorityOfString1Character > priorityOfString2Character) {
                        lst.set(k, string2);
                        lst.set(k + 1, string1);
                        break;
                    } else if (priorityOfString1Character < priorityOfString2Character){
                        break;
                    }
                }
            }
        }
    }
}

