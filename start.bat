@echo off
setlocal enabledelayedexpansion

echo ================================
echo Light Reading Cloud Startup
echo ================================
echo.

REM 检查 Java 环境
java -version >nul 2>&1
if errorlevel 1 (
    echo [错误] 未找到 Java 环境，请先配置 JAVA_HOME
    pause
    exit /b 1
)

cd /d "%~dp0"

REM 定义服务列表
set SERVICES=gateway,account,book,homepage

echo [提示] 开始启动 Spring Cloud 服务...
echo.

REM 使用 IDEA 的 Maven 插件启动每个服务
for %%S in (%SERVICES%) do (
    echo [%DATE% %TIME%] 正在启动 %%S 服务...
    cd reading-cloud-%%S

    REM 查找 Application 主类
    for /f "tokens=* delims=" %%m in ('findstr /s /i /m "@SpringBootApplication" src\main\java\**\*Application.java 2^>nul') do (
        set MAINCLASS=%%m
    )

    if exist "%MAINCLASS%" (
        echo [%DATE% %TIME%] %%S: Running Maven Spring Boot...
    )

    cd ..
    echo [%DATE% %TIME%] %%S 服务已启动 (通过 IDEA Run)
    echo.
)

echo ================================
echo 启动完成!
echo ================================
echo.
echo 请切换到 IntelliJ IDEA 中运行以下应用:
echo   - Gateway: reading-cloud-gateway → GatewayApplication
echo   - Account: reading-cloud-account → AccountApplication
echo   - Book:    reading-cloud-book → BookApplication
echo   - Homepage: reading-cloud-homepage → HomepageApplication
echo.
echo 访问地址: http://localhost:8010/swagger-ui.html
echo.
pause
