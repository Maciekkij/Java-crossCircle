
import java.util.Scanner;

public class Game {

    private Player one;
    private Player two;
    private Player current;
    private Player prev;
    private Field pole;
    private Scanner in;

    public Game() {
        one = new Player("Gracz 1", 'X');
        two = new Player("Gracz 2", 'O');
        current = one;
        prev = two;
        pole = new Field();
        pole.showField();

    }

    //zamiana graczy
    public void switchPlayers() {
        if (current == one) {
            current = two;
            prev = one;
        } else if (current == two) {
            current = one;
            prev = two;
        }
    }

    // pobierz liczbe
    public int getField() {
        int pom = 100;
        while (pom < 1 || pom > 9) {
            in = new Scanner(System.in);
            while (!in.hasNextInt())
            {
                in.nextLine();
                System.out.print("Wprowadź cyfre 1-9:  ");
            }


            pom = in.nextInt();
            if (pom < 1 || pom > 9) {
                pole.showField();
                System.out.println("Nieprawidłowa licza! Podaj poprawną: ");

            }
        }
        return pom;

    }


    // ruch gracza
    public void playerMove(Player gracz) {
        int liczba = 100;

        System.out.println(gracz.getName() + " ,Twój ruch: ");
        liczba = getField();

        while (!pole.checkField(pole.checkNumber(liczba))) {
            pole.showField();
            System.out.println("pole zajete! Wybierz inne: ");
            liczba = getField();
        }

        System.out.println("Wybrałeś pole: " + liczba);
        pole.setField(pole.checkNumber(liczba), current.getSymbol());
        pole.showField();

        switchPlayers();
    }


    public void playGame() {
        while (!pole.wygrana(prev))
            playerMove(current);

    }
}
