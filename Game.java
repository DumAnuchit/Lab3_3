import java.util.Scanner;

public class Game {
    private static OX ox;
    private static Scanner kb = new Scanner(System.in);
    private static int col,row;
    static int scoreX = 0;
    static int scoreO = 0;
    static int scoreDraw = 0;

    public static void input(){
        boolean canPut = true;
        do {
            System.out.print(ox.getCurrentPlayer() + " (Col): ");
            col = kb.nextInt();
            System.out.print(ox.getCurrentPlayer() + " (Row): ");
            row = kb.nextInt();
            canPut =  ox.put(col, row);
            if(!canPut){
                System.out.println(" Please input number between 0-2 ");
            }
        }while (!canPut);
    }

    public static void main(String[] args) {
        ox = new OX();
        while (true) {
            printTable();
            input();
            if(ox.checkWin(col,row)){
                printTable();
                if(ox.getCurrentPlayer().equals("X")){
                    scoreX = scoreX +1;
                    printScore();
                }else if(ox.getCurrentPlayer().equals("O")){
                    scoreO = scoreO+1;
                    printScore();
                }
                ox.reset();
                continue;
            }
            if(ox.isDraw()){
                printTable();
                scoreDraw = scoreDraw + 1;
                printScore();
                ox.reset();
                continue;
            }
            ox.switchPlayer();
        }
    }

    private static void printScore() {
        System.out.println("X Win: " + scoreX);
        System.out.println("O Win: " + scoreO);
        System.out.println("Draw: " + scoreDraw);
    }

    private static void printTable() {
        System.out.print(ox.getTableString());
    }
}