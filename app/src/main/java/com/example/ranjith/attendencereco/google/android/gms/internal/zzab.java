package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;

public class zzab
  extends zzk<String>
{
  private final zzm.zzb<String> zzaG;
  
  public zzab(int paramInt, String paramString, zzm.zzb<String> paramzzb, zzm.zza paramzza)
  {
    super(paramInt, paramString, paramzza);
    this.zzaG = paramzzb;
  }
  
  public zzab(String paramString, zzm.zzb<String> paramzzb, zzm.zza paramzza)
  {
    this(0, paramString, paramzzb, paramzza);
  }
  
  protected zzm<String> zza(zzi paramzzi)
  {
    try
    {
      str = new String(paramzzi.data, zzx.zza(paramzzi.zzA));
      return zzm.zza(str, zzx.zzb(paramzzi));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str = new String(paramzzi.data);
      }
    }
  }
  
  protected void zzi(String paramString)
  {
    this.zzaG.zzb(paramString);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */