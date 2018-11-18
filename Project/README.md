#Overview

This is an overview of the project [__Project__](https://github.com/sssurvey/ObjectOrientedDesign/tree/master/Project).
__For this project:__
- I choose, Gradle, Java 8, Visual Studio Code, And SpringBoot
	- Reasons:
		1. Gradle for the wrapper easy deployment on TA's testing environment
		2. Java 8 for the standard OOP style, and my familiarity
		3. VSC for the light weight, and less IDE magics
		4. SpringBoot for the light weight, and Tomcat inclution


_Haomin Shi_ @ Nov 18th, 2018 Final Project
```bash
haominshi@Haomins-MacBook-Pro:~/GitRepo/ObjectOrientedDesign/Project$ tree src
src
├── main
│   ├── java
│   │   ├── App.java
│   │   ├── AppContract.java
│   │   ├── AppPresenter.java
│   │   ├── jsonUtil
│   │   │   ├── NoteToJsonConvertor.java
│   │   │   ├── NoteValidator.java
│   │   │   ├── OrderToJsonConvertor.java
│   │   │   ├── OrderValidator.java
│   │   │   ├── ParkToJsonConvertor.java
│   │   │   ├── ParkValidator.java
│   │   │   ├── ResponseJsonParser.java
│   │   │   └── VisitorModelToJsonConvertor.java
│   │   ├── model
│   │   │   ├── noteModel
│   │   │   │   ├── NoteEntry.java
│   │   │   │   └── NoteModel.java
│   │   │   ├── orderModel
│   │   │   │   └── OrderModel.java
│   │   │   ├── parkModel
│   │   │   │   ├── LocationInfoModel.java
│   │   │   │   ├── ParkModel.java
│   │   │   │   └── PaymentInfoModel.java
│   │   │   ├── vehicleModel
│   │   │   │   ├── VehicleModel.java
│   │   │   │   └── VehicleTypeInfoModel.java
│   │   │   └── visitorModel
│   │   │       └── VisitorModel.java
│   │   ├── park
│   │   │   ├── Park.java
│   │   │   └── ParkContract.java
│   │   ├── responseCode
│   │   │   ├── BadRequestResponseCode.java
│   │   │   ├── CreatedResponseCode.java
│   │   │   ├── NotFoundResponseCode.java
│   │   │   ├── OkResponseCode.java
│   │   │   ├── ResponseCodeContract.java
│   │   │   └── StatusCodes.java
│   │   ├── search
│   │   │   ├── NoteSearch.java
│   │   │   ├── OrderSearch.java
│   │   │   ├── ParkSearch.java
│   │   │   └── VisitorSearch.java
│   │   ├── storage
│   │   │   ├── Storage.java
│   │   │   ├── StorageContract.java
│   │   │   └── StorageEntity.java
│   │   └── util
│   │       ├── ArrayFormatter.java
│   │       ├── DateHelper.java
│   │       ├── IdGenerator.java
│   │       ├── NumberFormatter.java
│   │       └── PriceCalculator.java
│   └── resources
│       └── application.properties
└── test
    ├── java
    │   ├── AppPresenterTest.java
    │   ├── AppTest.java
    │   ├── ArrayFormatterTest.java
    │   ├── IdGeneratorTest.java
    │   ├── LocationInfoModelTest.java
    │   ├── NoteToJsonConvertorTest.java
    │   ├── NumberFormatterTest.java
    │   ├── ParkModelTest.java
    │   ├── ParkTest.java
    │   ├── ParkValidatorTest.java
    │   └── PaymentInfoModelTest.java
    └── mockData
        └── createPark1.json

18 directories, 53 files

```

### Build the project:
- Build // do it at the project root dir i.e ```~/project/.```
```bash
haominshi@Haomins-MacBook-Pro:~/GitRepo/ObjectOrientedDesign/Project$ ./gradlew clean build
```
- Run // do it at the project root dir i.e ```~/project/.```
```bash
haominshi@Haomins-MacBook-Pro:~/GitRepo/ObjectOrientedDesign/Project$ ./gradlew run
```
- __The Project will be running at base url__ -- ```http://localhost:8080/parkpay/```
	- Example -- ```http://localhost:8080/parkpay/hello-world```

------
#### Tasks Checks

___PARKS___

- [x] Create park ( POST /parks )
- [x] Update park [pid] ( PUT /parks/[pid] )
- [x] Delete park [pid] ( DELETE /parks/[pid] )
- [x] View all parks ( GET /parks )
- [x] View park detail ( GET /parks/[pid] )
- [x] Search parks ( GET /parks?key=keyword )
- [x] View all notes associated with park [pid] ( GET /parks/[pid]/notes )
- [x] View note associated with park [pid] ( GET /parks/[pid]/notes/[nid] )
- [x] Create note and associate it with park [pid] ( POST /parks/[pid]/notes )

___NOTES___

- [x] View all notes ( GET /notes )
- [x] View note identified by [nid] ( GET /notes/[nid] ).
- [x] Update note [nid] ( PUT /notes/[nid] )
- [x] Search notes ( GET /notes?key=keyword )

___ORDERS___

- [x] Create order ( POST /orders )
- [x] View all orders ( GET /orders )
- [x] View order [oid] ( GET /orders/[oid] )
- [x] Search orders ( GET /orders?key=keyword )

___VISITORS___

- [x] View all visitors ( GET /visitors )
- [x] View visitor [vid] ( GET /visitors/[vid] )
- [x] Search visitors ( GET /visitors?key=keyword )

___REPORTS___

- [ ] Get list of available reports ( GET /reports )
- [ ] Get report identified by [rid] ( GET /reports/[rid]{?start_date=YYYYMMDD&end_date=YYYYMMDD} )

___SEARCH___

- [ ] Search ( GET /search?key=keyword{&start_date=YYYYMMDD&end_date=YYYYMMDD} )

### All Tasks
- You can view all aviliable gradle tasks via
```bash
haominshi@Haomins-MacBook-Pro:~/GitRepo/ObjectOrientedDesign/Project$ ./gradlew tasks
```


### Stats
- Totoal Lines of Code sourceCode vs Compiled: ..
```
Start counting... 
Countting took 283 ms. The result is: 
    total:	11,971
    code:	10,961
    comment:	266
    blank:	744
Start counting... 
Countting took 1807 ms. The result is: 
    total:	647,585
    code:	642,613
    comment:	267
    blank:	4,705
```

- Lines in unitests:
```bash
haominshi@Haomins-MacBook-Pro:~/GitRepo/ObjectOrientedDesign/Project$ ./gradlew jacocoTestReport
```
Then you can view the report under the gradle build dir under the report folder.

- For Code complexity:
```bash
haominshi@Haomins-MacBook-Pro:~/GitRepo/ObjectOrientedDesign/Project$ ./gradlew cloverGenerateReport
```
Then you can view the code complexity report at the build dir under the report, and then clover dir.

### Challenges:

Complete this project under 2 weeks is a challenge... I should've started the project earlier
