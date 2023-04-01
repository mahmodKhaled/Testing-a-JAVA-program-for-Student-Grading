# Testing-a-JAVA-program-for-Student-Grading

## Project Description

It is required to build an application for student grading using JAVA. The application 
requires the following as inputs data:
1. Subject name: It must be Alphabetic characters and Spaces. the name should not 
start with space
2. Subject-code: It must be 6-7 Alphanumeric characters. The first 3 are Alphabetic 
followed by 3 numeric characters. The sevens should be s if exists.
3. Full mark: It is a numeric number of one of the following values: 100
4. Student name: It must be Alphabetic characters and Spaces. the name should not 
start with space.
5. Student number: the length of this field must be Alphanumeric characters of exact 
length of 8 characters. It should start with numbers and might End with only one 
Alphabetic character
6. Student Activities mark: It is an integer of a value from 0 up to 10 of the full mark
7. Oral/Practical mark: It is an integer of a value from 0 up to 10 of the full mark
8. Midterm exam mark: It is an integer of a value from 0 up to 20 of the full mark
9. Final exam mark: It is an integer of a value from 0 up to 60 of the full mark

The application input is a file. The application reads each line in this file as one string 
where each of its fields are separated by comma “,”.

The first line of the file contains the subject name, subject-code and the full mark of that 
subject where each of their fields are separated by comma “,”

Each of the following lines of that file (starting from line 2 to the end of file) till the end of 
the fill should consists of the following items Student name, Student number, Student 
Activities mark, Oral/Practical mark, Midterm exam mark and Final exam mark

The application result is to produce the GPA and Grade in this subject. The following 
table describe the values of each case:

| Mark Range        | GPA   | Grade |
|-------------------|-------|-------|
| >= 97 and <= 100  | 4.0   | A+    |
| >= 93 and < 97    | 4.0   | A     |
| >= 89 and < 93    | 3.7   | A-    |
| >= 84 and < 89    | 3.3   | B+    |
| >= 80 and < 84    | 3.0   | B     |
| >= 76 and < 80    | 2.7   | B-    |
| >= 73 and < 76    | 2.3   | C+    |
| >= 70 and < 73    | 2.0   | C     |
| >= 67 and < 70    | 1.7   | C-    |
| >= 64 and < 67    | 1.3   | D+    |
| >= 60 and < 64    | 1.0   | D     |
| < 60              | 0.0   | F     |


The output of this application is a file that contains in the first line of each page the 
Following: **“Subject Name:”** subject-name **“Max Mark:”** full mark 
The line after contains a hear of the table which is:
**Student name** **Student number** **GPA** **Grade**
Teach of the following lines contains the name student, its number, GPA and Grade 
separated by space. 

## Project requirements

1. Build the described application using JAVA. Make sure to validate that each of the 
input is fulfilling the requirement before any processing.
2. You need to test each unit of your application separately. 
3. White box, data flow and black bock testing are required 
4. Integration testing is required as well
