import java.util.Scanner;

public class Game {
    private static OX ox;
    private static Scanner kb = new Scanner(System.in);
    private static int col,row;
    static int countX = 0;
    static int countO = 0;
    static int countDraw = 0;

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
                    countX = countX +1;
                    printScore();
                }else if(ox.getCurrentPlayer().equals("O")){
                    countO = countO+1;
                    printScore();
                }
                ox.reset();
                continue;
            }
            if(ox.isDraw()){
                printTable();
                countDraw = countDraw + 1;
                printScore();
                ox.reset();
                continue;
            }
            ox.switchPlayer();
        }
    }

    private static void printScore() {
        System.out.println("X Win: " + countX);
        System.out.println("O Win: " + countO);
        System.out.println("Draw: " + countDraw);
    }

    private static void printTable() {
        System.out.print(ox.getTableString());
    }
}