package com.wd.health_main.fragment.yaopinfragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HistryFlowView extends ViewGroup {
    private int widthPixels;

    public HistryFlowView(Context context) {
        super(context,null);
    }

    public HistryFlowView(Context context, AttributeSet attrs) {
        super(context, attrs,-1);
       Resources resources = context.getResources();
      DisplayMetrics displayMetrics = resources.getDisplayMetrics();
     widthPixels =  displayMetrics.widthPixels;
    }

    public HistryFlowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
                int childCount =   getChildCount();

        int widthSpace=25;
        int heightSpace=25;
        int left=widthSpace;
        int top=heightSpace;
        int right=0;
        int bottom=0;

        for (int i = 0; i <childCount ; i++) {
           View childAt = getChildAt(i);
           childAt.measure(0,0);
          int measuredWidth  =  childAt.getMeasuredWidth();

            int measuredHeight = childAt.getMeasuredHeight();

            right = left+measuredWidth;


            if(right>widthPixels){
                left=widthSpace;
                right=left+measuredWidth;
                top=bottom+heightSpace;
            }

            bottom=top+measuredHeight;
            childAt.layout(left,top,right,bottom);
            left=left+measuredWidth+widthSpace;
        }

    }

    public void addTag(String tag){

         final TextView textView =   new TextView(getContext());


        textView.setText(tag);
        textView.setTextSize(12);
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundColor(Color.GRAY);
        textView.setPadding(10,10,10,10);
        textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
        LayoutParams params=new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        addView(textView,params);

        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textClick!=null){
                    textClick.onClick(textView.getText().toString());
                }
            }
        });

        textView.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(textLongClick!=null){
                    removeView(textView);
                    textLongClick.onLongClick("删除成功");
                }
                return true;
            }
        });
    }

    public TextClick textClick;

    public void setTextClick(TextClick textClick) {
        this.textClick = textClick;
    }

    public interface TextClick{
        void onClick(String msg);
    }

    public TextLongClick textLongClick;

    public void setTextLongClick(TextLongClick textLongClick) {
        this.textLongClick = textLongClick;
    }

    public interface TextLongClick{
        void onLongClick(String msg);
    }



}
