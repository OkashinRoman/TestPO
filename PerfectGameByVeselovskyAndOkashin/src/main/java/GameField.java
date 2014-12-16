/**
 * Created by okashinR on 06/12/14.
 */
class GameField {
    static int[][] field;
    static int roads;
    static int roadLength;
    static Frog frog;


    static void finish (boolean didYouWin){
        if(didYouWin){
            System.out.println("YOU WON!!!!111");
        }
        else{
            System.out.println("GAME OVER");
        }
        //TODO: Stop Threads
    }

    public static void printField(){
        for (int i = 0; i<8; i++)
        {
            for (int j = 0; j<20; j++)
            {
                System.out.print(GameField.field[i][j]);
            }
            System.out.println();

        }

    }

    public static void main(String[] args) {
        GameField.start();
        Frog frog = new Frog(new Point(2,3));
        GameField.printField();
    }

    public static Point getFrogPoint() {
        return frog.getCurrent();
    }

    private static void start() {
        field  = new int[8][20];
        roads = 18;
        for (int i = 0; i<8; i++)
        {
            for (int j = 0; j<20; j++)
            {
                field[i][j] = 0;
            }
        }
    }
}

