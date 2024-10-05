package abdelilah.bouhkka.bank_account_service.services;


import abdelilah.bouhkka.bank_account_service.dto.BankAccountRequestDTO;
import abdelilah.bouhkka.bank_account_service.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
