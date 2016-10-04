package com.vpomo.reportglonass.service;

import com.vpomo.reportglonass.model.LogUsers;
import com.vpomo.reportglonass.model.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Here are the methods for testing data features
 *
 * @author Pomogalov Vladimir
 */

public abstract class AbstractLogUsersServiceTests {

    @Autowired
    protected LogUsersService logUsersService;
    @Autowired
    protected UsersService usersService;

    public Integer idLogUser = 0;
    public Users userL = null;

    @Before
    public void prepare() {
        System.out.println(" ==== Begin Before test's ) ==== ");
        userL = (Users) this.usersService.getUserLogin("adminTest");
        org.junit.Assert.assertNotNull(userL);
        System.out.println(" ==== Before Test's passed ==== ");
    }


    @Test
    public void testLogUsersGetAll() {
        System.out.println(" ==== Test's LogUsersClass getAll() begin ==== ");
        List<LogUsers> resultList = null;
        resultList = this.logUsersService.getAll();
        org.junit.Assert.assertNotNull(resultList);
        assertTrue(resultList != null);
        System.out.println(" ==== Test's LogUsersClass  getAll() passed ==== ");
    }

    @Test
    public void testAddLogUser() {
        System.out.println(" ==== Test's LogUsersClass addLogUser(userL, currentDate, actionLog) begin ==== ");
        Date currentDate = new Date();
        String actionLog = "Testing module";
        Integer result = 0;

        result = this.logUsersService.addLogUser(userL, currentDate, actionLog);
        idLogUser = result;
        assertTrue(result != 0);
        System.out.println(" ==== Test's LogUsersClass  addLogUser(userL, currentDate, actionLog) passed ==== ");
    }

    @Test
    public void testRemoveLogUser() {
        System.out.println(" ==== Test's LogUsersClass removeLogUser(id) begin ==== ");
        List<LogUsers> resultListBeforeRemove = null;
        List<LogUsers> resultListAfterRemove = null;
        Integer result = 0;
        Date currentDate = new Date();
        String actionLog = "Testing remove log's";

        result = this.logUsersService.addLogUser(userL, currentDate, actionLog);
        assertTrue(result != 0);
        resultListBeforeRemove = this.logUsersService.getAll();
        org.junit.Assert.assertNotNull(resultListBeforeRemove);

        this.logUsersService.removeLogUser(result);
        resultListAfterRemove = this.logUsersService.getAll();
        org.junit.Assert.assertNotNull(resultListAfterRemove);

        assertTrue(resultListBeforeRemove.size() != resultListAfterRemove.size());

        System.out.println(" ==== Test's LogUsersClass  removeLogUser(id) passed ==== ");
    }

    @After
    public void tearDown() {
        System.out.println(" ==== After Test's begin ==== ");
        this.logUsersService.removeLogUser(idLogUser);
        System.out.println(" **** After Test's passed *** ");
    }

    //void removeLogUser(int id);
}
