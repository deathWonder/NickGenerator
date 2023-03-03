import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    private static final List<Thread> threads = new LinkedList<>();

    private static final AtomicInteger count3 = new AtomicInteger(0);
    private static final AtomicInteger count4 = new AtomicInteger(0);
    private static final AtomicInteger count5 = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        threads.add(new Thread(() -> {
            for (String str : texts) {
                if (Beautiful.inOrder(str)) {
                    if (str.length() == 3) {
                        count3.set(count3.get() + 1);
                    } else if (str.length() == 4) {
                        count4.set(count4.get() + 1);
                    } else {
                        count5.set(count5.get() + 1);
                    }
                }
            }
        }));
        threads.add(new Thread(() -> {
            for (String str : texts) {
                if (Beautiful.isPalindrome(str)) {
                    if (str.length() == 3) {
                        count3.set(count3.get() + 1);
                    } else if (str.length() == 4) {
                        count4.set(count4.get() + 1);
                    } else {
                        count5.set(count5.get() + 1);
                    }
                }
            }
        }));
        threads.add(new Thread(() -> {
            for (String str : texts) {
                if (Beautiful.isSameCharacters(str)) {
                    if (str.length() == 3) {
                        count3.set(count3.get() + 1);
                    } else if (str.length() == 4) {
                        count4.set(count4.get() + 1);
                    } else {
                        count5.set(count5.get() + 1);
                    }
                }
            }
        }));

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }


        System.out.println("Красивых слов с длиной 3: " + count3.get() + " шт");
        System.out.println("Красивых слов с длиной 4: " + count4.get() + " шт");
        System.out.println("Красивых слов с длиной 5: " + count5.get() + " шт");

    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

}