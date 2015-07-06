package module3.laba7.expense;


public class Expense {
    private int num;
    private String paydate;
    private int receiver;
    private double value;

    public Expense() {
    }

    public Expense(int num, String paydate, int receiver, double value) {
        this.num = num;
        this.paydate = paydate;
        this.receiver = receiver;
        this.value = value;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense that = (Expense) o;

        if (num != that.num) return false;
        if (receiver != that.receiver) return false;
        if (Double.compare(that.value, value) != 0) return false;
        if (paydate != null ? !paydate.equals(that.paydate) : that.paydate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = num;
        result = 31 * result + (paydate != null ? paydate.hashCode() : 0);
        result = 31 * result + receiver;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ExpenseDAO{" +
                "num=" + num +
                ", paydate='" + paydate + '\'' +
                ", receiver=" + receiver +
                ", value=" + value +
                '}';
    }
}
