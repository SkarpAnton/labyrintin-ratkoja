# Määrittely

Ajatuksena olisi muodostaa satunnaisia labyrintteja, joiden lyhimmän polun alusta maaliin 

etsimiseen voisi sitten käyttää A*:ia ja Djikstraa. Läpikäyntien nopeutta voitaisiin käyttää sitten 

A-star:in ja Djikstran vertailussa.  A*:in heuristiikkana käytän yksinkertaisesti euklidista pituutta, 

sillä se on helppo laskea ja koska se ei ikinä yliarvio pituutta, mikä takaa vastauksen oikeuden.


Algoritmit käyttäisivät tietorakenteita kekoa, hajautustaulua ja linkitettyä listaa. Keko 

toteutuksessani olisi vain poisto ja lisäys, täten keossa olevien pituuksien päivitys tehdään 

lisäämällä päivitetty olio kekoon ja tarkastamalla jokaiselle keosta poistetulle arvolle, että niitä ei 

ole poistettu aikaisemmin keosta. Tarkastukseen käytän jonkinlaista hajautustaulua. Linkitettyä 

listaa ajattelin käyttää hajautustaulun toteutuksessa ja lisäksi käyttäisin sitä vieruslistoissa.


Keko toteutukseni olisi melko samanlainen kuin Tira:sta opittu. Djikstra on saman kaltainen kuin 

Tira:n ja täten voisi olettaa että aikavaativuus olisi samaa luokkaa eli O((|V|+|E|)log(|V|). 

Periaatteessa aikavaativuus voisi olla suurempi, jos toteutan hajautustaulun erityisen huonosti. 

A*:in aikavaativuuden määrittäminen ei ole kovin helppoa, sillä se riippuu paljolti heuristiikan 

valinnasta. Olettaisin, että A*, euklidisella pituudella toteutettuna, olisi keskimäärin 

huomattavasti nopeampi kuin Djikstra. Pahimman tapauksen aikavaativuus olisi varmaan

 algoritmeilla samaa luokkaa. Keko toteutukseni ei tue keon arvojen päivitystä, täten 
tilavaativuus on molemmille algoritmeille O(|V| + |E|).

