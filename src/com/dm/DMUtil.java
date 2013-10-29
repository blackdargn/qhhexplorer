package com.dm;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import cn.domob.android.ads.DomobAdEventListener;
import cn.domob.android.ads.DomobAdView;
import cn.domob.android.ads.DomobAdManager.ErrorCode;

public class DMUtil {
    public static final String PUBLISHER_ID = "56OJzVlYuNUYHpZvjM";
    public static final String FlexibleInlinePPID1 = "16TLm7ZaApAz1Y2JwNXy9TRk";
    public static final String FlexibleInlinePPID2 = "16TLm7ZaApAz1NUH-VfLsbXi";
    
    public static DomobAdView bindView(final Activity activity, ViewGroup container, String placeId) {
        DomobAdView mAdviewFlexibleAdView = new DomobAdView(activity, DMUtil.PUBLISHER_ID, placeId, DomobAdView.INLINE_SIZE_FLEXIBLE);
        mAdviewFlexibleAdView.setKeyword("game");
        mAdviewFlexibleAdView.setUserGender("male");
        mAdviewFlexibleAdView.setUserBirthdayStr("1984-05-08");
        mAdviewFlexibleAdView.setUserPostcode("518000");
        
        container.addView(mAdviewFlexibleAdView);
        
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
                view.requestRefreshAd();
                view.setRefreshable(true);
                Log.d("##", "Failed!");
            }
            
            @Override
            public void onDomobAdClicked(DomobAdView arg0) {
                
            }
        });
        
        return mAdviewFlexibleAdView;
    }
}