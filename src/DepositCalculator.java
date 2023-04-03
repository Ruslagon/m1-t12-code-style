import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundPay(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundPay(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundPay(double value, int placesAfterZero) {
        double Scale = Math.pow(10, placesAfterZero);
        return Math.round(value * Scale) / Scale;
    }

    void calculateGains() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outEarnings = 0;
        if (action == 1) {
            outEarnings = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outEarnings = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outEarnings);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateGains();
    }
}
