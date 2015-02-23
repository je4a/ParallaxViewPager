# ParallaxViewPager

If you want to apply parallax effect to page changing in android [ViewPager](http://developer.android.com/reference/android/support/v4/view/ViewPager.html) you'll need to implement a transformation for every page in [ViewPager](http://developer.android.com/reference/android/support/v4/view/ViewPager.html). To do that you need to implement [PageTransformer](http://developer.android.com/reference/android/support/v4/view/ViewPager.PageTransformer.html) interface.
```java
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
```

To be a bit efficient you'll need to implement ViewHolder. See ViewHolder pattern description [here](http://developer.android.com/training/improving-layouts/smooth-scrolling.html).
```java
public class ViewHolder {
    private View parallaxView;

    private ViewHolder() { this.parallaxView = null; }
    public ViewHolder(View parallaxView) { this.parallaxView = parallaxView; }
    public View getParallaxView() { return parallaxView; }
    public void setParallaxView(View parallaxView) { this.parallaxView = parallaxView; }
}
```

Finally, you'll need to setup your ViewPager.
```java
ViewPager pager = ...;
pager.setPageTransformer(false, new ParallaxTransform());
pager.setAdapter(...);
```

See complete example [here](https://github.com/je4a/ParallaxViewPager/blob/master/sample/src/main/java/com/parallaxviewpager/sample/SampleActivity.java).
See example video [here](http://youtu.be/kin8Qo2yDhY).
