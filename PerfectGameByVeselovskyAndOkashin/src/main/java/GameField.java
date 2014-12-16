/**
 * Created by okashinR on 06/12/14.
 */
class GameField {
    static int[][] field;
    static int roads;
    static int roadLength;
    static Frog frog;
    static boolean playContinue;


    static void finish (boolean didYouWin){
        if(didYouWin){
            System.out.println("YOU WON!!!!111");
        }
        else{
            System.out.println("GAME OVER");
        }
        playContinue = false;
    }
    //TODO if not gui -> some console changing
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
        frog = new Frog(new Point(2,3));
        GameField.printField();
    }

    public static Point getFrogPoint() {
        return frog.getCurrent();
    }

    private static void start() {
        field  = new int[8][20];
        roads = 8;
        roadLength = 20;
        playContinue = true;
        for (int i = 0; i<8; i++)
        {
            for (int j = 0; j<20; j++)
            {
                field[i][j] = 0;
            }
        }
        FrogActions fa = new FrogActions();
        CarsController cont = new CarsController();
        fa.start();
        fa.setDaemon(true);
        cont.start();
        cont.setDaemon(true);
        while(playContinue){
            //wait till game end
        }

    }


    static class FrogActions extends  Thread{
        @Override
        public void run(){
            //TODO gui or some frog instructions
            //Some frog actions
        }
    }

    static class CarsController extends Thread{
        @Override
        public  void run(){
            CarsMovements controller = new CarsMovements();

            while(true){
                controller.carsGenerator();
                controller.CarReplace();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

