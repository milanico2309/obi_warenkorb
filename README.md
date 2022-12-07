#Readme
##Initialisierung
Das Programm initialisiert zunächst eine in-memory H2 Datenbank mit einigen Artikel Daten. Das hierzu verwendete
SQL Skript befindet sich im "resources"-Verzeichniss.
##Verwendung
Das Programm stellt eine Rest-API für die weitere Kommunikation zur Verfügung. Es folgt einige Beispiele:
* "PUT http://localhost:8080/addArtikel?id=001&amount=10" fügt dem Warenkorb den genannten Artikel(id=001)
in der gewünschten Menge(10) hinzu, sofern dieser die Anforderungen bezüglich Mindestmenge und Bestand erfüllt.
* "GET http://localhost:8080/getWarenkorb" liefert den Warenkorb im JSON Format.
* "DELETE http://localhost:8080/removeArtikel?id=001" Entfernt den genannten Artikel(001) vollständig aus dem Warenkorb.
* "DELETE http://localhost:8080/clearWarenkorb" Leert den gesamten Warenkorb
Eine Reihe von Beispiel Requests befindet sich in der Datei "requests.http". Werden diese in der gegeben Reihenfolge
abgesendet, so wird jede Anforderung der Aufgabenstellung überprüft.
## Sonstiges
Unter der Adresse: "http://localhost:8080/h2-console/" kann auf die Datenbank zugegriffen werden.
Die URL lautet: "jdbc:h2:mem:itemDB" und der Nutzername lautet: "sa". Ein Password wurde nicht vergeben.
