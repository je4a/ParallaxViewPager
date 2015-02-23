package com.parallaxviewpager.sample;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Yevgen on 2/23/15.
 */
public class ParallaxTransform implements ViewPager.PageTransformer {
    private float parallaxSpeed = 0.3f;

    @Override
    public void transformPage(View view, float pagePos) {
        if (view.getTag() == null || !(view.getTag() instanceof ViewHolder)) { return; }
        View parallaxView = ((ViewHolder) view.getTag()).getParallaxView();

        if (parallaxView == null) { return; }
        if (pagePos <= -1 || pagePos >= 1) { return; }
        parallaxView.setTranslationX(-pagePos * parallaxSpeed * view.getWidth());
    }

    public void setParallaxSpeed(float parallaxSpeed) {
        this.parallaxSpeed = parallaxSpeed;
    }
}