package com.teamvii.healthcare.utitlity;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.teamvii.healthcare.data.PreferenceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static com.teamvii.healthcare.data.Contract.MashweerEntry.URL_SYNC;

/**
 * Created by ibrahim on 29/12/17.
 */

public class NetworkUtils {
    private static final String TAG = NetworkUtils.class.getSimpleName();


    public static URL getUrl(Context context) {
        if (PreferenceUtil.getPreferredLang( context ) != null) {
            String lang = PreferenceUtil.getPreferredLang( context );
            return buildUrlLang( context, lang );
        } else {
            String lang = PreferenceUtil.getPreferredLang( context );
            return buildUrlwithLangQuery( context, lang );
        }
    }

    private static URL buildUrlLang(Context context, String lang) {
        Uri weatherQueryUri = Uri.parse( URL_SYNC ).buildUpon()
                .appendPath( lang )
                .build();

        try {
            URL LANGQueryUri = new URL( weatherQueryUri.toString() );
            Log.v( TAG, "URL: " + LANGQueryUri );
            return LANGQueryUri;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static URL buildUrlwithLangQuery(Context context, String lang) {
        Uri weatherQueryUri = Uri.parse( URL_SYNC ).buildUpon()
                .appendPath( lang )
                .build();

        try {
            URL LANGQueryUri = new URL( weatherQueryUri.toString() );
            Log.v( TAG, "URL: " + LANGQueryUri );
            return LANGQueryUri;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner( in );
            scanner.useDelimiter( "\\A" );

            boolean hasInput = scanner.hasNext();
            String response = null;
            if (hasInput) {
                response = scanner.next();
            }
            scanner.close();
            return response;
        } finally {
            urlConnection.disconnect();
        }
    }
}
