import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public List<String> removeComments(String[] source) {
    String s = String.join("\n", source);
    Pattern pattern = Pattern.compile("//.*|/\\*(.|\n)*?\\*/");
    Matcher matcher = pattern.matcher(s);
    String result = matcher.replaceAll("");
    return List.of(result.split("\n"))
        .stream().filter(
            e -> !e.isEmpty()
        ).toList();
    }
}