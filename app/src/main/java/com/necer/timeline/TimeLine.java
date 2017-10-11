package com.necer.timeline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 闫彬彬 on 2017/10/11.
 * QQ:619008099
 */

public class TimeLine extends View {


    private int mRectWidth;
    private int mRectHeight;
    private int mCircleRadius;

    private Paint mPaint;

    private int leftDistance = 180;


    private String[] colors = {"#51a6fe", "#54adfb", "#57b5f8", "#5cbef4", "#61c7ef", "#67d0ea", "#6ed8e3", "#76dedb", "#81e0d0", "#8fe0c2", "#9fe0b1", "#b0e0a0", "#c3e08d"
            , "#d4e07b", "#e2e06c", "#edda60", "#f0d35c", "#f0c85c", "#f0ba5c", "#f0aa5c", "#f09b5c", "#ef8c5c", "#ec7e5c", "#ea745c"};

    private Map<Integer, List<String>> timeMap;


    private int hourHeight;

    public TimeLine(Context context) {
        this(context, null);
    }

    public TimeLine(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimeLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setTextSize(Utils.dp2px(context, 13));
        mPaint.setTextAlign(Paint.Align.CENTER);
        mRectWidth = (int) Utils.dp2px(context, 14);
        mCircleRadius = mRectWidth / 2;

        timeMap = new HashMap<>();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRectHeight = getHeight() * 5 / 6;
        hourHeight = mRectHeight / 24;
        mPaint.setColor(Color.parseColor("#A4DD74"));
        canvas.drawCircle(leftDistance, mRectWidth / 2, mCircleRadius, mPaint);
        RectF rect = new RectF(leftDistance - mRectWidth / 2, mRectWidth / 2, leftDistance + mRectWidth / 2, hourHeight / 2 + hourHeight);
        canvas.drawRect(rect, mPaint);

        mPaint.setColor(Color.parseColor("#5FB1FF"));
        RectF rect1 = new RectF(leftDistance - mRectWidth / 2, hourHeight + hourHeight / 2, leftDistance + mRectWidth / 2, hourHeight / 2 + hourHeight * 7);
        canvas.drawRect(rect1, mPaint);

        mPaint.setColor(Color.parseColor("#7EE0D1"));
        RectF rect2 = new RectF(leftDistance - mRectWidth / 2, hourHeight * 7 + hourHeight / 2, leftDistance + mRectWidth / 2, hourHeight / 2 + hourHeight * 13);
        canvas.drawRect(rect2, mPaint);


        mPaint.setColor(Color.parseColor("#ECD865"));
        RectF rect3 = new RectF(leftDistance - mRectWidth / 2, hourHeight * 13 + hourHeight / 2, leftDistance + mRectWidth / 2, hourHeight / 2 + hourHeight * 19);
        canvas.drawRect(rect3, mPaint);

        mPaint.setColor(Color.parseColor("#A4DD74"));
        RectF rect4 = new RectF(leftDistance - mRectWidth / 2, hourHeight * 19 + hourHeight / 2, leftDistance + mRectWidth / 2, hourHeight / 2 + hourHeight * 23 + hourHeight - 2 * mCircleRadius);
        canvas.drawRect(rect4, mPaint);

        mPaint.setColor(Color.parseColor("#A4DD74"));
        canvas.drawCircle(leftDistance, hourHeight / 2 + hourHeight * 23 + hourHeight - 2 * mCircleRadius, mCircleRadius, mPaint);


        for (int i = 0; i < 24; i++) {
            int y = hourHeight * i + hourHeight / 2;
            mPaint.setColor(Color.WHITE);
            canvas.drawCircle(leftDistance, y, Utils.dp2px(getContext(), 2), mPaint);

            Paint.FontMetrics fm = mPaint.getFontMetrics();
            float textY = y + (fm.descent - fm.ascent) / 2 - fm.descent;

            if ((i - 1) % 3 == 0) {
                mPaint.setColor(Color.parseColor("#8B8B8C"));
                canvas.drawText(i - 1 + "", Utils.dp2px(getContext(), 40), textY, mPaint);
            }

            for (Integer in : timeMap.keySet()) {
                if (in == i - 1) {
                    mPaint.setColor(Color.parseColor(colors[i]));
                    canvas.drawLine(leftDistance + mRectWidth / 2, y, leftDistance + mRectWidth + Utils.dp2px(getContext(), 30), y, mPaint);
                    canvas.drawCircle(leftDistance + mRectWidth + Utils.dp2px(getContext(), 30), y, Utils.dp2px(getContext(), 2), mPaint);

                    int textRectX = (int) (leftDistance + mRectWidth + Utils.dp2px(getContext(), 80)), textRectY = y;
                    List<String> textList = timeMap.get(in);
                    int offset = (int) Utils.dp2px(getContext(), 80);
                    for (int j = 0; j < textList.size(); j++) {
                        mPaint.setColor(Color.parseColor(colors[i]));
                        RectF r = new RectF(textRectX + (j * offset), textRectY - Utils.dp2px(getContext(), 8), textRectX + (j * offset) + Utils.dp2px(getContext(), 50), textRectY + Utils.dp2px(getContext(), 8));
                        canvas.drawRoundRect(r, textRectY - Utils.dp2px(getContext(), 5), textRectY - Utils.dp2px(getContext(), 5), mPaint);
                        mPaint.setColor(Color.WHITE);
                        canvas.drawText(textList.get(j), r.centerX(), textY, mPaint);
                    }
                }
            }

        }
    }


    public void setTimeMap(Map<Integer, List<String>> timeMap1) {
        timeMap.clear();
        timeMap.putAll(timeMap1);
        invalidate();
    }
}
