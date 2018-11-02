Feature: As a new user I want to verify vehicle datails from various files with DVLA website 

Scenario:  Reading vehicle data from Excelsheet file and inputing data into a webpage
     Given User has access to "xlsx" files from "HomeOfficeTest" directory
     When  User opens the webpage "https://www.gov.uk/get-vehicle-information-from-dvla"
      And  User hit the startnow button       
     Then  User veriy vehicle details with excel data on the vehicle details page 
     
Scenario: VReading vehicle data from Excelsheet file and inputing data into a webpage
     Given User has access to "csv" files from "HomeOfficeTest" directory
     When  User opens the webpage "https://www.gov.uk/get-vehicle-information-from-dvla"
      And  User hit the startnow button       
     Then  User veriy vehicle details with excel data on the vehicle details page