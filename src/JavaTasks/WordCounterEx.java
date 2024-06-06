package JavaTasks;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class WordCount {
    private Scanner scanner = new Scanner(System.in);

    void wordCount(int choice) throws IOException {
        if (choice == 1) {
            System.out.println("Enter The Text: ");
            String input = scanner.nextLine();
            while (true) {
                System.out.print(
                        "Please Enter:\n1. -> To know the Total Number of Words.\n2. -> To know the frequency of all input words.\n3. -> To know the frequency of all input words except common words.\n4. -> To Exit : ");
                int options = Integer.parseInt(scanner.nextLine());
                switch (options) {
                    case 1:
                        System.out.println("-->THE TOTAL NUMBER OF TOKENS IN THE ORIGINAL STRING: " + input.split("\\s+").length);
                        break;

                    case 2:
                        System.out.println("To know the frequency of all input words.");
                        wordOccurrence(input);
                        break;

                    case 3:
                        System.out.println("To know the frequency of all input words except common words");
                        Map<String, Integer> wordFrequency = getWordFrequency(input, true);
                        System.out.println("--->  Total Number of Words (except common words): " + wordFrequency.size());
                        System.out.println("-->"
                        		+ "The Common Words are : { \"a\", \"and\", \"as\", \"in\", \"is\", \"it\", \"of\", \"that\", \"the\", \"to\", \"with\"}");
                        System.out.println("Word Frequency:");
                        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                        break;

                    case 4:
                        System.out.println("Thank You for using the program!!!");
                        return;

                    default:
                        System.out.println("INVALID OPTION");
                }
            }

        } else if (choice == 2) {
            fileWordCount();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private Map<String, Integer> getWordFrequency(String input, boolean excludeCommonWords) {
        String[] words = input.split("[\\s.,!?;:]+");
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase();
            if (excludeCommonWords && isCommonWord(word)) {
                continue;
            }
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        return wordFrequency;
    }

    public static boolean isCommonWord(String word) {
        String[] commonWords = { "a", "and", "as", "in", "is", "it", "of", "that", "the", "to", "with" };
        return Arrays.asList(commonWords).contains(word.toLowerCase());
    }

    void fileWordCount() throws IOException {
        System.out.println("Select File Path for Count Words:");
        String path = scanner.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                count += words.length;
            }
            System.out.println("Number of Words present in Given File: " + count);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    void wordOccurrence(String input) {
        Map<String, Integer> words = new HashMap<>();
        for (String word : input.split("\\s+")) {
            word = word.toLowerCase();
            words.put(word, words.getOrDefault(word, 0) + 1);
        }
        System.out.println("-->WORD FREQUENCY OF THE TEXT: " + words);
    }

    void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}

public class WordCounterEx {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter '1' to input text manually or '2' to specify a file for word count: ");
        int choice = Integer.parseInt(scanner.nextLine());

        WordCount wc = new WordCount();
        wc.wordCount(choice);

        wc.closeScanner();
        scanner.close();
    }
}
