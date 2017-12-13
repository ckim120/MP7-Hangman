package Hangman;
import java.util.Scanner;
import java.util.Random;

public class Hangman {

    public static void main(String[] args) {
        Random random = new Random();
        String[] words = {"jazz","syzygy","banjo","crypt","haiku","pixel","rhythm","yacht"};
        boolean started = true;
        Scanner myscan = new Scanner(System.in);
        while(started) {
            System.out.println("Hangman!");
            char[] randomWord = words[random.nextInt(words.length)].toCharArray();
            int numOfGuesses = randomWord.length;
            char[] playerGuess = new char[numOfGuesses];
            for(int i = 0; i < playerGuess.length; i++) {
                playerGuess[i] = '_';
            }
            boolean wordGuessed = false;
            int numOfTries = 0;
            
            while(!wordGuessed && numOfTries != numOfGuesses) {
                System.out.println("Word so far");
                printArray(playerGuess);
                System.out.println("You have " + (numOfGuesses - numOfTries) + " guesses left");
                System.out.println("Enter a character or press 0 to exit");
                char guess = myscan.nextLine().charAt(0);
                numOfTries++;
                if(guess == '0') {
                    started = false;
                    wordGuessed =true;
                } else {
                      for(int i = 0; i < randomWord.length; i++) {
                          if(randomWord[i] == guess) {
                                  playerGuess[i] = guess;
                          }
                      }  
                if(isWordGuessed(playerGuess)) {
                        wordGuessed = true;
                        System.out.println("Congratulations you have won the game! ");
                }
                  }
            }
            if(!wordGuessed) {
                System.out.println("You have run out of guesses");
                System.out.println("Play another game? (y/n)");
                char choice = myscan.nextLine().charAt(0);
                if(choice == 'n') {
                    started = false;
                }
            }
        }
        System.out.println("Game over");    
        myscan.close();
    }
    
    public static void printArray(char[] array) {
        for(int i = 0; i < array.length; i ++) {
            System.out.print(array[i] + " ");
        }
    }
    
    public static boolean isWordGuessed(char[] array) {
        for(int j = 0; j < array.length; j++) {
            if(array[j] == '_') {
            return false;
            }
        }
        return true;
    }
    
}

