import java.util.Scanner;

public class TextVersion {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int inX, inY, rows, cols, mines, cond;
        boolean running = true;
        boolean newGame = true;

        do {
            System.out.println("Enter a number of rows:");
            rows = s.nextInt();
            System.out.println("Enter a number of columns:");
            cols = s.nextInt();
            System.out.println("Enter a number of mines:");
            mines = s.nextInt();

            if ((rows < 4 && cols < 4)){
                System.out.println("~!~ Size is too small, must be bigger than 3x3");
            }
            if ((rows*cols) - mines < 5){
                System.out.println("~!~ Too many mines for given size");
            }
        } while ((rows < 4 && cols < 4) || (rows*cols) - mines < 5);

        Board game = new Board(rows,cols,mines);

        // MAIN GAME LOOP:
        while(running) {
            System.out.println("Enter x:");
            inX = s.nextInt();

            System.out.println("Enter y:");
            inY = s.nextInt();

            if(newGame){
                game.setMines(inX, inY);
                newGame = false;
            }
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