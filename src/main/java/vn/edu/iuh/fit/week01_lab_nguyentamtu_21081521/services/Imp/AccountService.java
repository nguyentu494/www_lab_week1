/*
 * @ (#) AccountServices.java   1.0     20/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.services.Imp;

import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.Account;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.repositories.reImp.AccountRepository;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.services.AccountSerImp;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 20/09/2024
 * @version: 1.0
 */
public class AccountService implements AccountSerImp {

    private static AccountRepository ar;

    public AccountService() {
        ar = new AccountRepository();
    }

    @Override
    public boolean insertAccount(Account a) {
        return ar.insertAccount(a);
    }

    @Override
    public boolean updateAccount(Account a) {
        return ar.updateAccount(a);
    }

    @Override
    public boolean deleteAccount(String id) {
        return ar.deleteAccount(id);
    }

    @Override
    public Optional<Account> selectAccount(String id) {
        return ar.getAccount(id);
    }

    @Override
    public List<Account> selectAllAccount() {
        return ar.selectAllAccount();
    }

    @Override
    public Optional<Account> checkLogin(String email, String password) {
        if(ar.checkLogin(email, password).isPresent())
            return ar.checkLogin(email, password);
        else
            return Optional.empty();
    }

    public static void main(String[] args) {
        AccountService accountService = new AccountService();

    }
}
