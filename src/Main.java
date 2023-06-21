import java.util.*;

public class Main {
    public static String[][] board = new String[4][4];
    String playersymbol = "";

    static Boolean validation = false;

    static int count = 0;
    public static void TICTACTOE(int row, int column, String value){

        for(int i = 1; i< 4; ++i) {
            for (int j = 1; j < 4; ++j) {
                if ((i == row) && (j == column)) {
                    if (! ((board[i][j] != null) && (board[i][j].equalsIgnoreCase("X"))) && ! ((board[i][j] != null) && (board[i][j].equalsIgnoreCase("O")))) {
                        board[i][j] = value;
                    }else{
                        validation = true;
                    }
                } else {
                    if (! ((board[i][j] != null) && (board[i][j].equalsIgnoreCase("X"))) && ! ((board[i][j] != null) && (board[i][j].equalsIgnoreCase("O")))) {
                        board[i][j] = String.valueOf(i) + String.valueOf(j);
                        count++;
                    }else{
                        validation = true;
                    }
                }

                System.out.print(board[i][j]);

                if (j != 3) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i != 3) {
                System.out.println("-----------");
            }
        }
    }
    public String checkwinner(String sym) {

        for (int i = 1; i < 4; i++) {
            if (board[i][1].equalsIgnoreCase(sym) && board[i][2].equalsIgnoreCase(sym) && board[i][3].equalsIgnoreCase(sym)){
                return sym;
            }else if (board[1][i].equalsIgnoreCase(sym) && board[2][i].equalsIgnoreCase(sym) && board[3][i].equalsIgnoreCase(sym)){
                return sym;
            }
        }

        if ((board[1][1].equalsIgnoreCase(sym) && board[2][2].equalsIgnoreCase(sym) && board[3][3].equalsIgnoreCase(sym)) ||
                (board[1][3].equalsIgnoreCase(sym) && board[2][2].equalsIgnoreCase(sym) && board[3][1].equalsIgnoreCase(sym))) {
            return sym;
        }

        return "N";
    }
    public static void main(String[] args) {

        Main t1 = new Main();
        Scanner S1 = new Scanner(System.in);
        String  win = "";
        System.out.println("Who plays first? X or O? : ");
        t1.playersymbol = S1.nextLine();

        do {
            System.out.println("Enter the row and column number: ");
            int row =  S1.nextInt();
            int column =  S1.nextInt();
            t1.count = 0;
            TICTACTOE(row, column, t1.playersymbol);
            if (validation) {
                System.out.println("Invalid Move! Please try again with another place...\n");
                continue;
            }
            win = t1.checkwinner(t1.playersymbol);
            t1.playersymbol = (t1.playersymbol.equalsIgnoreCase("X")) ? "O" : "X";
            if (! win.equalsIgnoreCase("N")) {
                System.out.println(win+" is winner!!!");
                break;
            }
            if (count == 0){
                System.out.println("Tie between player 1 and player 2!!!!");
                break;
            }
        } while (win == "N");
    }
}
