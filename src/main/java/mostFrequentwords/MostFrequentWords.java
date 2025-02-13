package mostFrequentwords;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentWords {
    public static HashMap<String, Integer> findFrequency(String filepath){
        HashMap<String, Integer> wordCount = new HashMap<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            String line;

            while((line = bufferedReader.readLine()) != null){
                String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split(" ");

                for(String word : words){
                    int value = wordCount.getOrDefault(word, 0) + 1;
                    wordCount.put(word, value);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordCount;
    }

    public static void displayTopWords(HashMap<String, Integer> wordCount, int topN){
        ArrayList<Map.Entry<String,Integer>> sortedList = new ArrayList<>(wordCount.entrySet());

        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for(int i = 0 ; i < topN ; i++){
            String word  = sortedList.get(i).getKey();
            int frequency = sortedList.get(i).getValue();
            System.out.println(word + " : " + frequency);
        }
    }

    public static void main(String[] args) {
        String filepath = "C:\\CapgeminiHandsOn\\learnings\\SundayAssignment.txt";
        int topWordsToFind = 5;

        HashMap<String, Integer> wordCount = findFrequency(filepath);

        displayTopWords(wordCount, topWordsToFind);
    }
}
