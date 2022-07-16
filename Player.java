package zerotohundred;

class Player {
    private String name;
    private char shape;
    private int diceCount;

    boolean turn;
    int isPassedThroughNumber;

    int location = 0;

    char[] path;

    Player(char a) {
	this.setShape(a);
	this.turn = false;
	this.isPassedThroughNumber = 0;
	this.path = new char[305];
    }

    String getName() {
	return name;
    }

    void setName(String name) {
	this.name = name;
    }

    int getDiceCount() {
	return diceCount;
    }

    void setDiceCount(int diceCount) {
	this.diceCount = diceCount;
    }

    char getShape() {
	return shape;
    }

    void setShape(char shape) {
	this.shape = shape;
    }

    char[] moveForwardOnPath1(char[] path, int location,int distance) {

	path[location + distance] = this.shape;

	return path;
    }

    
    void setPath(char[] path) {
	for (int i = 0; i < path.length; i++) {
	    path[i] = ' ';
	}

    }

    char[] locatePlayer(char[] path, int location) {
	path[location] = this.shape;
	return path;
    }

    void refreshPaths() {
	this.setPath(this.path);
    }
   
}
