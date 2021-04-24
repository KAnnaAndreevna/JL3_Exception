import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static Calendar timeLock;
    public static Calendar currentTime;
    public static void main(String[] args) throws IOException {
        // 1 Проверка на каждое нажатие? - С помощью форм + событий?
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            boolean cardLock = false;
            String password;
            password = "7777";
            timeLock = new GregorianCalendar();
            for(int i = 0 ; i < 5 ; i++){

                if (!cardLock) {
                    System.out.print("Please enter Your pin-code: ");
                    if (password.equals(reader.readLine())) {
                        System.out.println("Pin-code is True");
                        break;
                    } else {
                        if (i == 2) {
                            cardLock = true;
                            System.out.println("3 failed attempts. Card is locked for 10 second");
                            timeLock = new GregorianCalendar();
                            Random r = new Random();
                            Thread.sleep(r.nextInt(10) * 1000);

                        } else {
                            System.out.println("Wrong Password");
                        }
                    }
                } else {
                    currentTime = new GregorianCalendar();

                    int hour = currentTime.get(Calendar.HOUR) - timeLock.get(Calendar.HOUR);
                    int min = currentTime.get(Calendar.MINUTE) - timeLock.get(Calendar.MINUTE);
                    int sec = currentTime.get(Calendar.SECOND) - timeLock.get(Calendar.SECOND);
                    if (hour == 0 && min == 0 && sec < 10) {
                        //System.out.println("Time out!");
                        throw new AccountIsLockedException("Time out - " + sec + " second");
                    }
                    else {
                        System.out.println("Card unlock");
                        cardLock = false;
                        i = 0;
                        continue;
                    }
                }

                }
        } catch (IOException | AccountIsLockedException | InterruptedException e) {
            e.printStackTrace();
        }

        //Логика по выдаче наличных - вынести в отдельный класс
        boolean withdrawalСash = false;
        while (!withdrawalСash){
            System.out.print("Please enter amount : ");
            if (Integer.parseInt(reader.readLine()) % 100 == 0) {
                System.out.println("The amount is a multiple of 100");
                //Запросить остаток в банкомате

                // В зависимости от остатка делать withdrawalСash
                withdrawalСash = true;
            } else {
                System.out.println("The amount is not a multiple of 100");

            }
        }
    }
}