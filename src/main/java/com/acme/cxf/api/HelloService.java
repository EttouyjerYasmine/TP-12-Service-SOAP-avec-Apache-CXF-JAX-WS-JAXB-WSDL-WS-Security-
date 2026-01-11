package com.acme.cxf.api;

import com.acme.cxf.model.Person;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

/**
 * Interface du service SOAP exposé via Apache CXF.
 * 
 * - @WebService : indique que cette interface définit un service web.
 *   Le paramètre targetNamespace définit l’espace de noms XML
 *   utilisé dans le WSDL généré.
 */
@WebService(targetNamespace = "http://api.cxf.acme.com/")
public interface HelloService {

  /**
   * Méthode SOAP simple qui retourne une salutation.
   * 
   * - @WebMethod : expose cette méthode comme une opération SOAP.
   *   Le paramètre operationName définit le nom de l’opération dans le WSDL.
   * - @WebResult : définit le nom de la balise XML de retour (<greeting>).
   * - @WebParam : définit le nom de la balise XML pour le paramètre (<name>).
   *
   * Exemple de réponse SOAP :
   * <SayHelloResponse>
   *   <greeting>Hello Yasmine!</greeting>
   * </SayHelloResponse>
   */
  @WebMethod(operationName = "SayHello")
  @WebResult(name = "greeting")
  String sayHello(@WebParam(name = "name") String name);

  /**
   * Méthode SOAP qui retourne un objet métier Person.
   * 
   * - @WebMethod : expose cette méthode comme une opération SOAP.
   * - @WebResult : définit le nom de la balise XML de retour (<person>).
   * - @WebParam : définit le nom de la balise XML pour l’argument (<id>).
   *
   * Exemple de réponse SOAP :
   * <FindPersonResponse>
   *   <person>
   *     <id>123</id>
   *     <name>Yasmine</name>
   *     <age>25</age>
   *   </person>
   * </FindPersonResponse>
   */
  @WebMethod(operationName = "FindPerson")
  @WebResult(name = "person")
  Person findPersonById(@WebParam(name = "id") String id);
}
