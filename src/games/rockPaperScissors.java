package games;

import java.util.Random;
import java.util.Scanner;

public class rockPaperScissors {

    //Variables declared outside any method to be accessible from anywhere inside the class(instance variables)
    String playerName;
    String playerMove;
    String computerMove;
    int score;
    Scanner myScanner = new Scanner(System.in);

    //Main method that runs when the program is started
    public static void main(String[] args){
        rockPaperScissors rps = new rockPaperScissors(); //New instance of the class
        rps.initialiseGame(); //Calling the method that initialises the game
    }


    //Method that initialises the game
    private void initialiseGame(){
        System.out.println("Enter your name: "); //Letting the user know he/she should enter his/her name
        playerName = myScanner.nextLine(); //Reading the user input and saving it in a String variable
        playGame(); //Calling the method that starts the game
    }

    //Method in which the game is played
    private void playGame(){
        System.out.println("Enter your move: "); //Asking the user to input his/her move
        playerMove = myScanner.nextLine(); //Reading the user input and saving it in a String variable
        System.out.println(playerName + " has selected " + playerMove + " as their move"); //Displaying to the user what name and move was inputted
        computerMove = generateComputerMove(); //Calling the generateComputerMove method and saving the returned value in a string variable
        /**
        * Calling the getWinner method
         * @param playerMove - String value of what the user inputted as his/her move
         * @param computerMove - String value of what the computer move is, determined in the generateComputerMove method
         * Saving the return in a String variable
         */
        String result = getWinner(playerMove, computerMove);
        //Check if the result variable matches the "Win" String
        //If the check is successful print out msg of congratulations and increment the score (integer variable) by 1
        if(result.equalsIgnoreCase("Win")){
            System.out.println("Congratulations, you won this round!");
            score++;
        }
        //If the first check is unsuccessful, check if the result variable matches the "Lose" String, irrespective of the case of the string
        //If this check is successful print a msg to let the user know he/she lost and decrement the score (integer variable) by 1
        else if(result.equalsIgnoreCase("Lose")){
            System.out.println("You lost this round!");
            score--;
        }
        //If the first and second check are unsuccessful, print out a msg to let the user know the result was a draw
        else {
            System.out.println("This round was a draw!");
        }

        //Check the score variable
        //If the value of the score is smaller then 3 and bigger than -3 (both conditions must be true) call the playGame method
        if(score < 3 && score > -3){
            playGame();
        }
        //If the previous check was unsuccessful, check if the score is equal to 3
        //If the score has the value 3, print out a msg to let the user know he/she won
        else if(score == 3){
            System.out.println("Winner Winner!!");
        }
        //If the first and second checks are unsuccessful, check to see if the score is equal to -3
        //If the score variable has a value of -3, print out a msg to let the user know he/she lost
        else if(score == -3){
            System.out.println("You Looooooosssseeeee!");
        }

    }

    //Method to generate the computer move, returns a String
    private String generateComputerMove() {
        Random r = new Random(); //New Random class instance saved to a reference variable of Random object data type
        String move = ""; //Empty String variable
        int i = r.nextInt(3); // Generate a random int with values between 0 and 3 exclusive by calling the nextInt method on r variable
        //switch statement to compare the value of i with each case that is possible in this situation, as it is already know it can only be 0, 1, or 2
        switch(i){
            case 0: //for the case in which i is equal to 0, change the value of move to "Rock"
                move = "Rock";
                break; //break out of the switch statement as the condition was met

            case 1: //for the case in which i is equal to 1, change the value of move to "Paper"
                move = "Paper";
                break;

            case 2: //for the case in which i is equal to 2, change the value of move to "Scissors"
                move = "Scissors";
                break;
        }
        return move; //return the value of move variable
    }

    /**
     * Method to determine the winner, takes 2 parameters
     * @param playerMove - String inputted by the user as his/her move
     * @param computerMove - String value of what the computer move is, determined in the generateComputerMove method
     * @return outcome - String value
     * */
    private String getWinner(String playerMove, String computerMove){
        String outcome = ""; //Declare an empty String variable

        //Nested if statements to determine the value of outcome based on the rules of the game and the moves selected by the user and generated for the computer
        //First check if the playerMove variable is equal to "rock" value, not case sensitive
        if(playerMove.equalsIgnoreCase("rock")){
            //If the first check is true
            //Check if the computerMove variable is equal to "rock value, if true change the value of outcome variable to "Draw"
            if(computerMove.equalsIgnoreCase("rock")){
                outcome = "Draw";
            }
            //If the previous check is false, check if the computerMove variable is equal to "paper", if true change the value of outcome variable to "Lose"
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Lose";
            }
            //If the previous check is false, change the value of outcome to "Win"
            else{
                outcome = "Win";
            }
        }
        //If the playerMove variable is not equal to "rock" value, check to see if playerMove variable is equal to "paper" value
        if(playerMove.equalsIgnoreCase("paper")){
            //If the check is true move inside the if statement,
            //Check if the computerMove variable is equal to "rock" value, if true change the value of outcome to "Win"
            if(computerMove.equalsIgnoreCase("rock")){
                outcome = "Win";
            }
            //If previous check is false, check if the computerMove value is equal to "paper", if true change the value of outcome to "Draw"
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Draw";
            }
            //If both previous checks are false, it can only mean that the user has lost, and the value of outcome becomes "Lose"
            else{
                outcome = "Lose";
            }
        }
        //If the playerMove is not equal to "paper" value, nor is it equal to "rock" value, check to see if playerMove is equal to "scissors" value
        if(playerMove.equalsIgnoreCase("scissors")){
            //If the first check is true move inside the if statement and check the value of computerMove
            //If the value of computerMove is equal to "rock", change the value of outcome to "Lose"
            if(computerMove.equalsIgnoreCase("rock")){
                outcome = "Lose";
            }
            //If the previous check is false, check if the computerMove value is equal to "paper"
            //If true, change the value of outcome to "Win"
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Win";
            }
            //If both the previous checks are false, change the value of outcome to "Draw"
            else{
                outcome = "Draw";
            }
        }

        //return the value of outcome
        return outcome;
    }
}
