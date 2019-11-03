![license](https://img.shields.io/github/license/MrIvanPlays/TeamTreesClient.svg?style=for-the-badge)
![issues](https://img.shields.io/github/issues/MrIvanPlays/TeamTreesClient.svg?style=for-the-badge)
[![support](https://img.shields.io/discord/493674712334073878.svg?colorB=Blue&logo=discord&label=Support&style=for-the-badge)](https://mrivanplays.com/discord)
![version](https://img.shields.io/maven-metadata/v?color=blue&label=latest%20version&metadataUrl=https%3A%2F%2Frepo.mrivanplays.com%2Frepository%2Fivan%2Fcom%2Fmrivanplays%2FTeamTreesClient%2Fmaven-metadata.xml&style=for-the-badge)

# TeamTreesClient

Client for retrieving information about team trees

Javadocs: https://mrivanplays.com/javadocs/TeamTreesClient/

## Installation

Using maven:

```xml
<repositories>
    <repository>
        <id>ivan</id>
        <url>https://repo.mrivanplays.com/repository/ivan/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.mrivanplays</groupId>
        <artifactId>TeamTreesClient</artifactId>
        <version>VERSION</version> <!-- Replace VERSION with latest version -->
        <scope>compile</scope>  
    </dependency>
</dependencies>
```

Using gradle:

```gradle
repositories {
    maven {
        url 'https://repo.mrivanplays.com/repository/ivan'
    }
}

dependencies {
    implementation group: 'com.mrivanplays', name: 'TeamTreesClient', version: 'VERSION' // Replace VERSION with latest version
}
```

## Usage
```java
TeamTreesClient client = new TeamTreesClient();
// sorry java newbies, no more information given
// figure it out yourself :P
```
