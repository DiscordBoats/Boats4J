# DEPRECATED
The website this module is for has shutdown.

[![Build Status](https://travis-ci.org/DiscordBoats/Boats4J.svg?branch=master)](https://travis-ci.org/DiscordBoats/Boats4J)
[![Download](https://api.bintray.com/packages/discordboats/Boats4J/Boats4J/images/download.svg) ](https://bintray.com/discordboats/Boats4J/Boats4J/_latestVersion)

# Boats4J
Discord Boats' Official Java API Wrapper

# Adding To Your Project
In Gradle:

```gradle
repositories {
  jcenter()
}
dependencies {
  compile 'xyz.discordboats:Boats4J:1.0.2'
}
```
In Maven:
```XML
 <dependency>
  <groupId>xyz.discordboats</groupId>
  <artifactId>Boats4J</artifactId>
  <version>1.0.2</version>
</dependency>
```
```XML
<repository>
    <id>jcenter</id>
    <name>jcenter-bintray</name>
    <url>http://jcenter.bintray.com</url>
</repository>
```

# Posting Stats
Boats4J can help you automatically post the server count by using the constructor with JDA:
```java
new Boats4J(jda, apiToken);
```
or
```java
new Boats4J(shardmanager, apiToken, botid) ;
```
Otherwise
```java
Boats4J bfourj = new Boats4J(ApiToken, botid);
bfourj.postStats(count); // count is a long!
```
# Posting Stats statically
If you do not want to create an instance you can post statically
```java
Boats4J.postStats(count, botid, token);
Boats4J.postStats(jda, token);
Boats4J.postStats(shardmanager, token);
```
# Getting Bot Info
You can easily get information about a bot
```java
BotInfo info = Boats4J.fetchBotInfo(id);
```
# Getting User Info
You can also get information about a user
```java
UserInfo info = Boats4J.fetchUserInfo(id);
```
