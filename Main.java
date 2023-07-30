// Необходимо написать проект, для розыгрыша в магазине игрушек. Функционал должен содержать добавление новых игрушек и 
// задания веса для выпадения игрушек.
// Напишите класс-конструктор у которого принимает минимум 3 строки, содержащие три поля id игрушки, текстовое название 
// и частоту выпадения игрушки
// Из принятой строки id и частоты выпадения(веса) заполнить минимум три массива.
// Используя API коллекцию: java.util.PriorityQueue добавить элементы в коллекцию
// Организовать общую очередь
// Вызвать Get 10 раз и записать результат в файл

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Iterator;



public class Main {
    public static final String FILE = "WinnedToys.txt";
    // Метод для приобретения призовой игрушки со склада
    public static void getToy(ArrayList<Toy> chosenToys) {
        try {
            if (chosenToys.isEmpty()) {
                System.out.println("No toys left in the list.");
                return;
            }
        
            int lastIndex = chosenToys.size() - 1;
            Toy winnedToy = chosenToys.get(lastIndex);
            chosenToys.remove(lastIndex);
    
            try (FileWriter fw = new FileWriter(FILE, true)) {
                fw.append(winnedToy.toString());
                fw.flush();
            } catch (IOException e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
    
            winnedToy.decreaseAmount(1);
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Создаем условие сравнения
        Comparator<Toy> comparator = Comparator.comparing(obj -> obj.getToyDropFrequencyPercent());
        comparator = comparator.reversed();
        // Создаем очередь для сравнения
        PriorityQueue<Toy> toysQueue = new PriorityQueue<>(comparator);
        // Создаем списки для хранения
        ArrayList<Toy> toysList = new ArrayList<>();
        ArrayList<Toy> chosenToysList = new ArrayList<>();

        
        // Создаем объекты Toy и передаем данные в список всех игрушек
        Toy toy1 = new Toy(1, "Конструктор", 10, 5);
        toysList.add(toy1);
        Toy toy2 = new Toy(2, "Робот", 11, 2);
        toysList.add(toy2);
        Toy toy3 = new Toy(3, "Кукла", 66, 6);
        toysList.add(toy3);
        Toy toy4 = new Toy(4, "Пазл", 51, 10);
        toysList.add(toy4);
        Toy toy5 = new Toy(5, "Плюшевый медведь", 100, 34);
        toysList.add(toy5);        
        Toy toy6 = new Toy(6, "Паровоз", 10, 25);
        toysList.add(toy6);        
        Toy toy7 = new Toy(7, "Мяч", 150, 60);
        toysList.add(toy7);

        // Заполняем очередь
        for (int j = 0; j < toysList.size(); j++) {
            toysQueue.add(toysList.get(j));
        }

        // Выбираем игрушку из очереди и добавляем в список призовых игрушек, которые ожидают выдачи
        Iterator<Toy> iterator = toysQueue.iterator();
        while (iterator.hasNext()) {
            Toy toy = iterator.next();
            iterator.remove();
            chosenToysList.add(toy);
        }

        // Получаем игрушку и записываем ее в файл
        for (int i = chosenToysList.size(); i > 0; i--) {
            getToy(chosenToysList);
        }

        System.out.println(toysList);
    }
}