package com.squareup.timessquare;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.squareup.timessquare.utils.MonthUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by matsumura on 2017/06/08.
 */

public class CalendarHeaderView extends CalendarRowView {
    public CalendarHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setIsHeaderRow(true);
    }

    public void init(Calendar today) {
        Context context = getContext();
        Locale locale = Locale.getDefault();
        SimpleDateFormat weekdayNameFormat = new SimpleDateFormat(context.getString(R.string.day_name_format), locale);

        this.init(weekdayNameFormat, today, locale);
    }

    public void init(DateFormat weekdayNameFormat, Calendar today, Locale locale) {
        int firstDayOfWeek = today.getFirstDayOfWeek();
        boolean isRtl = MonthUtil.isRtl(locale);

        for (int offset = 0; offset < 7; offset++) {
            today.set(Calendar.DAY_OF_WEEK, MonthUtil.getDayOfWeek(firstDayOfWeek, offset, isRtl));
            final TextView textView = (TextView) getChildAt(offset);
            textView.setText(weekdayNameFormat.format(today.getTime()));
        }
    }
}
