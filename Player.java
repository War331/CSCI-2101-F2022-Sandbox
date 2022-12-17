public class Player {
    private int lives;

//  // make a Player object with no parameter (default lives = 5)

    // q: how can I make an object with no parameters
    // a: make a constructor with no parameters
    // q: how do I make a constructor, show me an example

    public Player() { 
        lives = 5;
    }





//  // make a player object with lives parameter

    // q: how can I make an object with a parameter
    // a: make a constructor with a parameter
    // q: how do I make a constructor, show me an example

    public Player(int lives) { 
        this.lives = lives;
    }



//  // make a method to get the lives 
    // return lives (int)

    public int getLives() {
        return lives; 
    }



//  // make a method to subtract 1 life
  
    public void death() {
         lives--;
    }


}