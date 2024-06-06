package JavaTasks;

import java.util.*;

class Game
{
    Game()
    {
        Scanner scanner = new Scanner(System.in);
        int chances = 6;
        int score = 0;
        boolean playAgain = true;
        
        while(playAgain)
        {
            Random ran = new Random();
            int random = ran.nextInt(1, 100);
            boolean playerVal = false;
            System.out.println("RANDOM NUMBER HAS BEEN GENERATED. GUESS THE NUMBER BETWEEN (1 to 100)");
            
            for(int i = 1; i <= chances; i++)
            {
                System.out.println("CHANCE NO:" + i);
                try {
                    int guess = Integer.parseInt(scanner.nextLine());
                    if(guess == random)
                    {
                        playerVal = true;
                        score++;
                        System.out.println("CONGRATULATIONS PLAYER, YOU WON THE GAME!");
                        break;
                    }
                    else if(guess < random)
                    {
                        System.out.println("LESS THAN GENERATED VALUE");
                    }
                    else if(guess > random)
                    {
                        System.out.println("GREATER THAN GENERATED VALUE");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 100.");
                    i--; // to not count this as a valid chance
                }
            }

            if(!playerVal)
            {
                System.out.println("SORRY User. The Random Number Generated was: " + random);
            }

            System.out.println("DO YOU WANT TO PLAY AGAIN (Y/N)?");
            String play = scanner.nextLine();
            playAgain = play.equalsIgnoreCase("Y");
        }
        
        System.out.println("YOUR FINAL SCORE IS: " + score);
        System.out.println("HOPE YOU ENJOYED THE GAME :)");
        scanner.close();
    }
}

public class NumberGame 
{
    public static void main(String[] args) 
    {
        System.out.println("HI USER, WELCOME TO THE NUMBER GAME");
        System.out.println("GAME-RULES:");
        System.out.println("============================================================================================");
        System.out.println("1 - A RANDOM NUMBER WILL BE GENERATED AND THE USER SHOULD GUESS THE VALUE");
        System.out.println("2 - IF THE USER GUESSES THE VALUE, HIS/HER SCORE INCREASES");
        System.out.println("3 - HE/SHE CAN PLAY MULTIPLE ROUNDS TO INCREASE THE SCORE");
        System.out.println("4 - FOR EACH ROUND USER HAS ONLY 6 CHANCES");
        System.out.println("============================================================================================");

        new Game();
    }
}
