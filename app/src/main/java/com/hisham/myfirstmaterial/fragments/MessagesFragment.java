package com.hisham.myfirstmaterial.fragments;

/**
 * Created by Hisham on 4/16/2015.
 */

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hisham.myfirstmaterial.R;

import java.util.Random;


public class MessagesFragment extends Fragment {


    private TextView tvLabel;
    private ImageView imageView;

    public MessagesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    int images[] = new int[]{R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_messages, container, false);
        // Inflate the layout for this fragment

        tvLabel = (TextView) rootView.findViewById(R.id.label);
        imageView = (ImageView) rootView.findViewById(R.id.imageBg);
        imageView.setOnClickListener(colorChanger);
        return rootView;
    }

    private View.OnClickListener colorChanger = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int i = new Random().nextInt(4);
            imageView.setImageResource(images[i]);
//
//            // Getting bitmap out of image
//            imageView.setDrawingCacheEnabled(true);
//            imageView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
//                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
//            imageView.layout(0, 0,
//                    imageView.getMeasuredWidth(), imageView.getMeasuredHeight());
//            imageView.buildDrawingCache(true);
//
//            imageView.setDrawingCacheEnabled(true);


            //Bitmap bitmap = imageBg.getDrawingCache();


//        The Palette object will try to find 16 colors from the image by default, but there are six color profiles you will use most often:
//        Vibrant
//        Vibrant Dark
//        Vibrant Light
//        Muted
//        Muted Dark
//        Muted Light
            // https://www.bignerdranch.com/blog/extracting-colors-to-a-palette-with-android-lollipop/
//        Palette palette = Palette.generate(bitmap);
//        int vibrant = palette.getVibrantColor(0x000000);
//        int vibrantLight = palette.getLightVibrantColor(0x000000);
//        int vibrantDark = palette.getDarkVibrantColor(0x000000);
//        int muted = palette.getMutedColor(0x000000);
//        int mutedLight = palette.getLightMutedColor(0x000000);
//        int mutedDark = palette.getDarkMutedColor(0x000000);

            final Palette.Swatch swatch = new Palette.Swatch(Color.YELLOW, 100);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), images[i]);
            // working fine. and working on below lollipop too. Need a compile
            Palette.generateAsync(bitmap,
                    new Palette.PaletteAsyncListener() {
                        @Override
                        public void onGenerated(Palette palette) {
                            Palette.Swatch vibrant =
                                    palette.getVibrantSwatch();
                            if (swatch != null) {
                                // If we have a vibrant color
                                // update the title TextView
                                tvLabel.setBackgroundColor(
                                        vibrant.getRgb());
                                tvLabel.setTextColor(
                                        vibrant.getTitleTextColor());
                            }
                        }
                    });

        }
    };

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
