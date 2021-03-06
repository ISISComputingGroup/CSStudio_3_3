@echo off
set LOCINSTALLDIR=%CD%\CSStudio_P2_3_3_10\
set MAVENDIR=%CD%\mvn_repo\

REM If Jenkins need to set path
if not "%~1" == "" (
    if "%~1" == "jenkins" (
        @echo Setting to JENKINS build 
        set M2=C:\Program Files\Apache Software Foundation\apache-maven-3.2.2\bin\
        set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_13\
        set "PATH=%M2%;%JAVA_HOME%;%PATH%"
    )
)

REM make install dir
mkdir %LOCINSTALLDIR%

REM make repo dir
mkdir %MAVENDIR%

REM build it
REM call mvn -f cs-studio-3.3.x\applications\pom.xml org.eclipse.tycho:tycho-versions-plugin:update-pom -Dtycho.mode=maven
call mvn --settings=%CD%\mvn_user_settings.xml -Dmaven.repo.local=%MAVENDIR% -Dcsstudio.local.repo=%LOCINSTALLDIR% -f cs-studio-3.3.x\applications\pom.xml clean verify
if %errorlevel% neq 0 exit /b %errorlevel%