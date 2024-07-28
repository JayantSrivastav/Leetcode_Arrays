class Solution {
    public boolean checkInclusion(String s1, String s2) {
         HashMap<Character, Integer> map = new HashMap<>();
         for (int i = 0; i < s1.length(); i++) {
             map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
         }
         HashMap<Character, Integer> copyMap = new HashMap<Character, Integer>();
         copyMap.putAll(map);
         int pointer = 0;
         int counter = 0;
         while (pointer < s2.length()) {
             if (copyMap.containsKey(s2.charAt(pointer)) && copyMap.get(s2.charAt(pointer)) != 0) {
                    copyMap.put(s2.charAt(pointer), copyMap.get(s2.charAt(pointer)) - 1);
                    counter++;
                    if (counter == s1.length()) {
                        return true;
                    }
             }
             else {
                 counter = 0;
                 copyMap.clear();
                 copyMap.putAll(map);
                 int newPointer = pointer;
                 while (newPointer >= 0 && copyMap.containsKey(s2.charAt(newPointer)) && copyMap.get(s2.charAt(newPointer)) != 0) {
                        copyMap.put(s2.charAt(newPointer), copyMap.get(s2.charAt(newPointer))- 1);
                        counter++;
                        if (counter == s1.length()) {
                            return true;
                        }
                        newPointer--;
                 }

             }
             pointer++;
         }
         return false;
    }
}