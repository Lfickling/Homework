--Flowers Project
--Authors: Sara White, Tj Virbick, Letitia Fickling

--Creating flowers database
CREATE DATABASE flowers;

USE flowers;

--Create Zones Table
CREATE TABLE Zones (
	id INT(2) AUTO_INCREMENT NOT NULL PRIMARY KEY,
	lowerTemp INT(3) NOT NULL,
	higherTemp INT(3) NOT NULL
);

ALTER TABLE Zones AUTO_INCREMENT = 2;

--Populating Zones
INSERT INTO Zones(lowerTemp, higherTemp)
VALUES(-50, -40);
INSERT INTO Zones(lowerTemp, higherTemp)
VALUES(-40, -30);
INSERT INTO Zones(lowerTemp, higherTemp)
VALUES(-30, -20);
INSERT INTO Zones(lowerTemp, higherTemp)
VALUES(-20, -10);
INSERT INTO Zones(lowerTemp, higherTemp)
VALUES(-10, 0);
INSERT INTO Zones(lowerTemp, higherTemp)
VALUES(0, 10);
INSERT INTO Zones(lowerTemp, higherTemp)
VALUES(10, 20);
INSERT INTO Zones(lowerTemp, higherTemp)
VALUES(20, 30);
INSERT INTO Zones(lowerTemp, higherTemp)
VALUES(30, 40);


--Creating Deliveries Tables
CREATE TABLE Deliveries (
	id INT(1) AUTO_INCREMENT NOT NULL PRIMARY KEY,
	categ CHAR(5) NOT NULL,
	delSize DECIMAL(5, 3) NULL
);


--Populating Deliveries
INSERT INTO Deliveries(categ, delSize)
VALUES('pot', 1.500);
INSERT INTO Deliveries(categ, delSize)
VALUES('pot', 2.250);
INSERT INTO Deliveries(categ, delSize)
VALUES('pot', 2.625);
INSERT INTO Deliveries(categ, delSize)
VALUES('pot', 4.250);
INSERT INTO Deliveries(categ, delSize)
VALUES('plant', NULL);
INSERT INTO Deliveries(categ, delSize)
VALUES('bulb', NULL);
INSERT INTO Deliveries(categ, delSize)
VALUES('hedge', 18.000);
INSERT INTO Deliveries(categ, delSize)
VALUES('shrub', 24.000);
INSERT INTO Deliveries(categ, delSize)
VALUES('tree', 36.000);


--Creating the FlowersInfo Table

CREATE TABLE FlowersInfo (
	id INT(3) AUTO_INCREMENT NOT NULL PRIMARY KEY,
	comName CHAR(30) NOT NULL,
	latName CHAR(35) NOT NULL,
	cZone INT(2) NOT NULL,
	hZone INT(2) NOT NULL,
	deliver INT(1) NOT NULL,
	sunNeeds CHAR(5) NOT NULL,
	FOREIGN KEY (cZone) REFERENCES Zones (id),
	FOREIGN KEY (hZone) REFERENCES Zones (id),
	FOREIGN KEY (deliver) REFERENCES Deliveries (id)
);

ALTER TABLE FlowersInfo AUTO_INCREMENT = 101;

--Populating FlowersInfo
INSERT INTO FlowersInfo(comName, latName, cZone, hZone, deliver, sunNeeds)
VALUES('Lady Fern', 'Atbyrium filix-femina', 2, 9, 5, 'SH');
INSERT INTO FlowersInfo(comName, latName, cZone, hZone, deliver, sunNeeds)
VALUES('Pink Caladiums', 'C.x bortulanum', 10, 10, 6, 'PtoSH');
INSERT INTO FlowersInfo(comName, latName, cZone, hZone, deliver, sunNeeds)
VALUES('Lily-of-the-Valley', 'Convallaria majalis', 2, 8, 5, 'PtoSH');
INSERT INTO FlowersInfo(comName, latName, cZone, hZone, deliver, sunNeeds)
VALUES('Purple Liatris', 'Liatris spicata', 3, 9, 6, 'StoP');
INSERT INTO FlowersInfo(comName, latName, cZone, hZone, deliver, sunNeeds)
VALUES('Black Eyed Susan', 'Rudbeckia fulgida var. specios', 4, 10, 2, 'StoP');
INSERT INTO FlowersInfo(comName, latName, cZone, hZone, deliver, sunNeeds)
VALUES('Nikko Blue Hydrangea', 'Hydrangea macrophylla', 5, 9, 4, 'StoSH');
INSERT INTO FlowersInfo(comName, latName, cZone, hZone, deliver, sunNeeds)
VALUES('Variegated Weigela', 'W. florida Variegata',4, 9, 8, 'StoP');
INSERT INTO FlowersInfo(comName, latName, cZone, hZone, deliver, sunNeeds)
VALUES('Lombardy Poplar', 'Populus nigra Italica', 3, 9, 9, 'S');
INSERT INTO FlowersInfo(comName, latName, cZone, hZone, deliver, sunNeeds)
VALUES('Purple Leaf Plum Hedge', 'Prunus x cistena', 2, 8, 7, 'S');
INSERT INTO FlowersInfo(comName, latName, cZone, hZone, deliver, sunNeeds)
VALUES('Thorndale Ivy', 'Hedera belix Thorndale', 3, 9, 1, 'StoSH');



-- a) the total number of zones.
SELECT COUNT(*) as '# of Zones' FROM Zones;

-- b) the number of flowers per cold zone.
SELECT cZone as 'Cold Zone', COUNT(cZone) as '# of Flowers' FROM FlowersInfo GROUP BY cZone ORDER BY cZone;

-- c) common names of the plants that have delivery sizes less than 5.
SELECT comName as 'Common Name' FROM FlowersInfo WHERE deliver < 5;

-- d) common names of the plants that require full sun (i.e., sun needs contains ‘S’).
SELECT comName as 'Common Name' FROM FlowersInfo WHERE sunNeeds = 'S';

-- e) all delivery category names order alphabetically (without repetition).
SELECT DISTINCT categ as 'Delivery Category' FROM Deliveries ORDER BY categ;

-- f) the exact output (see instructions)
SELECT A.comName as 'Name', B.lowerTemp as 'Cool Zone (low)', B.higherTemp as 'Cool Zone (high)', C.categ as 'Delivery Category' FROM FlowersInfo A INNER JOIN Zones B ON A.cZone = B.id INNER JOIN Deliveries C ON A.deliver = C.id ORDER BY A.comName;

-- g) plant names that have the same hot zone as “Pink Caladiums” (your solution MUST get the hot zone of “Pink Caladiums” in a variable).
SET @hz_pcal := (SELECT hZone FROM FlowersInfo WHERE comName = 'Pink Caladiums');
SELECT comName as 'Common Name' FROM FlowersInfo WHERE hZone = @hz_pcal;

-- h) the total number of plants, the minimum delivery size, the maximum delivery size, and the average size based on the plants that have delivery sizes (note that the average value should be rounded using two decimals).
SELECT count(*) as 'Total',min(Deliveries.delSize) as 'Min', max(Deliveries.delSize) as 'Max',FORMAT(avg(Deliveries.delSize),2) as 'Average' FROM FlowersInfo INNER JOIN  Deliveries ON FlowersInfo.deliver = Deliveries.id WHERE  Deliveries.delSize IS NOT NULL ;

-- i) the Latin name of the plant that has the word ‘Eyed’ in its name (you must use LIKE in this query to get full credit).  
SELECT latName as 'Latin Name' FROM FlowersInfo WHERE comName LIKE '%Eyed%';

-- j) the exact output (see instructions)
SELECT A.categ as 'Category', B.comName as 'Name' FROM Deliveries A IN

SELECT A.scott as 'scott', A.description as 'Stamp Description', B.description as 'Theme' FROM Stamps A INNER JOIN StampThemes C ON A.scott = C.scott INNER JOIN Themes B ON C.code = B.code ORDER BY B.description, A.scott;

SELECT code, COUNT(*) FROM StampThemes GROUP BY code;

SELECT COUNT(country) as '# of stamps issued by USA' FROM Stamps WHERE country = 'USA';

SELECT A.description as'Descriptions' FROM Stamps A ORDER BY A.description;

SELECT COUNT(*) as 'number per album' FROM Stamps A GROUP BY A.number;