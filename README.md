# Logger
A java logger that should replace default System.Logger (java.util.logging.Logger)

Output scheme:
```log
[Name/LEVEL] message
```
# Usage
## Setup
Latest release <br>
[![](https://jitpack.io/v/PanJohnny/Logger.svg)](https://jitpack.io/#PanJohnny/Logger)
### Maven
Add this to your pom.xml and replace VERSION with the latest release tag
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
```xml
<dependency>
    <groupId>com.github.PanJohnny</groupId>
    <artifactId>Logger</artifactId>
    <version>VERSION</version>
</dependency>
```

### Gradle
Add this to your build.gradle and replace VERSION with the latest release tag
```gradle
    repositories {
        maven { url 'https://jitpack.io' }
    }
```
```gradle
    dependencies {
        implementation 'com.github.PanJohnny:Logger:VERSION'
    }
```

For more platforms look [on jitpack](https://jitpack.io/#PanJohnny/Logger).

## Snippet
```java
final System.Logger logger = System.getLogger("MyLogger");

logger.log(System.Logger.Level.INFO, "Hello, World!");
```

Expected output:
```log
[MyLogger/INFO] Hello, World!
```
