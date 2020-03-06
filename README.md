# SYSC3110A Term Project
[![Build Status](https://travis-ci.com/cyang030/SYSC3110A_project.svg?token=a1EppsrxP5RSz1A8weEt&branch=master)](https://travis-ci.com/cyang030/SYSC3110A_project)

This is the group project repo for “Yahoo Boyz”.
The goal of this project is to provide an implementation of the game "JumpIN'"

Description of the game can be found in the following links:

https://www.smartgames.eu/uk/one-player-games/jumpin

https://youtu.be/8sEoYzcmOfc

https://youtu.be/SGcMK-L59p4


## Prerequisites

* JDK 8, although later version should work as well
* Eclipse, the code is stored as a eclipse project
* Violet for UML diagrams


## Running the tests

Use maven test to run the unit tests

```
mvn -B test
```

Alternatively, right click on "OverallCoverageReport.launch" in Eclipse, then click "Run As"

Continuous Integration is provided via Travis-CI

## Start the game manually

Import this project into Eclipse, right click on "Game.lauch" in Eclipse, then click "Run As"

Alternatively, user can start the main method in Game class manually.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Changes since Milestone 1:

* GUI based version of the game
* Unit tests for the model class "Board"
* design decisions captured in UML diagrams

## Changes since Milestone 2:

* Solver and GUI integration to provide hint to user
* Undo/Redo functionality

## Changes since Milestone 3:

* Save/load via Java serialization
* Level builder with export/import to XML support

## Known Issues for Milestone 4:

None?

## TODOs:

### Lowest:
*	“mvn package” support to produce milestone ready zip directly


## Authors

* **Emmanuel Alawode** - [Alawode](https://github.com/Alawode)
* **Hassan Yusuf** - [almasrur](https://github.com/almasrur)
* **Justice Odia** - [oyenmwen](https://github.com/oyenmwen)
* **Tami Odunlami** - [Tamiod](https://github.com/Tamiod)
* **Yu-Kai Yang** - [cyang030](https://github.com/cyang030)


## Credits

The fox image is Tails from the game *Sonic the Hedgehog* by Sega

The rabbit images is Bugs Bunny from *Looney Tunes* by Warner Bros. Cartoons

The mushroom image is from *MapleStory* by Wizet

The hole image is created by Sergui Matei

The trophy image is created by Jeremy Brown
