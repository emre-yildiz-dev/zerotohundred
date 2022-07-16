package zerotohundred;

import java.util.Random;

class Dice {
    static char dot = (char) 0x025CF;
    static int diceNumber,dc1,dc2;
    static char[] upView = new char[] { ' ', ' ', ' ', ' ', ' ' };
    static char[] downView = new char[] { ' ', ' ', ' ', ' ', ' ' };

    static char[] showUpView(int rank) {
	for (int k = 0; k < 5; k++) {
	    upView[k] = ' ';
	}
	int j = 0;
	for (int i = 0; i < rank; i++) {
	    upView[j] = (char) 0x25CF;
	    j += 2;
	}
	return upView;
    }

    static char[] showRandomUpView() {
	for (int k = 0; k < 5; k++) {
	    upView[k] = ' ';
	}
	int j = 0;
	Random rnd = new Random();
	for (int i = 0; i < rnd.nextInt(4); i++) {
	    upView[j] = (char) 0x25CF;
	    j += 2;
	}
	return upView;
    }

    static char[] showDownView(int rank) {
	for (int k = 0; k < 5; k++) {
	    downView[k] = ' ';
	}
	int j = 0;

	for (int i = 0; i < rank; i++) {

	    downView[j] = (char) 0x25CF;
	    j += 2;
	}
	return downView;
    }
    static char[] showRandomDownView() {
	for (int k = 0; k < 5; k++) {
	    downView[k] = ' ';
	}
	int j = 0;
	Random rnd = new Random();
	for (int i = 0; i < rnd.nextInt(4) ; i++) {
	    downView[j] = (char) 0x25CF;
	    j += 2;
	}
	return downView;
    }
    
    static int randomDiceResult() {
	Random rnd = new Random();
	return rnd.nextInt(6)+1;
	}
}
