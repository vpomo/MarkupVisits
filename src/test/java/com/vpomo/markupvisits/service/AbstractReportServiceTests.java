package com.vpomo.reportglonass.service;

import com.vpomo.reportglonass.model.LogUsers;
import com.vpomo.reportglonass.model.Report;
import com.vpomo.reportglonass.model.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Here are the methods for testing data features
 *
 * @author Pomogalov Vladimir
 */

public abstract class AbstractReportServiceTests {

    @Autowired
    ReportService reportService;
    @Autowired
    UsersService usersService;


    public Integer idReport = 0;
    public Users userTest = null;

    @Before
    public void prepare() {
        System.out.println(" ==== Begin Before test's ) ==== ");
        userTest = (Users) this.usersService.getUserLogin("adminTest");
        org.junit.Assert.assertNotNull(userTest);
        System.out.println(" ==== Before Test's passed ==== ");
    }

    @Test
    public void testReportGetAll() {
        System.out.println(" ==== Test's ReportClass getAll() begin ==== ");
        List<Report> resultList = null;
        resultList = this.reportService.getAll();
        org.junit.Assert.assertNotNull(resultList);
        assertTrue(resultList != null);
        System.out.println(" ==== Test's ReportClass  getAll() passed ==== ");
    }

    @Test
    public void testAddReport() {
        System.out.println(" ==== Test's ReportClass addReport(userL, currentDate, ...) begin ==== ");
        Date currentDate = new Date();
        Integer result = 0;

        result = this.reportService.addReport(
                userTest, currentDate,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        idReport = result;
        assertTrue(result != 0);
        System.out.println(" ==== Test's ReportClass  addReport() passed ==== ");
    }

    @Test
    public void testRemoveReport() {
        System.out.println(" ==== Test's ReportClass removeReport(id) begin ==== ");
        List<Report> resultListBeforeRemove = null;
        List<Report> resultListAfterRemove = null;
        Integer result = 0;
        Date currentDate = new Date();
        result = this.reportService.addReport(
                userTest, currentDate,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 );
        assertTrue(result != 0);
        resultListBeforeRemove = this.reportService.getAll();
        org.junit.Assert.assertNotNull(resultListBeforeRemove);
        this.reportService.removeReport(result);
        resultListAfterRemove = this.reportService.getAll();
        org.junit.Assert.assertNotNull(resultListAfterRemove);
        assertTrue(resultListBeforeRemove.size() != resultListAfterRemove.size());
        System.out.println(" ==== Test's ReportClass  removeReport(id) passed ==== ");
    }

    @Test
    public void testFind() {
        System.out.println(" ==== Test's ReportClass find(id) begin ==== ");
        Report findReport = null;
        Integer idNewReport = 0;
        Date currentDate = new Date();
        idNewReport = this.reportService.addReport(
                userTest, currentDate,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);

        assertTrue(idNewReport != 0);
        findReport = this.reportService.find(idNewReport);
        org.junit.Assert.assertNotNull(findReport);
        assertTrue(findReport != null);
        this.reportService.removeReport(idNewReport);
        System.out.println(" ==== Test's ReportClass  find() passed ==== ");
    }

    @Test
    public void testReportsByLogin() {
        System.out.println(" ==== Test's ReportClass reportsByLogin(login) begin ==== ");
        List<Report> reportList = null;
        Integer idReport = 0;
        String login = "adminTest";
        Date currentDate = new Date();
        idReport = this.reportService.addReport(
                userTest, currentDate,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 );
        assertTrue(idReport != 0);
        reportList = this.reportService.reportsByLogin(login);
        assertTrue(reportList != null);
        this.reportService.removeReport(idReport);
        System.out.println(" ==== Test's ReportClass  reportsByLogin passed ==== ");
    }

    @After
    public void tearDown() {
        System.out.println(" ==== After Test's begin ==== ");
        this.reportService.removeReport(idReport);
        System.out.println(" **** After Test's passed *** ");
    }
}
