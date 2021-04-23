package avwish.demo.models.account;

public class AuthenticateResponse {
    private String authToken;
    private long expireTime;
    
    public AuthenticateResponse(String authToken, long expireTime)
    {
        this.authToken = authToken;
        this.expireTime = expireTime;
    }
    
    public String getAuthToken()
    {
        return authToken;
    }
    public void setAuthToken(String authToken)
    {
        this.authToken = authToken;
    }
    public long getExpireTime()
    {
        return expireTime;
    }
    public void setExpireTime(long expireTime)
    {
        this.expireTime = expireTime;
    }
}
