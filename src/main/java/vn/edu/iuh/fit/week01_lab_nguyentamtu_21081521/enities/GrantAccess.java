/*
 * @ (#) GrantAccess.java   1.0     19/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities;

import jakarta.persistence.*;
import vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities.keys.GrantAccessKey;

import java.io.Serializable;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 19/09/2024
 * @version: 1.0
 */
@Entity
@Table(name = "grant_access")
@NamedQueries({
        @NamedQuery(name = "GrantAccess.checkRole", query = "SELECT ga FROM GrantAccess ga where ga.grantAccessId.account.id = :accountId"),
        @NamedQuery(name = "GrantAccess.getRoles", query = "SELECT ga FROM GrantAccess ga where ga.grantAccessId.account.id = :accountId and ga.isGrant = true")
})
public class GrantAccess implements Serializable {
    @EmbeddedId
    private GrantAccessKey grantAccessId;
    private String note;
    @Column(name = "is_grant")
    private boolean isGrant;

    public boolean isGrant() {
        return isGrant;
    }

    public void setGrant(boolean grant) {
        isGrant = grant;
    }

    public GrantAccess(GrantAccessKey grantAccessId, String note, boolean isGrant) {
        this.grantAccessId = grantAccessId;
        this.note = note;
        this.isGrant = isGrant;
    }

    public GrantAccessKey getGrantAccessId() {
        return grantAccessId;
    }

    public void setGrantAccessId(GrantAccessKey grantAccessId) {
        this.grantAccessId = grantAccessId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public GrantAccess() {
    }
}
