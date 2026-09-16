class Solution {
    public String reverseWords(String s) {
        String [] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < words.length ;i++){
            char[] chars = words[i].toCharArray();
            int left = 0;
            int right = chars.length - 1;
            while(left < right){
                  char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;

            }
            
        result.append(new String(chars));
        if(i < words.length - 1){
            result.append(" ");
        }
        }
        return result.toString();
    }
}