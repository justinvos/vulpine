@echo off
del /f /s /q docs 
javadoc -d docs\ -use github.vulpine
javadoc -d docs\ -use github.vulpine.binary
javadoc -d docs\ -use github.vulpine.json
javadoc -d docs\ -use github.vulpine.xml
pause