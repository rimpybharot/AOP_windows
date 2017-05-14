set echo off
for %%i in (*) do if not %%i == MyCode.java if not %%i == Tracer.aj del %%i
FOR /D %%i IN (*) DO RD /S /Q "%%i"


if %3.==. (
    echo No parameters have been provided
	copy %1\*.java .
	ajc -cp ".;..\lib\aspectjrt.jar;..\lib\aspectjtools.jar;..\lib\aspectjweaver.jar;..\lib\commons-io-2.4.jar;..\lib\org.aspectj.matcher.jar;..\lib\plantuml.jar"  -source 1.6 *.java *.aj
	java -cp ".;..\lib\aspectjrt.jar;..\lib\aspectjtools.jar;..\lib\aspectjweaver.jar;..\lib\commons-io-2.4.jar;..\lib\org.aspectj.matcher.jar;..\lib\plantuml.jar" MyCode %2
	start Sequence.png
	for %%i in (*) do if not %%i == MyCode.java if not %%i == Tracer.aj if not %%i == Sequence.png del %%i
	FOR /D %%i IN (*) DO RD /S /Q "%%i"
) else (
    mkdir %3
	copy %1\*.java %3\
	ajc -cp ".;..\lib\aspectjrt.jar;..\lib\aspectjtools.jar;..\lib\aspectjweaver.jar;..\lib\commons-io-2.4.jar;..\lib\org.aspectj.matcher.jar;..\lib\plantuml.jar"  -source 1.6 *.java *.aj %3\*
	java -cp ".;..\lib\aspectjrt.jar;..\lib\aspectjtools.jar;..\lib\aspectjweaver.jar;..\lib\commons-io-2.4.jar;..\lib\org.aspectj.matcher.jar;..\lib\plantuml.jar" MyCode %3.%2
	start Sequence.png
	for %%i in (*) do if not %%i == MyCode.java if not %%i == Tracer.aj if not %%i == Sequence.png del %%i
	FOR /D %%i IN (*) DO RD /S /Q "%%i"
)







