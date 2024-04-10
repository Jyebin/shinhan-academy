import lombok.Data;

@Data
public class Account {
    private int accountId;
    private Data openDate;
    private String openPoint;
    private String accountOwner;
    private int balance;
    private String isOpenBank;
    private int userId;
}