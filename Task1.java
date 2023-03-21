package Homework5;

import java.util.*;

public class Task1 {

    /*
    *       Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
    *  что 1 человек может иметь несколько телефонов.
    * */
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Ivanov", List.of("8 962 111 11 11", "8 962 112 11 11"));
        phoneBook.put("Smirnov", List.of("8 962 111 12 11", "8 962 112 11 12"));
        phoneBook.put("Simonov", List.of("8 962 113 11 11", "8 962 114 11 11"));
        phoneBook.put("Petrov", List.of("8 962 115 11 11", "8 962 112 11 15"));
        phoneBook.put("Fedorov", List.of("8 962 116 11 11", "8 962 117 11 11"));

        menu2(phoneBook);

    }

    public static String inputDate() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static void printBook(Map<String, List<String>> phoneBook) {
        for (var item:
             phoneBook.entrySet()) {
            StringBuilder number = new StringBuilder();
            for (var el :
                    item.getValue()) {
                number.append(el).append(", ");
            }
            System.out.printf("%s: %s \n", item.getKey(), number.toString());
        }
    }
    public static void findSubscriber(Map<String, List<String>> phoneBook) {
        System.out.print("Введите имя абонента: ");
        String subscriber = inputDate();
        if (subscriber.isEmpty()) {
            System.out.println("Повторите ввод");
            System.out.println("-".repeat(20));
            menu2(phoneBook);
        }
        if (phoneBook.get(subscriber) != null) {
            System.out.println(phoneBook.get(subscriber));
        } else {
            System.out.println("Абонент не найден");
            System.out.println("-".repeat(20));
            menu2(phoneBook);
        }
    }

    public static Map<String, List<String>> addSubscriber(Map<String, List<String>> phoneBook) {
        System.out.println("Для выхода из режима ввода номера наберите stop");
        System.out.print("Введите имя для добавления: ");
        String subscriber = inputDate();
        List<String> numbers = new ArrayList<>();
        while (true) {
            System.out.print("Введите номер: ");
            String phoneNumber = inputDate();
            if (phoneNumber.equals("stop") || subscriber.equals("stop")) {
                break;
            } else {
                numbers.add(phoneNumber);
            }
        }
        phoneBook.put(subscriber, numbers);
        return phoneBook;
    }

    public static void menu2(Map<String, List<String>> phoneBook) {
        System.out.println("Выберите действие: ");
        System.out.print(
                "pt - распечатать телефонную книгу; fd - найти контакт; add - добавить контакт; esc - выход\n -> ");
        String action = inputDate();
        switch (action) {
            case "pt":
                printBook(phoneBook);
                System.out.println("-".repeat(30));
                menu2(phoneBook);
                break;
            case "fd":
                findSubscriber(phoneBook);
                System.out.println("-".repeat(30));
                menu2(phoneBook);
                break;
            case "add":
                addSubscriber(phoneBook);
                System.out.println("-".repeat(30));
                menu2(phoneBook);
                break;
            case "esc":
                break;
            default:
                System.out.println("Выберите одно из действий!");
                System.out.println("-".repeat(30));
                menu2(phoneBook);
                break;
        }
    }


}
