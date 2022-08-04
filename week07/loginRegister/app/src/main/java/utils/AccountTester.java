package utils;

import models.*;
import repository.*;

import java.util.*;

public class AccountTester {
  private List<Account> accounts = new ArrayList<>();
  private AccountRepository accountRepository;


  public AccountTester(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }
  public boolean identifierTester(String identifier) {

    for(Map.Entry<String, Account> accountSet : accountRepository.accounts().entrySet()) {
      if(accountSet.getKey().equals(identifier)) {
        return false;
      }
    }
    return true;
  }

  public boolean passwordTester(String password,String passwordDoubleCheck) {
    if (password.equals(passwordDoubleCheck)) {
      return true;
    }
    return false;
  }
 /* public boolean emptyTester(String identifier
      ,String password
      ,String passwordDoubleCheck
      ,String name
      ,String email) {
    if(!identifier.isBlank()
        && !password.isBlank()
        && !passwordDoubleCheck.isBlank()
        && !email.isBlank()
        && !name.isBlank()) {
      return true;
    }
  return false;}*/
}