set API_NAME=todo-list-backend
set API_VERSION=0.0.1
set API_PORT=8010
set IMAGE_NAME=%API_NAME%:%API_VERSION%
set CONTAINER_NAME=%API_NAME%-%API_VERSION%

copy ..\build\libs\*.jar .\
docker build -t %IMAGE_NAME% .

docker run --name %CONTAINER_NAME% -d -p %API_PORT%:8080 %IMAGE_NAME%