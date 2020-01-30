Run Server Restful using java8 >> java -jar rest.jar
Kill Port 8080 >>> lsof -n -i4TCP:8080 >>> kill -9 <PID>
To execute the Build provide the below Maven Goal:
clean verify serenity:aggregate

To execute Tagged tests, provide the goal as shown in the below format
clean verify -Dtags="apitestfeature:NEGATIVE,apitestfeature:SMOKE" serenity:aggregate