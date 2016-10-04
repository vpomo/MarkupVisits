package com.vpomo.reportglonass.service;

import com.vpomo.reportglonass.model.Users;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Here are the methods for testing data features
 *
 * @author Pomogalov Vladimir
 */


public abstract class AbstractUsersServiceTests {

    @Autowired
    protected UsersService usersService;

   // @Transactional

    @Before
    public void shouldUsersTest() {
        System.out.println(" ==== Test Before ==== ");
        System.out.println(" ==== Before Test's passed ==== ");
    }


    @Test
    public void testUsersGetAll() {
        System.out.println(" ==== Test's UsersClass getAll() begin ==== ");
        List<Users> resultList = null;
        resultList = this.usersService.getAll();
        assertTrue(resultList != null);
        System.out.println(" ==== Test's UsersClass  getAll() passed ==== ");
    }

    @Test
    public void testGetUserLogin() {
        System.out.println(" ==== Test's UsersClass getUserLogin() begin ==== ");
        Users resultList = null;
        String login = "adminTest";
        resultList = this.usersService.getUserLogin(login);
        assertTrue(resultList != null);
        System.out.println(" ==== Test's UsersClass  getUserLogin() passed ==== ");
    }

    @Test
    public void testAddUser() {
        System.out.println(" ==== Test's UsersClass addUser() begin ==== ");
        Integer result = 10;
        String login = "testUser";
        String password = "testpass";
        String passwordTwo = "testpass";
        String names = "namesTestUser";
        String groupUser = "iogv";

        result = this.usersService.addUser(login, password, passwordTwo, names, groupUser);
        // You can create a new user
        assertThat(result.compareTo(0));

        login = "adminTest";
        result = this.usersService.addUser(login, password, passwordTwo, names, groupUser);
        // Such user already exists
        assertThat(result.compareTo(3));

        passwordTwo = "newTestPass";
        result = this.usersService.addUser(login, password, passwordTwo, names, groupUser);
        // password is not passwordTwo for user
        assertThat(result.compareTo(2));

        passwordTwo = null;
        result = this.usersService.addUser(login, password, passwordTwo, names, groupUser);
        // passwordTwo is null
        assertThat(result.compareTo(2));

        System.out.println(" ==== Test's UsersClass  addUser() passed ==== ");
    }

    @Test
    public void testNewUser() {
        System.out.println(" ==== Test's UsersClass newUser() begin ==== ");
        String login = "newUser";
        String password = "testpass";
        String names = "Проверка";
        Date dateLastReport = new Date();
        String groupUser = "iogv";
        Users user = null;

        user = this.usersService.newUser(login, password, names, dateLastReport, groupUser);
        System.out.println(names);
        assertTrue(user != null);
        this.usersService.remove(login);
        System.out.println(" ==== Test's UsersClass  newUser() passed ==== ");
    }

    @Test
    public void testNewDateUser() {
        System.out.println(" ==== Test's UsersClass newDateUser() begin ==== ");
        Users user = new Users();
        Users user2 = new Users();
        String login = "adminTest";
        Date formatteddate = null;
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

        user = this.usersService.getUserLogin(login);
        String oldUserDate = user.getDateLastReport();
        Date currentDate = new Date();
        this.usersService.newDateUser(user, currentDate);

        user2 = this.usersService.getUserLogin(login);
        String testOldUserDate = user.getDateLastReport();

        assertTrue(!testOldUserDate.equals(oldUserDate));

        try {
            formatteddate = df.parse(oldUserDate);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.usersService.newDateUser(user, formatteddate);

        System.out.println(" ==== Test's UsersClass  newDateUser() passed ==== ");
    }

    @Test
    public void testGetUsersGroup() {
        System.out.println(" ==== Test's UsersClass getUsersGroup() begin ==== ");
        String groupUser = "iogv";
        List<Users> resultList = null;
        resultList = this.usersService.getUsersGroup(groupUser);
        assertTrue(resultList != null);
        System.out.println(" ==== Test's UsersClass  getUsersGroup() passed ==== ");
    }

    @After
    public void testRemoveUser() {
        System.out.println(" ==== Test's UsersClass remove() begin ==== ");
        String login = "testUser";
        this.usersService.remove(login);
        System.out.println(" ==== Test's UsersClass  remove() passed ==== ");
    }

}
