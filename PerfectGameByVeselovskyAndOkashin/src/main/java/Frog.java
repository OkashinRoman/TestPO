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

        current.x += 1;
        if (GameField.field[current.x][current.y] == 1) {
            GameField.finish(false);

        }
    }

    void goLeft() {
        current.y += 1;
        if (GameField.field[current.x][current.y] == 1) {
            GameField.finish(false);

        }
    }

    void goRight() {
        current.y -= 1;
        if (GameField.field[current.x][current.y] == 1) {
            GameField.finish(false);

        }
    }

    void goBack() {
        if (current.x == 0){
            return;
        }
        else {
            current.x -= 1;
            if (GameField.field[current.x][current.y] == 1) {
                GameField.finish(false);

            }
        }
    }
}
