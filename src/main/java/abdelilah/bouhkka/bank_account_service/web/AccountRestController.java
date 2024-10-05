package abdelilah.bouhkka.bank_account_service.web;

import abdelilah.bouhkka.bank_account_service.dto.BankAccountRequestDTO;
import abdelilah.bouhkka.bank_account_service.dto.BankAccountResponseDTO;
import abdelilah.bouhkka.bank_account_service.entities.BankAccount;
import abdelilah.bouhkka.bank_account_service.mappers.AccountMapper;
import abdelilah.bouhkka.bank_account_service.repositories.BankAccountRepository;
import abdelilah.bouhkka.bank_account_service.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper){
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount updatedAccount = bankAccountRepository.findById(id).orElseThrow();
        if(bankAccount.getBalance() != null) updatedAccount.setBalance(bankAccount.getBalance());
        if(bankAccount.getType() != null) updatedAccount.setType(bankAccount.getType());
        if(bankAccount.getCurrency() != null) updatedAccount.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getCreatedAt() != null) updatedAccount.setCreatedAt(new Date());

        return bankAccountRepository.save(updatedAccount);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }


}
