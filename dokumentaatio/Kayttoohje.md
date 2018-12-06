# Käyttöohje

## Komentorivitoiminnot (muokattu versio ohjelmistotekniikan esimerkki projektista)

### Alustus

Komennot suoritetaan maven projektin juuresta.

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _MazeSolver-1.0-SNAPSHOT-shaded.jar_

### Jar:in suorittaminen

Jar:in voi suorittaa komennolla
```
javac -jar target/MazeSolver-1.0-SNAPSHOT-shaded.jar
```
### Ohjelman parametrit

Ohjelmalla on kaksi parametria: labyrintin leveys ja ruudun leveys  

Esimerkiksi
```
javac -jar target/MazeSolver-1.0-SNAPSHOT-shaded.jar 100 1000
```
loisi labyrintin, jossa yhdellä sivulla on huoneita 100 kpl ja kyseisestä labyrintista kuvan, jonka koko on 1000 * 1000 pikseliä.
Vaihtoehtoisesti koot voi syottää suorituksen aikana.

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
