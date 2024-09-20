/*
 * @ (#) AccountRepositories.java   1.0     20/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.repositories.reImp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.Account;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enums.Status;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.repositories.AccountImp;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.repositories.ConnectDB;

import java.util.List;
import java.util.Optional;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 20/09/2024
 * @version: 1.0
 */
public class AccountRepository implements AccountImp {

    private ConnectDB dao;
    private static EntityManager em;

    public AccountRepository() {
        dao = new ConnectDB();
        em = dao.getEntityManager();
    }

    @Override
    public boolean insertAccount(Account a) {
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(a);
            et.commit();
            return true;
        }catch (Exception e){
            et.rollback();
        }

        return false;
    }

    @Override
    public boolean updateAccount(Account a) {
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.merge(a);
            et.commit();
            return true;
        }catch (Exception e){
            et.rollback();
        }

        return false;
    }

    @Override
    public boolean deleteAccount(String id) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Account a = em.find(Account.class, id);
            em.remove(a);
            et.commit();
            return true;
        }catch (Exception e){
            et.rollback();
        }
        return false;
    }

    @Override
    public Optional<Account> getAccount(String username) {
        return Optional.of(em.find(Account.class, username));
    }

    @Override
    public List<Account> selectAllAccount() {
        return em.createNamedQuery("Account.findAll", Account.class).getResultList();
    }

    @Override
    public Optional<Account> checkLogin(String email, String password) {
        try{
            return Optional.of(em.createNamedQuery("Account.findByEmailAndPassword", Account.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        Account a = new Account();
        AccountRepository ar = new AccountRepository();
    }
}
