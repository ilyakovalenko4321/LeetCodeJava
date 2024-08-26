package LeetCode.Meadium.GrumpyBookstoreOwner1052;

public class CorrectSolution {

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        // Сначала рассматриваем первые minutes как первый интервал и вычисляем сумму
        int n = customers.length, sum = 0;
        for(int i = 0; i < n; i++) {
            if(i < minutes) {
                // Внутри minutes считаем, что владелец не сердится, просто добавляем
                sum += customers[i];
            } else {
                // 1 означает, что владелец сердится, нельзя добавлять, поэтому sum = инвертируем и умножаем на customers
                sum += (1 - grumpy[i]) * customers[i];
            }
        }

        // Скользящее окно, постоянно обновляем максимальный результат
        int result = sum;
        // Интервал [0, minutes) полуоткрытый, внутри интервала все спокойно
        int left = 0, right = minutes;
        while(right < n) {
            if(grumpy[right] == 1) {
                sum += customers[right]; // Когда 0, уже добавлено при инициализации
            }
            if(grumpy[left] == 1) {
                sum -= customers[left];
            }
            result = Math.max(result, sum);
            left++;
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }
}
