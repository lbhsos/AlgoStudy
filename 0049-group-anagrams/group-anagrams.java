class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i=0; i<strs.length; i++) {
            String str = strs[i];
            char[] tmpChar = str.toCharArray();
            Arrays.sort(tmpChar);
            String sortedStr = String.valueOf(tmpChar);

            if (map.containsKey(sortedStr)) {
                List<String> arr = map.get(sortedStr);
                arr.add(str);
                map.put(sortedStr, arr);
                continue;
            }

            List<String> arr = new ArrayList<>();
            arr.add(str);
            map.put(sortedStr, arr);
        }

        List<List<String>> answer = new ArrayList<>();
        for (String str : map.keySet()) {
            map.get(str).sort(Comparator.naturalOrder());
            answer.add(map.get(str));
        }
        return answer;
    }
}
