package avwish.demo.models.db;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Entity
public class Account {
    
    // ! TODO fiks at notnull skal virke!!!!!!!
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_account")
    private int id;
    @NotNull
    private String name;
    @NotNull
    @Column(unique = true)
    private String email;
    
    private String imagePath;
    @NotNull
    private String passwordHash;
    @NotNull
    @Temporal(TemporalType.DATE)  //Ændrer typen fra DateTime til Date i MySQL databasen h
    private Date createdDate;
    
    // liste med dem man følger
    @ManyToMany
    @JoinTable(name = "followers",
            joinColumns={@JoinColumn(name="follower_id")},//, referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="following_id")}//, referencedColumnName="id")}
    )
    private Collection<Account> following;
    
    
    @ManyToMany(mappedBy = "following", cascade = CascadeType.PERSIST)
    //
    private Collection<Account> followedBy;
    
    
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
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
    public String getImagePath()
    {
        return imagePath;
    }
    public void setImagePath(String imagePath)
    {
        this.imagePath = imagePath;
    }
    public String getPasswordHash()
    {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }
    public Date getCreatedDate()
    {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }
    public Collection<Account> getFollowing()
    {
        return following;
    }
    public void setFollowing(Collection<Account> following)
    {
        this.following = following;
    }
    public Collection<Account> getFollowedBy()
    {
        return followedBy;
    }
    public void setFollowedBy(Collection<Account> followedBy)
    {
        this.followedBy = followedBy;
    }
}
