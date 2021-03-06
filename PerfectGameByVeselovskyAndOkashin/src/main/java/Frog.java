/**
 * Created by okashinR on 06/12/14.
 */
public class Frog {
    private Point current;

    public Point getCurrent() {
        return current;
    }

    Frog(Point x) {
        current = x;
        GameField.field[current.x][current.y] = 6;
    }

    void goForward() {

        current.x -= 1;
        if(current.x == 0){
            GameField.finish(true);
        }
        if (GameField.field[current.x][current.y] == 1) {
            GameField.finish(false);
        }

        synchronized (GameField.field) {
            GameField.field[current.x+1][current.y] = 0;
            GameField.field[current.x][current.y] = 6;
        }
    }

    void goLeft() {
        if (current.y == 0){
            return;
        }
        current.y -= 1;
        if (GameField.field[current.x][current.y] == 1) {
            GameField.finish(false);
            return;

        }
        synchronized (GameField.field) {
            GameField.field[current.x][current.y+1] = 0;
            GameField.field[current.x][current.y] = 6;
        }
    }

    void goRight() {
        if (current.y == GameField.roadLength){
            return;
        }
        current.y += 1;
        if (GameField.field[current.x][current.y] == 1) {
            GameField.finish(false);
            return;
        }
        synchronized (GameField.field) {
            GameField.field[current.x][current.y-1] = 0;
            GameField.field[current.x][current.y] = 6;
        }
    }

    void goBack() {
        if (current.x == GameField.roads+1) return;

        current.x += 1;
        if (GameField.field[current.x][current.y] == 1) {
            GameField.finish(false);
            return;
        }
        synchronized (GameField.field) {
            GameField.field[current.x-1][current.y] = 0;
            GameField.field[current.x][current.y] = 6;
        }

    }
}
