/*
 * @ (#) ConnectDB.java   1.0     20/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week01_lab_nguyentamtu_21081521.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.sql.Connection;

/*
 * @description:
 * @author: Tuss Nguyen
 * @date: 20/09/2024
 * @version: 1.0
 */
public class ConnectDB {
    private static EntityManager em = null;

    public ConnectDB() {
        if(em == null) {
            em = Persistence.createEntityManagerFactory("week01").createEntityManager();
        }
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public static void main(String[] args) {
        ConnectDB con = new ConnectDB();
        if(em != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Not connected");
        }
    }
}
