package com.colistor.core.services;

import com.colistor.core.persistence.model.Drawer;
import com.colistor.core.services.exception.ServiceException;

import java.util.List;

/**
 * Created by joel on 2/20/16.
 */
public interface DrawerSI {

    public Drawer add(String userCode, Drawer drawer) throws ServiceException;

    public void delete(String userCode, String drawerCode) throws ServiceException;

    public Drawer modify(String userCode, String drawerCode, Drawer drawer) throws ServiceException;

    public List<Drawer> findAll(String userCode) throws ServiceException;

    public List<Drawer> findByCriteria(String userCode, String criteria) throws ServiceException;
}
