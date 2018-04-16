@echo off

::############################################################################################
:: This script was injected into hybrisserver.bat file. After every start(hybrisserver.bat), 
:: script will be copy local.properties file into a folder above of a hybris folder on one step as a copyLocal.properties.
:: All originall content of local.properties will be located locally only.
echo Denasale's script is executing
copy ..\..\config\local.properties ..\..\..\..\copyLocal.properties
::############################################################################################

setlocal

SET MODE=%1

IF  "%MODE%" == "" (
	SET MODE=run
)

IF "%1"=="debug" (
	SET _YWRAPPER_CONF=%~dp0tomcat/conf/wrapper-debug.conf
	SET MODE=run
)

IF "%1"=="minimal" (
	SET _YWRAPPER_CONF=%~dp0tomcat/conf/wrapper-minimal.conf
	SET MODE=run
)

IF "%1"=="jprofiler" (
	SET _YWRAPPER_CONF=%~dp0tomcat/conf/wrapper-jprofiler.conf
	SET MODE=run
)

IF "%1"=="" (
   set _YWRAPPER_CONF=%~dp0tomcat/conf/wrapper.conf
) 

IF "%1"=="-v" (
	call java -cp %~dps0tomcat\lib\catalina.jar org.apache.catalina.util.ServerInfo
	GOTO:EOF
)

call %~dps0tomcat\bin\catalina.bat %MODE%

endlocal

	
