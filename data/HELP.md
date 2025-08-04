# Data Analytics Service - CarPost

Este é um microserviço dedicado à análise de dados de anúncios de carros. Ele processa informações de carros e proprietários recebidas via Kafka e armazena dados em um banco de dados PostgreSQL. O serviço é capaz de salvar informações relacionadas ao modelo e marca do carro, bem como o preço do modelo e análises associadas.

Este microserviço utiliza Kafka para consumir dados dos tópicos. O serviço está configurado para ouvir o tópico `car-post-topic`, e processar as mensagens com a ajuda do consumidor `KafkaConsumerMessage`.

## Endpoints Expostos

Este microserviço não possui endpoints REST diretos, pois ele é um consumidor de mensagens Kafka. Ele processa automaticamente as mensagens recebidas no tópico `car-post-topic`.

## Funcionamento do Serviço

###  Consumo de Mensagens
O microserviço está configurado para consumir mensagens do tópico Kafka `car-post-topic`. Essas mensagens são do tipo `CarPostDTO` e contêm informações sobre o carro, como modelo, marca e preço.

### Processamento e Armazenamento
Quando uma mensagem é recebida, ela é processada pelo `PostAnalyticsServiceImpl`, que realiza os seguintes passos:

- Salva as informações sobre a marca no repositório `BrandAnalyticsRepository`.
- Salva as informações sobre o modelo do carro no repositório `CarModelAnalyticsRepository`.
- Salva o preço do modelo de carro no repositório `CarModelPriceRepository`.

###  Exceções
Se algum dado estiver ausente ou inválido, o serviço lançará uma exceção `ResourceNotFoundException`. O tratamento global de exceções irá capturar essas falhas e retornar uma resposta adequada.

## Exemplo de Mensagem Kafka

Uma mensagem consumida pode ter o seguinte formato:

```json
{
  "model": "Fusca 2020",
  "brand": "Volkswagen",
  "price": 30000.0,
  "description": "Carro em ótimo estado, bem conservado.",
  "engineVersion": "1.0",
  "city": "São Paulo",
  "createdDate": "2025-08-04T15:30:00",
  "ownerId": 12345,
  "ownerName": "João da Silva",
  "ownerType": "Pessoa Física",
  "contact": "+55 11 98765-4321"
}
````


# Iniando Projeto:

Após iniciar o serviço, a aplicação estará disponível na porta 8082.

[**http://localhost:8082**](http://localhost:8082)

# Estrutura do Projeto

```plaintext
📁 dto
│   ├── CarPostDTO

📁 entity
│   └── CarModelPriceEntity
│   ├── CarModelAnalyticsEntity
│   └── BrandAnalyticsEntity

📁 message
│   ├── config
│   │   └── KafkaConfigs
│   └── consumer
│       └── KafkaConsumerMessage

📁 exception
│   ├── handler                    
│   │   └── GlobalExceptionHandler  
│   ├── response                    
│   │   └── ErrorResponse          
│   └── custom                        
│       └── ResourceNotFoundException

📁 repository
│   └── CarModelPriceRepository
│   ├── CarModelAnalyticsRepository
│   └── BrandAnalyticsRepository

📁 service
│   ├── api
│   │   └── PostAnalyticsServiceImpl
│   └── impl
│       └── PostAnalyticsServiceImpl

📄 DataApplication

````