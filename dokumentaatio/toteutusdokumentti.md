# Toteutus

## Määritelmä

Tarkoituksena oli vertailla A* ja leveyshaun aikavaativuutta satunnaisten labyrinttien ratkaisussa. Labyrintin koko määritetään
käyttäjän syötteen perusteella. 

## Satunnaisen labyrintin muodostus

Labyrintin muodostin satunnaisella Kruskalin algoritmilla. Satunnainen Kruskalin algoritmi lisää satunnaisesti labyrintin käytäviä, jotka yhdistävät huoneet, joista ei ole polkua toisiinsa. Huoneiden yhteydet tarkistetaan Union-Find tietorakenteen avulla. Käytäviä lisätään, kunnes jokaisesta huoneesta on polku jokaiseen huoneeseen (verkko on yhtenäinen). Muokkasin lopuksi algoritmin muodostamaa labyrinttia poistamalla siitä seiniä, koska halusin, että puussa olisi useampi mahdollinen lyhin polku. 

## Alku ja määränpää

Arvoin alkuhuoneen ja määränpään satunnaisesti, tosin vaadin, että ruutujen euklidinen etäisyys toisistaan on ainakin labyrintin sivun mittainen. 

## A*

### Implementaatio

Toteutin melko klassisen A* hakualgoritmin, joka käytti keko tietorakennetta. Toteutin vain poisto ja lisäys toiminnot kekoon. 

### Kustannusfunktio 

Kustannusfunktio on (matka huoneeseen + heuristiikka funktio). Käytin koordinaattien erotusta 
(|yDestination - yCurrent| + |xDestination - xCurrent|)
heuristiikka funktiona. Koordinaattien erotus ei ikinä yliarvio jäljelle jäävä pituutta, koska labyrintti on vain taulukko, jossa ruudusta voi kulkea vain ruutuihin, jotka jakavat sivun ruudun kanssa. Siirtymillä ei ole myöskään painoja, täten yksi nopeimmista reiteistä on mennä yksinkertaisesti x koordinaattien erotus ensin ja sitten y koordinaattien erotus. 

## Leveyshaku

Toteutin klassisen leveyshaun, mikä käytti jono tietorakennetta. 

## UI

Ohjelma muodostaa kuvan labyrintista, jonka huoneet on merkattu eri värisillä merkeillä. Sininen merkki merkkaa alkuhuonetta ja punainen määränpää huonetta. Vihreä merkki merkkaa huoneita, jotka ovat osa lyhintä polkua alkuhuoneen ja määränpään välillä, jonka A* tai leveyshaku löysi. Keltainen merkki kuvaa ruutua, jossa molemmat A* ja leveyshaku on käynyt. Magenta merkki kuvaa ruutua, jossa vain leveyshaku on käynyt, vastaavasti syaani kuvaa ruutuja, jossa vain A* on käynyt.


Tietorakenteet ja algoritmit luentomateriaali, kevät 2018, Jyrki Kivinen
[Kruskalin algoritmi](https://en.wikipedia.org/wiki/Maze_generation_algorithm)

