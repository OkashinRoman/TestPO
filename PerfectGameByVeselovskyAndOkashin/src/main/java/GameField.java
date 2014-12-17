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
    public static void printField(){
        for (int i = 0; i<8; i++)
        {
            for (int j = 0; j<20; j++) {
                System.out.print(GameField.field[i][j]);
            }
            System.out.println();
        }
        for(int i = 0; i<10; i++){
            System.out.print("\n");
        }

    }

    public static void main(String[] args) {
        GameField.start();
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
        frog = new Frog(new Point(2,13));
        FrogActions fa = new FrogActions();
        CarsController cont = new CarsController();
        fa.setDaemon(true);
        fa.start();
        cont.setDaemon(true);
        cont.start();

        while(playContinue){
           //wait till game end
        }

    }


    static class FrogActions extends  Thread{
        @Override
        public void run(){
            //TODO gui or some frog instructions
            //Some frog actions
            while(GameField.playContinue){
                //MOVE!!
            }
        }
    }

    static class CarsController extends Thread{
        @Override
        public  void run(){
            CarsMovements controller = new CarsMovements();

            while(GameField.playContinue){
                GameField.printField();
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

