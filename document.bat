@echo off
del /f /s /q docs 
javadoc -d docs\ -use com.github.vulpine
javadoc -d docs\ -use com.github.vulpine.json
pause