/*
 * @ (#) log.java   1.0     19/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.enities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 19/09/2024
 * @version: 1.0
 */
@Entity
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String accountId;
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;
    private String note;
}
