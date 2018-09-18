# Giler's File System

Basic file system operations assignment.

## Target

> Design and implement a program which will handle and manage a "file System" structure.

## Entities

### File

is defined as having:
*  name - up to 32 characters long
*  size - positive long integer
*  create date (date type)

### Directory 

is defined as having:
*  name - up to 32 characters long
*  create date (date type)
*  directory can contain directories or files

## Operations

Add a new file under the Directory branch
```java
addFile (string parentDirName, String fileName, integer fileSize)
```

Add a new Directory under the parent Directory
```java
addDir (string parentDirName, String dirName)
```

Delete the Directory or the file with this name
```java
delete (string name)
```

Display all files & directories with their hierarchical structure (for file display all file properties and for Directory all its properties)
```java
showFileSystem ()
```

## Definitions

* Each name, file or directory is unique in the file system.
* Each directory can contain an unlimited number of files or directories.
* No need to write anything on the disk, the data structure should be managed in memory only.


The design should include:
* The classes that will be involved in the program and the relationship between them.
* The major methods and members of each class
