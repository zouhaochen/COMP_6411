COMP 6411 Assignment 1
==== 
Quick sort in Java  
-------
### How to compile
1. Download all the .java files;
2. Open terminal and navigate to `main` folder;
3. Run the command:
   ```
   javac -d [./out] java/assignment1/*.java java/filemanager/*.java java/performance/*.java
   ```
   `./out` is optional, which is used to specify the directory for the .class files.

### How to execute
1. Complete the compilation as instructed in the previous section;
2. Open terminal and navigate to `main` folder (or the parent directory of the folder you specify for the .class files
   in the compilation);
3. Run the command: 
   ```
   java -classpath out:resources assignment1/QuickSort [path/to/input/file]
   ```
   `path/to/input/file` is optional, which is used to specify the input file you want to use. If the parameter
   is not specified, the default file `rand.txt` will be used.