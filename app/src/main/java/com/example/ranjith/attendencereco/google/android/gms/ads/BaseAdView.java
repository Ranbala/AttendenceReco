package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

class BaseAdView
  extends ViewGroup
{
  private final zzz zzoy;
  
  public BaseAdView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.zzoy = new zzz(this, zze(paramInt));
  }
  
  public BaseAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.zzoy = new zzz(this, paramAttributeSet, false, zze(paramInt));
  }
  
  public BaseAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    this.zzoy = new zzz(this, paramAttributeSet, false, zze(paramInt2));
  }
  
  private static boolean zze(int paramInt)
  {
    return paramInt == 2;
  }
  
  public void destroy()
  {
    this.zzoy.destroy();
  }
  
  public AdListener getAdListener()
  {
    return this.zzoy.getAdListener();
  }
  
  public AdSize getAdSize()
  {
    return this.zzoy.getAdSize();
  }
  
  public String getAdUnitId()
  {
    return this.zzoy.getAdUnitId();
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.zzoy.getInAppPurchaseListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return this.zzoy.getMediationAdapterClassName();
  }
  
  public boolean isLoading()
  {
    return this.zzoy.isLoading();
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    this.zzoy.zza(paramAdRequest.zzaG());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int i = localView.getMeasuredWidth();
      int j = localView.getMeasuredHeight();
      int k = (paramInt3 - paramInt1 - i) / 2;
      int m = (paramInt4 - paramInt2 - j) / 2;
      localView.layout(k, m, i + k, j + m);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(0);
    int j;
    int i;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      measureChild(localView, paramInt1, paramInt2);
      j = localView.getMeasuredWidth();
      i = localView.getMeasuredHeight();
    }
    for (;;)
    {
      int k = Math.max(j, getSuggestedMinimumWidth());
      int m = Math.max(i, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSize(k, paramInt1), View.resolveSize(m, paramInt2));
      return;
      AdSize localAdSize = getAdSize();
      if (localAdSize != null)
      {
        Context localContext = getContext();
        j = localAdSize.getWidthInPixels(localContext);
        i = localAdSize.getHeightInPixels(localContext);
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
  }
  
  public void pause()
  {
    this.zzoy.pause();
  }
  
  public void resume()
  {
    this.zzoy.resume();
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.zzoy.setAdListener(paramAdListener);
    if ((paramAdListener != null) && ((paramAdListener instanceof zza))) {
      this.zzoy.zza((zza)paramAdListener);
    }
    while (paramAdListener != null) {
      return;
    }
    this.zzoy.zza(null);
  }
  
  public void setAdSize(AdSize paramAdSize)
  {
    this.zzoy.setAdSizes(new AdSize[] { paramAdSize });
  }
  
  public void setAdUnitId(String paramString)
  {
    this.zzoy.setAdUnitId(paramString);
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    this.zzoy.setInAppPurchaseListener(paramInAppPurchaseListener);
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    this.zzoy.setPlayStorePurchaseParams(paramPlayStorePurchaseListener, paramString);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\BaseAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */