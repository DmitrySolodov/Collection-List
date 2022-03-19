import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int count = 0; //Количество введённых задач
        String input = null;
        while (true) {
            try {
                System.out.println("Выберите действие: \n" + "1. Добавить задачу\n" + "2. Вывести список задач\n" +
                        "3. " + "Удалить задачу\n" + "4. Изменить задачу\n" + "0. Выход\n");
                input = scanner.nextLine();
                int choose = Integer.parseInt(input);
                if (choose < 0 || choose > 4) {
                    System.out.println("Необходимо ввести число от 0 до 4, повторите попытку");
                    continue;
                }
                if (choose == 0) {
                    System.out.println("Завершение программы");
                    break;
                }
                switch (choose) {
                    case 1:
                        System.out.println("Введите порядковый номер планирумой задачи: ");
                        input = scanner.nextLine();
                        choose = Integer.parseInt(input);
                        if (choose <= 0 || (list.size() + 1) < choose) {
                            System.out.println("Порядковый номер вводимой задачи не может быть меньше 1, либо больше "
                                    + (count + 1));
                            break;
                        }
                        System.out.println("Введите задачу для планирования: ");
                        String task = scanner.nextLine();
                        list.add((choose - 1), task);
                        count++;
                        break;
                    case 2:
                        if (list.isEmpty()) {
                            System.out.println("Список пуст\n");
                            break;
                        }
                        System.out.println("Список задач: ");
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println((i + 1) + ". " + list.get(i));
                        }
                        System.out.println();
                        break;
                    case 3:
                        if (list.isEmpty()) {
                            System.out.println("Список пуст\n");
                            break;
                        }
                        System.out.println("Введите номер задачи из списка для её удаления:");
                        input = scanner.nextLine();
                        choose = Integer.parseInt(input);
                        if (choose > list.size() || choose <= 0) {
                            System.out.println("Неверный ввод, в вашем списке " + count + " задач(и)");
                            break;
                        }
                        System.out.println("Задача № " + choose + " \"" + list.get(choose - 1) + "\" удалена из " +
                                "списка");
                        list.remove(choose - 1);
                        count--;
                        break;
                    case 4:
                        if (list.isEmpty()) {
                            System.out.println("Список пуст\n");
                            break;
                        }
                        System.out.println("Введите порядковый номер задачи, которую хотите изменить: ");
                        input = scanner.nextLine();
                        choose = Integer.parseInt(input);
                        if (choose <= 0 || list.size() < choose) {
                            System.out.println("Порядковый номер изменяемой задачи не может быть меньше 1, либо " +
                                    "больше " + count);
                            break;
                        }
                        System.out.println("Введите новую задачу: ");
                        task = scanner.nextLine();
                        list.set((choose - 1), task);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка!!! Необходимо ввести ЦЕЛОЕ ПОЛОЖИТЕЛЬНОЕ ЧИСЛО, а вы ввели \"" + input +
                        "\"");
            }
            System.out.println();
        }
    }
}
