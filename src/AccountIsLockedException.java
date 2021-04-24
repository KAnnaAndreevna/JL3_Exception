import java.util.Calendar;
import java.util.Date;

public class AccountIsLockedException extends Exception{
    public AccountIsLockedException (String mess) {
        super (mess);
    }

}
