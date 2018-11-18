# CS 445
## Object Oriented Design
---
__Rules__: Always commit to the ```develop``` branch first. New branch should be limited to as less new features as possible.

- [x] Homework 1

> http://www.cs.iit.edu/~virgil/cs445/mail.fall2018/HW-1/hw1.html

__$ tree Homework_1/src/__
```
Homework_1/src/
└── com
    └── haomins
        ├── main
        │   ├── TestCreature.java
        │   └── things
        │       ├── Ant.java
        │       ├── Creature.java
        │       ├── Thing.java
        │       ├── Tiger.java
        │       └── flyer
        │           ├── Bat.java
        │           ├── Fly.java
        │           └── Flyer.java
        └── test
            └── unitTests
                ├── AntTest.java
                ├── BatTest.java
                ├── CreatureTest.java
                ├── FlyTest.java
                ├── ThingTest.java
                └── TigerTest.java

7 directories, 14 files
```
---
- [x] Homework 2

> http://www.cs.iit.edu/~virgil/cs445/mail.fall2018/hw2.html

__$ tree Homework_2/src/__
```
Homework_2/src/
├── main
│   ├── java
│   │   ├── A.java
│   │   ├── B.java
│   │   ├── C.java
│   │   ├── D.java
│   │   ├── E.java
│   │   ├── F.java
│   │   ├── ImporvedStringTokenizer.java
│   │   └── ImprovedRandom.java
│   └── resources
└── test
    ├── java
    │   ├── ATest.java
    │   ├── BTest.java
    │   ├── CTest.java
    │   ├── DTest.java
    │   ├── ETest.java
    │   ├── FTest.java
    │   ├── ImporvedStringTokenizerTest.java
    │   └── ImprovedRandomTest.java
    └── resources

6 directories, 16 files
```

---
- [x] Homework 3

> http://cs.iit.edu/~virgil/cs445/mail.fall2018/hw3.html

__$ tree Homework_3/src/__

```bash
Homework_3/src/
├── main
│   ├── java
│   │   ├── Main.java
│   │   └── tableLamp
│   │       ├── bulb
│   │       │   ├── Lightbulb.java
│   │       │   └── LightbulbContract.java
│   │       ├── control
│   │       │   └── Button.java
│   │       └── enumsUtil
│   │           └── Status.java
│   └── resources
└── test
    ├── java
    │   └── tableLamp
    │       ├── bulb
    │       │   └── LightbulbTest.java
    │       └── control
    │           └── ButtonTest.java
    └── resources

13 directories, 7 files
```

---
- [x] Final Project - A park parking payment system

> http://cs.iit.edu/~virgil/cs445/mail.fall2018/project/project.html

__$ tree Project/src/__

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