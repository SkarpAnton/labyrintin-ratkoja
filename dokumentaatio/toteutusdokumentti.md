# Toteutus

Tarkoituksena oli vertailla A* ja leveyshaun aikavaativuutta satunnaisten labyrinttien ratkaisussa. Labyrintin koko määritetään
käyttäjåän syötteen perusteella. Labyrintin muodostin satunnaisella
[Kruskalin algoritmilla](https://en.wikipedia.org/wiki/Maze_generation_algorithm). Muokkasin algoritmin muodostamaa labyrintin muodostamaa
labyrinttia poistamalla siitä seinä, koska halusin, että puussa olisi useampi oikea lyhyin polku. Wikipedian mukaan algoritmin 
aikavaativuus on O(5 * mahdollisten seinien määrä) = O(20 * ruutujen määrä) = O(ruutujen määrä). Omassa toteutksessani kruskal on ollut
ylivoimaisesti hitain kolmesta algoritmista, ehkä 20 vakiokerroin on suurempi kuin leveyshaun vakiokerroin.

Arvoin alkuruudun ja määränpään satubnnaisesti, tosin vaadin, että ruutujen etäisyys toisistaan on ainakin labyrintin sivun mittainen.


