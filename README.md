# Transformers
We do love transforming... people, lives, teams, companies. And there’s no better
representation of transformation than Hasbro’s Transformers, the classic television series
featuring heroic Autobots raging their battle to destroy the evil forces of the Decepticons.
The Transformers are at war and you are in charge of settling the score! You’re to create an API
that evaluates who wins a fight between the Autobots and the Decepticons.
Please watch this video: https://www.youtube.com/watch?v=nLS2N9mHWaw

### Overview
The goal of the technical test is to create a RESTful API. Your API should allow the following
main functionality:
- Create a Transformer
- Update a Transformer
- Delete a Transformer
- List Transformers
- Given a list of Transformer IDs, determine the winning team

### Transformer definition:

Each Transformer has the following criteria (ranked from 1 to 10) on their tech spec:
- Strength
- Intelligence
- Speed
- Endurance
- Rank
- Courage
- Firepower
- Skill 
  
The “overall rating” of a Transformer is the following formula: (Strength +
Intelligence + Speed + Endurance + Firepower). Each Transformer must either be an
Autobot or a Decepticon.

### Determining the winning team:

Your API should take as input a list of Transformer IDs and based on input returns:
1. The number of battles
2. The winning team
3. The surviving members of the losing team

The basic rules of the battle are:
- The transformers are split into two teams based on if they are Autobots or Decepticons
- The teams should be sorted by rank and faced off one on one against each other in
order to determine a victor, the loser is eliminated.
- A battle between opponents uses the following rules:
1. If any fighter is down 4 or more points of courage and 3 or more points of
strength compared to their opponent, the opponent automatically wins the
face-off regardless of overall rating (opponent has ran away)
2. Otherwise, if one of the fighters is 3 or more points of skill above their opponent,
they win the fight regardless of overall rating
- The winner is the Transformer with the highest overall rating
- In the event of a tie, both Transformers are considered destroyed
- Any Transformers who don’t have a fight are skipped (i.e. if it’s a team of 2 vs. a team of
1, there’s only going to be one battle)
- The team who eliminated the largest number of the opposing team is the winner

### Special rules:
- Any Transformer named Optimus Prime or Predaking wins his fight automatically
regardless of any other criteria
- In the event either of the above face each other (or a duplicate of each other), the game
immediately ends with all competitors destroyed

### Example:
For example, given the following
input: Soundwave, D, 8,9,2,6,7,5,6,10 Bluestreak, A, 6,6,7,9,5,2,9,7 Hubcap:
A, 4,4,4,4,4,4,4,4

The output should be: 1 battle Winning team (Decepticons): Soundwave Survivors from the
losing team (Autobots): Hubcap

### Requirements:

- API must be RESTful
- Delivered as a Java web app (Spring boot or Spring mvc). This must be created in at
least Java 8
- The project must include unit tests (do not include integration tests)
- Short document explaining how to build and start the project. This Readme file should
show:
1. How to build and run the unit tests
2. How to run the application
Include the API endpoints used with example (JSON) payloads
3. Any assumptions or notes to the reviewer
- A list of default transformers is created on startup: at least 3 Autobots, 3 Decepticons
- The project must be uploaded onto GitHub and have descriptive commit messages
- Only an in memory data repository should be used

### Technology Stack
- Java 8
- Spring boot
- Swagger
- H2 DB
- Junit 5
- Gradle

### Build Command
- To build and run tests 
> gradle clean build

- To running the service
> gradle bootRun

### API Document
http://localhost:8080/swagger-ui/index.html

### Todo
- Improve and refactor tests: Using mocks for related beans and speed.
- Improve Score DataType rendering in Spring Fox.
