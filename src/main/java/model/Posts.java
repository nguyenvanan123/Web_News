package model;

public class Posts {
    private int id;
    private String title;
    private String timestamp;
    private String content;
    private String avatar;
    private String shortdescription;
    private boolean access;

    public Posts() {}
    public Posts(String title, String content, boolean access){
        super();
        this.title = title;
        this.content = content;
        this.access = access;
    }

    public Posts(int id, String title, String content, boolean access){
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.access = access;
    }

    public Posts(String title, String content, String timestamp, boolean access) {
        super();
        this.title = title;
        this.timestamp = timestamp;
        this.content = content;
        this.access = access;

    }
    public Posts(String title, String content, String timestamp, String avatar,
                 String shortdescription , boolean access) {
        super();
        this.title = title;
        this.timestamp = timestamp;
        this.content = content;
        this.avatar = avatar;
        this.shortdescription = shortdescription;
        this.access = access;
    }

    public Posts(int id, String title, String content, String avatar, String shortdescription, boolean access) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.avatar = avatar;
        this.shortdescription = shortdescription;
        this.access = access;
    }
    public Posts(int id, String title, String content, String timestamp, String avatar, String shortdescription, boolean access) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.avatar = avatar;
        this.shortdescription = shortdescription;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
}