package swarawan.ganteng;

import swarawan.ganteng.datetime.DateTimeFormatterIsSafeThread;
import swarawan.ganteng.datetime.SimpleDateFormatIsNotSafeThread;

public class Main {

    public static void main(String[] args) {
//        SimpleDateFormatIsNotSafeThread dateTimeClass = new SimpleDateFormatIsNotSafeThread();
        DateTimeFormatterIsSafeThread dateTimeClass = new DateTimeFormatterIsSafeThread();
        dateTimeClass.run();
    }
}
