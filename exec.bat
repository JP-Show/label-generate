@echo off
setlocal enabledelayedexpansion

rem Defina a pasta de destino
set "pasta_destino=\\192.168.30.250\programas\Etiquetas"

rem Itera sobre todos os arquivos .txt no diretório atual
for %%F in (*.txt) do (
    rem Obtenha a data e hora atual no formato AAAAMMDD_HHMMSS
    for /f "tokens=1-3 delims=/. " %%a in ('date /t') do (set "data=%%c%%b%%a")
    for /f "tokens=1-2 delims=: " %%a in ('time /t') do (set "hora=%%a%%b")
    set "timestamp=!data!_!hora!"

    rem Verifique se o arquivo de saída já existe na pasta de destino
    if exist "%pasta_destino%\%%~nF.txt" (
        set "novo_nome=%%~nF_!timestamp!.txt"
    ) else (
        set "novo_nome=%%~nF.txt"
    )

    rem Copie o arquivo para a pasta de destino com o nome modificado
    copy "%%F" "%pasta_destino%\!novo_nome!"
)

java -jar geradorEtiqueta.jar