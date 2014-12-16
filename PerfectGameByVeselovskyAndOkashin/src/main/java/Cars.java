/**
 * Created by okashinR on 06/12/14.
 */
public class Cars {
    Point Begin;
    int Length;
    int distanceToNext;
    int Speed;
    Cars(Point P, int L, int S , int dist){
        Begin = P;
        Length = L;
        distanceToNext = dist;
        Speed = S;
        }
    public void go(){
        Begin.y += Speed;

    }
}
