import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ladder {
    // Panels are the physical glass or tempered glass sheets
    public int panels;




    // ladder is the ladder structure (2d array)
    public int[][] ladder;
    
    // round counter
    public int round = 1;

    // make a ladder object with no parameter (default 5 panels)

    // make a ladder object with a panel parameter and assign the panels to that int

    // create an array list called selections of integers for the selections the user will enter

    // ----make a int method to get the selection from the user called getSelection()---

// make a ladder object with no parameter (default 5 panels)
    public Ladder() {
        this.panels = 5;
        this.ladder = new int[this.panels][this.panels];
    }
// make a ladder object with a panel parameter and assign the panels to that int
    public Ladder(int panels) {
        this.panels = panels;
        this.ladder = new int[this.panels][this.panels];
    }
// create an array list called selections of integers for the selections the user will enter
ArrayList<Integer> selections = new ArrayList<Integer>();



public int getSelection() {
        // Get user input for selection
        int selection = 0;

        // Add selection to the array list
        this.selections.add(selection);

        return selection;
    }



   
// create a Scanner object for user input
    Scanner input = new Scanner(System.in);

    // create a int variable for convertedSelection
    int convertedSelection;

    // collect the selection (use scanner here)
    public int collectSelection() {
        // get user input for selection
        String selection = input.nextLine();

        // if selection is L or l convert the selection to 0
        if (selection.equalsIgnoreCase("L")) {
            this.convertedSelection = 0;
            // Print the selection selected
            System.out.println("Selection selected: " + selection);
            // return convertedSelection
            return this.convertedSelection;
        }
        // else if selection is R or r
        else if (selection.equalsIgnoreCase("R")) {
            // convertSelection = 1
            this.convertedSelection = 1;
            // Print the selection selected
            System.out.println("Selection selected: " + selection);
            // return the converted selection
            return this.convertedSelection;
        }
        // else print selection is invalid
        else {
            System.out.println("Invalid selection. Please try again.");
            // collect the selection again
            collectSelection();
        }
        return convertedSelection;
    }






    // REMEMBER 2d array is [row][column]
    
   

// create a 2d array method called createLadder()
    public int[][] createLadder() {
        // inside this method create a new 2d array where your rows 
        // are the panels and the colums is hard coded to 2
        this.ladder = new int[this.panels][2];

        // make a double for loops with variables i and j
        for (int i = 0; i < this.ladder.length; i++) {
            for (int j = 0; j < this.ladder[i].length; j++) {
                // inside the double for loop assign ladder[i][j] to a random int
                this.ladder[i][j] = (int) (2 * Math.random()) + 1;
            }
        }
        return ladder;
    }





    


// then the magic happens:
    // we need to determine that the random values create do not
    // contain two of the same values per row
    public void createLadderDuplicate() {
        // make a double for loops with variables i and j
        for (int i = 0; i < this.ladder.length; i++) {
            for (int j = 0; j < this.ladder[i].length; j++) {
                // inside the double for loop assign ladder[i][j] to a random int
                this.ladder[i][j] = (int) (2 * Math.random()) + 1;
            }

            // make an if statement inside the 'i' of the for loop to check 
            // if the row 'i' of the ladder in the first column is equal 
            // to the row 'i' of the second column
            if (this.ladder[i][0] == this.ladder[i][1]) {
                // then a second nested if statement to check if the row 'i' of the first column
                // is equal to 0 (use ==0 here)
                if (this.ladder[i][0] == 0) {
                    // if this is true assign ladder[i][0]=1
                    this.ladder[i][0] = 1;
                }
                // else we want the value to be 0 so ladder[i][0]=0
                else {
                    this.ladder[i][0] = 0;
                }
            }
        }
    }





    


 // create a boolean method called calcPanel that takes in the following parameters:
    // 1. 2d int array ladder
    // 2. Integer ArrayList called selections
    public boolean calcPanel(int[][] ladder, List<Integer> selections) {
        // Create a boolean variable called hasWon and initialize it to false
        boolean hasWon = false;

        // Create a for loop to iterate over the selections
        for (int i = 0; i < selections.size(); i++) {
            // Create an int variable called selection and initialize it to the value of the current iteration of the loop
            int selection = selections.get(i);

            // Create an if statement to check if the selection is 0
            if (selection == 0) {
                // If the selection is 0, check if the value of the current panel in the first column is equal to 0
                // If it is, set hasWon to true
                if (ladder[i][0] == 0) {
                    hasWon = true;
                }
            }
            // Else, if the selection is not 0, check if the value of the current panel in the second column is equal to 0
            // If it is, set hasWon to true
            else if (ladder[i][1] == 0) {
                hasWon = true;
            }
        }

        // Return the value of hasWon
        return hasWon;
    }
    


    // This method is pretty complex and will calculate the selections from the user in getSelection
    // and see if it matches up the 2d array from createLadder
    /**
     * @return
     */
    public boolean checkAnswer() {
        // First create an int size of the selections size
        int size = this.selections.size();

        // then print the Round variable from above (that's why we made it global)
        System.out.println("Round " + this.round);

        // make an int array called temp of size 2
        int[] temp = new int[2];

// create a for loop as long as i is less than ladder[0].length
        for (int i = 0; i < this.ladder[0].length; i++) {
            // temp[i] = ladder[size][i]
            temp[i] = this.ladder[size][i];
        }

        // create an int variable called currentSelection to get the current selection from the getSelection method
        int currentSelection = getSelection();

        // use the array list's add method to add the currentSelection
        this.selections.add(currentSelection);

        // create an int choice to use the selections array list method .get for the selections size-1(also another arraylist method)
        int choice = this.selections.get(this.selections.size() - 1);


// using an if statment check if temp[choice]==1
    if (temp[choice] == 1) {
        // if it is then the choice is correct
        System.out.println("Answer is correct!");

        // increment the round counter
        this.round++;

        // return true (this is a boolean method afterall)
        return true;
    } else {
        // else
        // remove the last variable from the selections arraylist (using size method (size-1) like above)
        this.selections.remove(this.selections.size() - 1);

        // increment the round counter
        this.round++;

        // print and say they lose 1 life
        System.out.println("You lose 1 life!");

        // return false
        return false;
        }
    }









    
    // EVERYTHING AFTER THIS POINT IS TO PRINT THE LADDER
    // HERE IS HOW TO PRINT A BLANK LADDER
    public void printLadderBlank(){
        try {
            System.out.println("|||||| ---- Start");
            for (int i = 0; i < ladder.length; i++) {
                System.out.print("|"+" || "+"|");
                System.out.println();
            }
            System.out.println("|||||| ---- Finish");
        } catch (Exception e) {
            System.out.println("ERROR LADDER IS NOT CREATED OR IS NULL...");
            }
        }
    
    // From here you will need to create 2 more methods one for printLadder() and one for printCurrentLadder()
    // printLadder():
    // in a try block similar to above
    // print System.out.println("|||||| ---- Start");
    // then in a for i loop of ladder.length 
    // in a for j loop ladder[i].length 
    // print the ladder[i][j]
    // like this:
    // "|"+ladder[i][j] + "|"
    // make a black printline
    // catch an Exception e like i have above in printLadder Blank 
    

    public void printLadder() {
        try {
            System.out.println("|||||| ---- Start");
            for (int i = 0; i < ladder.length; i++) {
                for (int j = 0; j < ladder[i].length; j++) {
                    System.out.print("|" + ladder[i][j] + "|");
                }
                System.out.println();
            }
            System.out.println("|||||| ---- Finish");
        } catch (Exception e) {
            System.out.println("ERROR LADDER IS NOT CREATED OR IS NULL...");
        }
    }





    // printCurrentLadder():
    // print System.out.println("|||||| ---- Start");
    // make a nested for loop like above except the i should be i < selections.size()
    // the j should be j< ladder[i].length
    // print out ladder[i][j]
    // like this:
    // System.out.print("|"+ladder[i][j] + "|");
    // outside the inner for loop print a blank line
    // ouside both for loops print a ? ladder 
    // like this:
    // System.out.println("|?||?|");
    
    public void printCurrentLadder() {
    try {
        int size = this.selections.size();
        System.out.println("|||||| ---- Start");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                System.out.print("|" + ladder[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("|||||| ---- Finish");
    } catch (Exception e) {
        System.out.println("ERROR LADDER IS NOT CREATED OR IS NULL...");
        }
    }
}
