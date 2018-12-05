# Testaus

## Testikattavuus

Testikattavuus alkaa olla aika hyvä algoritmien ja tietorakenteiden suhteen. En tehnyt automaattisia testejä UI:lle, vaikka varmasti hyvä olisi sellaisetkin topteuttaa. Olen tosin toki testannut UI:ta manuaalisesti.

![Testikattavuus](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/Testikattavuus.png)

## Aikavaativuuksien arviointi

### Teoreettiset aikavaativuudet

Wikipedian mukaan satunnaisen Kruskalin algoritmin aikavaativuus on O(5 * mahdollisten seinien määrä) = O(20 * ruutujen määrä) = O(ruutujen määrä). Omassa toteuksessani Kruskal on ollut ylivoimaisesti hitain kolmesta algoritmista, epäilen että toteutukseni ei saavuta kyseistä aikavaativuutta.

Leveyshaun aikavaativuus on tunnetusti O(|V| + |E|) eli tässä tilanteessa O(ruutujen määrä + käytävien määrä). 
Implementaationi on aika klassinen leveyshaku, joten aikavaativuus luultavasti pätee.

A* teoreettisen aikavaativuuden määrittely on kohtuu hankalaa, sillä se riippu heuristiikasta. Käytin koordinaattien erotusta 
(|yDestination - yCurrent| + |xDestination - xCurrent|)
heuristiikka funktiona.

### Aikavaativuuksien kokeellinen arviointi



![A* vs Leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/AStarVsBFS.png)


![Kruskal vs A* vs leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/KruskalVsAStarVsBFS.png)


