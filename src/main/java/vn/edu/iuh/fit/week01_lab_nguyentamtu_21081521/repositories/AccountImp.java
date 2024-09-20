/*
 * @ (#) AccountImp.java   1.0     20/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.repositories;

import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.Account;
import java.util.*;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 20/09/2024
 * @version: 1.0
 */
public interface AccountImp {
    boolean insertAccount(Account a);
    boolean updateAccount(Account a);
    boolean deleteAccount(String id);
    Optional<Account> getAccount(String username);
    List<Account> selectAllAccount();
    Optional<Account> checkLogin(String email, String password);
}
