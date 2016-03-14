#include <SPI.h>
#include <Ethernet.h>
#include <MFRC522.h>
 
#define SS_PIN 4
#define RST_PIN 5
MFRC522 mfrc522(SS_PIN, RST_PIN);
 
//Definicoes de IP, mascara de rede e gateway
byte mac[] = {
  0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };
IPAddress ip(192,168,100,8);          //Define o endereco IP
IPAddress gateway(192,168,100,0);     //Define o gateway
IPAddress subnet(255, 255, 255, 0); //Define a máscara de rede
String valor;
 
//Inicializa o servidor web na porta 80
EthernetServer server(2020);
 
void setup()
{
  pinMode(SS_PIN, OUTPUT);
  SPI.begin();      // Inicia  SPI bus
  mfrc522.PCD_Init();   // Inicia MFRC522
  //Inicializa a interface de rede
  Ethernet.begin(mac, ip, gateway, subnet);
  server.begin();
}
 
void loop() {   
  //Aguarda conexao
  EthernetClient client = server.available();
  if (client) {
    while (client.connected()) {
      while (client.available()) {
        char c = client.read();
      }
      readTag();
      
      if(valor!=""){
        client.print(valor);
        valor="";
      }
    }
    client.stop();
    Ethernet.maintain();
  }
}

void readTag(){
  if ( ! mfrc522.PICC_IsNewCardPresent()) 
  {
    return;
  }
  if ( ! mfrc522.PICC_ReadCardSerial()) 
  {
    return;
  }
  delay(200);
  String conteudo= "";
  for (byte i = 0; i < mfrc522.uid.size; i++) 
  {
     conteudo.concat(String(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " "));
     conteudo.concat(String(mfrc522.uid.uidByte[i], HEX));
  }
  conteudo.toUpperCase();
  valor = conteudo.substring(1);
}


