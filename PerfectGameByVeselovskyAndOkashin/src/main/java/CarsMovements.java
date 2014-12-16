import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by okashinR on 06/12/14.
 */
public class CarsMovements {
    int mainX = 0;
    ArrayList<LinkedList<Cars>> cars;
    int [] speed;
    CarsMovements(int n){
        cars = new ArrayList<LinkedList<Cars>>(); //создание массива списков
        speed = new int[GameField.roads];

        //для каждой полосы своя скорость (для каждой машины)
        for(int i = 0; i<GameField.roads; i++){
            Random random = new Random();
            speed[i] = random.nextInt(2)+1;
        }
        //создание списков в массиве
        for (int i = 0; i <n; i++) {
            cars.add(new LinkedList<Cars>());
        }

    }

    public void carsGenerator(){
        for(int i = 0; i < cars.size(); i++){
            LinkedList<Cars> list = cars.get(i);//получаем список с которым работаем
            int sum = 0; //ограничетель на количество машин

            //добавлять по одной машине (с проверкой заполненности полосы) за итерацию цикла в бесконечном потоке движения машин
            //первая машина добавляется в конструкторе  CarMovemnets
            //в потоке создается CarMovemenets и также в цикле вызывается CarReplace
            //list.add(new Cars(new Point()))

        }
    }

    void CarReplace(){
//        for (int i = 0;i <= cars.size();i++ )
//        {
//            for (int j = 0;j<cars.get(i).Length; j++)
//            {
//                GameField.field[cars.get(i).Begin.x][cars.get(i).Begin.y+j] = 0;
//                cars.get(i).go();
//            }
//            //заполнить поле машинами, проверяя Car == Frog
//        }

    }



}

