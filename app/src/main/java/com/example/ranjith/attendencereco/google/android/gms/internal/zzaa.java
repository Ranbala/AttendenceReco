package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class zzaa
  extends ByteArrayOutputStream
{
  private final zzu zzar;
  
  public zzaa(zzu paramzzu, int paramInt)
  {
    this.zzar = paramzzu;
    this.buf = this.zzar.zzb(Math.max(paramInt, 256));
  }
  
  private void zzd(int paramInt)
  {
    if (paramInt + this.count <= this.buf.length) {
      return;
    }
    byte[] arrayOfByte = this.zzar.zzb(2 * (paramInt + this.count));
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.zzar.zza(this.buf);
    this.buf = arrayOfByte;
  }
  
  public void close()
    throws IOException
  {
    this.zzar.zza(this.buf);
    this.buf = null;
    super.close();
  }
  
  public void finalize()
  {
    this.zzar.zza(this.buf);
  }
  
  public void write(int paramInt)
  {
    try
    {
      zzd(1);
      super.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      zzd(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */