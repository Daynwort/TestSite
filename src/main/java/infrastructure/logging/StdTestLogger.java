package infrastructure.logging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StdTestLogger implements AbstractLogger{
        private static int counter = 0;

    public String getEntry(String operation){
        counter++;
        Date curDate = new Date();
        curDate.getTime();
        String formattedDatedDate = new SimpleDateFormat("HH:mm:ss.SSS").format(curDate.getTime());
        return counter+ ")" + formattedDatedDate + "[" + Thread.currentThread().getName() + "]: " +
                operation + "\n";
    }

        @Override
        public void log(String operation){
            System.out.println(getEntry(operation));
        }

    public void atStart() {

    }

    public void atFinish() {

    }
}
