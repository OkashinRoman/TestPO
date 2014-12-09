/**
 * Created by okashinR on 06/12/14.
 */
public class Cars {
    Point Begin;
    int Length;
    int Speed;
    Cars(Point P, int L, int S ){
        Begin = P;
        Length = L;
        Speed = S;
        }
    public void go(){
        Begin.y += Speed;

    }
}
