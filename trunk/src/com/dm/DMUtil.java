package com.dm;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import android.view.ViewGroup;
import cn.domob.android.ads.DomobAdEventListener;
import cn.domob.android.ads.DomobAdView;
import cn.domob.android.ads.DomobAdManager.ErrorCode;

public class DMUtil {
    // attention this 56OJzVlYuNOpRvB1hD 56OJzVlYuNUYJwhJ7N
    public static final String PUBLISHER_ID = "56OJzVlYuNOpRvB1hD";
    // 16TLm7ZaAp0EcNU-fFg-XTCk 16TLm7ZaApAzkY2Jwfrh3B2k
    public static final String FlexibleInlinePPID1 = "16TLm7ZaAp0EcNU-fFg-XTCk";
    // 16TLm7ZaAp0EcNU-fAuDq7rz 16TLm7ZaApAzkNUH-tQGBpZz
    public static final String FlexibleInlinePPID2 = "16TLm7ZaAp0EcNU-fAuDq7rz";
    
    public static DomobAdView bindView(final Activity activity, ViewGroup container, String placeId) {
        DomobAdView mAdviewFlexibleAdView = createAdView(activity, placeId);
        container.addView(mAdviewFlexibleAdView);
        return mAdviewFlexibleAdView;
    }
    
    public static DomobAdView createAdView( final Activity activity, String placeId) {
        DomobAdView mAdviewFlexibleAdView = new DomobAdView(activity, DMUtil.PUBLISHER_ID, placeId, DomobAdView.INLINE_SIZE_FLEXIBLE);
        mAdviewFlexibleAdView.setKeyword("game");
        mAdviewFlexibleAdView.setUserGender("male");
        mAdviewFlexibleAdView.setUserBirthdayStr("1984-05-08");
        mAdviewFlexibleAdView.setUserPostcode("518000");
        mAdviewFlexibleAdView.setAdEventListener(new DomobAdEventListener() {
            @Override
            public void onDomobLeaveApplication(DomobAdView arg0) {
                
            }
            
            @Override
            public void onDomobAdReturned(DomobAdView arg0) {
                
            }
            
            @Override
            public Context onDomobAdRequiresCurrentContext() {
                return activity;
            }
            
            @Override
            public void onDomobAdOverlayPresented(DomobAdView arg0) {
                
            }
            
            @Override
            public void onDomobAdOverlayDismissed(DomobAdView arg0) {
                
            }
            
            @Override
            public void onDomobAdFailed(DomobAdView view, ErrorCode arg1) {
                if(isNetAvaliable(view.getContext())) {
                    view.requestRefreshAd();
                    view.setRefreshable(true);
                }
                Log.d("##", "Failed!");
            }
            
            @Override
            public void onDomobAdClicked(DomobAdView arg0) {
                
            }
        });
        return mAdviewFlexibleAdView;
    }
    
    public static boolean isNetAvaliable(Context context)
    {
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connMgr == null) return false;
        final android.net.NetworkInfo wifi = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        final android.net.NetworkInfo mobile = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ( (wifi == null || !wifi.isAvailable()) && ( mobile == null || !mobile.isAvailable()))
        {
            return false;
        }
        return true;
    }
}