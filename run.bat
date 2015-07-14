@ECHO OFF
set JAVA_HOME="C:\Program Files\Java\jdk1.8.0_45"
set PATH=C:\Windows;C:\Windows\System32;"C:\Program Files\Java\jdk1.8.0_45\bin\"
set CLASSPATH=D:\DataSite\DataSite\build\classes\datasite\

ECHO Compiling Java Classes
javac DataSite.java

ECHO Compiled Java Class
ECHO Running Java Class

ECHO Successfully ran Java Class

ECHO Compiling Java Classes
javac words_tweeted.java

ECHO Compiled Java Class
ECHO Running Java Class

ECHO Successfully ran Java Class

ECHO Compiling Java Classes
javac SortedUnique.java

ECHO Compiled Java Class
ECHO Running Java Class

ECHO Successfully ran Java Class

ECHO Compiling Java Classes
javac median_unique.java

ECHO Compiled Java Class
ECHO Running Java Class

ECHO Successfully ran Java Class
cmd


