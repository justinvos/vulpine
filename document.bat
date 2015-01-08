@echo off
del /f /s /q docs 
javadoc -d docs\ -use com.github.vulpinejson
pause