package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class AccountChangeEventsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new zzc();
  final int mVersion;
  final List<AccountChangeEvent> zzpw;
  
  AccountChangeEventsResponse(int paramInt, List<AccountChangeEvent> paramList)
  {
    this.mVersion = paramInt;
    this.zzpw = ((List)zzx.zzy(paramList));
  }
  
  public AccountChangeEventsResponse(List<AccountChangeEvent> paramList)
  {
    this.mVersion = 1;
    this.zzpw = ((List)zzx.zzy(paramList));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<AccountChangeEvent> getEvents()
  {
    return this.zzpw;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\auth\AccountChangeEventsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */