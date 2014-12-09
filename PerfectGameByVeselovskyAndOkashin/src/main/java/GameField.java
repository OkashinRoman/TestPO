/**
 * Created by okashinR on 06/12/14.
 */
public class GameField {
    static int[][] field;

    GameField()
    {
        int[][] field  = new int[8][20];
        for (int i = 0; i<8; i++)
        {
            for (int j = 0; j<20; j++)
            {
               field[i][j] = 0;
            }
        }
    }
    static void finish (boolean didYouWin){
        if(didYouWin){
            System.out.println("YOU WON!!!!111");
        }
        else{
            System.out.println("GAME OVER");
        }
        //TODO: Stop Threads
    }
}
