# INSTALACJA I URUCHOMIENIE
Do wykonania zadania użyłem Javy 11, Spring Boota i Mavena. Dzięki narzędziu Spring Initializr otrzymałem szkielet projektu z gotowymi skryptami budującymi projekt.

0. Należy zapewnić JRE w wersji 11 i ustawić zmienną środowiskową JAVA_HOME
1. Należy pobrać archiwum z niniejszego repozytorium.
2. Są 2 pliki Maven Wrappera - "mvnw"(skrypt dla GNU/Linux) i "mvnw.cmd"(skrypt dla Windows)
3. Aby uruchomić program, wystarczy komenda "./mvnw spring-boot:run"(Linux) lub "mvnw spring-boot:run"(Windows). W przypadku problemów, konieczne będzie uruchomienie skryptu z podwyżsonymi uprawnieniami.

Aplikacja domyślnie ma wbudowany serwer Apache Tomcat i zajmuje port 8080. Port można zmienić ustawiając zmienną środowiskową $SERVER_PORT bez przebudowy lub wartość "server.port" w  "{katalog projektu}/src/main/resources/application.properties" i przebudować.

#### Nieobowiązkowe
4. Można także utworzyć JAR-a za pomocą komendy "./mvnw package"(Linux) i uruchomić otrzymany pakiet poleceniem "java -jar".

# UŻYWANIE
Aplikacja działa jako serwer udostępniający następujące końcówki:
* / — dostępne end-pointy
* /stars/{login} — zsumowanie liczby gwiazdek we wszystkich repozytoriach i wynik w postaci łańcucha znaków
* /repos/{login} — wylistowanie wszystkich pełnych nazw repozytoriów i liczby gwiazdek w postaci łańcucha znaków
* /json/stars/{login} — zsumowanie liczby gwiazdek we wszystkich repozytoriach i wynik w postaci obiektu JSON - {sumOfStars:int}
* /json/repos/{login} — wylistowanie wszystkich pełnych nazw repozytoriów i liczby gwiazdek w postaci tablicy obiektów JSON - [{full_name:string, stargazers_count:int}...]

Można użyć dowolnego klienta HTTP lub polecenia curl, aby pobrać dane.

# UWAGI
* Aplikacja nie uzyskuje dostępu do prywatnych repozytoriów.

# PROPOZYCJE ROZSZERZENIA
* Tą wersję można rozbudować o przyjmowanie znaczników bezpieczeństwa lub inną formę uwierzytelnienia.
* Można także pobierać listy gwiazdkujących i liczyć unikalne wystąpienia.
* Można rozszerzyć o statystyki na temat liczby obserwujących dane repozytoria i sumę obserwujących.
* Można rozszerzyć o prosty front.

* REST API GitHuba przesyła sporą liczbę informacji, z których to trzeba wyodrębnić potrzebne nam dane. Możemy to też ograniczyć z wykorzystaniem GraphQL API, które dzięki odpowiednio przygotowanemu zapytaniu prześle tylko potrzebne dane.
