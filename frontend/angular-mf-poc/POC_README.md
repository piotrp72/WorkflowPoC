# Angular Module Federation Monorepo - instrukcja gotowego POC

To archiwum zawiera gotowy szkielet monorepo dla POC mikrofrontendów Angular:
- `orchestrator` - host, port 8081,
- `calculator` - remote, port 8082,
- `collector` - remote, port 8083.
- `decision` -remote, port 8084 (ten został dodany ręcznie jako kopia `calculatora`)

## Ważne

Poprzednia wersja była szkieletem. Ta paczka zawiera poprawioną strukturę monorepo oraz komplet plików źródłowych do wdrożenia host/remotes z przekazywaniem identyfikatora procesu.

Ze względu na wrażliwość Angular Module Federation na dokładne wersje CLI, builderów i pluginów, najbezpieczniejszy sposób uruchomienia jest taki, aby wygenerować workspace lokalnie przy użyciu Angular CLI i pluginu Angular Architects, a następnie podmienić pliki źródłowe z tej paczki.

## Docelowy efekt

- Orchestrator pokazuje ekran START.
- Orchestrator generuje losowy identyfikator procesu i zapisuje go w `sessionStorage`.
- Orchestrator pokazuje ten identyfikator na ekranie.
- Po kliknięciu `calculator` albo `collector` albo `decision` ładowany jest odpowiedni remote.
- Każdy remote pokazuje swój formularz oraz ten sam identyfikator procesu.

## Krok po kroku - jak uruchomić poprawnie

### 1. Utwórz workspace host/remotes

```bash
npm install -g @angular/cli
npx -p @angular/cli ng new angular-mf-poc --create-application=false --routing=false --style=css
cd angular-mf-poc
npm i -D @angular-architects/module-federation
npx ng g application orchestrator --routing --style=css
npx ng g @angular-architects/module-federation:init --project orchestrator --type host --port 8081
```

### 2. Dodaj remote calculator

```bash
npx ng g application calculator --routing --style=css
npx ng g @angular-architects/module-federation:init --project calculator --type remote --port 8082 
```

### 3. Dodaj remote collector

```bash
npx ng g application collector --routing --style=css
npx ng g @angular-architects/module-federation:init --project collector --type remote --port 8083 
```

### 4. Podmień pliki z katalogu `src-files`

Z tej paczki skopiuj przygotowane pliki z `src-files/` do wygenerowanego workspace `angular-mf-poc/`. Przykładowo przekopiowanie plików aplikacji `\src-files\calculator\src\app` do `\angular-mf-poc\projects\calculator\src\app` i analogicznie dla innych projektów.


i w tym miejscy utworzyłem `decision` jako kopię `calculator` z uwzględnieniem koniecznych zmian w plikach.

### 5. Uruchom aplikacje

cd .\angular-mf-poc\

```bash
npm run start:all
```

albo osobno:

```bash
ng serve orchestrator -o --port 8081
ng serve calculator --port 8082
ng serve collector --port 8083
ng serve decision --port 8084
```

## Co zawiera katalog src-files

- komponent hosta orchestratora,
- widok START i przyciski calculator / collector,
- logikę generowania `applicationId`,
- formularz calculatora z prezentacją identyfikatora,
- formularz collectora z prezentacją identyfikatora,
- przykładową konfigurację routingu i lazy-load remote'ów.

## Dlaczego tak

To podejście daje Ci największą szansę na uruchomienie bez walki z różnicami wersji Angular CLI i builderów. Sam kod biznesowy i widoki masz gotowe, a federacyjny runtime powstaje lokalnie przez oficjalny generator.
