package com.parallaxviewpager.sample;

import android.view.View;

/**
 * Created by Yevgen on 2/23/15.
 */
public class ViewHolder {
    private View parallaxView;

    private ViewHolder() { this.parallaxView = null; }
    public ViewHolder(View parallaxView) { this.parallaxView = parallaxView; }
    public View getParallaxView() { return parallaxView; }
    public void setParallaxView(View parallaxView) { this.parallaxView = parallaxView; }
}