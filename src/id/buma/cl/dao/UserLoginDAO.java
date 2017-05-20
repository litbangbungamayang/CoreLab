/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.dao;

import id.buma.cl.model.UserLogin;

/**
 *
 * @author Bayu Anandavi Muhardika
 */
public interface UserLoginDAO {
    
    public UserLogin getByUsername(String username);
    
}
