# Testaus

Testikattavuus alkaa olla aika hyvä algoritmien ja tietorakenteiden suhteen. En varmaan automaattisesti testaa ui:ta vaikka varmaan hyvä sellainenkin olisi toteuttaa. Ui:ta olen tosin testannut jonkin verran manuaalisesti.

[Testikattavuus](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/Testikattavuus.png)

Hiukan aikavaativuuksien testausta algotritmeille. Testasin aluksi 10 kertaa algoritmeja tietyllä solmumäärällä ja otin keskiarvon niistä. Sitten lisäsin solmujen määrää ja tein mittaukset uudestaan. A* oli nopein, mutta leveyshaku ei ollut pahasti jäljessä nopeudessa. Kruskal oli tosin verrattaen todella hidas.

[A* vs Leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/AStarVsBFS.png)
[Kruskal vs A* vs leveyshaku](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/KruskalVsAStarVsBFS.png)

