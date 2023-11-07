package model;

public class User {
    protected int id;
    protected String title;
    protected String timestamp;
    protected String content;
    //     protected String avatar;
//     protected String shortdescription;
    protected boolean access;

    public User() {}
    public User(String title, String content, boolean access){
        super();
        this.title = title;
        this.content = content;
        this.access = access;
    }

    public User(int id, String title, String content, boolean access){
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.access = access;
    }

    public User(String title,  String content, String timestamp, boolean access) {
        super();
        this.title = title;
        this.timestamp = timestamp;
        this.content = content;
        this.access = access;

    }

    public User(int id, String title,  String content, String timestamp, boolean access) {
        super();
        this.id = id;
        this.title = title;
        this.timestamp = timestamp;
        this.content = content;
//          this.avatar = avatar;
//          this.shortdescription = shortdescription;
        this.access = access;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//     public String getAvatar() {
//          return avatar;
//     }
//
//     public void setAvatar(String avatar) {
//          this.avatar = avatar;
//     }
//
//     public String getShortdescription() {
//          return shortdescription;
//     }
//
//     public void setShortdescription(String shortdescription) {
//          this.shortdescription = shortdescription;
//     }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
}