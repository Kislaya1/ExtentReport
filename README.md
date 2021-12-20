# <span style="font-family: Calibri; font-size: 2.8em;"> Automation Reporting </span>

## <span style="font-family: Calibri; font-size: 2.8em;"> Introduction </span>
Hi All, I had created this demo-project which will in-cooperate Extent Reports, Allure and Report Portal **(Allure and Report Portal are still in development phase).** 
Anyone can use this demo-project as it will be helpful for a quick-start.
    
## <span style="font-family: Calibri; font-size: 2.8em;"> Project Overview </span>
Below are the key points in my project : - <br><br>
**a) Klov Integration :** <br>
    Klov is a part of Extent Reports and is generally used to view all the old builds which were executed earlier.<br>

**b) Extent Spark Reporter Generation :** <br>
I am also creating Extent Spark Reporter which is a plain HTML file and can be accessed using any browser. It contains the report for current executed build. (it will not contain older build run report).<br>

**c) Extent PDF Reporter :** <br>
I had also created a PDF file for the current report which is generated using **"Extent Spark Reporter"**. Anyone can use it to send to your PMs, Stakeholder etc to get a complete view of your report in PDF format. <br>

**d) Report Sending through Email :** <br> 
I am also sending my Report through Email.Anyone can configure his / her email id so that report is send to the required mail id.<br>

**NOTE : Docker Compose Yml File : <br> 
I had created a docker compose yml file which can be used for quick starting the KLOV server in your local (without worrying about MongoDb installation).
You can use [Local Klov](localhost:80) to access Klov Report generated.** <br>

## <span style="font-family: Calibri; font-size: 2.8em;"> Technology Stack Used </span>
**1. Java** <br>
**2. Docker** <br>

## <span style="font-family: Calibri; font-size: 2.8em;"> Pre-Requisite </span>
**1. Docker Installation.** <br>
**2. Any of your favorite IDE.** <br>

## <span style="font-family: Calibri; font-size: 2.8em;"> Execution </span>
**1. Clone the repository and checkout to main branch.** <br>
**2. Run the below Docker Commands. (Run the docker commands while being inside the project)** <br>

## <span style="font-family: Calibri; font-size: 2.8em;"> Docker Commands </span>

    1. docker-compose up --build : Since you are using the project 1st time, run this command to install all dependencies.

#### <span style="font-family: Calibri; font-size: 2.8em;"> Note : Run the command "docker-compose up" from 2nd time after above steps is successfully executed. </span>

    2. docker-compose down : Stopping all the running containers which are getting executed in above 1st step.

## <span style="font-family: Calibri; font-size: 2.8em;"> Issues Faced </span>
There are some issues which I had faced while creating this project. Documenting these so that it would be helpful for all.
    
### a) Docker Issue : 
I was facing one issue while creating Docker Compose Yml file (integrating mongo db with Klov Server). Since Klov is having dependencies with Mongo Db, so klov will use the MongoDB URL.<br>
    
**Issue -** "com.mongodb.MongoSocketOpenException: Exception opening socket"<br><br>
**Solution -** Use "SPRING_DATA_MONGODB_URI" as "mongodb://host.docker.internal:27017" instead of "mongodb://127.0.0.1:27017".<br>

[Docker Issue](https://github.com/extent-framework/klov/issues/66)

### b) Klov Old version issue : 
In case if you are using old version of extent report and Klov report (<= 4.x), then there is an issue, as Build Number were coming as #null in Klov report and failures were also not getting reported.<br>

**Issue -** Klov does not report on failures and build numbers are shows as nulls <br><br>
**Solution -** Upgrade everything to the latest version and switch from "Extent HTMLReport" to "ExtentSparkReporter" <br>

[Old Version Issue](https://github.com/extent-framework/klov/issues/67)

### c) Threading Issue :
In case even if you are using latest Extent Report & Klov Report version, you will still face one issue as Project name is getting generated but when you will click on the project it will appear blank and also there will be 1 duplicate project created.<br>
        
**Solution -** Use ThreadLocal when calling Extent Test class variable, and also make use of "synchronized" methods as it will ensure threads handling. This is already present under **ExtentManager & ExtentReport Class** <br><br>