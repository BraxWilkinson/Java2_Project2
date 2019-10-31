# Java2_Project2
OU Fall 2019 - CS 2334 - Java 2 Project 2

Author: Braxton Wilkinson

Version: 10/30/2019
## Description
This program is built to read the text file Mesonet.txt and return the output as specified 

by the Main class and Project 2 description. 

## Usage
This program is built to operate as specified by the given Driver.java class and the Project 2 description.

# Classes

## abstract class MesoAbstract
### Abstract Methods
### public abstract int[] calAverage();
Abstract method calAverage to return integer array.

### public abstract char letterAverage();
Abstract method letterAverage to return char.

## MesoInherit extends MesoAbstract
### Private fields
String stid - Station ID

### Constructor - public MesoInherit(MesoStation station)
MesoInherit constructor, initializes an object with stid 

@param station

### public int[] calAverage()
Calculates the Ascii average of the given station ID.

@return result An array of ints containing the floor, ceiling and rounded Ascii average.

### public char letterAverage()
Finds the character associated with the rounded Ascii average from calAverage().

@return result The character associated with the calAverage rounded result.

## LetterAvg
### Private fields
String[] sameStation - String array initialized with a length of 10

char letter - A letter to be used in LetterAvg

int count - The number of elements in the sameStations array

### Constructor - public LetterAvg(char letter)
LetterAvg constructor, initializes with letter and numberOfStationWithLetterAvg reader method.

@param letter

### public int numberOfStationWithLetterAvg() throws IOException
Read Mesonet.txt and compare the first letter of the Station IDs to the given letter. 

If the letters are the same, add to the count and put the Station ID in the sameStation array.

@return count The number of stations that start with the given letter.

@throws IOException

### public String toString()
@Override object toString

Overrides the default toString. Prints the stations in the sameStations array.

## PosAvg
### Private fields
String stid - Station ID

String[] stationArray = new String[5] - String array containing station IDs, 

int arrayElements = 0 - int counter tracking the number of elements in the array

String avgFirst1 - Station index-1

String avgFirst2 - Station index+1

String avgSecond1 - Station index-2

String avgSecond2 - Station index-2

### Constructor - PosAvg(String stid)
PosAvg constructor, initializes with stid and Mesonet.txt reader

@param stid

### public int indexOfStation()
Find the index in stationArray of the given station ID

@return i The index

### public void read(String filename) throws IOException
Reader method optimized to read Mesonet.txt

@param filename

@throws IOException

### public void avgStations()
Retrieves the Station IDs of the two stations before and after the given index

### public void expandArray()
Expand the stationArray if the limit is reached

### public String toString()
@Override object toString
Overrides the default toString. Prints the stations retrieved in avgStations.
