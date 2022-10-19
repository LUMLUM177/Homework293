import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Passport {

    private final Integer numberID;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate date;



    public Passport(Integer numberID, String surname, String name, String patronymic, LocalDate date) {
        if (numberID == null) {
            throw new RuntimeException("Необходимо указать номер паспорта!");
        }
        this.numberID = numberID;
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setDate(date);
    }

    public Integer getNumberID() {
        return numberID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isBlank()) {
            this.surname = "default";
        } else {
            this.surname = surname;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            this.name = "default";
        } else {
            this.name = surname;
        }
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            this.date = LocalDate.of(2000,01,01);
        } else {
            this.date = date;
        }
    }


    @Override
    public String toString() {
        return "Passport{" +
                "numberID=" + numberID +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", date=" + date +
                '}';
    }
}
