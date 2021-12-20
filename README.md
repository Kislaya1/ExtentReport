# <span style="font-family: Calibri; font-size: 2.8em;"> Automation Reporting </span>

## <span style="font-family: Calibri; font-size: 2.8em;"> Introduction </span>
    Hi All, I had created this demo-project which will in-cooperate Extent Reports, Allure and Report Portal (Allure and Report Portal are still in development phase). 
    Anyone can use this demo-project as it will be helpful for a quick-start.
    
## <span style="font-family: Calibri; font-size: 2.8em;"> Project Overview </span>
    Below are the key points in my project : -
        a) Klov Integration : Klov is a part of Extent Reports and is generally used to view all the old builds which were executed earlier.

        b) Extent Spark Reporter Generation : I am also creating Extent Spark Reporter which is a plain HTML file and can be accessed using any browser. 
            It contains the report for current executed build. (it will not contain older build run report).

        c) Extent PDF Reporter : I had also created a PDF file for the current report which is generated using "Extent Spark Reporter". 
            Anyone can use it to send to your PMs, Stakeholder etc to get a complete view of your report in PDF format.

        d) Report Sending through Email : I am also sending my Report through Email.
            Anyone can configure his / her email id so that report is send to the required mail id.
        NOTE : Docker Compose Yml File : I had created a docker compose yml file which can be used for quick starting the KLOV server in your local (without worrying about MongoDb installation).
            You can use "localhost:80" to access Klov Report generated.

## <span style="font-family: Calibri; font-size: 2.8em;"> Issues Which I had encountered </span>
    There are some issues which I had faced while creating this project. 
    Documenting these so that it would be helpful for all.
        a) Docker Issue : 
        I was facing one issue while creating Docker Compose Yml file (integrating mongo db with Klov Server).
        Since Klov is having dependencies with Mongo Db, so klov will use the MongoDB URL.
        Issue - "com.mongodb.MongoSocketOpenException: Exception opening socket"
        Solution - Use "SPRING_DATA_MONGODB_URI" as "mongodb://host.docker.internal:27017" instead of "mongodb://127.0.0.1:27017".
        
[Refer this Link](https://github.com/extent-framework/klov/issues/66)
        
        b) Klov Old version issue : 
        In case if you are using old version of extent report and Klov report (<= 4.x), then there is an issue, as Build Number were coming as #null
        in Klov report and failures were also not getting reported.
        Issue - Klov does not report on failures and build numbers are shows as nulls
        Solution - Upgrade everything to the latest version and switch from "Extent HTMLReport" to "ExtentSparkReporter"

[Refer this Link](https://github.com/extent-framework/klov/issues/67)
        
        c) Threading Issue :
        In case even if you are using latest Extent Report & Klov Report version, you will still face one issue as Project name 
        is getting generated but when you will click on the project it will appear blank and also there will be 1 duplicate project created.
        
        Solution : Use below code when calling Extent Test class, and also make use of "synchronized" methods as it will ensure threads handling.
        Code : - private static final ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

## <span style="font-family: Calibri; font-size: 2.8em;"> Technology Stack Used </span>

    1. Java

    2. Docker 

## <span style="font-family: Calibri; font-size: 2.8em;"> Pre-Requisite </span>

    1. Docker Installation.

    2. Any of your favorite IDE.

## <span style="font-family: Calibri; font-size: 2.8em;"> Execution </span>

    1. Clone the repository and checkout to main branch.

    2. Run the below Docker Commands. (Run the docker commands while being inside the project)

## <span style="font-family: Calibri; font-size: 2.8em;"> Docker Commands </span>

    1. docker-compose up --build : Since you are using the project 1st time, run this command to install all dependencies.

#### <span style="font-family: Calibri; font-size: 2.8em;"> Note : Run the command "docker-compose up" from 2nd time after above steps is successfully executed. </span>

    2. docker-compose down : Stopping all the running containers which are getting executed in above 1st step.