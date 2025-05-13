import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private LocalDate date;
    private LocalTime time;
    private double amount;
    private String vendor;
    private String description;

    public Transaction(String description, String vendor, double price) {
        date = LocalDate.now();
        time = LocalTime.now();
        this.amount = price;
        this.description = description;
        this.vendor = vendor;
    }

    // 2024-10-31|01:22:21|commission|Martinelli Winery|200.63
    Transaction(String line) {
        String[] fields = line.split("\\|"); //need \\ for it to split properly
        date = LocalDate.parse(fields[0]);
        time = LocalTime.parse(fields[1], formatter);
        description = fields[2];
        vendor = fields[3];
        amount = Double.parseDouble(fields[4]);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n")
                .append(date)
                .append("|")
                .append(time.format(formatter))
                .append("|")
                .append(description)
                .append("|")
                .append(vendor)
                .append("|")
                .append(amount);
        return sb.toString();
    }


    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public double getAmount() {
        return amount;
    }

    public String getVendor() {
        return vendor;
    }

    public String getDescription() {
        return description;
    }
}
