package ArenaRPG;

import java.util.Scanner;

public class MainHub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextBattleSimulator test1 = new TextBattleSimulator();
        Warrior fighter = new Warrior();
        System.out.println("Greetings warrior, please enter your name: ");
        String name = scanner.nextLine();
        fighter.setName(name);
        System.out.println();
        System.out.println("Welcome to the Text Battle Simulator, " + name + ".");
        System.out.println();
        test1.playGame();
    }
}