import java.util.Arrays;

public class Field {

    private char[][] field;
    private int[][] pomoc;

    // constructor default 3x3
    public Field() {
        int po = 1;
        pomoc = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pomoc[i][j] = po;
                po++;
            }
        }
        field = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = ' ';

            }
        }
//        System.out.println(Arrays.deepToString(field));
    }

    // sprawdz czy wolne pole
    public boolean checkField(int[] tablica) {
        int i = tablica[0];
        int j = tablica[1];
        if (field[i][j] != ' ') {
            return false;
        } else return true;
    }

    // mapping
    public int[] checkNumber(int numer) {
        int liczba = numer;
        int[] tablica = new int[2];
        switch (liczba) {
            case 1:
                tablica[0] = 0;
                tablica[1] = 0;
                break;
            case 2:
                tablica[0] = 0;
                tablica[1] = 1;
                break;
            case 3:
                tablica[0] = 0;
                tablica[1] = 2;
                break;
            case 4:
                tablica[0] = 1;
                tablica[1] = 0;
                break;
            case 5:
                tablica[0] = 1;
                tablica[1] = 1;
                break;
            case 6:
                tablica[0] = 1;
                tablica[1] = 2;
                break;
            case 7:
                tablica[0] = 2;
                tablica[1] = 0;
                break;
            case 8:
                tablica[0] = 2;
                tablica[1] = 1;
                break;
            case 9:
                tablica[0] = 2;
                tablica[1] = 2;
                break;

        }
        return tablica;
    }


    // setter zmapowany
    public void setField(int[] tablica, char znak) {
        int i = tablica[0];
        int j = tablica[1];

        field[i][j] = znak;
    }

    // pokaz plansze gry i pomocnicza
    public void showField() {

        System.out.print("|" + field[0][0] + " " + field[0][1] + " " + field[0][2] + "|");
        System.out.println("        |" + pomoc[0][0] + " " + pomoc[0][1] + " " + pomoc[0][2] + "|");
        System.out.print("|" + field[1][0] + " " + field[1][1] + " " + field[1][2] + "|");
        System.out.println("        |" + pomoc[1][0] + " " + pomoc[1][1] + " " + pomoc[1][2] + "|");
        System.out.print("|" + field[2][0] + " " + field[2][1] + " " + field[2][2] + "|");
        System.out.println("        |" + pomoc[2][0] + " " + pomoc[2][1] + " " + pomoc[2][2] + "|");
        System.out.println();


    }

    /// sprawdz czy zajete
    public boolean emptyField(int i, int j) {
        return field[i][j] == ' ';
    }


    // sprawdz wygrana
    public boolean wygrana(Player gracz) {

        if (field[0][0] == gracz.getSymbol() && field[0][1] == gracz.getSymbol() && field[0][2] == gracz.getSymbol()) {
            System.out.println(gracz.getName() + " WYGRAŁ!!!");
            return true;

        }
        if (field[1][0] == gracz.getSymbol() && field[1][1] == gracz.getSymbol() && field[1][2] == gracz.getSymbol()) {
            System.out.println(gracz.getName() + " WYGRAŁ!!!");
            return true;

        }
        if (field[2][0] == gracz.getSymbol() && field[2][1] == gracz.getSymbol() && field[2][2] == gracz.getSymbol()) {
            System.out.println(gracz.getName() + " WYGRAŁ!!!");
            return true;

        }
        if (field[0][0] == gracz.getSymbol() && field[1][0] == gracz.getSymbol() && field[2][0] == gracz.getSymbol()) {
            System.out.println(gracz.getName() + " WYGRAŁ!!!");
            return true;

        }
        if (field[0][1] == gracz.getSymbol() && field[1][1] == gracz.getSymbol() && field[2][1] == gracz.getSymbol()) {
            System.out.println(gracz.getName() + " WYGRAŁ!!!");
            return true;

        }
        if (field[0][2] == gracz.getSymbol() && field[1][2] == gracz.getSymbol() && field[2][2] == gracz.getSymbol()) {
            System.out.println(gracz.getName() + " WYGRAŁ!!!");
            return true;

        }
        if (field[0][0] == gracz.getSymbol() && field[1][1] == gracz.getSymbol() && field[2][2] == gracz.getSymbol()) {
            System.out.println(gracz.getName() + " WYGRAŁ!!!");
            return true;

        }
        if (field[0][2] == gracz.getSymbol() && field[1][1] == gracz.getSymbol() && field[2][0] == gracz.getSymbol()) {
            System.out.println(gracz.getName() + " WYGRAŁ!!!");
            return true;

        }
        else return false;

    }
}
