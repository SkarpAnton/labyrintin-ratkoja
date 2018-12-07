# Testaus


## Testikattavuus

Testikattavuus alkaa olla aika hyvä algoritmien ja tietorakenteiden suhteen. En tehnyt automaattisia testejä UI:lle, vaikka varmasti hyvä olisi sellaisetkin toteuttaa. Olen tosin toki testannut UI:ta manuaalisesti.

![Testikattavuus](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/Testikattavuus.png)


## Teoreettiset aikavaativuudet

Wikipedian mukaan satunnaisen Kruskalin algoritmin aikavaativuudeksi voitaisiin saavuttaa O(5 * mahdollisten seinien määrä) = O(20 * huoneiden määrä) = O(huoneiden määrä), mutta Union-Find implementaationi ei käyttänyt 'path compression:ia', joten todellinen teoreettinen aikavaativuus algoritmille on O(nlogn), mikä on sama kuin tira:n luentomat1200eriaalissa todettu arvo Kruskalin aikavaativuudelle.

Leveyshaun aikavaativuus on tunnetusti O(|V| + |E|) eli tässä tilanteessa O(huoneiden määrä + käytävien määrä) <= O(huoneiden määrä + 4 * huoneiden määrä) = O(huoneiden määrä). Leveyshaun implementaationi on aika klassinen, joten aikavaativuus luultavasti pätee. 


A* teoreettisen aikavaativuuden määrittely on kohtuu hankalaa, sillä se riippu heuristiikasta. Käytin koordinaattien erotusta 
(|yDestination - yCurrent| + |xDestination - xCurrent|)
heuristiikka funktiona. A* pitäisi olla yleensä nopeampi kuin leveyshaku.

## Aikavaativuuksien kokeellinen arviointi

### Testien suoritus

#### ALgoritmien suorituksen mittaus

Algoritmeja testatiin eri huone määrillä. Huoneiden määrät määräytyivät huoneiden leveyden kautta. Huoneiden leveydet alkoivat sadasta ja loppuivat 3900 ja mittauksia otettiin 100 intervalleilla, täten huoneiden määrä on välillä [100, 15120000]. Jokaisella huone määrällä algoritmeja ajettin kymmenen kertaa, joista jokainen mitattiin yksilöllisesti. Ajoista otettiin keskiarvo, joita sitten käytin vertailussa. Ajat mitattiin sekunneissa.

Käytetty koodi:
      
      //Other stuff
            for (mazeWidth = 100; mazeWidth < 4000; mazeWidth += 100) {

               arrayofTimes = new AlgorithmTimes[10];
               for (int j = 0; j < 10; j++) {
                    times = new AlgorithmTimes();
                    RandomStartAndDestination randomStartAndDestination
                            = new RandomStartAndDestination(mazeWidth);
                    start = randomStartAndDestination.getStart();
                    destination = randomStartAndDestination.getDestination();
                    timeRandomKruskal();
                    timeAStar();
                    timeBfs();
                    arrayofTimes[j] = times;
                }

                writeTimesToFile();
            }
      //Other Stuff      
            
    private static void timeRandomKruskal() {
        long startTime = System.nanoTime();
        maze = RandomKruskal.createMaze(mazeWidth);
        long endTime = System.nanoTime();
        times.setKruskalTime((endTime - startTime) / 1000000000.0);
    }

    private static void timeAStar() {
        long startTime = System.nanoTime();
        SearchAlgorithms.aStar(start, destination, maze, mazeWidth);
        long endTime = System.nanoTime();
        times.setaStarTime((endTime - startTime) / 1000000000.0);

    }

    private static void timeBfs() {
        long startTime = System.nanoTime();
        SearchAlgorithms.breadthFirstSearch(start, destination, maze, mazeWidth);
        long endTime = System.nanoTime();
        times.setBfsTime((endTime - startTime) / 1000000000.0);
    }




### Testien tulokset
![Leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/Leveyshaku.png)
![A*](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/AStar.png)
![A* vs Leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/AStar_vs_Leveyshaku.png)
![Kaydyt huoneet](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/K%C3%A4ydyt_huoneet.png)
![Kruskal](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/Kruskal.png)
![O(n^2) vs Kruskal](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/O(n%5E2)_vs_Kruskal.png)
Testaus tukee päätelmää. 

Testaus näyttäisi tukevan oletustani, että A* on nopeampi kuin leveyshaku.

![Kruskal vs A* vs leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/SatunnainenKruskal_vs_AStar_vs_Leveyshaku.png)

Selvästi satunnainen Kruskal on ylivoimaisesti hitain algoritmeista. Epäilen, että toteutukseni ei saavuta algoritmin teoreettista  aikavaativuutta O(20 * ruutujen määrä).



