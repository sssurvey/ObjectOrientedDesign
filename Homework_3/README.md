# Memo

__For Homework - 3__

_Haomin Shi_

# Project Overview

__Status:__ Complete

__Difficult part:__ Deploy, since no previous knowledge

__Work space tree:__

```bash
$ tree Homework_3/src/
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



------

### Appendix

Complexity: By methods

| tableLamp.bulb.Lightbulb.ChangeStatus(Status)      | 2.0                | 2.0                | 3.0                |
| -------------------------------------------------- | ------------------ | ------------------ | ------------------ |
| tableLamp.bulb.Lightbulb.getStatus()               | 1.0                | 1.0                | 1.0                |
| tableLamp.bulb.Lightbulb.Lightbulb()               | 1.0                | 1.0                | 1.0                |
| tableLamp.control.Button.Button(LightbulbContract) | 1.0                | 1.0                | 1.0                |
| tableLamp.control.Button.getStatus()               | 1.0                | 1.0                | 1.0                |
| tableLamp.control.Button.pushButton()              | 2.0                | 2.0                | 3.0                |
| Total                                              | 8.0                | 8.0                | 10.0               |
| Average                                            | 1.3333333333333333 | 1.3333333333333333 | 1.6666666666666667 |

**Lines of Code:**

| Total: | 146         | 106       | 0.726027397260274 | 5       | 0.03424657534246575 | 35          | 0.23972602739726026 |
| ------ | ----------- | --------- | ----------------- | ------- | ------------------- | ----------- | ------------------- |
|        | total lines | src lines | src %             | comment | comment %           | blank lines | blank %             |

**Unit Test Coverage:**

| bulb      | 100% (2/2) | 100% (4/4) | 100% (10/10) |
| --------- | ---------- | ---------- | ------------ |
| control   | 100% (2/2) | 100% (4/4) | 100% (13/13) |
| enumsUtil | 100% (1/1) | 100% (2/2) | 100% (2/2)   |

