# Labyrinti ratkoja

Tarkoituksena olisi vertailla A* ja leveyshaun aikavaativuutta satunnaisten labyrinttien ratkaisussa. Projekti muodostaa labyrintin, jonka ruuduissa on erivärisiä merkkejä. Sininen merkki merkkaa alkuruutua ja punainen määränpää ruutua. Vihreä merkki merkkaa ruutuja, jotka ovat osa lyhintä polkua alkuruudun ja määränpään välillä, jonka A* tai leveyshaku löysi. Keltainen merkki kuvaa ruutua, jossa molemmat A* ja leveyshaku on käynyt. Magenta merkki kauvaa ruutua, jossa vain leveyshaku on käynyt, vastaavasti syaani kuvaa ruutuja, jossa vain A* on käynyt.

##Dokumentaatio

[Dokumentaatio](https://github.com/SkarpAnton/labyrintin-ratkoja/tree/master/dokumentaatio)
[Alkuperäinen määrittelydokumentti](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/maarittelydokumentti.md)

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

generoi hakemistoon _target_ suoritettavan jar-tiedoston _OtmTodoApp-1.0-SNAPSHOT.jar_

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
