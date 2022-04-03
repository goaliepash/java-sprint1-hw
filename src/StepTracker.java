import java.util.Locale;

public class StepTracker {

    private final MonthData[] monthData = new MonthData[12];
    private int targetNumberOfSteps = 1000;

    public StepTracker() {
        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new MonthData();
        }
    }

    public void setStepsNumber(int month, int day, int steps) {
        if (isMonthNumberCorrect(month) & isDayNumberCorrect(day) & isStepsNumberPositive(steps)) {
            monthData[month].stepsPerDays[day] = steps;
        }
    }

    public void printStatsByMonth(int monthNumber) {
        if (isMonthNumberCorrect(monthNumber)) {
            printNumberOfSteps(monthNumber);
            printMaxNumberOfSteps(monthNumber);
            printAverageNumberOfSteps(monthNumber);
            printPassedDistance(monthNumber);
            printNumberOfKilocaloriesBurned(monthNumber);
            printBestSeries(monthNumber);
        }
    }

    public void setTargetNumberOfSteps(int stepsNumber) {
        if (isStepsNumberPositive(stepsNumber)) {
            targetNumberOfSteps = stepsNumber;
        }
    }

    private boolean isMonthNumberCorrect(int month) {
        if (month < 0 || month > 11) {
            System.out.println("Указан неверный номер месяца. Диапазон должен быть от 0 до 11 включительно.");
            return false;
        }
        return true;
    }

    private boolean isDayNumberCorrect(int day) {
        if (day < 0 || day > 29) {
            System.out.println("Указан неверный номер дня. Диапазон должен быть от 0 до 29 включительно.");
            return false;
        }
        return true;
    }

    private boolean isStepsNumberPositive(int steps) {
        if (steps < 0) {
            System.out.println("Количество шагов не может быть отрицательным.");
            return false;
        }
        return true;
    }

    private void printNumberOfSteps(int monthNumber) {
        System.out.println("Количество пройденных шагов по дням:");
        int[] stepsPerDays = monthData[monthNumber].stepsPerDays;
        for (int i = 0; i < stepsPerDays.length; i++) {
            if (i == stepsPerDays.length - 1) {
                System.out.printf("%d день: %d\n", i + 1, stepsPerDays[i]);
            } else {
                System.out.printf("%d день: %d, ", i + 1, stepsPerDays[i]);
            }
        }
    }

    private void printMaxNumberOfSteps(int monthNumber) {
        int[] stepsPerDays = monthData[monthNumber].stepsPerDays;
        int maxNumberOfStepsTaken = 0;
        for (int stepsPerDay : stepsPerDays) {
            if (stepsPerDay > maxNumberOfStepsTaken) {
                maxNumberOfStepsTaken = stepsPerDay;
            }
        }
        System.out.printf("Максимальное пройденное количество шагов в месяце: %d\n", maxNumberOfStepsTaken);
    }

    private void printAverageNumberOfSteps(int monthNumber) {
        int[] stepsPerDays = monthData[monthNumber].stepsPerDays;
        int sumOfSteps = getSumOfSteps(stepsPerDays);
        double averageNumberOfSteps = (double) sumOfSteps / stepsPerDays.length;
        System.out.printf(Locale.US, "Среднее количество шагов: %.2f\n", averageNumberOfSteps);
    }

    private void printPassedDistance(int monthNumber) {
        int[] stepsPerDays = monthData[monthNumber].stepsPerDays;
        Converter converter = new Converter();
        int sumOfSteps = getSumOfSteps(stepsPerDays);
        System.out.printf(Locale.US, "Пройденная дистанция (в км): %.2f\n", converter.calculateDistance(sumOfSteps));
    }

    private void printNumberOfKilocaloriesBurned(int monthNumber) {
        int[] stepsPerDays = monthData[monthNumber].stepsPerDays;
        Converter converter = new Converter();
        int sumOfSteps = getSumOfSteps(stepsPerDays);
        System.out.printf(Locale.US, "Количество сожжённых килокалорий: %.2f\n", converter.calculateKilocalories(sumOfSteps));
    }

    private void printBestSeries(int monthNumber) {
        int[] stepsPerDays = monthData[monthNumber].stepsPerDays;
        int bestSeries = 0;
        int currentSeries = 0;
        for (int stepsPerDay : stepsPerDays) {
            if (stepsPerDay >= targetNumberOfSteps) {
                currentSeries++;
            } else {
                currentSeries = 0;
            }
            if (currentSeries > bestSeries) {
                bestSeries = currentSeries;
            }
        }
        System.out.printf("Лучшая серия: %d\n", bestSeries);
    }

    private int getSumOfSteps(int[] stepsPerDays) {
        int sumOfStepsNumber = 0;
        for (int stepsPerDay : stepsPerDays) {
            sumOfStepsNumber += stepsPerDay;
        }
        return sumOfStepsNumber;
    }

    class MonthData {
        int[] stepsPerDays = new int[30];
    }
}