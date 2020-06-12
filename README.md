# Втора лабораториска вежба по Софтверско инженерство
## Јелена Огњаноска, бр. на индекс 183005

### Група на код:
Ја добив групата на код 5.

### Control Flow Graph
![alt text](https://github.com/ognjanoskajelena/SI_lab2_183005/blob/master/images/CFG_lab2.jpg?raw=true)

### Цикломатска комплексност
###### E - број на ребра (во CFG изнесува 20)  
###### N - број на јазли (во CFG изнесува 16)  
###### P - број на предикатни јазли (во CFG изнесува 5)  
Цикломатската комплексност на кодот изнесува 6. Може да се пресмета преку следните формули:  
#### Cyclomatic complexity = E - N + 2 = 6
#### Cyclomatic complexity = P + 1 = 6
#### Cyclomatic complexity = R(Regions) = 6

### Тест случаи според критериумот Every branch
Според Every branch критериумот за структурно тестирање, потребно е да се напишат минимален број на тест случаи со кои ќе се измине секој од исходите во јазлите на одлука во кодот. Според тоа, следните три тест случаи ги изминуваат сите гранки:  
1. test case: испраќање на празна листа - се изминуваат гранките: 1,2 - 3; 3 - 17.  
2. test case: ["#", "0", "#"] - се изминуваат гранките: 1,2 - 4; 4 - 5.1; 5.1 - 5.2; 5.2 - 6; 6 - 7,8;
6 - 13,14; 13,14 - 15; 7,8 - 9; 9 - 10; 10 - 11; 11 - 12; 12 - 15; 15 - 5.3; 5.3 - 5.2; 16 - 17.  
3. test case: ["0"] - се изминуваат гранките: 1,2 - 4; 4 - 5.1; 5.1 - 5.2; 5.2 - 6; 6 - 7,8; 7,8 - 10; 
10 - 12; 12 - 15; 15 - 5.3; 5.3 - 5.2; 16 - 17.  
  
![alt text](https://github.com/ognjanoskajelena/SI_lab2_183005/blob/master/images/every-branch.png?raw=true)

### Тест случаи според критериумот Multiple - condition
Според Multiple - condition критериумот за структурно тестирање, потребно е да се напишат минимален број на тест случаи со кои ќе се покријат сите комбинации на исходите на релационите изрази во јазлите на одлука. Бидејќи по одреден исход од првиот дел од изразот, исходот од вториот дел нема да има влијание на резултатот, некои од комбинациите се изоставени _(lazy evaluation)_. Вредностите кои не влијаат на резултатот се означени со "X".
###### T - true
###### F - false
###### X - true/false
1. test case: ["0"] - комбинација FX 
2. test case: ["#", "0", "#"] - комбинација ТТ
3. test case: ["0", "0"] - комбинација TF
  
![alt text](https://github.com/ognjanoskajelena/SI_lab2_183005/blob/master/images/multiple-condition.png?raw=true)  
  
### Објаснување на напишаните unit tests
#### Every branch test cases
Со овој тест случај се проверува дали при праќање на аргумент - празна листа, програмата ќе фрли исклучок.
```java
IllegalArgumentException exception;
exception = assertThrows(IllegalArgumentException.class, () -> this.lab2.function(Collections.emptyList()));
assertTrue(exception.getMessage().contains("List length should be greater than 0"));
```
Со следниот тест случај се проверува дали ќе бидат изброени двете "бомби" пред и по 0 (нулата).
```java
assertEquals(new ArrayList<>(createList("#", "2", "#")), lab2.function(createList("#", "0", "#")));
```
Со последниот тест случај се проверува дали при праќање на една 0 (нула) во листата нема да се изврши инкрементирање на бројачот (num).
```java
assertEquals(new ArrayList<>(createList("0")), lab2.function(createList("0"))); 
```
#### Multiple - condition coverage test cases  
###### Релациони изрази: (i - 1 >= 0 && list.get(i - 1).equals("#")) и (i + 1 < list.size() && list.get(i + 1).equals("#"))
Со овој тест случај исходот од првиот дел од релациониот израз е неточен (False), па вториот не се проверува воопшто.
```java
assertEquals(new ArrayList<>(createList("0")), lab2.function(createList("0"))); //F && X
```
Со следниот тест случај исходот од првиот дел од релациониот израз е точен (True), се проверува вториот и тој е неточен (False).
```java
assertEquals(new ArrayList<>(createList("0", "0")), lab2.function(createList("0", "0"))); //T && F
```
Со последниот тест случај исходот од првиот дел од релациониот израз е точен (True), се проверува вториот и тој е точен (True).
```java
assertEquals(new ArrayList<>(createList("#", "2", "#")), lab2.function(createList("#", "0", "#"))); //T && T
```
