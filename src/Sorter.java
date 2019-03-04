/**
 * Created by veronika on 04.03.2019.
 */
import java.util.*;

public class Sorter {
    static String directors[] = new String[]{"kubrick", "fincher", "polanski", "aronofski", "hitchcock", "coppola", "refn"};
    static List<String> lst = new ArrayList<>();

    public static void main(String[] args) {
        //Sorter srt = new Sorter();
        Collections.addAll(lst, directors);
        sortWithoutComparator(lst);
        for (String s : lst)
            System.out.println(s);
    }

    public static void sortWithoutComparator(List<String> lst){

        Map<Character, Integer> priorityMap = new HashMap<>();
        priorityMap.put('a', 1); priorityMap.put('b', 2);
        priorityMap.put('c', 3); priorityMap.put('d', 4);
        priorityMap.put('e', 5); priorityMap.put('f', 6);
        priorityMap.put('g', 7); priorityMap.put('h', 8);
        priorityMap.put('i', 9); priorityMap.put('j', 10);
        priorityMap.put('k', 11); priorityMap.put('l', 12);
        priorityMap.put('m', 13); priorityMap.put('n', 14);
        priorityMap.put('o', 15); priorityMap.put('p', 16);
        priorityMap.put('q', 17); priorityMap.put('r', 18);
        priorityMap.put('s', 19); priorityMap.put('t', 20);
        priorityMap.put('u', 21); priorityMap.put('v', 22);
        priorityMap.put('w', 23); priorityMap.put('x', 24);
        priorityMap.put('y', 25); priorityMap.put('z', 26);

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

