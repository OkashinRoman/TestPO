import java.util.ArrayList;

/**
 * Created by okashinR on 06/12/14.
 */
public class CarsMovements {

    ArrayList<Cars> Cars;

    CarsMovements(int n){
        Cars = new ArrayList<Cars>();
//        рандомно заполнить список машин, подумать об организации правильной структуры хранения данных для машин
        for (int i = 0; i <n; i++)
            Cars.add(new Cars(new Point(i,0),2,2));

    }

    void CarReplace(){
        for (int i = 0;i <= Cars.size();i++ )
        {
            for (int j = 0;j<Cars.get(i).Length; j++)
            {
                GameField.field[Cars.get(i).Begin.x][Cars.get(i).Begin.y+j] = 0;
                Cars.get(i).go();
            }
            //заполнить поле машинами, проверяя Car == Frog
        }
    }



}
