package avwish.demo.models.account;

import avwish.demo.models.account.images.ImageUpload;

public class CreateAccount
{
    private String name;
    private String email;
    private ImageUpload image;
    private String password;
    private String repeatedPassword;
    
    
    public CreateAccount(String name, String email, ImageUpload image, String password, String repeatedPassword)
    {
        this.name = name;
        this.email = email;
        this.image = image;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
    }
    
    // TODO hvis der ikke er noget billede så generer lige et billede
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public ImageUpload getImage()
    {
        return image;
    }
    public void setImage(ImageUpload image)
    {
        this.image = image;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getRepeatedPassword()
    {
        return repeatedPassword;
    }
    public void setRepeatedPassword(String repeatedPassword)
    {
        this.repeatedPassword = repeatedPassword;
    }
}
