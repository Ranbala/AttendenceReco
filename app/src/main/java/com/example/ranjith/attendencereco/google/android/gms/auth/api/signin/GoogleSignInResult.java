package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class GoogleSignInResult
  implements Result
{
  private Status zzTA;
  private GoogleSignInAccount zzVI;
  
  public GoogleSignInResult(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
  {
    this.zzVI = paramGoogleSignInAccount;
    this.zzTA = paramStatus;
  }
  
  public GoogleSignInAccount getSignInAccount()
  {
    return this.zzVI;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  public boolean isSuccess()
  {
    return this.zzTA.isSuccess();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\auth\api\signin\GoogleSignInResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */