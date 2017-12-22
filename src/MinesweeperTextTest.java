import java.util.Scanner;

public class MinesweeperTextTest {



    public static void main(String[] args){
        Board game = new Board(5,5,5);
        Scanner s = new Scanner(System.in);

        int inX, inY;
        boolean running = true;
        int cond;

        game.printBoard();

        System.out.println("Enter x:");
        inX = s.nextInt();

        System.out.println("Enter y:");
        inY = s.nextInt();

        game.setMines(inX, inY);
        game.onPush(inX, inY);

        game.printBoard();

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
    }
}