/*
 * @ (#) RoleSerImp.java   1.0     20/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.services;
import java.util.Map;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.Role;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 20/09/2024
 * @version: 1.0
 */
public interface RoleSerImp {
    public boolean checkAdmin(String accountId);
    Map<String, Object> getRoles(String accountId);
}
