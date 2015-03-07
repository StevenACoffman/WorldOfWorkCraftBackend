# WorldOfWorkCraftBackend

This is the acompanying backend for the World Of WorkCraft from the 2015 University of Michigan "Hacks with Friends" Hackathon competition.


### Step 1: Install neo4j with homebrew

```bash
brew install neo4j
```
Step 2: Start neo4j
```bash
neo4j start
```
### Step 3: Connect to http://localhost:7474/browser/

### Step 4: You could do either:

1.  Copy and paste /WorldOfWorkCraftBackend/src/main/Cypher.cql source code then execute the code.\
    > ****OR****

2.  Download it as a file and drag and drop to the saved script section
    > (see screenshot below). You’ll need Chrome to do the drag and
    > drop. To execute, click on the play button next to “Use Chrome to
    > drop and drag….”


To view all the nodes and relationships, run:
```
match (l) return l;
```

### Step 5: install tomcat with homebrew

```bash
brew install tomcat
```

### Step 6: start tomcat

```bash
/usr/local/opt/tomcat/libexec/bin/startup.sh
```

### Step 7: build package

```bash
mvn clean install; mvn tomcat7:redeploy
```

### Test if things are working
Make GET REST request to
[http://localhost:8080/worldofworkcraft/challenges/bbunny](http://localhost:8080/worldofworkcraft/challenges/bbunny)


### Only if you need to start over:

**==Delete ==**

**--Delete everything**
```
MATCH (a)

WITH a

LIMIT 10000

OPTIONAL MATCH (a)-[r]-()

DELETE a,r

RETURN COUNT(\*)
```
**--Delete entity and relationship: Delete **Neo4j Challenge** entity
and its relationship**
```
match (c:Challenge {name:"Neo4j Challenge"})-[r]-() delete c,r;
```
