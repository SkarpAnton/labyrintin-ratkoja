# Testaus

## Testikattavuus

Testikattavuus alkaa olla aika hyvä algoritmien ja tietorakenteiden suhteen. En tehnyt automaattisia testejä UI:lle, vaikka varmasti hyvä olisi sellaisetkin topteuttaa. Olen tosin toki testannut UI:ta manuaalisesti.

![Testikattavuus](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/Testikattavuus.png)

## Aikavaativuuksien arviointi

### Teoreettiset aikavaativuudet

Wikipedian mukaan satunnaisen Kruskalin algoritmin aikavaativuus on O(5 * mahdollisten seinien määrä) = O(20 * ruutujen määrä) = O(ruutujen määrä). 

Leveyshaun aikavaativuus on tunnetusti O(|V| + |E|) eli tässä tilanteessa O(ruutujen määrä + käytävien määrä). 


A* teoreettisen aikavaativuuden määrittely on kohtuu hankalaa, sillä se riippu heuristiikasta. Käytin koordinaattien erotusta 
(|yDestination - yCurrent| + |xDestination - xCurrent|)
heuristiikka funktiona. A* pitäisi olla nopeampi kuin leveyshaku.

### Aikavaativuuksien kokeellinen arviointi


![A* vs Leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/AStarVsBFS.png)

Levyshaun implementaationi on aika klassinen, joten aikavaativuus luultavasti pätee. Testaus tukee päätelmää. 

Testaus näyttäisi tukevan oletustani, että A* on nopeampi kuin leveyshaku.

![Kruskal vs A* vs leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/KruskalVsAStarVsBFS.png)

Selvästi satunnainen Kruskal on ylivoimaisesti hitain algoritmeista. Epäilen, että toteutukseni ei saavuta algoritmin teoreettista  aikavaativutta O(20 * ruutujen määrä).



