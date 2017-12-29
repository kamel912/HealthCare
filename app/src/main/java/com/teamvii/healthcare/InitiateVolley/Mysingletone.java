package com.teamvii.healthcare.InitiateVolley;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 14/07/2017.
 */

public class Mysingletone {
    private static Mysingletone mInstance;
    private static Context mCtx;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private Mysingletone(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();

        mImageLoader = new ImageLoader( mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>( 20 );

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get( url );
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put( url, bitmap );
                    }
                } );
    }

    public static synchronized Mysingletone getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Mysingletone( context );
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue( mCtx.getApplicationContext() );
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add( req );
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    public <T> void addRequestQueue(Request<T> request) {
        DefaultRetryPolicy retryPolicy = new DefaultRetryPolicy( 0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT );
        request.setRetryPolicy( retryPolicy );
        getRequestQueue().add( request );
    }
}