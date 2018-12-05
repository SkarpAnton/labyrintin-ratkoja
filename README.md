# Labyrintin ratkoja

Tarkoituksena olisi vertailla A* ja leveyshaun aikavaativuutta satunnaisten labyrinttien ratkaisussa. Projekti muodostaa kuvan labyrintista, jonka huoneet on merkattu eri värisillä merkeillä. Sininen merkki merkkaa alkuhuonetta ja punainen määränpää huonetta. Vihreä merkki merkkaa huoneita, jotka ovat osa lyhintä polkua alkuhuoneen ja määränpään välillä, jonka A* tai leveyshaku löysi. Keltainen merkki kuvaa ruutua, jossa molemmat A* ja leveyshaku on käynyt. Magenta merkki kuvaa ruutua, jossa vain leveyshaku on käynyt, vastaavasti syaani kuvaa ruutuja, jossa vain A* on käynyt.

## Dokumentaatio

[Dokumentaatio](https://github.com/SkarpAnton/labyrintin-ratkoja/tree/master/dokumentaatio)

[Alkuperäinen määrittelydokumentti](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/maarittelydokumentti.md)

[Toteutusdokumentti](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/toteutusdokumentti.md)

[Testausdokumentti](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/testausdokumentti.md)



## Komentorivitoiminnot (Täysin kopioitu ohjelmistotekniikan esimerkki projektista)

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _MazeSolver-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/mluukkai/OtmTodoApp/blob/master/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
. 
