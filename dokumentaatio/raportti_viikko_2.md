
##Viikkoraportti 2

Toteutin satunnaisen labyrintin muodostamisen ja sen tulostamisen näytölle. Labyrintin muodostamiseen käytin 
muokattua Kruskalin algoritmia, sillä se näytti olevan helpoin tapa muodostaa haluamani tapainen labyrintti. 

Määrittelydokumentissa ajattelin, että muodostaisin vieruslistan labyrintistä, mutta labyrinttia toteuttaessa 
tajusin, että labyrintti on sen verran kiemurteleva, että solmuja olisi melkein yhtä paljon kuin labyrintissä 
on ruutuja. Täten käytän verkkona muodostettua labyrinttiä. Huono puoli tässä on, että kaikkien kaarien 
kaarien painot ovat yhtä suuria, joten Djikstran algoritmi on tässä verkossa vain yksinkertaisesti leveyshaku. 
Tietorakenteiden määrä ei tosin vähenny sillä A* käyttää edelleen kekoa ja hajautustaulua, ja itseasiassa 
minun pitää lisäksi toteuttaa leveyshakua varten jono-tietorakenne.

Seuraavaksi ajattelin tehdä reitinhaun javan olemassaolevilla tietorakenteilla.

10h

