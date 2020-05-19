/**
Leetcode 394 - Decode String
*/
class Solution {
    
    public String decodeString(String s) {
        String result = "";
        int lastIndex = 0;
        
        if (!s.contains("[")) {
            return s;
        }
        
        int index = 0;
        while(lastIndex < s.length() && !Character.isDigit(s.charAt(lastIndex))) {
            lastIndex++;
        }
        
        while (index < s.length()) {
            if (s.charAt(index) == '[') {
                int startIndex = index;
                int balance = 0;
                index++;
                while (index < s.length()) {
                    if (s.charAt(index) == ']' && balance == 0) {
                        // we have found the end
                        break;
                    }
                    
                    if (s.charAt(index) == '[') balance++;
                    if (s.charAt(index) == ']') balance--;
                    
                    index++;
                }
                
                // needs to go from last index to new start index
                int num = Integer.parseInt(s.substring(lastIndex, startIndex));
                // decode string needs to be more generic 
                String currentAns = decodeString(s.substring(startIndex+1, index));
                for (int i = 0; i < num; i++) {
                    result += currentAns;
                }
                
                lastIndex = index;
                while(lastIndex < s.length() && !Character.isDigit(s.charAt(lastIndex))) {
                    lastIndex++;
                }
            } else if (!Character.isDigit(s.charAt(index)) && s.charAt(index) != ']') {
                result += "" + s.charAt(index);
            }
            
            index++;
        } 
    
        return result;
    }
    
    
}
