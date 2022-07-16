package zerotohundred;

public class Event {
    static void diceTurn(Player player1, Player player2) {

	for (int i = 0; i < 6; i++) {
	    clearScreen();
	    Screen.renderFirstPart(player1, player2);
	    Event.diceTurning();
	    Screen.renderWriteLine(Dice.showUpView(Dice.dc1), Dice.diceNumber, player1, player2,
		    WriteLine.DICE_IS_ROLLING);
	    Screen.renderWriteLine(Dice.showDownView(Dice.dc2), Dice.diceNumber, player1, player2,
		    WriteLine.DICE_IS_ROLLING);
	    Screen.renderSecondPart(player1, player2);
	    try {
		Thread.sleep(500);
	    } catch (InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	}
    }

    static void whoIsTurn(Player player1, Player player2) {
	Event.diceTurn(player1, player2);
	if (Dice.diceNumber % 2 != 0) {
	    player1.turn = true;
	    Event.clearScreen();
	    Screen.renderScreen(player1, player2, WriteLine.STARTING);
	    Event.sleepTime(1500);
	} else {
	    player2.turn = true;
	    Event.clearScreen();
	    Screen.renderScreen(player1, player2, WriteLine.STARTING);
	    Event.sleepTime(1500);
	}
    }

    static void clearScreen() {
	System.out.print("\033[H\033[2J");
	System.out.flush();
    }

    static void sleepTime(int time) {
	try {
	    Thread.sleep(time);
	} catch (InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
    }

    static void diceTurning() {
	Dice.dc1 = 0;
	Dice.dc2 = 0;
	Dice.diceNumber = Dice.randomDiceResult();
	if (Dice.diceNumber > 3) {
	    Dice.dc1 = 3;
	    Dice.dc2 = Dice.diceNumber - 3;
	} else
	    Dice.dc1 = Dice.diceNumber;

    }

    static void moveTime(Player player, Player player1, Player player2, int times, int distance) {
	if (Event.controlLastPoint(player)) {
	    int x = (Dice.diceNumber * 3 - ((Dice.diceNumber * 3 + player.location) - 300)) / 3;
	    Event.moveABit(player, player1, player2, x, 3);
	    Event.clearScreen();
	    Screen.renderScreen(player1, player2, WriteLine.WINNER);
	} else
	    Event.moveABit(player, player1, player2, times, distance);
    }

    static void swapTurn(Player player1, Player player2) {
	player1.turn = player1.turn ? false : true;
	player2.turn = player2.turn ? false : true;
    }

    static void moveABit(Player player, Player player1, Player player2, int times, int distance) {
	for (int i = 0; i < times; i++) {
	    Event.clearScreen();
	    player.refreshPaths();

	    player.moveForwardOnPath1(player.path, player.location, distance);
	    player.location += distance;
	    player.locatePlayer(player.path, player.location);

	    Screen.renderScreen(player1, player2, WriteLine.MOVING);
	    Event.sleepTime(500);
	}
    }

    static void numberControls(Player player, Player player1, Player player2) {
	do {
	    if (Number.isTwoDigits(player.location / 3)) {
		if (Number.isDividableToTen(player.location / 3) && player.location != 300) {
		    player.refreshPaths();
		    Event.clearScreen();
		    player.locatePlayer(player.path, player.location);
		    Screen.renderScreen(player1, player2, WriteLine.DIVIDABLE_TO_TEN); 
		   
		    Event.sleepTime(2000);
		    Event.moveTime(player, player1, player2, 2, 3);
		    player.locatePlayer(player.path, player.location);
		} else if (Number.isPrimeNumber(player.location / 3)) {
		    player.refreshPaths();
		    Event.clearScreen();
		    player.locatePlayer(player.path, player.location);
		    Screen.renderScreen(player1, player2, WriteLine.PRIME_NUMBER);
		    
		    Event.sleepTime(2000);
		    Event.moveTime(player, player1, player2, 1, -3);
		    player.locatePlayer(player.path, player.location);
		}
	    }
	} while (Number.isTwoDigits(player.location / 3)
		&& ((Number.isDividableToTen(player.location / 3)&& player.location !=300) || Number.isPrimeNumber(player.location / 3)));

    }

    static boolean controlLastPoint(Player player) {
	return ((Dice.diceNumber * 3) + player.location) > 300;
    }
}
