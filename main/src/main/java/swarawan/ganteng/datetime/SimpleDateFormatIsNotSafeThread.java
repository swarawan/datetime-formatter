package swarawan.ganteng.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatIsNotSafeThread {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void run() {

        String stringDate = "2023-02-28 15:15:15";

        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    Date date = simpleDateFormat.parse(stringDate);
                    System.out.println("Parsed Date ==> " + date);
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
