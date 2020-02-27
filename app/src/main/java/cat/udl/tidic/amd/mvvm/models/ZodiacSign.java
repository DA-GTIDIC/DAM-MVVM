package cat.udl.tidic.amd.mvvm.models;

import java.util.Date;

public class ZodiacSign {

    private String name;
    private String description;
    private Date from;
    private Date to;

    public ZodiacSign() {
    }

    public ZodiacSign(String name, String description, Date from, Date to) {
        this.name = name;
        this.description = description;
        this.from = from;
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public Date getFrom() {
        return from;
    }


    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
