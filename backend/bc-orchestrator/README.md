# Orchestrator - backend

Uruchomienie procesu odbywa się przez wysłanie requesta:

`POST http://localhost:8070/start` (Klasa `StartProcessController`)

Endpoint zwraca id processu. To id wstawiamy potem w adress `GET http://localhost:8080/company-data/{processId}` (przez przeglądarkę, to jest wejście do aplikacji serwującej formularz i ta aplikacje nic nie wie o eximee itd.).

Klasa `CreateFormDelegate` zapisuje do `eximee` info że zostaje uruchomiony formularz z adresem i wysyła request do drugiej aplikacji z `processInstanceId` `POST http://localhost:8080/company-data-process-start`

Klasa `FinishingTaskListener` jest wpięta jako listner pod skończenie procesu.

W klasie `StartProcessController` znajduje się jeszce endpoint do zebrania informacji że zebranie danych z formularza się powiodło:

`POST http://localhost:8070/form-result`

```json
{
   "processInstanceId": "df4a4e88-50fe-11f1-a789-00155dad84bc",
   "approved": true
}
```
