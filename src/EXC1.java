import java.util.Calendar;

public class EXC1 extends Exception{
    public EXC1 (String mess, Calendar date) {
        super (mess);
        System.out.println("TIME out " + date);
    }
}
