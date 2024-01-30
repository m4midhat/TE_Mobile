package org.te.app.android.utils;

import lombok.extern.slf4j.Slf4j;
import org.te.app.android.AppConstants.AppConstants;
import org.te.app.testRail.APIClient;
import org.te.app.testRail.APIException;
import org.te.app.testRail.TestRailClass;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Slf4j
public class TestRailUtils {


    static Properties testRailProp;

    public static int testRailTestPlanID=-1;
    static int testRailTestRunID=-1;
    public static TestRailClass testRail;
    public static APIClient testRailClient;
    public static String TestRailLink;
    static String TestRailUserName;
    static String TestRailPassword;
    static String TestPlanName;
    static String projectID;
    static String TestPlanDescription;
    public static String TestRunName;
    static String TestRunDescription;
    static String suiteID;
    static String userAssignedTo;

    static int statusPassed = 1;
    static int statusFailed = 5;
    static int statusBlocked = 2;


    private static void readTestRailConfigurations() throws IOException {
        if(AppConstants.TEST_RAIL_REPORTING) {
            testRailProp = utils.initTestRailProperties();
            TestRailLink = testRailProp.getProperty("TestRailLink");
            TestRailUserName = testRailProp.getProperty("TestRailUserName");
            TestRailPassword = testRailProp.getProperty("TestRailPassword");
            TestPlanName = testRailProp.getProperty("TestPlanName");
            projectID = testRailProp.getProperty("projectID");
            TestPlanDescription = testRailProp.getProperty("TestPlanDescription");
            TestRunName = testRailProp.getProperty("TestRunName");
            TestRunDescription = testRailProp.getProperty("TestRunDescription");
            suiteID = testRailProp.getProperty("suiteID");
            userAssignedTo = testRailProp.getProperty("userAssignedTo");
        }
    }

    public static int connectTestRailAndCreateTestPlan() throws IOException {
        if(AppConstants.TEST_RAIL_REPORTING) {
            readTestRailConfigurations();
            testRail = new TestRailClass();
            testRailClient = testRail.connectTestRail(TestRailLink, TestRailUserName, TestRailPassword);
            String testPlanNameWithDateTime = TestPlanName + " " + new java.util.Date();
            try {
                // Create a Test Plan for this execution
                if (testRailTestPlanID < 0) {
                    // Get current machine name
                    String computerName = InetAddress.getLocalHost().getHostName();
                    // Create a test plan
                    testRailTestPlanID = testRail.createTestPlan(testRailClient, testPlanNameWithDateTime,
                            TestPlanDescription + "\nMachine Name:\t" + computerName, Integer.parseInt(userAssignedTo), Integer.parseInt(projectID));
                    log.info("TestRail TestPlanID: " + testRailTestPlanID);
                }
            } catch (Exception e) {
                log.error(e.toString());
            }
        }

        return testRailTestPlanID;
    }

    public static void createTestRun(int testRailTestPlanID, String testRunName, String[] testCasesIDs){
        if(AppConstants.TEST_RAIL_REPORTING) {
            log.info("Creating a test plan in TestRail ....");
            try {
                testRailTestRunID = testRail.createTestRunInTestPlan(testRailClient, Integer.parseInt(suiteID), Integer.parseInt(userAssignedTo), testCasesIDs,
                        Integer.parseInt(projectID), testRunName, TestRunDescription, testRailTestPlanID);
                log.info("Test Run created in TestRail testRailTestRunID : " + testRailTestRunID);
            } catch (Exception e) {
                log.error(e.toString());
            }
        }
    }

    public static void closeTestPlan(int planId) throws APIException, IOException {
        if(AppConstants.TEST_RAIL_REPORTING) {
            testRail.closeTestPlan(testRailClient, planId);
        }
    }

    public static void setTestCaseAsPassed(int testCaseId){
        if(AppConstants.TEST_RAIL_REPORTING) {
            try {
                testRail.updateTestCaseStatus(testRailClient, statusPassed, "Test Case Passed", testRailTestRunID, testCaseId);
            } catch (IOException | APIException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void setTestCaseAsBlocked(int testCaseId){
        if(AppConstants.TEST_RAIL_REPORTING) {
            try {
                testRail.updateTestCaseStatus(testRailClient, statusBlocked, "Test Case Blocked", testRailTestRunID, testCaseId);
            } catch (IOException | APIException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void setTestCaseAsFailed(int testCaseId, String failureMsg) {
        if (AppConstants.TEST_RAIL_REPORTING) {
            if (failureMsg != null) {
                try {
                    testRail.updateTestCaseStatus(testRailClient,
                            statusFailed,
                            "Test Case Failed!!!\n\n" + failureMsg,
                            testRailTestRunID,
                            testCaseId);
                } catch (IOException | APIException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    testRail.updateTestCaseStatus(testRailClient,
                            statusFailed,
                            "Test Case Failed!!!",
                            testRailTestRunID,
                            testCaseId);
                } catch (IOException | APIException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public static void updateTestCase(int testCaseID, ComparisonType comparisonType, String string1, String string2, String errorMessage){
        if(ComparisonType.STRING_CONTAINS == comparisonType){
            if(string1.contains(string2))
                setTestCaseAsPassed(testCaseID);
            else
                setTestCaseAsFailed(testCaseID, errorMessage);
        }
        else
        if(ComparisonType.STRING_HARD_EQUAL == comparisonType){
            if(string1.compareTo(string2)==0)
                setTestCaseAsPassed(testCaseID);
            else
                setTestCaseAsFailed(testCaseID, errorMessage);
        }
        else
        if(ComparisonType.STRING_SOFT_EQUAL == comparisonType){
            if(string1.compareToIgnoreCase(string2)==0)
                setTestCaseAsPassed(testCaseID);
            else
                setTestCaseAsFailed(testCaseID, errorMessage);
        }
    }

    public static void updateTestCase(int testCaseID, String string1, String string2, String errorMessage){
        if(string1.compareToIgnoreCase(string2)==0)
            setTestCaseAsPassed(testCaseID);
        else
            setTestCaseAsFailed(testCaseID, errorMessage);
    }

    public static void updateTestCase(int testCaseID, ComparisonType comparisonType, int int1, int int2, String errorMessage){
        if(ComparisonType.INT_EQUAL == comparisonType){
            if(int1 == int2)
                setTestCaseAsPassed(testCaseID);
            else
                setTestCaseAsFailed(testCaseID, errorMessage);
        }
        else
        if(ComparisonType.INT_GREATER_THEN == comparisonType){
            if (int1 > int2)
                setTestCaseAsPassed(testCaseID);
            else
                setTestCaseAsFailed(testCaseID, errorMessage);
        }
        else
        if(ComparisonType.INT_GREATER_THEN_EQUAL == comparisonType){
            if(int1 >= int2)
                setTestCaseAsPassed(testCaseID);
            else
                setTestCaseAsFailed(testCaseID, errorMessage);
        }

        else
        if(ComparisonType.INT_LESS_THEN == comparisonType){
            if(int1 < int2)
                setTestCaseAsPassed(testCaseID);
            else
                setTestCaseAsFailed(testCaseID, errorMessage);
        }
        else
        if(ComparisonType.INT_LESS_THEN_EQUAL == comparisonType){
            if (int1 <= int2)
                setTestCaseAsPassed(testCaseID);
            else
                setTestCaseAsFailed(testCaseID, errorMessage);
        }

        else
        if(ComparisonType.INT_NOT_EQUAL == comparisonType){
            if(int1 != int2)
                setTestCaseAsPassed(testCaseID);
            else
                setTestCaseAsFailed(testCaseID, errorMessage);
        }
    }

    public static void updateTestCase(int testCaseID, int int1, int int2, String errorMessage){
        if(int1 == int2)
            setTestCaseAsPassed(testCaseID);
        else
            setTestCaseAsFailed(testCaseID, errorMessage);
    }

    public static void updateTestCase(int testCaseID, boolean condition, String errorMessage){
        if(condition)
            setTestCaseAsPassed(testCaseID);
        else
            setTestCaseAsFailed(testCaseID, errorMessage);
    }

    public static void updateTestCase(int testCaseID, List<String > stringList1, List<String> stringList2, String errorMessage){
        if(stringList1.equals(stringList2)){
            setTestCaseAsPassed(testCaseID);
        }
        else
            setTestCaseAsFailed(testCaseID, errorMessage);
    }

    public static void updateTestCase(int testCaseID, List<String > stringList1, String[] Array, String errorMessage){
        if(Arrays.asList(Array).equals(stringList1))
            setTestCaseAsPassed(testCaseID);
        else
            setTestCaseAsFailed(testCaseID, errorMessage);
    }

    public static void updateTestCase(int testCaseID, String[] Array1, String[] Array2, String errorMessage){
        if(Arrays.equals(Array1, Array2)){
            setTestCaseAsPassed(testCaseID);
        }
        else
            setTestCaseAsFailed(testCaseID, errorMessage);
    }

}
