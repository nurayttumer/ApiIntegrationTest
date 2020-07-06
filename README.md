# ApiIntegrationTest
Bu projede Hepsiburada tarafından verilen task oluşturulmuş olup JSON API isteğinin sonucunun(http status) kontrolünü gerçekleştiren bir entegrasyon testi projesidir.   <br /><br />
## Proje Özellikleri
* Rest-Assured ile Java dilinde API entegrasyon otomasyonu projesidir.
* Url: http://generator.swagger.io
* Seçilen Endpoint: /api/gen/clients
* Projedeki İstek metodları : POST ve GET
* Assertion için JUnit kütüphanesi kullanılmakta.
* Proje çıktı olarak Response status code ve response bilgilerini bastırmakta. 
* Response Status code 200 değilse başarısız olarak "Assertion Error" vermekte.

## Hepsiburada Task İsterleri

-JSON API isteğinin sonucunun(http status) kontrolünü gerçekleştiren bir entegrasyon testi yazınız. <br />
(Örnek url: http://generator.swagger.io)  <br />
-Tarafınızdan seçilecek birer tane GET ve POST endpointleri için Http status code 200 verirse başarılı,
değilse başarısız olarak rapor edilmelidir.

## Test Çıktısı

HATALI POST İLE SONUÇ  <br />
```
Response POST Body is =>  {"code":500,"type":"unknown","message":"something bad happened"}
Response POST Status Code =>  500

java.lang.AssertionError: 
Expected :200
Actual   :500
<Click to see difference>


	at org.junit.Assert.fail(Assert.java:89)
	at org.junit.Assert.failNotEquals(Assert.java:835)
	at org.junit.Assert.assertEquals(Assert.java:647)
	at org.junit.Assert.assertEquals(Assert.java:633)
	at IntegrationTest.PostClients(IntegrationTest.java:73)
  .
  .
  .

Response GET Body is =>  ["ada","akka-scala","android","apex","bash","clojure","cpprest","csharp","csharp-dotnet2","cwiki","dart","dart-jaguar","dynamic-html","eiffel","elixir","elm","erlang-client","flash","go","groovy","haskell-http-client","html","html2","java","javascript","javascript-closure-angular","jaxrs-cxf-client","jmeter","kotlin","lua","objc","perl","php","powershell","python","qt5cpp","r","ruby","rust","scala","scala-gatling","scalaz","swagger","swagger-yaml","swift","swift3","swift4","swift5","tizen","typescript-angular","typescript-angularjs","typescript-aurelia","typescript-fetch","typescript-inversify","typescript-jquery","typescript-node"] 
Response GET Status Code =>  200 

```

DOĞRU POST DATASI İLE SONUÇ  <br />

```

Response POST Body is =>  {"code":"02157b40-9d4e-4e73-b335-61781ea342ce","link":"https://generator.swagger.io/api/gen/download/02157b40-9d4e-4e73-b335-61781ea342ce"} 
Response POST Status Code =>  200 
Response GET Body is =>  ["ada","akka-scala","android","apex","bash","clojure","cpprest","csharp","csharp-dotnet2","cwiki","dart","dart-jaguar","dynamic-html","eiffel","elixir","elm","erlang-client","flash","go","groovy","haskell-http-client","html","html2","java","javascript","javascript-closure-angular","jaxrs-cxf-client","jmeter","kotlin","lua","objc","perl","php","powershell","python","qt5cpp","r","ruby","rust","scala","scala-gatling","scalaz","swagger","swagger-yaml","swift","swift3","swift4","swift5","tizen","typescript-angular","typescript-angularjs","typescript-aurelia","typescript-fetch","typescript-inversify","typescript-jquery","typescript-node"] 
Response GET Status Code =>  200 


```
