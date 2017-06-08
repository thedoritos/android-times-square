package com.squareup.timessquare;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.List;

/**
 * Created by matsumura on 2017/06/08.
 */

public class CalendarTitleView extends CalendarRowView {
    public CalendarTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setTitle(MonthDescriptor month, List<MonthCellDescriptor> firstWeek, boolean isRtl) {
        for (int i = 0; i < firstWeek.size(); i++) {
            TextView textView = (TextView) getChildAt(i);
            textView.setText(null);
        }

        for (int i = 0; i < firstWeek.size(); i++) {
            int idx = isRtl ? 6 - i : i;
            MonthCellDescriptor cell = firstWeek.get(idx);
            if (cell.isCurrentMonth()) {
                TextView textView = (TextView) getChildAt(idx);
                textView.setText(month.getLabel());
                return;
            }
        }
    }
}