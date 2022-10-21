import java.util.Objects;

public class MultiplicationTable {

    private int a;
    private int b;

    public MultiplicationTable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MultiplicationTable that = (MultiplicationTable) o;
        return (this.a == that.a && this.b == that.b) ||
                (this.b == that.a && this.a == that.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.min(a, b), Math.max(b, a));
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public String toString() {
        return "" +
                a +
                " * " + b;
    }
}
