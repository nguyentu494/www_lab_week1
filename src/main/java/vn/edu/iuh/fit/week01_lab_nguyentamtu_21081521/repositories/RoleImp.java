/*
 * @ (#) RoleImp.java   1.0     20/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.repositories;

import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.GrantAccess;
import java.util.*;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.Role;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 20/09/2024
 * @version: 1.0
 */
public interface RoleImp {
    public List<GrantAccess> checkRole(String accountId);
    public List<GrantAccess> getRoles(String accountId);
}
