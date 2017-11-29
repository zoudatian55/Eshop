package com.example.administrator.eshop.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2017/9/24 0024.
 */

public class CommandGridView extends GridView {
    public CommandGridView(Context context) {
        super(context);
    }

    public CommandGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommandGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>4,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
    public int getNumColumns() {
        return 4;
    }

}
