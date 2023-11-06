import java.util.*;

public int sum(int[] a) {
    int total = 0;
    for (int i = 0; i < a.length; i++) {
        total += a[i];
    }
    return total;
}

public int[] cumsum(int[] a) {
    int[] cumulativeSum = new int[a.length];
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
        sum += a[i];
        cumulativeSum[i] = sum;
    }
    return cumulativeSum;
}

public int[] positives(int[] a) {
    int count = 0;
    for (int num : a) {
        if (num > 0) {
            count++;
        }
    }

    int[] positiveArray = new int[count];
    int index = 0;
    for (int num : a) {
        if (num > 0) {
            positiveArray[index] = num;
            index++;
        }
    }

    return positiveArray;
}

public static void main(String[] args) {
    int[] array = { 1, 2, 3, -4, 5, -6 };
    int result1 = sum(array);
    int[] result2 = cumsum(array);
    int[] result3 = positives(array);

    System.out.println("Sum: " + result1);
    System.out.print("Cumulative Sum: ");
    for (int num : result2) {
        System.out.print(num + " ");
    }
    System.out.println();
    System.out.print("Positive Elements: ");
    for (int num : result3) {
        System.out.print(num + " ");
    }
}
