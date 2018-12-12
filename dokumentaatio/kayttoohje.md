# Käyttöohje

## Komentorivitoiminnot

#### Alustus
Lataa suoritettava tiedosto [MazeSolver_v1-0.jar](https://github.com/SkarpAnton/labyrintin-ratkoja/releases)

#### Jar:in suorittaminen

Jar:in voi suorittaa komennolla
```
java -jar MazeSolver_v1-0.jar
```
#### Ohjelman parametrit

Ohjelmalla on kaksi parametria: labyrintin leveys ja huoneen leveys  

Esimerkiksi
```
java -jar MazeSolver_v1-0.jar 100 1000
```
loisi labyrintin, jossa yhdellä sivulla on huoneita 100 kpl ja kyseisestä labyrintista kuvan, jonka koko on 1000 * 1000 pikseliä.
Vaihtoehtoisesti koot voi syottää suorituksen aikana.


#### Suoritettavan jarin generointi

Vaihtoehtoisesti voit luoda oman jar:in komennolla:

```
mvn package
```

Komento generoi hakemistoon _target_ suoritettavan jar-tiedoston _MazeSolver-1.0-SNAPSHOT-shaded.jar_

#### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_



#### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

#### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/mluukkai/OtmTodoApp/blob/master/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_

## Kuvan tulkinta

Projekti muodostaa kuvan labyrintista, jonka huoneet on merkattu eri värisillä merkeillä. Sininen merkki merkkaa alkuhuonetta ja punainen määränpää huonetta. Vihreä merkki merkkaa huoneita, jotka ovat osa lyhintä polkua alkuhuoneen ja määränpään välillä, jonka A* tai leveyshaku löysi. Keltainen merkki kuvaa ruutua, jossa molemmat A* ja leveyshaku on käynyt. Magenta merkki kuvaa ruutua, jossa vain leveyshaku on käynyt, vastaavasti syaani kuvaa ruutuja, jossa vain A* on käynyt.

![Labyrintti kuva](https://github.com/SkarpAnton/labyrintin-ratkoja/blob/master/dokumentaatio/kuvat/labyrinttiKuvat.png)

A* harvoin vierailee ruuduissa, joissa leveyshaku ei vieraile, joten syaania näkee harvoin kuvissa. Lyhyimpiä polkuja voi olla enemmän kuin yksi, joten A* ja leveyshaku ei välttämättä löydä samaa polkua, mikä näkyy kuvassa vihreiden merkkien erkaantumisella.



## Lähteet

Paljolti kopioitu ohjelmistotekniikan esimerkki projektista
