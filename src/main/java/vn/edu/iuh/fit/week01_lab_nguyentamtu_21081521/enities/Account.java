/*
 * @ (#) Account.java   1.0     19/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities;

import jakarta.persistence.*;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enums.Status;

import java.io.Serializable;
import java.util.List;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 19/09/2024
 * @version: 1.0
 */

@Entity
@Table(name = "account")
@NamedQueries(
        {
               @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
                @NamedQuery(name="Account.findByEmailAndPassword", query = "SELECT a FROM Account a WHERE a.email = :email AND a.password = :password")
        }
)
public class Account implements Serializable {
    @Id
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "full_name")
    private String fullName;
    private String password;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "grantAccessId.account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GrantAccess> grantAccesses;
    public Account() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<GrantAccess> getGrantAccesses() {
        return grantAccesses;
    }

    public void setGrantAccesses(List<GrantAccess> grantAccesses) {
        this.grantAccesses = grantAccesses;
    }

    public Account(String accountId, String fullName, String password, String email, String phone, Status status) {
        this.accountId = accountId;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public String getaccountId() {
        return accountId;
    }

    public void setaccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
