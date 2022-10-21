import java.util.ArrayList;
import java.util.Objects;

public class Sponsor {

    private String name;
    private double amountSupport;

    public Sponsor(String name, double amountSupport) {
        this.name = name;
        this.amountSupport = amountSupport;
    }
    public void sponsorTheRace() {
        System.out.println("Спонсор " + getName() + " спонсирует заезд на сумму " + getAmountSupport() + " рублей.");
    }
    public String getName() {
        return name;
    }

    public double getAmountSupport() {
        return amountSupport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return Double.compare(sponsor.amountSupport, amountSupport) == 0 && name.equals(sponsor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amountSupport);
    }
}
