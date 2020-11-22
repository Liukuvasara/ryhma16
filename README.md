# Ryhma16
![Github Actions](https://github.com/vuorenkoski/ryhma16/workflows/Automaattitesti/badge.svg)

## Dokumentit

### Burndown-kirjanpito
Lisää tehdyt taskit Seuranta-välilehdelle.

[Burndown-kirjanpito](https://drive.google.com/file/d/1j_Juq5yFYapAQBtRJbpEmEyYTJ6UJzF-/edit)

### Backlogit

[Sprintti 1](https://github.com/vuorenkoski/ryhma16/projects/2)

### Ohjelman asennusohje

1. Lataa ohjelma Githubista (komento *git clone*).
2. Avaa ohjelmakansio.
3. Suorita ohjelma komentoriviltä komennolla *gradle run*.

### Käyttöohje

Ohjelma toimii komentoriviltä. Käytössä ovat tällä hetkellä komennot:

ohjeet - Tulostaa käytettävissä olevat komennot.

lisaa kirja - Lisää kirjastoon uuden kirjavinkin.

hae kirja HAKUSANA - hakee kirjaa tietyllä termillä.

hae kirja kaikki - Hakee kirjaston kaikki kirjat.

### Definition of done

Taski on suoritettu "definition of donen" tasolla, kun
1. Taskiin liittyvä koodi (esim. metodi) on kirjoitettu.
2. Tuotetun koodin on katsonut läpi ja hyväksynyt joku toinen projektin henkilö. Koodi toimii toivotusti.
3. Tuotettuun koodiin on kirjoitettu kattavat testit.
4. Toinen henkilö on tarkastanut ko. testit. Testit toimivat odotetusti.
5. Koodiin liittyvä dokumentaatio on lisätty  ohjelman ohjeisiin ja tarvittaessa README-tiedostoon.
6. Taski on siirretty backlogissa DONE-sarakkeeseen.
7. Taskin suoritus on lisätty burndown-listalle.

#### Parit tarkistusta varten

Sami & Ossi

Sonja & dennis

Atte & Lauri

#### Tietokannan käyttö

Käyttöönotto:

Jos ei vielä olemassa tiedostoa tietokannalle: (eli periaatteessa jos käsitellään vaan samaa niin tämä askel ensimmäisen kerran jälkeen tarpeeton, mutta vaaraton)

TiedostoDAO annaNimi = new TiedostoDAO();
annaNimi.createFile("tähän haluttu tiedoston nimi tietokannalle")

Tietokannan kanssa leikkiminen siitä lähtien:

TietokantaDAO käsittelijä = new TietokantaDAO("tähän juuri tehty/jo aikaisemmin tehty tiedoston nimi");

---------------------------
Tosiaan, lisäys pitää tehdä omana asiana / ei käytä kirja olentoa.
Listaus palauttaa tällä hetkellä vaan string listan kirjojen nimistä - miten halutaan muokata?
