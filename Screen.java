package zerotohundred;

import java.util.Arrays;

class Screen {

    static final String ZEROTOFORTYNINE = "|_00_01_02_03_04_05_06_07_08_09_10_11_12_13_14_15_16_17_18_19_20_21_22_23_24_"
	    + "25_26_27_28_29_30_31_32_33_34_35_36_37_38_39_40_41_42_43_44_45_46_47_48_49_|";
    static final String FIFTYTONINTYNINE = "|_50_51_52_53_54_55_56_57_58_59_60_61_62_63_64_65_66_67_68_69_70_71_72_73_74_"
	    + "75_76_77_78_79_80_81_82_83_84_85_86_87_88_89_90_91_92_93_94_95_96_97_98_99_";

    static String blackFlag = Character.toString((char) 0x2691);

    static void render(String str) {
	System.out.println(str);
    }

    static void renderpath(char[] playerPath) {

	System.out.print("  ");
	System.out.print(String.valueOf(playerPath));
    }

//  Main Screen 
    static void renderScreen(Player player1, Player player2, String str) {
	renderFirstPart(player1, player2);

	renderWriteLine(Dice.showUpView(Dice.dc1), Dice.diceNumber, player1, player2, str);
	renderWriteLine(Dice.showDownView(Dice.dc2), Dice.diceNumber, player1, player2, str);
	renderSecondPart(player1, player2);
    }

    static void renderWriteLine(char[] diceView, int diceResult, Player player1, Player player2, String str) {
	Player player = player1.turn ? player1 : player2;
	System.out.print("|");
	System.out.print(String.valueOf(diceView));
	System.out.print("|");
	System.out.print(" DICE RESULT IS = " + diceResult);
	System.out.print("                               ");
	System.out.println(WriteLine.infoScreen(player, str));
	System.out.println();
    }

    static void renderFirstPart(Player player1, Player player2) {
	render(ZEROTOFORTYNINE);
	renderpath(Arrays.copyOfRange(player1.path, 0, 149));
	System.out.println();
	renderpath(Arrays.copyOfRange(player2.path, 0, 149));
	System.out.println();
	render(ZEROTOFORTYNINE);
	System.out.println();
    }

    static void renderSecondPart(Player player1, Player player2) {
	System.out.println();
	render(FIFTYTONINTYNINE + blackFlag + blackFlag);
	renderpath(Arrays.copyOfRange(player1.path, 150, 305));
	System.out.println();
	renderpath(Arrays.copyOfRange(player2.path, 150, 305));
	System.out.println();
	render(FIFTYTONINTYNINE + blackFlag + blackFlag);

    }
}
