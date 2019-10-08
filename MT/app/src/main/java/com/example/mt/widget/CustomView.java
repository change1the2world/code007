package com.example.mt.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Time:2019/6/11
 * Author:zyh
 * Description:
 */
public class CustomView extends View {

    private Paint innerPaint;
    private Paint outPaint;


    private int border = 60;

    private int mStepMax = 5000;//总的步数
    private int mCurrentStep = 3500;//当前步数
    private Paint textPaint;
    private Paint taint;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        innerPaint = new Paint();
        innerPaint.setStyle(Paint.Style.STROKE);
        innerPaint.setColor(Color.MAGENTA);
        innerPaint.setStrokeWidth(border);
        innerPaint.setStrokeCap(Paint.Cap.ROUND);//设置下方为圆形
        outPaint = new Paint();
        outPaint.setColor(Color.BLUE);
        outPaint.setStyle(Paint.Style.STROKE);
        outPaint.setStrokeWidth(border);
        outPaint.setStrokeCap(Paint.Cap.ROUND);//设置下方为圆形

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.BLUE);
        textPaint.setTextSize(dpToPx(30));

        taint = new Paint();
        taint.setAntiAlias(true);
        taint.setColor(Color.GRAY);
        taint.setTextSize(dpToPx(30));

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(dpToPx(300),dpToPx(300));
        }else if (widthMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(dpToPx(300),heightSize);
        }else if (heightMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSize,dpToPx(300));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int center = width/2;
        int radius = center - border;

        RectF rectF = new RectF(center - radius,
                center - radius,
                radius+center,
                radius+center);

        canvas.drawArc(rectF,135,270,false,outPaint);

        float scale = (float)mCurrentStep/mStepMax;

        canvas.drawArc(rectF,135,scale* 270,false,innerPaint);

        Rect rect = new Rect();
        String text = mCurrentStep+"";
        textPaint.getTextBounds(text,0,text.length(),rect);//把文字 放到rect里
        int dx = getWidth() / 2 - rect.width() / 2;

        //计算baseline
        Paint.FontMetrics fontMetrics=textPaint.getFontMetrics();
        int distance= (int) ((fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom);
        int dy = getHeight() / 2 + distance;
        canvas.drawText(text,dx,dy,textPaint);

        Rect rect1 = new Rect();
        String text1 = "步";
        taint.getTextBounds(text1,0,text1.length(),rect1);
        int dx1 = getWidth() / 2 - rect1.width() / 2;
        int dy1 = dy + rect1.height();
        canvas.drawText(text1,dx1,dy1,taint);

    }

    public void setStep(int step){
        ValueAnimator animator = ValueAnimator.ofFloat(0, step);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentStep = (float) animation.getAnimatedValue();//获取当前值
                CustomView.this.mCurrentStep = (int) currentStep;
                invalidate();
            }
        });
        animator.setDuration(3000);
        animator.start();
    }

    protected int dpToPx(float dpValue) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return (int) (dpValue * metrics.density + 0.5f);
    }

}
