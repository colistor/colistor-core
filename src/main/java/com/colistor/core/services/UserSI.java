package com.colistor.core.services;

import com.colistor.core.persistence.model.User;
import com.colistor.core.services.exception.ServiceException;

/**
 * Created by joel on 2/20/16.
 */
public interface UserSI {

    public User login(String email, String password) throws ServiceException;

    public User register(User user) throws ServiceException;

    public User modify(String userCode, User user) throws ServiceException;

    public void deleteAccount(String userCode) throws ServiceException;
}
