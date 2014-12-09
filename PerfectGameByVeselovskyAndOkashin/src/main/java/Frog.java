/**
 * Created by okashinR on 06/12/14.
 */
public class Frog {
    Point current;

    Frog(Point x){
        current = x;
    }

   void GoForward(){
        current.x += 1;
       if (GameField.field[current.x][current.y] == 1){
           GameField.finish(false);

       }
    }
}
