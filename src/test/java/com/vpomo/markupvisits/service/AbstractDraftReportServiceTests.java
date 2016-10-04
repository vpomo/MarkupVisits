package com.vpomo.reportglonass.service;

import com.vpomo.reportglonass.model.DraftReport;
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

public abstract class AbstractDraftReportServiceTests {

    @Autowired
    DraftReportService draftReportService;
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
        List<DraftReport> resultList = null;
        resultList = this.draftReportService.getAll();
        org.junit.Assert.assertNotNull(resultList);
        assertTrue(resultList != null);
        System.out.println(" ==== Test's ReportClass  getAll() passed ==== ");
    }

    @Test
    public void testAddReport() {
        System.out.println(" ==== Test's ReportClass addReport(userL, currentDate, ...) begin ==== ");
        Date currentDate = new Date();
        Integer result = 0;

        result = this.draftReportService.addReport(
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
    public void testUpdateReport() {
        System.out.println(" ==== Test's ReportClass updateReport(userL, currentDate, ...) begin ==== ");

/*
        Users usersDraft = null;
        List<DraftReport> draftReportsUser = null;
        Integer countReports = 0;
*/

        Date currentDate = new Date();
        String login = "adminTest";
        DraftReport reportBeforeUpdate = null;
        DraftReport reportAfterUpdate = null;
        Integer idUpdateReport = 0;

        idUpdateReport = this.draftReportService.addReport(
                userTest, currentDate,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

        assertTrue(idUpdateReport != 0);
        reportBeforeUpdate = this.draftReportService.find(idUpdateReport);
        org.junit.Assert.assertNotNull(reportBeforeUpdate);
        assertTrue(reportBeforeUpdate.getCatDepartStateRNIS() == 1);
        this.draftReportService.updateReport(
                login, currentDate,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
        reportAfterUpdate = this.draftReportService.find(idUpdateReport);
        assertTrue(reportAfterUpdate.getCatDepartStateRNIS() == 2);
        this.draftReportService.removeReport(idUpdateReport);
       /* usersDraft = this.usersService.getUserLogin(login);

        if (usersDraft != null) {
            draftReportsUser = usersDraft.getDraftreportList();
            countReports = draftReportsUser.size();
            System.out.println("countReports=" + countReports);
        }*/
        System.out.println(" ==== Test's ReportClass  updateReport() passed ==== ");
    }

    @Test
    public void testRemoveReport() {
        System.out.println(" ==== Test's ReportClass removeReport(id) begin ==== ");
        List<DraftReport> resultListBeforeRemove = null;
        List<DraftReport> resultListAfterRemove = null;
        Integer result = 0;
        Date currentDate = new Date();
        result = this.draftReportService.addReport(
                userTest, currentDate,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
        assertTrue(result != 0);
        resultListBeforeRemove = this.draftReportService.getAll();
        org.junit.Assert.assertNotNull(resultListBeforeRemove);
        this.draftReportService.removeReport(result);
        resultListAfterRemove = this.draftReportService.getAll();
        org.junit.Assert.assertNotNull(resultListAfterRemove);
        assertTrue(resultListBeforeRemove.size() != resultListAfterRemove.size());
        System.out.println(" ==== Test's ReportClass  removeReport(id) passed ==== ");
    }

    @Test
    public void testFind() {
        System.out.println(" ==== Test's ReportClass find(id) begin ==== ");
        DraftReport findReport = null;
        Integer idNewReport = 0;
        Date currentDate = new Date();
        idNewReport = this.draftReportService.addReport(
                userTest, currentDate,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3);

        assertTrue(idNewReport != 0);
        findReport = this.draftReportService.find(idNewReport);
        org.junit.Assert.assertNotNull(findReport);
        assertTrue(findReport != null);
        this.draftReportService.removeReport(idNewReport);
        System.out.println(" ==== Test's ReportClass  find() passed ==== ");
    }

    @Test
    public void testfindReportsLogin() {
        System.out.println(" ==== Test's ReportClass reportsByLogin(login) begin ==== ");
        List<DraftReport> reportList = null;
        Integer idReport = 0;
        String login = "adminTest";
        Date currentDate = new Date();
        idReport = this.draftReportService.addReport(
                userTest, currentDate,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 );
        assertTrue(idReport != 0);
        reportList = this.draftReportService.reportsByLogin(login);
        assertTrue(reportList != null);
        this.draftReportService.removeReport(idReport);
        System.out.println(" ==== Test's ReportClass  reportsByLogin passed ==== ");
    }

    @After
    public void tearDown() {
        System.out.println(" ==== After Test's begin ==== ");
        this.draftReportService.removeReport(idReport);
        System.out.println(" **** After Test's passed *** ");
    }
}
