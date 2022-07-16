package zerotohundred;

class Number {

    static boolean isTwoDigits(int number) {
	return number >= 10;
    }

    static boolean isPrimeNumber(int number) {
	int factors = 0;
	int j = 1;

	while (j <= number) {
	    if (number % j == 0) {
		factors++;
	    }
	    j++;
	}
	return (factors == 2);
    }

    static boolean isDividableToTen(int number) {
	return (number % 10 == 0);
    }

    static boolean isFinished(int number1,int number2) {
	return number1 == 300 || number2 == 300;
    }
}
