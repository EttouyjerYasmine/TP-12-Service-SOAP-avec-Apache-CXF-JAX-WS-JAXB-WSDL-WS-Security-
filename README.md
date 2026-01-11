## TP 12 : Service SOAP avec Apache CXF (JAX-WS, JAXB, WSDL, WS-Security)

### 🧩 Présentation
Ce projet expose un service SOAP basé sur **Apache CXF**, avec deux opérations :
- `sayHello(String name)` → retourne un message de salutation.
- `findPersonById(String id)` → retourne un objet `Person`.

Le service est sécurisé via **WS-Security UsernameToken**, et testé avec **SoapUI**.

---

### 🛠️ Technologies utilisées
- Java 17  
- Maven  
- Apache CXF 4.0.3  
- JAXB (Jakarta XML Bind)  
- WS-Security (WSS4J)  
- SoapUI 5.9.1  
- JUnit 5

---

### 📦 Structure du projet

```
src/
├── main/
│   ├── java/
│   │   └── com.acme.cxf/
│   │       ├── api/           → Interface HelloService
│   │       ├── model/         → Classe Person
│   │       ├── impl/          → Implémentation HelloServiceImpl
│   │       ├── client/        → Client Java (ClientDemo.java)
│   │       └── security/      → UTPasswordCallback.java
│   └── resources/
│       └── service.wsdl       → WSDL généré automatiquement
└── test/
    └── java/                  → Tests unitaires JUnit
```

---

### 🚀 Lancer le serveur

```bash
mvn exec:java
```

Le service est exposé à :
```
http://localhost:8080/services/hello
http://localhost:8080/services/hello-secure
```

---

### 🔐 Sécurité WS-Security

Le service `hello-secure` est protégé par **UsernameToken** :
- **Username** : `student`  
- **Password** : `secret123`  
- **Type** : `PasswordText`

Côté serveur, la validation est faite via :
```java
new UTPasswordCallback(Map.of("student", "secret123"))
```

---

### 🧪 Tester avec SoapUI

1. Importer le WSDL :
   ```
   http://localhost:8080/services/hello-secure?wsdl
   ```

2. Configurer WS-Security :
   - Username : `student`
   - Password : `secret123`
   - Type : `Text`
   - Ajouter Nonce + Created (optionnel)

3. Envoyer une requête `SayHello` → réponse attendue :
   ```xml
   <greeting>Bonjour, student</greeting>
   ```

---

### 📄 Génération du client Java

Tu peux consommer le service via JAX-WS :

```java
Service svc = Service.create(wsdl, qname);
HelloService port = svc.getPort(HelloService.class);
```

Ou générer les classes automatiquement avec :
```bash
wsdl2java -p com.acme.cxf.client -d src/main/java http://localhost:8080/services/hello?wsdl
```

---

### ✅ Tests unitaires

Les tests sont écrits avec JUnit 5 :
```bash
mvn test
```

---

###  Démonstration

<img width="953" height="476" alt="YasmineConfiguration" src="https://github.com/user-attachments/assets/3936136b-ba79-448d-a407-3f919af1e000" />

<img width="957" height="497" alt="1" src="https://github.com/user-attachments/assets/68307398-73e4-46c6-ac41-611f6245a71c" />

<img width="956" height="502" alt="3" src="https://github.com/user-attachments/assets/a2a50be5-26bf-4707-abde-3ebc0684de53" />


### 📚 Références
- [Apache CXF Documentation](https://cxf.apache.org/docs/)
- WS-Security (WSS4J) [(cxf.apache.org in Bing)](https://www.bing.com/search?q="https%3A%2F%2Fcxf.apache.org%2Fdocs%2Fws-security.html")
- [SoapUI](https://www.soapui.org/)

---

### Auteurs 

Réalisé par : Ettouyjer yasmine.

Encadré par : Pr.Mohamed Lechgar.
