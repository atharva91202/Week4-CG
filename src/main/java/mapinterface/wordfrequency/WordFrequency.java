package mapinterface.wordfrequency;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public static HashMap<String, Integer> wordFrequency(String filepath) throws FileNotFoundException {
        HashMap<String, Integer> wordCount = new HashMap<>();

        FileReader fileReader;
        BufferedReader bufferedReader;

        try{
            fileReader = new FileReader(filepath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split(" ");
                if(words.length > 0){
                    for(String word : words){
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e){
            throw new Error("Error reading file : " + e.getMessage());
        }

        return wordCount;
    }

    public static void main(String[] args) {
        // Reading and storing frequency count in a map
        HashMap<String, Integer> frequency;
        try {
            frequency = wordFrequency("E:\\Essay.txt");
        } catch (FileNotFoundException e) {
            throw new Error("File not found : " + e.getMessage());
        }

        // displaying frequency of words
        for(Map.Entry<String, Integer> entry : frequency.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
