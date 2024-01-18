package org.te.app.android.utils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class dbDriver {

    static String IPAddress="", port="", username="", password="", dbName="";
    static Connection connection;

    public dbDriver(){
        connection = null;
    }

    private static Connection initiateConnection(String envName) throws IOException, SQLException {
        Properties properties = null;
            if (envName.compareToIgnoreCase("uat") == 0) {
                properties = utils.initProperties("dbUATResources");
                if(properties!=null){
                    IPAddress = utils.decodeString(properties.getProperty("ipAddress"));
                    port = utils.decodeString(properties.getProperty("dbPort"));
                    dbName = utils.decodeString(properties.getProperty("dbName"));
                    username = utils.decodeString(properties.getProperty("dbUser"));
                    password = utils.decodeString(properties.getProperty("dbPwd"));
                    String hostURL = "jdbc:mysql://"+IPAddress+":"+port+"/"+dbName+"?useSSL=false";
                    connection = DriverManager.getConnection(hostURL, username, password);
                    System.out.println("Connection successful via ip address");
                }
            }
        return connection;
    }

    private static void closeConnection() throws SQLException {
        if(!connection.isClosed()){
            connection.close();
        }
    }


    public static String getRandomCountry() throws IOException {
        int TotalCount = -1;
        String randomCountry = "";
        Properties queryFile = utils.initProperties("queries");
        try {
            connection = initiateConnection("uat");
            String query = utils.decodeString(queryFile.getProperty("queryCountryCount"));
            System.out.println("Executing : "+query);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            TotalCount = rs.getInt("TotalCount");
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        if(TotalCount!=-1){
            try {
                String query = utils.decodeString(queryFile.getProperty("countries"));
                System.out.println("Executing : "+query);
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                int randomIndex = utils.generateRandomNumber(0, TotalCount-1);
                System.out.println("Random index : "+randomIndex);
                int counter = 0;
                while (rs.next()){
                    if(counter==randomIndex){
                        randomCountry = rs.getString(1);
                        break;
                    }
                    counter++;
                }
                st.close();
                closeConnection();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
        }
        System.out.println(randomCountry);
        return randomCountry;
    }

}
