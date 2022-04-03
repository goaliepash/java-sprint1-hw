import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            switch (userInput) {
                case 1:
                    setStepsByDay(scanner, stepTracker);
                    break;
                case 2:
                    printStatsByMonth(scanner, stepTracker);
                    break;
                case 3:
                    setTargetNumberOfSteps(scanner, stepTracker);
                    break;
                default:
                    System.out.println("Такой команды не существует.");
                    break;
            }
            printMenu();
            userInput = scanner.nextInt();
        }

        System.out.println("Программа завершена.");
    }

    private static void printMenu() {
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день;");
        System.out.println("2 - Напечатать статистику за определённый месяц;");
        System.out.println("3 - Изменить цель по количеству шагов в день;");
        System.out.println("0 - Выйти из приложения.");
    }

    private static void setStepsByDay(Scanner scanner, StepTracker stepTracker) {
        System.out.print("Введите месяц: ");
        int month = scanner.nextInt();
        System.out.print("Введите день: ");
        int day = scanner.nextInt();
        System.out.print("Введите количество шагов: ");
        int steps = scanner.nextInt();
        stepTracker.setStepsNumber(month, day, steps);
    }

    private static void printStatsByMonth(Scanner scanner, StepTracker stepTracker) {
        System.out.print("Введите номер месяца: ");
        int month = scanner.nextInt();
        stepTracker.printStatsByMonth(month);
    }

    private static void setTargetNumberOfSteps(Scanner scanner, StepTracker stepTracker) {
        System.out.print("Введите количество шагов: ");
        int steps = scanner.nextInt();
        stepTracker.setTargetNumberOfSteps(steps);
    }
}