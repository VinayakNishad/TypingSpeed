import java.util.Random;
import java.util.Scanner;

public class TypingGame {
    private static final String[] sentences = {
            "The Bill class represents a legislative bill that can be voted on.",
            "The member of parliament class represents a member of the Indian parliament.",
            "In the city of 2024, temperature rise high; vibrant lights & sounds fill the air, creating Global warming!",
            "By the lake, where nature's beauty meets serenity, @100% pure relaxation is always within un reach!",
            "The Seven Wonders of the Ancient World, selected by Hellenic travelers and noted in poetry and other arts."
    };

    private static final String[] paragraphs = {
            "The Bill class represents a legislative bill that can be voted on. The MemberOfParliament class represents a member of the Indian Parliament.\nIn the Panaji city of 2024, Temperature rise high; vibrant lights & sounds fill the air, creating Global warming!\nBy the Godavari lake, where nature's beauty meets serenity, @100% pure relaxation is always within unreach! Among ancient ruins,\nexplorers not find hidden treasures & clues: 7 wonders await, blending History & mystery."
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Typing Speed Test! Choose an option to start.");
        
        while (true) {
            System.out.println("\nChoose text type:");
            System.out.println("1. Sentence");
            System.out.println("2. Paragraph");
            System.out.print("Enter your choice (1/2): ");
            int textTypeChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String originalText;
            switch (textTypeChoice) {
                case 1:
                    originalText = sentences[random.nextInt(sentences.length)];
                    break;
                case 2:
                    originalText = paragraphs[random.nextInt(paragraphs.length)];
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }
            System.out.println("\nType the following text:");
            System.out.println(originalText);
            // Prompt to start typing
            System.out.println("\nPress Enter to start typing...");
            scanner.nextLine(); // wait for the user to press Enter



            long startTime = System.currentTimeMillis();
            System.out.print("Your input: ");
            String userInput = scanner.nextLine();
            long endTime = System.currentTimeMillis();

            // Calculate results
            long elapsedTime = endTime - startTime;
            double seconds = elapsedTime / 1000.0;
            double minutes = seconds / 60.0;

            int originalTextLength = originalText.length();
            int userInputLength = userInput.length();

            int correctChars = 0;
            int minLength = Math.min(originalTextLength, userInputLength);

            for (int i = 0; i < minLength; i++) {
                if (originalText.charAt(i) == userInput.charAt(i)) {
                    correctChars++;
                }
            }

            double grossWordsPerMinute = (userInputLength / 5.0) / minutes;
            double netWordsPerMinute = (correctChars / 5.0) / minutes;
            int accuracy = (int) ((correctChars / (double) originalTextLength) * 100);

            // Display results
            System.out.printf("\nTest Result:\n--------------\n");
            System.out.printf("Time elapsed: %.2f seconds\n", seconds);
            System.out.printf("Accuracy: %d%%\n", accuracy);
            System.out.printf("Gross Words per Minute: %.2f\n", grossWordsPerMinute);
            System.out.printf("Net Words per Minute: %.2f\n", netWordsPerMinute);

            // Award medals based on accuracy
            if (accuracy >= 90) {
                System.out.println("Gold Medal");
            } else if (accuracy >= 85) {
                System.out.println("Silver Medal");
            } else if (accuracy >= 80) {
                System.out.println("Platinum Medal");
            } else {
                System.out.println("Bad Accuracy");
            }

            // Check for extra or missing characters
            if (userInputLength > originalTextLength) {
                int extraCharacters = userInputLength - originalTextLength;
                System.out.println("Extra characters typed: " + extraCharacters);
            } else if (userInputLength < originalTextLength) {
                int missingCharacters = originalTextLength - userInputLength;
                System.out.println("Missing characters: " + missingCharacters);
            }

            System.out.print("\nWould you like to try again? (yes/no): ");
            String tryAgain = scanner.nextLine();
            if (!tryAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Thank you for playing!");
    }
}
