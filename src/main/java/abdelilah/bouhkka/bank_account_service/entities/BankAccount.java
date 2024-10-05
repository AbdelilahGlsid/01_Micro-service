package abdelilah.bouhkka.bank_account_service.entities;

import abdelilah.bouhkka.bank_account_service.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;// Double valeur par defaut null
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
