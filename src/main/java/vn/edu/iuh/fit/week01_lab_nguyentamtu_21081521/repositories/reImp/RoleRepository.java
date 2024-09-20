/*
 * @ (#) RoleRepository.java   1.0     20/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.repositories.reImp;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.GrantAccess;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.Role;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.repositories.ConnectDB;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.repositories.RoleImp;

import java.util.List;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 20/09/2024
 * @version: 1.0
 */
public class RoleRepository implements RoleImp {

    private ConnectDB dao;
    private static EntityManager em;

    public RoleRepository() {
        dao = new ConnectDB();
        em = dao.getEntityManager();
    }

    @Override
    public List<GrantAccess> checkRole(String accountId) {
        return em.createNamedQuery("GrantAccess.checkRole", GrantAccess.class).setParameter("accountId", accountId).getResultList();
    }

    @Override
    public List<GrantAccess> getRoles(String accountId) {
        return em.createNamedQuery("GrantAccess.getRoles",GrantAccess.class).setParameter("accountId", accountId).getResultList();
    }

    public static void main(String[] args) {
        RoleRepository rr = new RoleRepository();
    }
}
