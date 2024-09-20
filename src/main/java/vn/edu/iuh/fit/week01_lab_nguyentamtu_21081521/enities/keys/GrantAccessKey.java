/*
 * @ (#) GrantAccessKey.java   1.0     19/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.keys;

import jakarta.persistence.*;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.Account;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.Role;

import java.io.Serializable;
import java.util.Objects;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 19/09/2024
 * @version: 1.0
 */

@Embeddable
public class GrantAccessKey implements Serializable {


    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public GrantAccessKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrantAccessKey that = (GrantAccessKey) o;
        return Objects.equals(account, that.account) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, role);
    }

    public GrantAccessKey(Account account, Role role) {
        this.account = account;
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
