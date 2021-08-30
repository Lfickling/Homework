-- CS3810 - Principles of Database Systems - Spring 2021
-- Instructor: Thyago Mota
-- Description: job_skills database script
-- Student(s) Name(s): Sara White, Tj Virbick, Letitia Fickling

-- creating database jobSkills
CREATE DATABASE jobSkills;

USE jobSkills;

DROP TABLE IF EXISTS Positions;

-- create tables
CREATE TABLE Positions (
  id INT(5) NOT NULL PRIMARY KEY,
  positionTitle     VARCHAR(105)
);

CREATE TABLE Skills (
  id INT(5) NOT NULL PRIMARY KEY,
  skill            VARCHAR(105) 
);

CREATE TABLE PositionSkills (
  positionID INT(5) NOT NULL ,
  skillID INT(5) NOT NULL,
  PRIMARY KEY (positionID, skillID),
  FOREIGN KEY (positionID) REFERENCES Positions (id),
  FOREIGN KEY (skillID) REFERENCES Skills (id) 
);

--data access
CREATE USER 'job_skills';
CREATE USER 'job_skills_admin' IDENTIFIED BY '02468';

GRANT SELECT ON jobSkills.* TO 'job_skills';
GRANT ALL ON jobSkills.* TO 'job_skills_admin';

-- queries

-- a) what is the total number of job positions?
SELECT COUNT(*) as '# of job positions' FROM Positions ;

-- b) what is the total number of skills?
SELECT COUNT(*) as '# of skills' FROM Skills;

-- c) which job position titles have the word "database"?
SELECT positionTitle as 'Position Titles' 
FROM Positions 
WHERE positionTitle LIKE '%database%';

-- d) provide an alphabetical list of all job position titles that require "sql" or "mysql" as a skill.
SELECT A.positionTitle as 'Position Title', C.skill as 'skill' 
FROM Positions A INNER JOIN PositionSkills B ON A.id = B.positionID INNER JOIN Skills C ON B.skillID = C.id  
WHERE skill = 'sql' OR skill = 'mysql' ORDER BY A.positionTitle;

-- e) which skills "database analyst" like positions have that "database admin" like positions don't?
SET @data_analyst_id = (SELECT id FROM Positions WHERE positionTitle LIKE '%database analyst%');
SET @data_admin_id = (SELECT id FROM Positions WHERE positionTitle LIKE '%database admin%');

--SELECT A.skill as 'skills a database analyst needs that a database admin does not'
--FROM Skills A INNER JOIN PositionSkills B ON A.id = B.skillID
--WHERE B.positionID = @data_analyst_id 
--AND WHERE B.skillID NOT IN (SELECT skillID FROM PositionSkills WHERE positionID = @data_admin_id)
--ORDER BY A.skill;

SELECT DISTINCT A.skill as 'skills a database analyst needs that a database admin does not'
FROM Skills A INNER JOIN PositionSkills B ON A.id = B.skillID
WHERE B.positionID = @data_analyst_id OR B.positionID = @data_admin_id
ORDER BY A.skill;

-- f) list the top 20 skills required by job positions having the word "database" in their titles.
SELECT A.skill as 'Top 20 Skills for Database Positions' 
FROM Skills A INNER JOIN PositionSkills B ON A.id = B.skillID INNER JOIN Positions C ON B.positionID = C.id 
WHERE C.positionTitle LIKE '%database%' 
GROUP BY A.skill 
ORDER BY COUNT(A.skill) DESC
LIMIT 20;
