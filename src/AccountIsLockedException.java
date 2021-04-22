import java.util.Calendar;
import java.util.Date;

public class AccountIsLockedException extends Exception{
    public AccountIsLockedException (String mess, Calendar date) {
        super (mess);
        System.out.println("TIME out " + date);
    }

}
