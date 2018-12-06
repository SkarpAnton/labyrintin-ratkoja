# Testaus

## Testikattavuus

Testikattavuus alkaa olla aika hyvä algoritmien ja tietorakenteiden suhteen. En tehnyt automaattisia testejä UI:lle, vaikka varmasti hyvä olisi sellaisetkin toteuttaa. Olen tosin toki testannut UI:ta manuaalisesti.

![Testikattavuus](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/Testikattavuus.png)

## Aikavaativuuksien arviointi

### Teoreettiset aikavaativuudet

Wikipedian mukaan satunnaisen Kruskalin algoritmin aikavaativuudeksi voitaisiin saavuttaa O(5 * mahdollisten seinien määrä) = O(20 * huoneiden määrä) = O(huoneiden määrä), mutta Union-Find implementaationi ei käyttänyt 'path compression:ia', joten todellinen teoreettinen aikavaativuus algoritmille on O(nlogn), mikä on sama kuin tira:n luentomat1200eriaalissa todettu arvo Kruskalin aikavaativuudelle.

Leveyshaun aikavaativuus on tunnetusti O(|V| + |E|) eli tässä tilanteessa O(huoneiden määrä + käytävien määrä) <= O(huoneiden määrä + 4 * huoneiden määrä) = O(huoneiden määrä). Leveyshaun implementaationi on aika klassinen, joten aikavaativuus luultavasti pätee. 


A* teoreettisen aikavaativuuden määrittely on kohtuu hankalaa, sillä se riippu heuristiikasta. Käytin koordinaattien erotusta 
(|yDestination - yCurrent| + |xDestination - xCurrent|)
heuristiikka funktiona. A* pitäisi olla yleensä nopeampi kuin leveyshaku.

### Aikavaativuuksien kokeellinen arviointi


![A* vs Leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/AStarVsBFS.png)
Testaus tukee päätelmää. 

Testaus näyttäisi tukevan oletustani, että A* on nopeampi kuin leveyshaku.

![Kruskal vs A* vs leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/KruskalVsAStarVsBFS.png)

Selvästi satunnainen Kruskal on ylivoimaisesti hitain algoritmeista. Epäilen, että toteutukseni ei saavuta algoritmin teoreettista  aikavaativuutta O(20 * ruutujen määrä).



