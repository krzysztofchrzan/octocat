# Treść zadania
> I.Dla endpointu https://api.github.com/users/octocat zaprezentuj jak go przetestować automatycznie w Postmanie (test weryfikujący status i wartości w response) oraz pobierz  parametr "name" z response i zapisz go do zmiennej środowiskowej. Wynik umożliwiający odczyt i poprawne działanie zapisz w plikach
> 
> II.Dla endpointu https://api.github.com/users/octocat w restAssured+Java rozpisz test wraz z drzewem klas (pattern) + asercje na dowolne pola/wartości. Pamiętaj o zastosowaniu dobrych praktyk pisania testów. Projekt umieść na dowolnym repozytorium i udostępnij nam link.

# I.Realizacja - testy API endpointu (Postman)
## Import plików 
Należy zaimportować zaimportować do Postmana
- plik kolekcji : postman_collection.json
- plik środowiska: postman_environment.json

## Ustawienie środowiska
Należy ustawić środowisko na "Environment 1"

## Zawartość kolekcji
1.GET octocat (główny test kolekcji)
- asercje: status, typ odpowiedzi, czas odpowiedzi
- asercje również na wszystkie pola z odpowiedzi
- zapisanie zmiennej "name" jako zmiennej środowiskowej

2.PUT POST DELETE octocat
- testy negatywne - sprawdzenie blokowania użycia metod PUT POST DELETE

3.GET octocat webpage
- sprawdzenie czy w odpowiedzi zwracana jest strona web

4.GET octocat /subscriptions /followers /repos /received_event
- sprawdzenie czy zwracane są jakiekolwiek obiekty

## Uruchomienie 
[kolekcja] ... -> Run -> Run octocat Collection
Wyniki testów kolekcji znajdują się również w pliku postman_test_run.json



# II.Realizacja - testy API endpointu (Java)
Repozytorium zawiera testy automatyczne API napisane w Javie przy użyciu RestAssured i TestNG.

## Pierwsze kroki
Aby lokalnie uruchomić testy, wykonaj następujące kroki:
1. Sklonuj to repozytorium na komputer lokalny.
2. Upewnij się, że masz zainstalowaną Javę i Maven.
3. Przejdź do katalogu projektu.
4. Wszystkie testy mogą być uruchomione poprzez runnera TestNG.
5. Aby go stworzyć należy w Intellij wykonać:
   1. Run -> Edit Configurations 
   2. Następnie dodać konfigurację dla TestNG
   3. z parametrami: 
      1. Test Kind: All in package
      2. Package: octocat


## Opis testu
### Testy endpointu (EndpointTest.java)
Ta klasa zawiera pozytywne testy metodą GET dla API użytkownika octocat. Sprawdza kod stanu, typ zawartości, czas odpowiedzi i różne pola odpowiedzi JSON.

### Testy negatywne endpointu (EndpointNegativeTest.java)
Ta klasa zawiera próby wywołania zapytań metodami PUT, POST i DELETE dla API użytkownika octocat. Ponieważ metod tych nie da się zrealizować, testy sprawdzają czy po wywołaniu zwracają kod stanu 404.

## Wyniki testu
Po uruchomieniu testów z poziomu maven, można przejrzeć wyniki w raporcie TestNG w pliku: **target/surefire-reports/Practice Suite/API Github Octocat Test.html** Raport dostarcza informacji na temat każdego przypadku testowego - statusu pozytywnego lub niepomyślnego.
