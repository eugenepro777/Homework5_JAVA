package Homework5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
public class Task2 {
    /*  Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов
Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
*  Отсортировать по убыванию популярности. */

    public static void main(String[] args) {
        Map<String, Integer> nameWorker = new HashMap<>();
        String[] worker = new String[]{
                "Иван Иванов", "Светлана Петрова",
                "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов",
                "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова",
                "Анна Владимирова", "Иван Мечников",
                "Петр Петин", "Иван Ежов"};
        searchRepetitions(worker, nameWorker);
        sortNames(nameWorker);

    }

    public static void searchRepetitions(String[] worker, Map<String, Integer> nameWoker) {
        for (String item :
                worker) {
            String name = item.split(" ")[0];
            if (!nameWoker.containsKey(name)) {
                nameWoker.put(name, 1);
            } else {
                nameWoker.put(name, nameWoker.get(name) + 1);
            }
        }
    }

    public static void sortNames(Map<String, Integer> nameWorker) {
        Map<String, Integer> sortName = nameWorker.entrySet().stream()
                .sorted(Comparator.comparingInt(value -> -value.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        }, LinkedHashMap::new));
        sortName.entrySet().forEach(System.out::println);
    }


}
