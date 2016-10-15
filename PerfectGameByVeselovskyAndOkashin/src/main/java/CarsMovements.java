import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by okashinR on 06/12/14.
 */
public class CarsMovements {
    int mainY = 0;

    ArrayList<LinkedList<Cars>> cars;
    int [] speed;
    CarsMovements(){
        cars = new ArrayList<LinkedList<Cars>>(); //создание массива списков
        speed = new int[GameField.roads];

        //для каждой полосы своя скорость (для каждой машины)
        Random random = new Random();
        for(int i = 0; i<GameField.roads; i++){
            speed[i] = random.nextInt(2)+1;
        }
        //создание списков в массиве и их первый элемент
        for (int i = 0; i <GameField.roads; i++) {
            cars.add(new LinkedList<Cars>());
            //добавление самой первой машины
            int len = random.nextInt(4);
            int dist = random.nextInt(4)+1;
            cars.get(i).add(new Cars(new Point(i+1,this.mainY -len-dist),len, speed[i],0));
        }

    }

    public void carsGenerator(){
        //добавляем одну машину в каждую полосу
        for(int i = 0; i < cars.size(); i++){
            LinkedList<Cars> list = cars.get(i);//получаем список с которым работаем
            int sum = 0; //ограничетель на количество машин
            //Считаем количество занятых позиций на полосе движения
            Cars car;
            for(int j = 0; j<list.size(); j++){
                car = list.get(j);
                sum += car.distanceToNext + car.Length;
            }
            //если еще не вся полоса занята
            int length;
            int distance;
            if (sum < GameField.roadLength){
                Random random = new Random();
                car = list.getFirst();
                length = random.nextInt(4)+1;
                distance = random.nextInt(4)+1;
                list.addFirst(new Cars(new Point(i+1,car.Begin.y-length-distance),length, speed[i],distance));
            }

            //добавлять по одной машине (с проверкой заполненности полосы) за итерацию цикла в бесконечном потоке движения машин
            //первая машина добавляется в конструкторе  CarMovemnets
            //в потоке создается CarMovemenets и также в цикле вызывается CarReplace
        }
    }

    void CarReplace(){
        for (int i = 0;i < cars.size();i++ )
        {
            LinkedList<Cars> list = cars.get(i);

            int size = list.size();
            for(int j = size-1; j>=0; j--){ //проход по списку машин
                Cars car = list.get(j);
                //очищаем старые позиции
                synchronized (GameField.field) {
                    for (int k = 0; k < car.Length; k++) {

                        if (car.Begin.y + k >= 0 && car.Begin.y + k < GameField.roadLength)
                            GameField.field[i+1][car.Begin.y + k] = 0;
                    }
                }
                car.go();

                //удаляем машину из списка, если она вышла из поля видимости
                if(car.Begin.y>=GameField.roadLength){
                    list.removeLast();
                    continue;
                }
                //рисуем нашу машину
                for(int k =0; k<car.Length; k++){
                    int y = car.Begin.y+k;

                    if(y<0){//если эта точка не дошла до начала поля
                        continue;
                    }
                    if(y >= GameField.roadLength){//если эта часть машины находится за правым краем поля
                        break;
                    }
                    //если на этом месте была лягушка, заканчиваем игру
                    if(i+1 == GameField.getFrogPoint().x && (GameField.getFrogPoint().y<y||y == GameField.getFrogPoint().y)){
                        GameField.finish(false);
                    }
                    //если все ОК, занимаем позицию
                    synchronized (GameField.field) {
                        GameField.field[i+1][y] = 1;
                    }
                }//конец прохода позиций, занятых машиной
            }//конец прохода по списку
        }

    }



}

