# tgbot-microservice-quickstart
This is a two services version of a telegram bot
### default ports:
#### 8087 - eureka
#### 8088 - processor
#### 8089 - bot
<p>Bot acts like a proxy. It responsible to:  </p>

* listen for telegram updates 
* send updates to processor 
* listen for new messages to send from processor 
* send messages from "/send" endpoint 

<p>Processor do all the job:  </p>

*  listens for bot updates 
*  dispatches update from bot 
*  grabs data from 3d party API 
*  stores data in DB if necessary 
*  Prepares message for bot to be sent 
*  sends messages to bots "/send" endpoint 


Eureka registry and discovery need to `bot` and `processor` could be discovered without configuration changes

### Local setup 

1. Run eureka service. You could build *.jar (recommended) or run it with idea. 
By default, it should be accessible at http://localhost:8087 . After startup open browser and verify eureka running  
1. Run bot service. Apply changes to application.properties file by updating bot.name and bot.token properties. 
   It's better to have it running in debug mode in Idea until you verify it stable. 
   Run serivce and open http://localhost:8087 make sure bot is registered. 
   Bot endpoint located at http://localhost:8089 
1. Run processor service. This is the main application service, so assumed it is under development and running in debug mode. 
   After startup the following endpoints will be available:
>1. http://localhost:8088/explorer/index.html#uri=/ - HAL BROWSER
>1. http://localhost:8088/swagger-ui/ - Api Documentation in swagger
>1. http://localhost:8088/h2-console - H2 database (no pass, just press "Connect" button)

To gain benefits of this configuration try the run.sh script configuration. <br />
Firstly, now you can process as many Updates as you want - it's only depends on resources available. <br />
Secondly, noe you can connect to a single processing algorithm as many different bots as you want: 
Telegram, Instagram, whatsapp, Viber, Slack ect.<br />

### No eureka setup
#### EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
<p>Eureka registry and discovery need to be updated regularly and sometimes between startups it could claim that 
instances are running when they are not. That is why for developing purpose you may want to disable eureka and let 
services communicate to each other directly. To do that </p>

1. Remove in both bot and processor dependency on eureka by deleting from pom.xml following lines:
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

1. in `bot/src/main/java/com/tutrit/qs/webtgbot/proxy/ProcessorProxy.java` add processor url like this:
   ```
    @FeignClient(name = "PROCESSOR", url = "http://localhost:8088")
   ```
1. in `processor/src/main/java/com/tutrit/qs/webtgbot/proxy/BotProxy.java` add bot url like this:
   ```
    @FeignClient(name = "bot", url = "http://localhost:8089")
   ```


