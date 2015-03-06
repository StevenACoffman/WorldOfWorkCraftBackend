//Use Chrome to drop and drag CQL file to Neo4J. Otherwise, copy and paste.
//Clean all the nodes and the relationships in database. 
OPTIONAL MATCH (a)
WITH a
LIMIT 10000
OPTIONAL MATCH (a)-[r]-()
DELETE a,r

//-----------Bugs Bunny
create (bunny:Learner:_Learner {uniqname:"bbunny", name:"Bugs Bunny"})
//-----------Create Challenge for Bugs Bunny
With 1 as dummy
match (bunny:Learner {uniqname:"bbunny"}) create (c:Challenge:_Challenge {name:"Neo4j Challenge", endDate:"04/01/2016"}) create (bunny)-[:ACCEPT]->(c)
//-----------Create Achievements for Bugs Bunny
with 1 as dummy
match (bunny:Learner {uniqname:"bbunny"}) create (a:Achievement:_Achievement {name:"Cypher", point:5}) create (bunny)-[:LEARN]->(a)
with 1 as dummy
match (bunny:Learner {uniqname:"bbunny"}) create (a:Achievement:_Achievement {name:"Install Brew", point:10}) create (bunny)-[:APPLY]->(a)
with 1 as dummy
match (bunny:Learner {uniqname:"bbunny"}) create (a:Achievement:_Achievement {name:"lynda.com", point:5}) create (bunny)-[:LEARN]->(a) 
with 1 as dummy
match (bunny:Learner {uniqname:"bbunny"}) create (a:Achievement:_Achievement {name:"Data Modeling", point:20}) create (bunny)-[:TEACH]->(a)

//-----------Daffy Duck
create (duck:Learner:_Learner {uniqname:"dduck", name:"Daffy Duck"})
//-----------Create challenge for Daffy Duck 
with 1 as dummy
match (duck:Learner {uniqname:"dduck"}) match (c:Challenge {name:"Neo4j Challenge"}) create (duck)-[:ACCEPT]->(c)
//-----------Create Achievement for Daffy Duck 
with 1 as dummy
match (duck:Learner {uniqname:"dduck"}) match (a:Achievement {name:"Cypher"}) create (duck)-[:LEARN]->(a)

//-----------Elmer Fudd
create (fudd:Learner:_Learner {uniqname:"efudd", name:"Elmer Fudd"})
//-----------Create challenge for Elmer Fudd 
with 1 as dummy
match (fudd:Learner {uniqname:"efudd"}) match (c:Challenge {name:"Neo4j Challenge"}) create (fudd)-[:ACCEPT]->(c)
//-----------Create achievements for Elmer Fudd 
with 1 as dummy
match (fudd:Learner {uniqname:"efudd"}) match (a:Achievement {name:"Install Brew"}) create (fudd)-[:APPLY]->(a)
with 1 as dummy
match (fudd:Learner {uniqname:"efudd"}) create (a:Achievement:_Achievement {name:"Share Google Doc", point:5}) create (fudd)-[:LEARN]->(a)

//-----------Create Hackathon Badge
create (b:Badge:_Badge {name:"Hackathon", requiresCount:3})

//-----------Create Achievements
create (join:Achievement:_Achievement {name:"Join a Team",points:10})
create (stay:Achievement:_Achievement {name:"Stay up late",points:30})
create (moment:Achievement:_Achievement {name:"Have a moment of despair",points:20})

//-----------Create achievement for the badge
with 1 as dummy
match (b:Badge {name:"Hackathon"}) match (a:Achievement {name:"Join a Team"}) create (b)-[:REQUIRES]->(a)
with 1 as dummy
match (b:Badge {name:"Hackathon"}) match (a:Achievement {name:"Stay up late"}) create (b)-[:REQUIRES]->(a)
with 1 as dummy
match (b:Badge {name:"Hackathon"}) match (a:Achievement {name:"Have a moment of despair"}) create (b)-[:REQUIRES]->(a)

//-----------A learner finished all 3 achievement for hackathon badge
with 1 as dummy
match (l:Learner {uniqname:"bbunny"}) match (a:Achievement {name:"Join a Team"}) create (l)-[:LEARN]->(a)
with 1 as dummy
match (l:Learner {uniqname:"bbunny"}) match (a:Achievement {name:"Stay up late"}) create (l)-[:LEARN]->(a)
with 1 as dummy
match (l:Learner {uniqname:"bbunny"}) match (a:Achievement {name:"Have a moment of despair"}) create (l)-[:LEARN]->(a)


