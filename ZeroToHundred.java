package zerotohundred;

class ZeroToHundred {
    public static void main(String[] args) {

	Player playerA = new Player((char) 0x26AB);
	Player playerB = new Player((char) 0x2B55);
	playerA.setName("PLAYER_A");
	playerB.setName("PLAYER_B");
	playerA.refreshPaths();
	playerB.refreshPaths();
	playerA.locatePlayer(playerA.path, playerA.location);
	playerB.locatePlayer(playerB.path, playerB.location);

	Event.clearScreen();
	Screen.renderScreen(playerA, playerB, WriteLine.CHANCE_OF_STARTING);
	Event.sleepTime(1500);
	Event.whoIsTurn(playerA, playerB);

	while (!Number.isFinished(playerA.location, playerB.location)) {
	    Event.diceTurn(playerA, playerB);

	    Player player = playerA.turn ? playerA : playerB;
	    Event.moveTime(player, playerA, playerB, Dice.diceNumber, 3);

	    Event.numberControls(player, playerA, playerB);
	    Event.swapTurn(playerA, playerB);
	}
	Event.clearScreen();
	Event.swapTurn(playerA, playerB);
	Screen.renderScreen(playerA, playerB, WriteLine.WINNER);
    }
}
