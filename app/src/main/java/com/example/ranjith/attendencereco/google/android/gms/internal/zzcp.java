package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public abstract interface zzcp
  extends IInterface
{
  public abstract void destroy()
    throws RemoteException;
  
  public abstract zzd zzU(String paramString)
    throws RemoteException;
  
  public abstract void zza(String paramString, zzd paramzzd)
    throws RemoteException;
  
  public abstract void zzb(zzd paramzzd)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzcp
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }
    
    public static zzcp zzu(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof zzcp))) {
        return (zzcp)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        zza(paramParcel1.readString(), zzd.zza.zzbs(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        zzd localzzd = zzU(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localzzd != null) {}
        for (IBinder localIBinder = localzzd.asBinder();; localIBinder = null)
        {
          paramParcel2.writeStrongBinder(localIBinder);
          return true;
        }
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        zzb(zzd.zza.zzbs(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
      destroy();
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class zza
      implements zzcp
    {
      private IBinder zzoo;
      
      zza(IBinder paramIBinder)
      {
        this.zzoo = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.zzoo;
      }
      
      public void destroy()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
          this.zzoo.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public zzd zzU(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
          localParcel1.writeString(paramString);
          this.zzoo.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzd localzzd = zzd.zza.zzbs(localParcel2.readStrongBinder());
          return localzzd;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void zza(String paramString, zzd paramzzd)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 28
        //   12: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: aload_1
        //   17: invokevirtual 49	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   20: aload_2
        //   21: ifnull +47 -> 68
        //   24: aload_2
        //   25: invokeinterface 64 1 0
        //   30: astore 6
        //   32: aload_3
        //   33: aload 6
        //   35: invokevirtual 67	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   38: aload_0
        //   39: getfield 15	com/google/android/gms/internal/zzcp$zza$zza:zzoo	Landroid/os/IBinder;
        //   42: iconst_1
        //   43: aload_3
        //   44: aload 4
        //   46: iconst_0
        //   47: invokeinterface 38 5 0
        //   52: pop
        //   53: aload 4
        //   55: invokevirtual 41	android/os/Parcel:readException	()V
        //   58: aload 4
        //   60: invokevirtual 44	android/os/Parcel:recycle	()V
        //   63: aload_3
        //   64: invokevirtual 44	android/os/Parcel:recycle	()V
        //   67: return
        //   68: aconst_null
        //   69: astore 6
        //   71: goto -39 -> 32
        //   74: astore 5
        //   76: aload 4
        //   78: invokevirtual 44	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: invokevirtual 44	android/os/Parcel:recycle	()V
        //   85: aload 5
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	zza
        //   0	88	1	paramString	String
        //   0	88	2	paramzzd	zzd
        //   3	79	3	localParcel1	Parcel
        //   7	70	4	localParcel2	Parcel
        //   74	12	5	localObject	Object
        //   30	40	6	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   9	20	74	finally
        //   24	32	74	finally
        //   32	58	74	finally
      }
      
      /* Error */
      public void zzb(zzd paramzzd)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 28
        //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 64 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 67	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/internal/zzcp$zza$zza:zzoo	Landroid/os/IBinder;
        //   36: iconst_3
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 38 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 41	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 44	android/os/Parcel:recycle	()V
        //   54: aload_2
        //   55: invokevirtual 44	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 5
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 44	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 44	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	zza
        //   0	78	1	paramzzd	zzd
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        //   24	37	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	26	65	finally
        //   26	50	65	finally
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzcp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */