package swarawan.ganteng.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DateTimeFormatterIsSafeThread {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void run() {
        String stringDate = "2023-02-28 15:15:15";

        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    LocalDateTime localDateTime = LocalDateTime.parse(stringDate, dateTimeFormatter);
                    String result = localDateTime.toString().replace("T", " ");
                    System.out.println("Parsed Date ==> " + result);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            executorService.submit(runnable);
        }
        executorService.shutdown();
    }
}
