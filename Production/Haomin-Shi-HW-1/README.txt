How to compile all the src
1. install >>> ant
2. make sure you have java
3. run on your terminal $ ant -buildfile homework_1.xml
	- This will compile everything except the unitTests for you.

LAST: To test TestCreature.java
1. $ cd TA_grading
2. $ java com.haomins.main.TestCreature
3. You will now see the output on the terminal

Finally:
1. If you want to compile Junit test, you can type
2. $ ant -buildfile homework_1.xml Test_compile
3. Then in the com.haomins.test.unitTests will appear
4. But unfortunately, during the development phase, I choose JUnit5 instead of JUnit4, and ant don't really support Junit5, so I cannot run the batch test

All the .class files can be found in:
haominshi@MacBook-Pro-de-Haomin:~/Desktop/Haomin-Shi-HW-1$ tree TA_grading/
TA_grading/
└── com
    └── haomins
        ├── main
        │   ├── TestCreature.class
        │   └── things
        │       ├── Ant.class
        │       ├── Creature$1.class
        │       ├── Creature$Stomach.class
        │       ├── Creature.class
        │       ├── Thing.class
        │       ├── Tiger.class
        │       └── flyer
        │           ├── Bat.class
        │           ├── Fly.class
        │           └── Flyer.class
        └── test
            └── unitTests
                ├── AntTest.class
                ├── BatTest$1.class
                ├── BatTest.class
                ├── CreatureForTesting.class
                ├── CreatureTest.class
                ├── FlyTest$1.class
                ├── FlyTest.class
                ├── ThingTest.class
                └── TigerTest.class

7 directories, 19 files
