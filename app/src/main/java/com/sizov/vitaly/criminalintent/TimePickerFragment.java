package com.sizov.vitaly.criminalintent;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimePickerFragment extends PickerDialogFragment {

    private TimePicker mTimePicker;

    public static TimePickerFragment newInstance(Date date) {
        Bundle args = getArgs(date);
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @TargetApi(Build.VERSION_CODES.M)
    protected View initLayout() {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time, null);

        mTimePicker = (TimePicker) v.findViewById(R.id.dialog_time_time_picker);
        mTimePicker.setIs24HourView(false);
        mTimePicker.setHour(mCalendar.get(Calendar.HOUR_OF_DAY));
        mTimePicker.setMinute(mCalendar.get(Calendar.MINUTE));

        return v;
    }

    @TargetApi(Build.VERSION_CODES.M)
    protected Date getDate() {
        int year = mCalendar.get(Calendar.YEAR);
        int month = mCalendar.get(Calendar.MONTH);
        int day = mCalendar.get(Calendar.DAY_OF_MONTH);

        // Поолучить время с TimePicker
        int hour = mTimePicker.getHour();
        int minute = mTimePicker.getMinute();

        return new GregorianCalendar(year, month, day, hour, minute).getTime();
    }
}


