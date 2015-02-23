package com.parallaxviewpager.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

public class SampleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        List<Integer> images = Arrays.asList(R.drawable.golden_gate,   R.drawable.karlov_bridge,
                                             R.drawable.london_bridge, R.drawable.manhattan_bridge);

        pager.setPageTransformer(false, new ParallaxTransform());
        pager.setAdapter(new SampleAdapter(this, images));
        pager.setOffscreenPageLimit(images.size());
    }

    private class SampleAdapter extends PagerAdapter {
        private final LayoutInflater inflater;
        private final List<Integer> images;

        public SampleAdapter(Context context, List<Integer> images) {
            this.inflater = LayoutInflater.from(context);
            this.images = images;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View parallaxContainer = inflater.inflate(R.layout.page_layout, null);
            ImageView image = (ImageView) parallaxContainer.findViewById(R.id.image);
            ViewHolder holder = new ViewHolder(image);

            image.setImageResource(images.get(position));
            container.addView(parallaxContainer);
            parallaxContainer.setTag(holder);
            return parallaxContainer;
        }

        @Override
        public int getCount() { return images.size(); }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) { container.removeView((View) object); }
        @Override
        public boolean isViewFromObject(View view, Object o) { return view == o; }
        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }
}
