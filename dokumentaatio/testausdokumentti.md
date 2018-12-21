# Testaus

### Yksikkö- ja integraatiotestaus

#### Logiikka

Yritin sanallisesti kuvailla tekemiäni testien rakennetta, mutta melkein on vain helpompaa lukea alkuperäistä koodia, testien nimet ovat josaain määrin kuvaavia ja testit eivät ole kovin monimutkaisia. 

Yksikkötestit löytyy: [testit](https://github.com/SkarpAnton/labyrintin-ratkoja/tree/master/MazeSolver/src/test/java/tests/junit)

#### Käyttöjliittymä

En tehnyt automaattisia testejä käyttöliittymälle, vaikka varmasti hyvä olisi sellaisetkin toteuttaa.

#### Testikattavuus

Jos käyttöliittymää ei huomioi niin testikattavuus on hyvä. Rivikattavuus on 97% ja haaraumakattavuus on 100%.  

![Testikattavuus](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/Testikattavuus.png)

### Järjestelmätestaus

Toteutetettu manuaalisesti

#### Asennus ja konfigurointi

Sovellus ei sisällä oikeastaan konfigurointia, jar:in pitäisi sisältää kaikki tarvittava tieto. Tietokannan on testattu toimivan ladatulla jar tiedostolla.

#### Käyttäjien syöte

Syötteet tarkistetaan ohjelmassa ja olen testannut syöttää vääriä syötteitä.
Käyttäjän syötettä käytetään ohjelmassa hyvin vähän, syötteitä käytetään vain huoneiden määrän ja kuvan koon valintaan, joten tarkastus oli helppoa.

## Teoreettiset aikavaativuudet

Wikipedian mukaan satunnaisen Kruskalin algoritmin aikavaativuudeksi voitaisiin saavuttaa O(5 * mahdollisten seinien määrä) = O(20 * huoneiden määrä) = O(huoneiden määrä), mutta Union-Find implementaationi ei käyttänyt 'path compression:ia', joten todellinen teoreettinen aikavaativuus algoritmille on O(nlogn), mikä on sama kuin tira:n luentomateriaalissa todettu arvo Kruskalin aikavaativuudelle.

Leveyshaun aikavaativuus on tunnetusti O(|V| + |E|) eli tässä tilanteessa O(huoneiden määrä + käytävien määrä) <= O(huoneiden määrä + 4 * huoneiden määrä) = O(huoneiden määrä). Leveyshaun implementaationi on aika klassinen, joten aikavaativuus luultavasti pätee. 


A* teoreettisen aikavaativuuden määrittely on kohtuu hankalaa, sillä se riippu heuristiikasta. Käytin koordinaattien erotusta 
(|yDestination - yCurrent| + |xDestination - xCurrent|)
heuristiikka funktiona. A* pitäisi olla yleensä nopeampi kuin leveyshaku.

A* on riippuvainen keon lisäys ja posto operaatioista. Toteutukseni toimenpiteistä pitäisi olla aikavaativuudeltaan O(logn).

## Aikavaativuuksien kokeellinen arviointi

### Välineistö

Testit ajettiin seuraavanlaisella koneella:

Käyttöjärjestelmä: Windows 10 Home

CPU: i5-4690k

GPU: NVIDIA GeForce GTX 980

Ram: 16 gb

Taustalla oli luultavasti erinäisiä ohjelmia.

### Testien suoritus


Algoritmeja testatiin eri huone määrillä. Huoneiden määrät määräytyivät labyrintin sivulla olevien huoneiden määrän kautta. Huoneiden määrät sivulla alkoivat sadasta ja loppuivat 3900 ja mittauksia otettiin 100 intervalleilla, täten huoneiden määrä on välillä [10000, 15120000]. Jokaisella huone määrällä algoritmeja ajettin kymmenen kertaa, joista jokainen mitattiin yksilöllisesti. Ajoista otettiin keskiarvo, joita sitten käytin vertailussa. Ajat mitattiin sekunneissa.

Mittasin lisäksi vertalukohdaksi triviaalit O(n), O(nlogn) ja O(n^2) algoritmit.

Käytetty koodi: [suorituskykytestaus](https://github.com/SkarpAnton/labyrintin-ratkoja/tree/master/MazeSolver/src/test/java/tests/performance)


### Testien tulokset

Raaka data: [suoritus ajat](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/suoritusajat.md)

#### Leveyshaku

![Leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/Leveyshaku.png)

Leveyshaku näyttäisi olevan suurusluokaltaan teoreettisten aikavaativuuksien mukaisia.

#### A*

![A*](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/AStar.png)

A* nopeus lähestyy vertailukohteena käyettyä triviaalia O(n) algoritmia.

#### A* vs leveyshaku

![A* vs Leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/AStar_vs_Leveyshaku.png)

Testit tukevat oletusta, että A* on nopeampi kuin leveyshaku. 

![Kaydyt huoneet](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/K%C3%A4ydyt_huoneet.png)

Aikaero tulee selvästi siitä, että A* käy yksinkertaisesti vähemmässä määrässä huoneita.

#### Kruskal

![Kruskal](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/Kruskal.png)

Kruskalin toteutukseni näyttäisi olevan suhteellisen hidas. Algoritmi on merkittävästi hitaampi, kuin triviaali O(nlogn) algoritmi. 

#### Kruskal vs A* vs leveyshaku

![Kruskal vs A* vs leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/SatunnainenKruskal_vs_AStar_vs_Leveyshaku.png)

Kruskalin algoritmi on selvästi ohjelmani pullonkaula.

#### Kruskal vs O(n^2)

![O(n^2) vs Kruskal](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/O(n%5E2)_vs_Kruskal.png)

Vaikka Kruskal vaikuttaa hitaalta niin on se silti merkittävästi tehokkaampi, kuin O(n^2) algoritmi. Huone määrä on testissä paljon pienempi, koska testien suorittaminen alkoi kestää liian kauan suuremilla huone määrillä.


## Lähteet

Tietorakenteet ja algoritmit luentomateriaali, kevät 2018, Jyrki Kivinen

[Satunnainen Kruskalin algoritmi Wikipedia](https://en.wikipedia.org/wiki/Maze_generation_algorithm#Randomized_Kruskal's_algorithm)

Graafit tehtiin [plot.ly](https://plot.ly/create/) avulla









