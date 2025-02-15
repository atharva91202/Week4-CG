package JavaRegex.modifystrings.removespaces;

public class ReplaceSpaces {
    public static void main(String[] args) {
        String text = "This   is  an   example   with   multiple    spaces.";
        String result = replaceSpaces(text);
        System.out.println(result);
    }
    static String replaceSpaces(String text){
        //Regex to match multiple spaces with single
        return text.replaceAll("\\s+"," ").trim();
    }
}
