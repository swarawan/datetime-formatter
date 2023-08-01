# Datetime-Formatter

## Story

Before Java 8, developers used to use `SimpleDateFormat` to convert their date String into Date class.
Since `SimpleDateFormat` was mutable and not thread-safe, advised not to be shared between threads.

Alternatively, this could be done with `DateTimeFormatter` to convert String to `LocalDate`, `LocalTime`,
and `LocalDatetime`.

## In This Repo

There's an example to convert String to Date concurrently using `Runnable` and `Executors` with two difference approach
using `SimpleDateFormat` and `DateTimeFormatter` for the same date in String form.

```
String stringDate = "2023-02-28 15:15:15";
```

## How to

1. Open `Main.java` file.
2. Comment / uncomment instance you want to run.
3. Run
4. See the result

### Result using SimpleDateFormat

Sometimes it result exceptions or inconsistency date.

```
java.lang.NumberFormatException: For input string: ""
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.base/java.lang.Long.parseLong(Long.java:702)
	at java.base/java.lang.Long.parseLong(Long.java:817)
	at java.base/java.text.DigitList.getLong(DigitList.java:195)
	at java.base/java.text.DecimalFormat.parse(DecimalFormat.java:2121)
	at java.base/java.text.SimpleDateFormat.subParse(SimpleDateFormat.java:1933)
	at java.base/java.text.SimpleDateFormat.parse(SimpleDateFormat.java:1541)
	at java.base/java.text.DateFormat.parse(DateFormat.java:393)
	at swarawan.ganteng.datetime.SimpleDateFormatIsNotSafeThread$1.run(SimpleDateFormatIsNotSafeThread.java:20)
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:829)
Parsed Date ==> Tue Feb 28 15:15:00 WIB 2           // Year of 2 ( ? )
Parsed Date ==> Tue Feb 28 15:15:15 WIB 2023
Parsed Date ==> Tue Feb 28 15:15:15 WIB 2023
Parsed Date ==> Tue Feb 28 15:15:15 WIB 2023
Parsed Date ==> Sat Feb 28 15:15:15 WIB 1           // Year of 1 ( ? )
Parsed Date ==> Tue Feb 28 15:15:15 WIB 2023
Parsed Date ==> Tue Feb 28 15:15:15 WIB 2023
Parsed Date ==> Tue Feb 28 15:15:15 WIB 2023
Parsed Date ==> Tue Feb 28 15:15:15 WIB 2023
```

### Result using DateTimeFormatter

The result should use `'T'` but for the sake of beautification, we change it manually :p

```
Parsed Date ==> 2023-02-28 15:15:15
Parsed Date ==> 2023-02-28 15:15:15
Parsed Date ==> 2023-02-28 15:15:15
Parsed Date ==> 2023-02-28 15:15:15
Parsed Date ==> 2023-02-28 15:15:15
Parsed Date ==> 2023-02-28 15:15:15
Parsed Date ==> 2023-02-28 15:15:15
Parsed Date ==> 2023-02-28 15:15:15
Parsed Date ==> 2023-02-28 15:15:15
Parsed Date ==> 2023-02-28 15:15:15
```