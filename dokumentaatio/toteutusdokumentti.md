# Toteutus

Tarkoituksena oli vertailla A* ja leveyshaun aikavaativuutta satunnaisten labyrinttien ratkaisussa. Labyrintin koko määritetään
käyttäjän syötteen perusteella. Labyrintin muodostin satunnaisella
[Kruskalin algoritmilla](https://en.wikipedia.org/wiki/Maze_generation_algorithm). Muokkasin algoritmin muodostamaa labyrinttia poistamalla siitä seiniä, koska halusin, että puussa olisi useampi mahdollinen lyhin polku. Wikipedian mukaan algoritmin 
aikavaativuus on O(5 * mahdollisten seinien määrä) = O(20 * ruutujen määrä) = O(ruutujen määrä).

Omassa toteuksessani Kruskal on ollut
ylivoimaisesti hitain kolmesta algoritmista, ehkä 20 vakiokerroin on suurempi kuin leveyshaun vakiokerroin.

Arvoin alkuruudun ja määränpään satunnaisesti, tosin vaadin, että ruutujen etäisyys toisistaan on ainakin labyrintin sivun mittainen. 
Leveyshaun aikavaativuus on tunnetusti O(|V| + |E|) eli tässä tilanteessa O(ruutujen määrä + käytävien määrä). 

Implementaationi on aika klassinen leveyshaku, joten aikavaativuus luultavasti pätee.

A* aikavaativuuden määrittely on kohtuu hankalaa, sillä se riippu heuristiikasta. Käytin koordinaattien erotusta 
(|yDestination - yCurrent| + |xDestination - xCurrent|)
heuristiikkana. Koordinaattien erotus ei ikinä yliarvio jäljelle jäävä pituutta, koska labyrintti on vain taulukko, jossa ruudusta voi kulkea vain ruutuihin, jotka jakavat sivun ruudun kanssa. Siirtymillä ei ole myöskään painoja, täten yksi nopeimmista reiteistä on mennä yksinkertaisesti x koordinaattien erotus ensin ja sitten y koordinaattien erotus. A* käy huomattavasti vähemmässä määrässä ruutuja keskimäärin kuin leveyshaku perustuen siihen, että kun ajaa projektin niin on lähes aina vähemmän syaanin värisiä merkkejä kuin magentan värisiä merkkejä tulostetussa kuvassa. 


Tietorakenteet ja algoritmit luentomateriaali, kevät 2018, Jyrki Kivinen
https://en.wikipedia.org/wiki/Maze_generation_algorithm

