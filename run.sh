java -jar eureka/target/webtgbot.qs.eureka-0.0.1-SNAPSHOT.jar &
sleep 10
java -jar bot/target/webtgbot.qs-0.0.1-SNAPSHOT.jar &
java -jar -Dserver.port=5000 processor/target/webtgbot.qs.processor-0.0.1-SNAPSHOT.jar &
java -jar -Dserver.port=5001 processor/target/webtgbot.qs.processor-0.0.1-SNAPSHOT.jar &
java -jar -Dserver.port=5002 processor/target/webtgbot.qs.processor-0.0.1-SNAPSHOT.jar &
java -jar -Dserver.port=5003 processor/target/webtgbot.qs.processor-0.0.1-SNAPSHOT.jar &
java -jar -Dserver.port=5004 processor/target/webtgbot.qs.processor-0.0.1-SNAPSHOT.jar &
sleep 180
ps ax | grep qs
