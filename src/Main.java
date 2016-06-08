//help from www.java-forums.org, codereview.stackexchange.com, static.void.games.com



import java.util.*;



public class Main {


    public static int wins = 0;
    public static int losses = 0;
    public static int ties = 0;

    static ArrayList<String> newResult = new ArrayList<>();







    public static String random() {


        Random rand = new Random();
        int cChoice = rand.nextInt(3);
        String[] cChoiceArray = {"r", "p", "s"};
        return cChoiceArray[cChoice];
    }


    public static void main(String[] args) {
        System.out.println("Ready to play Rock, Paper, Scissors?");
        System.out.println("Type y or n to quit. (To see game history, type h.)");

        Scanner userInput = new Scanner(System.in);
        String x = userInput.next();

        switch (x) {
            case "y":
            case "Y":
            case "YES": {
                System.out.println("Great! Let's do this.");
                // calls game method
                RpSgame();
            }   break;
            case "n":
            case "no":
            case "NO":
                System.out.println("Well, FINE. Be that way.");
                //Exits
                break;
            case "h":
            case "H":
            case "history":
                System.out.println("Wait, what history? You haven't played yet! Let's create a history!");
                //No history can be shown yet; game method is called.
                RpSgame();
                break;
            default:
                System.out.println("Invalid option.");
                //Exits
                break;

        }

    }//history method
    public static void history() {
        int history = newResult.size();
        System.out.println(newResult);



    }

// game method

    public static void RpSgame() {
        System.out.println("Please enter r, p, or s now:");
        Scanner scanThis = new Scanner(System.in);
        String playerC = scanThis.next();
        String cChoice = random();
        String result = new String();

        System.out.println("You have " + playerC + ".");
        System.out.println("The computer has " + cChoice + ".");

        if (playerC.equals("r")) {
            if (cChoice.equals("p")) {
                losses++;
                result = "lose";
                newResult.add(result);

                System.out.println("Sorry, you lose. Paper covers rock.");
            } else if (cChoice.equals("s")) {
                wins++;
                result = "win";
                newResult.add(result);
                System.out.println("You win! Rock beats scissors!");
            } else if (cChoice.equals("r")) {
                ties++;
                result = "tie";
                newResult.add(result);
                System.out.println(" You have tied!");
            }
        } else if (playerC.equals("s")) {
            if (cChoice.equals("p")) {
                wins++;
                result = "win";
                newResult.add(result);
                System.out.println("You win! Scissors cut paper!");

            } else if (cChoice.equals("r")) {
                losses++;
                result = "lose";
                newResult.add(result);
                System.out.println("Sorry...rock beats scissors.");
            } else if (cChoice.equals("s")) {
                ties++;
                result = "tie";
                newResult.add(result);
                System.out.println("A tie!");
            }

        } else if (playerC.equals("p")) {
            if (cChoice.equals("r")) {
                wins++;
                result = "win";
                newResult.add(result);

                System.out.println("Awesome! You win! Paper covers rock!");

            } else if (cChoice.equals("s")) {
                losses++;
                result = "loss";
                newResult.add(result);
                System.out.println("You win! No wait, no you lose. Scissors cut paper.");
            } else if (cChoice.equals("p")) {
                ties++;
                result = "tie";
                newResult.add(result);
                System.out.println("Whoa! A tie!");

            }



        }

// Allows people to keep playing, recalls game method until player chooses to exit.

        System.out.println("Would you like to play again? Type y, or n to quit. Type h for your game history.");
        Scanner playAgain =  new Scanner(System.in);
        String pC = playAgain.next();

        switch (pC){

            case "y":
            case "Y":
            case "YES":
                System.out.println("OK!");
                RpSgame();
                break;
            case "n":
            case "no":
            case "NO":
                System.out.println("OK, thanks for playing. Bye!");
                //Exit message
                break;
            case "h":
            case "H":
            case "HISTORY":
                System.out.println("Here is your game result history:");
                history();
                break;
            //exits

        }


    }

}




