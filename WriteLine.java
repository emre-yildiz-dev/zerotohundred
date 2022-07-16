package zerotohundred;

class WriteLine {
    static final String WINNER = " is the Winner !!!";
    static final String STARTING = " starts the game !";
    static final String MOVING =  " moving forward.." ;
    static final String PRIME_NUMBER = " crashes the PrimeNumber, moving backward.. just one step !";
    static final String DIVIDABLE_TO_TEN = " is happy for catching a dividable ten number.. moving two step forward...";
    static final String DICE_IS_ROLLING = " DICE IS ROLLING !!";
    static final String CHANCE_OF_STARTING = "  will start the Game if the Dice is Even, otherwise PlayerB starts..";
    
     static String infoScreen(Player player, String str) {
	 return (player.getName() + str);
     }
}
