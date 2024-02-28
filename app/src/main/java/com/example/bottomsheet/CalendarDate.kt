package com.example.bottomsheet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarDate {

    private Date date;
    private boolean isSelected;

    public CalendarDate(Date date, boolean isSelected) {
        this.date = date;
        this.isSelected = isSelected;
    }

    public CalendarDate(Date date) {
        this.date = date;
        this.isSelected = false;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getCalendarDay() {
        return new SimpleDateFormat("EE", Locale.getDefault()).format(date);
    }

    public String getCalendarDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
    }
}
