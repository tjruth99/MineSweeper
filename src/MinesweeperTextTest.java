import java.util.Scanner;

public class MinesweeperTextTest {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int inX, inY, rows, cols, mines, cond;
        boolean running = true;

        System.out.println("Enter a number of rows:");
        rows = s.nextInt();
        System.out.println("Enter a number of columns:");
        cols = s.nextInt();
        System.out.println("Enter a number of mines:");
        mines = s.nextInt();

        Board game = new Board(rows,cols,mines);

        // START OF GAME:
        game.printBoard();

        System.out.println("Enter x:");
        inX = s.nextInt();

        System.out.println("Enter y:");
        inY = s.nextInt();

        game.setMines(inX, inY);
        game.onPush(inX, inY);

        game.printBoard();

        // MAIN GAME LOOP:
        while(running) {
            System.out.println("Enter x:");
            inX = s.nextInt();

            System.out.println("Enter y:");
            inY = s.nextInt();

            cond = game.onPush(inX, inY);

            game.printBoard();

            switch(cond){
                case -1:
                    System.out.println("You lose");
                    running = false;
                    break;
                case 1:
                    System.out.println("You win!");
                    running = false;
                    break;
            }
        }
    } // end main
} // end class