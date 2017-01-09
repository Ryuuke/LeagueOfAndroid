package com.home.yassine.leagueofandroid.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import yassine.home.com.leagueofandroid.R;

/**
 * Created by Yassine on 03/01/2017.
 */

public class CustomBindingAdapters {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        if (url == null) {
            imageView.setImageResource(R.drawable.default_image);
        }
        else {
            Picasso.with(imageView.getContext())
                    .load(url)
                    .error(R.drawable.default_image)
                    .into(imageView);
        }
    }
}