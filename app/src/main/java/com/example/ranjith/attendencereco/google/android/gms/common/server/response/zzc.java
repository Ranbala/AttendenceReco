package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<FieldMappingDictionary>
{
  static void zza(FieldMappingDictionary paramFieldMappingDictionary, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramFieldMappingDictionary.getVersionCode());
    zzb.zzc(paramParcel, 2, paramFieldMappingDictionary.zzrk(), false);
    zzb.zza(paramParcel, 3, paramFieldMappingDictionary.zzrl(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public FieldMappingDictionary zzaC(Parcel paramParcel)
  {
    String str = null;
    int i = zza.zzau(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        j = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localArrayList = zza.zzc(paramParcel, k, FieldMappingDictionary.Entry.CREATOR);
        break;
      case 3: 
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new zza.zza("Overread allowed size end=" + i, paramParcel);
    }
    return new FieldMappingDictionary(j, localArrayList, str);
  }
  
  public FieldMappingDictionary[] zzck(int paramInt)
  {
    return new FieldMappingDictionary[paramInt];
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\server\response\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */