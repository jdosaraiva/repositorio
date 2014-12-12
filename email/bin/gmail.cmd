@echo off
cd C:\workspaces\JDOS\workspaceJDOS\repositorio\email\JavaSource
rem c:\jdk1.7.0_72\bin\javac -cp .;c:\javamail-1.4.7\mail.jar br\com\saraiva\utils\Gmail.java

c:\jdk1.7.0_72\bin\java -cp .;c:\javamail-1.4.7\mail.jar br.com.saraiva.utils.Gmail %1 %2 %3 %4 %5
cd C:\workspaces\JDOS\workspaceJDOS\repositorio\email\bin
