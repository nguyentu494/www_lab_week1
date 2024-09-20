/*
 * @ (#) RoleServices.java   1.0     20/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.services.Imp;

import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.Role;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.repositories.reImp.AccountRepository;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.repositories.reImp.RoleRepository;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.services.RoleSerImp;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 20/09/2024
 * @version: 1.0
 */
public class RoleService implements RoleSerImp {
    private static RoleRepository rr;

    public RoleService() {
        rr = new RoleRepository();
    }
    @Override
    public boolean checkAdmin(String accountId) {
        return rr.checkRole(accountId).stream().anyMatch(role -> role.getGrantAccessId().getRole().getRoleId().equals("admin"));
    }

    @Override
    public Map<String, Object> getRoles(String accountId) {
        List<Role> roles = new ArrayList<>();
        roles =  rr.getRoles(accountId).stream().map(grantAccess -> {
            return grantAccess.getGrantAccessId().getRole();
        }).collect(Collectors.toList());
        return Map.of(accountId, roles);
    }

//    public static void main(String[] args) {
//        RoleService rs = new RoleService();
//        rs.getRoles("met").forEach((k, v) -> System.out.println(k + " " + v));
//    }
}
