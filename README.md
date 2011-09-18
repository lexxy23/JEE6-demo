# JEE6 Demo

A simple project to demonstrate the capabilities of JEE6, using Glassfish and JBoss AS 7.

## How to build

Add maven repository to your installation via your settings.xml:

    <profile>
      <id>awsDs2Profile</id>
      <repositories>
        <repository>
          <id>ds2.aws.ossrepo</id>
          <releases>
            <enabled>true</enabled>
          </releases>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
          <url>https://ds2mvn.s3.amazonaws.com/oss.rel</url>
        </repository>
      </repositories>
      <pluginRepositories>
        <pluginRepository>
          <id>ds2.aws.ossrepo</id>
          <releases>
            <enabled>true</enabled>
          </releases>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
          <url>https://ds2mvn.s3.amazonaws.com/oss.rel</url>
        </pluginRepository>
      </pluginRepositories>
    </profile>

This enables a specific maven profile called awsDs2Profile in your maven builds. By default it's deactivated.
On builds, you have to use

mvn clean install -PawsDs2Profile

That will use your default repositories, plus the one mentioned above.