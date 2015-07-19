package module3.laba7.receiver1;


public class Receiver {
    private int num;
    private String name;

    public Receiver() {
    }

    public Receiver(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receiver that = (Receiver) o;

        if (num != that.num) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReceiverDAO{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
