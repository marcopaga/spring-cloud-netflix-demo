# Eureka Service directory

The setup here will run a single eureka instance for development purposes. Make sure to run multiple instances when you deploy it to production. 
Clients keep a local cache of the directory structure to improve performance so you won't see instant feedback if you kill a service. This is not a bug ;) .

## Health

The registered services will regularly send heartbeat messages to the eureka server. If eureka receives these messages the client is marked as up.
The heartbeat message is sent every 30 seconds by default. A service is not available for discovery by clients until the instance, the server and the client all have the same metadata in their local cache (so it could take 3 heartbeats).