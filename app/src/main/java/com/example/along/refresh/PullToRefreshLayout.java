package com.example.along.refresh;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Title:
 * <p>
 * Description:
 * </p>
 * Author dragon.
 * Date 2018/3/23 14:34
 */

public class PullToRefreshLayout extends LinearLayout {

    public static final int STATUS_PULL_TO_REFRESH=1;
    public static final int STATUS_RELEASE_TO_REFRESH=2;
    public static final int STATUS_REFERSHING=3;
    public static final int STATUS_REFERSH_FINISHING=4;

//    https://www.imooc.com/article/2112
    public PullToRefreshLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


}
