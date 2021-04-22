import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static Calendar timeLock;
    public static Calendar currentTime;
    public static void main(String[] args) {
        // 1 Проверка на каждое нажатие? - С помощью форм + событий?
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            boolean cardLock = false;
            String password;
            password = "7777";
            timeLock = new GregorianCalendar();
            for(int i = 0 ; i < 30 ; i++){

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
                        System.out.println("Time out!");
                        throw new AccountIsLockedException("Err", timeLock);
                    }
                    else {
                        System.out.println("Card unlock");
                        cardLock = false;
                        continue;
                    }
                }

                }
        } catch (IOException | AccountIsLockedException e) {
            e.printStackTrace();
        }
    }
}