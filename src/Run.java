import java.util.Scanner;

/**
 * Created by dai on 16-9-10.
 */
public class Run {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String SystemIn = scanner.next();
        String[] strings = SystemIn.split(",");
        Integer[] arrays = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arrays[i] = Integer.parseInt(strings[i]);
        }
        int result = calculate(arrays);
        System.out.println(result);

    }

    private static int calculate(Integer[] array) {

        int left = 0;
        int right = array.length - 1;
        int now = 1;
        int result = 0;

        for (; now < array.length; ) {
            if (array[left] <= array[now]) {
                if (now - left > 1) {
                    for (int i = left + 1; i < now; i++) {
                        result += array[left] - array[i];
                    }
                }
                left = now;
            }
            now++;
        }

        now = right - 1;
        for (; now > left; ) {
            if (array[right] <= array[now]) {
                if (right - now > 1) {
                    for (int i = now + 1; i < right; i++) {
                        result += array[right] - array[i];
                    }
                }
                right = now;
            }
            now--;
        }

        return result;
    }
}
