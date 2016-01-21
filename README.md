PMO-web
=============

Software of project management

Installation
-----------

```
Download the jboss-logging 3.3.0 Final
https://repository.jboss.org/nexus/content/groups/public/org/jboss/logging/jboss-logging/3.3.0.Final/jboss-logging-3.3.0.Final.jar

Install it into Glassfish's lib directory
glassfish-X.X\glassfishX\glassfish\lib
glassfish-X.X\glassfishX\glassfish\domains\domain1\lib
```

```
If you use Eclipse :

1) Implement the maven's dependencies :
Project properties > Deployment assembly > Add > Java Build Path Entries
Then choose "Maven Dependencies"

2) Change the JRE version used to 1.8
Project properties > Java Build Path
Click on the java library used, then click on Edit and choose "JRE System Library [JavaSE-1.8]"
```

Licence
------------

AdminLTE is an open source project by Almsaeed Studio that is licensed under MIT. Almsaeed Studio reserves the right to change the license of future releases.
