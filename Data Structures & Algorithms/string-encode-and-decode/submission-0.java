class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        // Encode the string with the format [length#str]
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        char[] chars = str.toCharArray();
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < str.length()) {
            int start = index;
                while (str.charAt(index) != '#') {
                    index++;
                }
            int length = Integer.parseInt(str.substring(start, index));
            // Skip #
            index++;
            String s = str.substring(index, index + length);
            res.add(s);
            index += length;
        }
        return res;
    }
}
