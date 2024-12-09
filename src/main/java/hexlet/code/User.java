package hexlet.code;

public class User {

    private Long id;
    private String phone;
    private String name;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
