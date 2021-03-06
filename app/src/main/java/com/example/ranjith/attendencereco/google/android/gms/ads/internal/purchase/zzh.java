package com.google.android.gms.ads.internal.purchase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzha;
import java.util.Locale;

@zzha
public class zzh
{
  private static final String zzEU = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[] { "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time" });
  private static zzh zzEW;
  private static final Object zzpK = new Object();
  private final zza zzEV;
  
  zzh(Context paramContext)
  {
    this.zzEV = new zza(paramContext, "google_inapp_purchase.db");
  }
  
  public static zzh zzy(Context paramContext)
  {
    synchronized (zzpK)
    {
      if (zzEW == null) {
        zzEW = new zzh(paramContext);
      }
      zzh localzzh = zzEW;
      return localzzh;
    }
  }
  
  public int getRecordCount()
  {
    localCursor = null;
    SQLiteDatabase localSQLiteDatabase;
    synchronized (zzpK)
    {
      localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase == null) {
        return 0;
      }
    }
    try
    {
      localCursor = localSQLiteDatabase.rawQuery("select count(*) from InAppPurchase", null);
      if (localCursor.moveToFirst())
      {
        int i = localCursor.getInt(0);
        if (localCursor != null) {
          localCursor.close();
        }
        return i;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        zzb.zzaH("Error getting record count" + localSQLiteException.getMessage());
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
    finally
    {
      if (localCursor == null) {
        break label137;
      }
      localCursor.close();
    }
    return 0;
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.zzEV.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      zzb.zzaH("Error opening writable conversion tracking database");
    }
    return null;
  }
  
  public zzf zza(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    return new zzf(paramCursor.getLong(0), paramCursor.getString(1), paramCursor.getString(2));
  }
  
  public void zza(zzf paramzzf)
  {
    if (paramzzf == null) {
      return;
    }
    SQLiteDatabase localSQLiteDatabase;
    synchronized (zzpK)
    {
      localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase == null) {
        return;
      }
    }
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "purchase_id";
    arrayOfObject[1] = Long.valueOf(paramzzf.zzEO);
    localSQLiteDatabase.delete("InAppPurchase", String.format(localLocale, "%s = %d", arrayOfObject), null);
  }
  
  public void zzb(zzf paramzzf)
  {
    if (paramzzf == null) {
      return;
    }
    SQLiteDatabase localSQLiteDatabase;
    synchronized (zzpK)
    {
      localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase == null) {
        return;
      }
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("product_id", paramzzf.zzEQ);
    localContentValues.put("developer_payload", paramzzf.zzEP);
    localContentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
    paramzzf.zzEO = localSQLiteDatabase.insert("InAppPurchase", null, localContentValues);
    if (getRecordCount() > 20000L) {
      zzfL();
    }
  }
  
  /* Error */
  public void zzfL()
  {
    // Byte code:
    //   0: getstatic 46	com/google/android/gms/ads/internal/purchase/zzh:zzpK	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: invokevirtual 72	com/google/android/gms/ads/internal/purchase/zzh:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +6 -> 18
    //   15: aload_1
    //   16: monitorexit
    //   17: return
    //   18: aload_3
    //   19: ldc 25
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: ldc -71
    //   28: ldc -69
    //   30: invokevirtual 191	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore 7
    //   35: aload 7
    //   37: astore 5
    //   39: aload 5
    //   41: ifnull +23 -> 64
    //   44: aload 5
    //   46: invokeinterface 86 1 0
    //   51: ifeq +13 -> 64
    //   54: aload_0
    //   55: aload_0
    //   56: aload 5
    //   58: invokevirtual 193	com/google/android/gms/ads/internal/purchase/zzh:zza	(Landroid/database/Cursor;)Lcom/google/android/gms/ads/internal/purchase/zzf;
    //   61: invokevirtual 195	com/google/android/gms/ads/internal/purchase/zzh:zza	(Lcom/google/android/gms/ads/internal/purchase/zzf;)V
    //   64: aload 5
    //   66: ifnull +10 -> 76
    //   69: aload 5
    //   71: invokeinterface 93 1 0
    //   76: aload_1
    //   77: monitorexit
    //   78: return
    //   79: astore_2
    //   80: aload_1
    //   81: monitorexit
    //   82: aload_2
    //   83: athrow
    //   84: astore 6
    //   86: aconst_null
    //   87: astore 5
    //   89: new 95	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   96: ldc -59
    //   98: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 6
    //   103: invokevirtual 105	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   106: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 114	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   115: aload 5
    //   117: ifnull -41 -> 76
    //   120: aload 5
    //   122: invokeinterface 93 1 0
    //   127: goto -51 -> 76
    //   130: aload 5
    //   132: ifnull +10 -> 142
    //   135: aload 5
    //   137: invokeinterface 93 1 0
    //   142: aload 4
    //   144: athrow
    //   145: astore 4
    //   147: goto -17 -> 130
    //   150: astore 6
    //   152: goto -63 -> 89
    //   155: astore 4
    //   157: aconst_null
    //   158: astore 5
    //   160: goto -30 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	zzh
    //   3	78	1	localObject1	Object
    //   79	4	2	localObject2	Object
    //   10	9	3	localSQLiteDatabase	SQLiteDatabase
    //   142	1	4	localObject3	Object
    //   145	1	4	localObject4	Object
    //   155	1	4	localObject5	Object
    //   37	122	5	localCursor1	Cursor
    //   84	18	6	localSQLiteException1	SQLiteException
    //   150	1	6	localSQLiteException2	SQLiteException
    //   33	3	7	localCursor2	Cursor
    // Exception table:
    //   from	to	target	type
    //   6	11	79	finally
    //   15	17	79	finally
    //   69	76	79	finally
    //   76	78	79	finally
    //   80	82	79	finally
    //   120	127	79	finally
    //   135	142	79	finally
    //   142	145	79	finally
    //   18	35	84	android/database/sqlite/SQLiteException
    //   44	64	145	finally
    //   89	115	145	finally
    //   44	64	150	android/database/sqlite/SQLiteException
    //   18	35	155	finally
  }
  
  /* Error */
  public java.util.List<zzf> zzg(long paramLong)
  {
    // Byte code:
    //   0: getstatic 46	com/google/android/gms/ads/internal/purchase/zzh:zzpK	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: new 201	java/util/LinkedList
    //   9: dup
    //   10: invokespecial 202	java/util/LinkedList:<init>	()V
    //   13: astore 4
    //   15: lload_1
    //   16: lconst_0
    //   17: lcmp
    //   18: ifgt +8 -> 26
    //   21: aload_3
    //   22: monitorexit
    //   23: aload 4
    //   25: areturn
    //   26: aload_0
    //   27: invokevirtual 72	com/google/android/gms/ads/internal/purchase/zzh:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore 6
    //   32: aload 6
    //   34: ifnonnull +8 -> 42
    //   37: aload_3
    //   38: monitorexit
    //   39: aload 4
    //   41: areturn
    //   42: aload 6
    //   44: ldc 25
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: aconst_null
    //   51: ldc -71
    //   53: lload_1
    //   54: invokestatic 205	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   57: invokevirtual 191	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 10
    //   62: aload 10
    //   64: astore 8
    //   66: aload 8
    //   68: invokeinterface 86 1 0
    //   73: ifeq +31 -> 104
    //   76: aload 4
    //   78: aload_0
    //   79: aload 8
    //   81: invokevirtual 193	com/google/android/gms/ads/internal/purchase/zzh:zza	(Landroid/database/Cursor;)Lcom/google/android/gms/ads/internal/purchase/zzf;
    //   84: invokeinterface 211 2 0
    //   89: pop
    //   90: aload 8
    //   92: invokeinterface 214 1 0
    //   97: istore 12
    //   99: iload 12
    //   101: ifne -25 -> 76
    //   104: aload 8
    //   106: ifnull +10 -> 116
    //   109: aload 8
    //   111: invokeinterface 93 1 0
    //   116: aload_3
    //   117: monitorexit
    //   118: aload 4
    //   120: areturn
    //   121: astore 9
    //   123: aconst_null
    //   124: astore 8
    //   126: new 95	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   133: ldc -40
    //   135: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 9
    //   140: invokevirtual 105	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   143: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 114	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   152: aload 8
    //   154: ifnull -38 -> 116
    //   157: aload 8
    //   159: invokeinterface 93 1 0
    //   164: goto -48 -> 116
    //   167: astore 5
    //   169: aload_3
    //   170: monitorexit
    //   171: aload 5
    //   173: athrow
    //   174: astore 7
    //   176: aconst_null
    //   177: astore 8
    //   179: aload 8
    //   181: ifnull +10 -> 191
    //   184: aload 8
    //   186: invokeinterface 93 1 0
    //   191: aload 7
    //   193: athrow
    //   194: astore 7
    //   196: goto -17 -> 179
    //   199: astore 9
    //   201: goto -75 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	zzh
    //   0	204	1	paramLong	long
    //   3	167	3	localObject1	Object
    //   13	106	4	localLinkedList	java.util.LinkedList
    //   167	5	5	localObject2	Object
    //   30	13	6	localSQLiteDatabase	SQLiteDatabase
    //   174	18	7	localObject3	Object
    //   194	1	7	localObject4	Object
    //   64	121	8	localCursor1	Cursor
    //   121	18	9	localSQLiteException1	SQLiteException
    //   199	1	9	localSQLiteException2	SQLiteException
    //   60	3	10	localCursor2	Cursor
    //   97	3	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   42	62	121	android/database/sqlite/SQLiteException
    //   6	15	167	finally
    //   21	23	167	finally
    //   26	32	167	finally
    //   37	39	167	finally
    //   109	116	167	finally
    //   116	118	167	finally
    //   157	164	167	finally
    //   169	171	167	finally
    //   184	191	167	finally
    //   191	194	167	finally
    //   42	62	174	finally
    //   66	76	194	finally
    //   76	99	194	finally
    //   126	152	194	finally
    //   66	76	199	android/database/sqlite/SQLiteException
    //   76	99	199	android/database/sqlite/SQLiteException
  }
  
  public class zza
    extends SQLiteOpenHelper
  {
    public zza(Context paramContext, String paramString)
    {
      super(paramString, null, 4);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL(zzh.zzfM());
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      zzb.zzaG("Database updated from version " + paramInt1 + " to version " + paramInt2);
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\purchase\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */