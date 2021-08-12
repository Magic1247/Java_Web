package JDBCDemo;

public class DemoDBPerson {
    private int id;
    private String name;
    private int sex;
    private int balance;

    public DemoDBPerson(int id, String name, int sex, int balance) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.balance = balance;
    }

    public DemoDBPerson() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "DemoLogin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", balance=" + balance +
                '}';
    }
}
