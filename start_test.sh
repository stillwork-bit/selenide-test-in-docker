#!/bin/sh


#echo "check hub is ready"
#while ["$( curl -s http://localhost:4444/wd/hub/status | jq -r .value.ready )" != "true"]
#
#echo "Выполняю проверку статуса"
#do
#  sleep 1
#done

echo "Selenoid доступен, запускам тесты"
mvn clean test