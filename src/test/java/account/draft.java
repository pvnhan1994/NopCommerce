package account;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class draft {
    public static void main(String[] args) {
        System.out.println(getDayOfWeek()+", "+getCurrentMonth()+ " " +getCurrentDay()+", "+getCurrentYear());

    }

    protected static String getMinuteCurrent() {
        DateTime nowUTC = new DateTime(DateTimeZone.UTC);
        return nowUTC.getMinuteOfHour() + "";
    }
    protected static String getDayOfWeek(){
        DateTime now = new DateTime(DateTimeZone.UTC);
        String day;
        int indexInWeek = now.getDayOfWeek();
        switch (indexInWeek){
            case 0:
                return day= "Sunday";
            case 1:
                return day= "Monday";
            case 2:
                return day="Tuesday";
            case 3:
                return day="Wednesday";
            case 4:
                return day="Thursday";
            case 5:
                return day="Friday";
            case 6:
                return day="Saturday";
            default:
                return null;
        }
    }

    protected static String getHourCurrent() {
        DateTime nowUTC = new DateTime(DateTimeZone.UTC);
        int hour = 7 + nowUTC.getHourOfDay();
        return hour + "";
        //	return nowUTC.getHourOfDay()+"";
    }

    protected static String getCurrentDay() {
        DateTime nowUTC = new DateTime(DateTimeZone.UTC);
        int day = nowUTC.getDayOfMonth();
        if (day < 10) {
            String dayValue = "0" + day;
            return dayValue;
        }
        return day + "";
    }

    protected static String getCurrentMonth() {
        DateTime now = new DateTime(DateTimeZone.UTC);
        String stringMonth;
        int month = now.getMonthOfYear();
//        if (month < 10) {
//            String monthValue = "0" + month;
//            return monthValue;
//        }
//        return month + "";
        switch (month) {
            case 1:
                return stringMonth = "January";
            case 2:
                return stringMonth = "February";
            case 3:
                return stringMonth = "March";
            case 4:
                return stringMonth = "April";
            case 5:
                return stringMonth = "May";
            case 6:
                return stringMonth = "June";
            case 7:
                return stringMonth = "July";
            case 8:
                return stringMonth = "August";
            case 9:
                return stringMonth = "September";
            case 10:
                return stringMonth = "October";
            case 11:
                return stringMonth = "November";
            case 12:
                return stringMonth = "December";
            default:
                System.out.println("Wrong month");
        }
        return null;
    }

    protected static String getCurrentYear() {
        DateTime now = new DateTime(DateTimeZone.UTC);
        return now.getYear() + "";
    }


    protected static String getToday() {
        //return getCurrentDay() + "/" + getCurrentMonth() + "/" + getCurrentYear();
        return getCurrentMonth() + "/" + getCurrentDay() + "/" + getCurrentYear();
    }

    protected  String getTimeCurrent() {
        return getHourCurrent() + ":" + getMinuteCurrent();
    }

}
