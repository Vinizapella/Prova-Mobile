# Contador de Produção - Cronoanálise Industrial

Aplicativo Android nativo desenvolvido em Kotlin para auxiliar na cronoanálise industrial em tempo real, substituindo o registro manual de produção por planilhas físicas.

## Sobre o projeto

O app simula o monitoramento de uma linha de produção, permitindo que o operador registre o início da produção, conte as peças produzidas e finalize o ciclo, gerando automaticamente um relatório com o tempo total e o takt time (tempo médio por peça).

## Funcionalidades

### Tela 1 - Monitoramento de Linha
- Identificação do operador e da linha de produção
- Captura do horário de início da produção
- Bloqueio dos campos de identificação após o início (proteção dos dados)
- Contador de peças produzidas em tempo real
- Cálculo automático do tempo total e do takt time ao finalizar

### Tela 2 - Relatório
- Exibição do operador e da linha em caixa alta
- Quantidade total de peças produzidas
- Tempo total convertido em minutos e segundos
- Takt time médio formatado com duas casas decimais
- Botão para iniciar uma nova produção

## Tecnologias utilizadas

- Kotlin
- Android Studio
- ConstraintLayout
- Material Design
- Intent (navegação entre Activities)

## Como executar

1. Clone este repositório
2. Abra o projeto no Android Studio
3. Aguarde a sincronização do Gradle
4. Execute em um emulador ou dispositivo físico 

## Estrutura do projeto

```
app/src/main/
├── java/com/example/prova/
│   ├── MainActivity.kt
│   └── RelatorioActivity.kt
└── res/layout/
    ├── activity_main.xml
    └── activity_relatorio.xml
```

## Fluxo de uso

1. Preencha o nome do operador e a linha de produção
2. Clique em **Iniciar Produção**
3. Clique em **Registrar Peça** a cada peça produzida
4. Clique em **Finalizar Produção** para ver o relatório
5. Clique em **Nova Produção** para reiniciar o ciclo
