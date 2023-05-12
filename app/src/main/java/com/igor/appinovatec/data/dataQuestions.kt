package com.igor.appinovatec.data

import com.igor.appinovatec.model.QuizQuestion


val dataScience = listOf(
    QuizQuestion(
        questao = "Qual é a etapa do processo de Data Science que envolve a limpeza e preparação dos dados?",
        alternativas = listOf(
            "Modelagem",
            "Visualização",
            "Análise exploratória",
            "Pré-processamento",
            "Algoritmos de aprendizado de máquina"
        ),
        alternativaCorreta = "Pré-processamento"
    ),
    QuizQuestion(
        questao = "Qual das seguintes técnicas de aprendizado de máquina é usada para classificação?",
        alternativas = listOf(
            "Regressão linear",
            "Agrupamento",
            "Árvore de decisão",
            "Análise de componentes principais (PCA)",
            "Regressão logística"
        ),
        alternativaCorreta = "Regressão logística"
    ),
    QuizQuestion(
        questao = "Qual é o objetivo da validação cruzada em aprendizado de máquina?",
        alternativas = listOf(
            "Testar a precisão do modelo em dados que não foram usados para treinamento",
            "Medir a acurácia de um modelo durante o treinamento",
            "Selecionar o melhor modelo a partir de um conjunto de modelos candidatos",
            "Calibrar os hiperparâmetros do modelo",
            "Identificar os outliers no conjunto de dados"
        ),
        alternativaCorreta = "Testar a precisão do modelo em dados que não foram usados para treinamento"
    ),
    QuizQuestion(
        questao = "O que é overfitting em aprendizado de máquina?",
        alternativas = listOf(
            "Um modelo que é muito simples e não é capaz de capturar as relações nos dados",
            "Um modelo que se adapta muito bem aos dados de treinamento, mas não generaliza bem para novos dados",
            "Um modelo que é muito complexo e tende a se ajustar demais aos dados",
            "Uma técnica de pré-processamento de dados para lidar com valores ausentes",
            "Uma técnica para reduzir a dimensão dos dados"
        ),
        alternativaCorreta = "Um modelo que se adapta muito bem aos dados de treinamento, mas não generaliza bem para novos dados"
    ),
    QuizQuestion(
        questao = "O que é o método K-means?",
        alternativas = listOf(
            "Uma técnica de classificação supervisionada",
            "Uma técnica de classificação não supervisionada",
            "Uma técnica de redução de dimensionalidade",
            "Uma técnica de validação cruzada",
            "Uma técnica de pré-processamento de dados"
        ),
        alternativaCorreta = "Uma técnica de classificação não supervisionada"
    )
)
val frontend = listOf(
    QuizQuestion(
        questao = "Qual a função do HTML?",
        alternativas = listOf(
            "Estilizar o conteúdo da página",
            "Fornecer interatividade com o usuário",
            "Definir a estrutura e o conteúdo da página",
            "Controlar o comportamento da página",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "Definir a estrutura e o conteúdo da página"
    ),
    QuizQuestion(
        questao = "Qual a função do CSS?",
        alternativas = listOf(
            "Definir a estrutura e o conteúdo da página",
            "Controlar o comportamento da página",
            "Estilizar o conteúdo da página",
            "Fornecer interatividade com o usuário",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "Estilizar o conteúdo da página"
    ),
    QuizQuestion(
        questao = "Qual a função do JavaScript?",
        alternativas = listOf(
            "Definir a estrutura e o conteúdo da página",
            "Definir a estrutura e o conteúdo da página",
            "Estilizar o conteúdo da página",
            "Fornecer interatividade com o usuário",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "Definir a estrutura e o conteúdo da página"
    ),
    QuizQuestion(
        questao = "O que é um elemento HTML?",
        alternativas = listOf(
            "Uma propriedade de CSS",
            "Um recurso de JavaScript",
            "Uma funcionalidade do servidor",
            "Um item da página web",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "Um item da página web"
    ),
    QuizQuestion(
        questao = "O que é responsividade em design de interfaces?",
        alternativas = listOf(
            "A habilidade do usuário em interagir com a interface",
            "A capacidade da interface em se adaptar a diferentes dispositivos e tamanhos de tela",
            "A velocidade de carregamento da página",
            "A qualidade visual da interface",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "A capacidade da interface em se adaptar a diferentes dispositivos e tamanhos de tela"
    ),
    QuizQuestion(
        questao = "Qual a função do box-sizing no CSS?",
        alternativas = listOf(
            "Definir o tamanho da caixa que envolve o elemento HTML",
            "Definir o tamanho e a posição da caixa que envolve o elemento HTML",
            "Definir a cor da caixa que envolve o elemento HTML",
            "Definir o modelo de caixa a ser usado pelo elemento HTML",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "Definir o modelo de caixa a ser usado pelo elemento HTML"
    ),
)
val machinelearning = listOf(
    QuizQuestion(
        questao = "Qual é a definição correta de Machine Learning?",
        alternativas = listOf(
            "O estudo de como as máquinas aprendem a partir de dados",
            "O estudo de como os seres humanos aprendem",
            "O estudo de como as máquinas podem substituir o trabalho humano",
            "O estudo de como as máquinas funcionam",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "O estudo de como as máquinas aprendem a partir de dados"
    ),
    QuizQuestion(
        questao = "Qual é a técnica de Machine Learning utilizada para prever resultados futuros com base em dados rotulados?",
        alternativas = listOf(
            "Aprendizado não Supervisionado",
            "Aprendizado por Reforço",
            "Aprendizado Supervisionado",
            "Regressão Linear",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "Aprendizado Supervisionado"
    ),
    QuizQuestion(
        questao = "Qual é a técnica de Machine Learning utilizada para encontrar padrões e insights em dados não rotulados?",
        alternativas = listOf(
            "Aprendizado não Supervisionado",
            "Aprendizado por Reforço",
            "Aprendizado Supervisionado",
            "Regressão Linear",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "Aprendizado não Supervisionado"
    ),
    QuizQuestion(
        questao = "Qual é a técnica de Machine Learning utilizada para ensinar um modelo a tomar decisões em um ambiente interativo?",
        alternativas = listOf(
            "Aprendizado não Supervisionado",
            "Aprendizado por Reforço",
            "Aprendizado Supervisionado",
            "Regressão Linear",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "Aprendizado por Reforço"
    ),
    QuizQuestion(
        questao = "Qual é o tipo de Aprendizado Supervisionado utilizado para classificar dados em categorias discretas?",
        alternativas = listOf(
            "Regressão Linear",
            "Regressão Logística",
            "Árvores de Decisão",
            "K -Nearest Neighbors (KNN)",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "Regressão Logística"
    ),
    QuizQuestion(
        questao = "Qual é o tipo de Aprendizado Supervisionado utilizado para prever um valor contínuo?",
        alternativas = listOf(
            "Regressão Linear",
            "Regressão Logística",
            "Árvores de Decisão",
            "K-Nearest Neighbors (KNN)",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "Regressão Linear"
    ),
    QuizQuestion(
        questao = "Qual é a técnica de Aprendizado Não Supervisionado utilizada para reduzir a dimensionalidade dos dados?",
        alternativas = listOf(
            "Análise de Componentes Principais (PCA)",
            "Clustering",
            "Regressão Linear",
            "Árvores de Decisão",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "Análise de Componentes Principais (PCA)"
    ),
    QuizQuestion(
        questao = "Qual é a técnica de Aprendizado Não Supervisionado utilizada para agrupar dados semelhantes em clusters?",
        alternativas = listOf(
            "Análise de Componentes Principais (PCA)",
            "Clustering",
            "Regressão Linear",
            "Árvores de Decisão",
            "Nenhuma das anteriores"
        ),
        alternativaCorreta = "Clustering"
    ),
    QuizQuestion(
        questao = "O que é Aprendizado Não Supervisionado?",
        alternativas = listOf(
            "Uma técnica de Machine Learning em que o modelo é treinado usando dados rotulados para prever resultados futuros",
            "Uma técnica de Machine Learning em que o modelo é treinado em dados rotulados e não rotulados simultaneamente",
            "Uma técnica de Machine Learning em que o modelo é treinado para reconhecer objetos em imagens",
            "Uma técnica de Machine Learning em que o modelo é treinado usando dados não rotulados para encontrar padrões",
            "Nenhuma das alternativas anteriores"
        ),
        alternativaCorreta = "Uma técnica de Machine Learning em que o modelo é treinado usando dados não rotulados para encontrar padrões"
    )
)
val engSoftware = listOf(
    QuizQuestion(
        questao = "Qual é o principal objetivo da Engenharia de Software?",
        alternativas = listOf(
            "Desenvolver hardware",
            "Criar programas de computador",
            "Produzir software de qualidade",
            "Gerenciar projetos de TI",
            "Construir infraestrutura de rede"
        ),
        alternativaCorreta = "Produzir software de qualidade"
    ),
    QuizQuestion(
        questao = "O que é o modelo em cascata (Waterfall) na Engenharia de Software?",
        alternativas = listOf(
            "Um modelo de desenvolvimento iterativo",
            "Um modelo de desenvolvimento ágil",
            "Um modelo de desenvolvimento em espiral",
            "Um modelo de desenvolvimento linear sequencial",
            "Um modelo de desenvolvimento baseado em prototipação"
        ),
        alternativaCorreta = "Um modelo de desenvolvimento linear sequencial"
    ),
    QuizQuestion(
        questao = "Qual é o objetivo principal das metodologias ágeis na Engenharia de Software?",
        listOf(
            "Entregar software funcionando rapidamente",
            "Seguir um plano rigoroso e detalhado",
            "Minimizar a interação com o cliente",
            "Fornecer documentação abrangente",
            "Evitar mudanças durante o desenvolvimento"
        ),
        alternativaCorreta = "Entregar software funcionando rapidamente"
    ),
    QuizQuestion(
        questao = "O que é o versionamento de software?",
        alternativas = listOf(
            "O processo de testar o software em diferentes versões de sistema operacional",
            "O processo de criar diferentes versões do software para diferentes clientes",
            " O processo de controlar e rastrear as alterações feitas no software ao longo do tempo",
            "O processo de atualizar automaticamente o software sem intervenção do usuário",
            "O processo de dividir o software em módulos independentes"
        ),
        alternativaCorreta = "O processo de controlar e rastrear as alterações feitas no software ao longo do tempo"
    ),
    QuizQuestion(
        questao = "O que é um teste de unidade na Engenharia de Software?",
        alternativas = listOf(
            "Um teste que verifica se diferentes componentes de software funcionam bem juntos",
            "Um teste que verifica se o software atende aos requisitos do cliente",
            "Um teste que verifica se o software é fácil de usar",
            "Um teste que verifica se o software funciona corretamente em diferentes sistemas operacionais",
            "Um teste que verifica a corretude e funcionalidade de uma unidade específica do software"
        ),
        alternativaCorreta = "Um teste que verifica a corretude e funcionalidade de uma unidade específica do software"
    ),
    QuizQuestion(
        questao = "O que é a reengenharia de software?",
        alternativas = listOf(
            "A criação de um software a partir do zero",
            "A otimização de um software existente para melhorar sua eficiência",
            "A eliminação de bugs em um software",
            "A documentação de um software existente",
            "O processo de manutenção corretiva de um software"
        ),
        alternativaCorreta = "A otimização de um software existente para melhorar sua eficiência"
    ),
    QuizQuestion(
        questao = "Qual é o objetivo do design orientado a objetos na Engenharia de Software?",
        alternativas = listOf(
            "Criar uma interface de usuário amigável",
            "Dividir o software em módulos independentes",
            "Aumentar a velocidade de execução do software",
            "Otimizar a utilização de recursos de hardware",
            "Melhorar a manutenibilidade e reutilização do software"
        ),
        alternativaCorreta = "Melhorar a manutenibilidade e reutilização do software"
    ),
    QuizQuestion(
        questao = "O que é o processo de verificação na Engenharia de Software?",
        alternativas = listOf(
            "Testar o software em diferentes ambientes de hardware",
            "Revisar o código fonte do software em busca de erros",
            "Validar se o software atende aos requisitos do cliente",
            "Verificar se o software funciona corretamente em diferentes sistemas operacionais",
            "Garantir que o software foi construído corretamente e de acordo com as especificações"
        ),
        alternativaCorreta = "Garantir que o software foi construído corretamente e de acordo com as especificações"
    ),
    QuizQuestion(
        questao = "O que é um backlog de produto (product backlog) no contexto da metodologia ágil Scrum?",
        alternativas = listOf(
            "Uma lista de funcionalidades e requisitos do software ordenados por prioridade",
            "Uma lista de tarefas diárias a serem realizadas pela equipe de desenvolvimento",
            "Um documento que descreve a arquitetura do software em detalhes",
            "Uma reunião diária em que a equipe revisa o progresso do projeto",
            "Um gráfico que mostra o progresso do projeto ao longo do tempo"
        ),
        alternativaCorreta = "Uma lista de funcionalidades e requisitos do software ordenados por prioridade"
    ),
    QuizQuestion(
        questao = "O que é o diagrama de sequência na UML (Unified Modeling Language)?",
        alternativas = listOf(
            "Um diagrama que mostra a estrutura do banco de dados",
            "Um diagrama que mostra a relação entre diferentes classes de objetos",
            "Um diagrama que mostra a interação entre diferentes objetos ao longo do tempo",
            "Um diagrama que mostra as dependências entre diferentes módulos do software",
            "Um diagrama que mostra a distribuição do software em diferentes servidores"
        ),
        alternativaCorreta = "Um diagrama que mostra a interação entre diferentes objetos ao longo do tempo"
    ),
    QuizQuestion(
        questao = "Qual é o objetivo principal da engenharia de requisitos na Engenharia de Software?",
        alternativas = listOf(
            "Desenvolver um protótipo funcional do software",
            "Documentar as especificações técnicas do software",
            "Identificar e definir os requisitos do software",
            "Especificar as características de design do software",
            "Validar a qualidade do software"
        ),
        alternativaCorreta = "Identificar e definir os requisitos do software"
    ),
    QuizQuestion(
        questao = "Qual é o objetivo principal da fase de testes na Engenharia de Software?",
        alternativas = listOf(
            "Validar a funcionalidade do software",
            "Definir os requisitos do software",
            "Criar o design do software",
            "Identificar bugs no software",
            "Implementar o software"
        ),
        alternativaCorreta = "Identificar bugs no software"
    )
)
val desenvMobile = listOf(
    QuizQuestion(
        questao = "Qual é a linguagem de programação mais comum para o desenvolvimento de aplicativos móveis?",
        alternativas = listOf(
            "Java",
            "C++",
            "Python",
            "Swift",
            "HTML"
        ),
        alternativaCorreta = "Swift"
    ),
    QuizQuestion(
        questao = "O que é um SDK no contexto do desenvolvimento mobile?",
        alternativas = listOf(
            "Um software para criar interfaces de usuário",
            "Um conjunto de ferramentas para desenvolvimento de aplicativos móveis",
            "Um ambiente de desenvolvimento integrado (IDE)",
            "Um dispositivo de teste para aplicativos móveis",
            "Um servidor para hospedar aplicativos móveis"
        ),
        alternativaCorreta = "Um conjunto de ferramentas para desenvolvimento de aplicativos móveis"
    ),
    QuizQuestion(
        questao = "O que é o Android Studio?",
        alternativas = listOf(
            "Uma linguagem de programação para desenvolvimento de aplicativos iOS",
            "Um framework para desenvolvimento de aplicativos híbridos",
            "Um ambiente de desenvolvimento integrado (IDE) para o desenvolvimento de aplicativos Android",
            "Um dispositivo de teste para aplicativos móveis Android",
            "Um sistema operacional para dispositivos móveis"
        ),
        alternativaCorreta = "Um ambiente de desenvolvimento integrado (IDE) para o desenvolvimento de aplicativos Android"
    ),
    QuizQuestion(
        questao = "Qual plataforma utiliza a linguagem Objective-C para o desenvolvimento de aplicativos móveis?",
        alternativas = listOf(
            "Android",
            "Windows Phone",
            "iOS",
            "BlackBerry",
            "Symbian"
        ),
        alternativaCorreta = "iOS"
    ),
    QuizQuestion(
        questao = "O que é um emulador no contexto do desenvolvimento mobile?",
        alternativas = listOf(
            "Um dispositivo real utilizado para testar aplicativos móveis",
            "Um aplicativo que permite emular a funcionalidade de outro aplicativo",
            "Um servidor para hospedar aplicativos móveis",
            "Um ambiente de desenvolvimento integrado (IDE)",
            "Um software que simula um dispositivo móvel para testar aplicativos"
        ),
        alternativaCorreta = "Um software que simula um dispositivo móvel para testar aplicativos"
    ),
    QuizQuestion(
        questao = "O que é o React Native?",
        alternativas = listOf(
            "Uma linguagem de programação para desenvolvimento de aplicativos iOS",
            "Um framework para desenvolvimento de aplicativos híbridos",
            "Um ambiente de desenvolvimento integrado (IDE) para o desenvolvimento de aplicativos Android",
            "Uma biblioteca para desenvolvimento de aplicativos Android nativos",
            "Um sistema operacional para dispositivos móveis"
        ),
        alternativaCorreta = "Um framework para desenvolvimento de aplicativos híbridos"
    ),
    QuizQuestion(
        questao = "Quais são as principais linguagens de programação utilizadas no desenvolvimento de aplicativos móveis com o framework React Native?",
        alternativas = listOf(
            "Java e Kotlin",
            "Objective-C e Swift",
            "C++ e C#",
            "JavaScript e TypeScript",
            "HTML e CSS"
        ),
        alternativaCorreta = "JavaScript e TypeScript"
    ),
    QuizQuestion(
        questao = "Qual das seguintes plataformas permite o desenvolvimento de aplicativos móveis usando tecnologias web, como HTML, CSS e JavaScript?",
        alternativas = listOf(
            "Android",
            "iOS",
            "Windows Phone",
            "React Native",
            "Xamarin"
        ),
        alternativaCorreta = "React Native"
    ),
    QuizQuestion(
        questao = "O que é o Xcode?",
        alternativas = listOf(
            "Um software de edição de imagem para dispositivos móveis",
            "Um ambiente de desenvolvimento integrado (IDE) para desenvolvimento de aplicativos iOS",
            "Um framework para desenvolvimento de aplicativos Android",
            "Um emulador de dispositivo móvel",
            "Um software de gerenciamento de projeto para desenvolvimento de aplicativos móveis"
        ),
        alternativaCorreta = "Um ambiente de desenvolvimento integrado (IDE) para desenvolvimento de aplicativos iOS"
    ),
    QuizQuestion(
        questao = "O que é o Flutter?",
        alternativas = listOf(
            "Uma linguagem de programação para desenvolvimento de aplicativos móveis",
            "Um framework para desenvolvimento de aplicativos iOS",
            "Um emulador de dispositivo móvel",
            "Um serviço de armazenamento em nuvem para aplicativos móveis",
            "Um SDK (Software Development Kit) para desenvolvimento de aplicativos móveis multiplataforma"
        ),
        alternativaCorreta = "Um SDK (Software Development Kit) para desenvolvimento de aplicativos móveis multiplataforma"
    )
)
val bi = listOf(
    QuizQuestion(
        questao = "O que é Business Intelligence (BI)?",
        alternativas = listOf(
            "Um software de gerenciamento de projetos",
            "Uma técnica de marketing para aumentar as vendas",
            "Um conjunto de práticas para recrutamento de funcionários",
            "Um processo de análise de dados para auxiliar na tomada de decisões empresariais",
            "Um modelo de negócios voltado para startups"
        ),
        alternativaCorreta = "Um processo de análise de dados para auxiliar na tomada de decisões empresariais"
    ),
    QuizQuestion(
        questao = "Qual é o objetivo principal do Business Intelligence?",
        alternativas = listOf(
            "Coletar dados em tempo real",
            "Criar relatórios financeiros",
            "Identificar oportunidades de mercado",
            "Melhorar a segurança cibernética",
            "Fornecer insights para suportar decisões de negócios"
        ),
        alternativaCorreta = "Fornecer insights para suportar decisões de negócios",
    ),
    QuizQuestion(
        questao = "O que são painéis de controle (dashboards) em Business Intelligence?",
        alternativas = listOf(
            "Relatórios de desempenho dos funcionários",
            "Ferramentas de comunicação interna",
            "Interfaces gráficas para visualização de dados e métricas-chave",
            "Modelos de negócios para startups",
            "Técnicas de marketing para atrair clientes"
        ),
        alternativaCorreta = "Interfaces gráficas para visualização de dados e métricas-chave"
    ),
    QuizQuestion(
        questao = "Qual é a função do ETL (Extract, Transform, Load) em Business Intelligence?",
        alternativas = listOf(
            "Coletar dados de diversas fontes, transformá-los e carregá-los em um data warehouse ou data mart",
            "Gerar relatórios financeiros",
            "Monitorar as redes sociais da empresa",
            "Criar campanhas de marketing digital",
            "Realizar análises de risco",
        ),
        alternativaCorreta = "Coletar dados de diversas fontes, transformá-los e carregá-los em um data warehouse ou data mart"
    ),
    QuizQuestion(
        questao = "Qual é a diferença entre OLTP (Online Transaction Processing) e OLAP (Online Analytical Processing)?",
        alternativas = listOf(
            "OLTP é usado para análises de dados em tempo real, enquanto OLAP é usado para transações online",
            "OLTP é um processo de tomada de decisões, enquanto OLAP é um processo de coleta de dados",
            "OLTP é voltado para processamento de transações em tempo real, enquanto OLAP é voltado para análise de dados históricos",
            "OLTP é um termo genérico para sistemas de banco de dados, enquanto OLAP se refere especificamente a sistemas de data warehousing",
            "OLTP é utilizado para visualização de dados, enquanto OLAP é utilizado para integração de dados",
        ),
        alternativaCorreta = "OLTP é voltado para processamento de transações em tempo real, enquanto OLAP é voltado para análise de dados históricos"
    ),
    QuizQuestion(
        questao = "OLTP é voltado para processamento de transações em tempo real, enquanto OLAP é voltado para análise de dados históricos",
        alternativas = listOf(
            "Um armazenamento em nuvem para dados empresariais",
            "Um conjunto de ferramentas de análise de dados",
            "Um processo para limpeza e organização de dados",
            "Um sistema para coleta de dados em tempo real",
            "Um banco de dados centralizado para armazenar dados empresariais integrados e históricos",
        ),
        alternativaCorreta = "Um banco de dados centralizado para armazenar dados empresariais integrados e históricos"
    ),
    QuizQuestion(
        questao = "Quais são as etapas do processo de Business Intelligence?",
        alternativas = listOf(
            "Coleta, análise, visualização e compartilhamento de dados",
            "Coleta, armazenamento, compartilhamento e monitoramento de dados",
            "Extração, análise, carregamento e transformação de dados",
            "Armazenamento, recuperação, manipulação e exclusão de dados",
            "Análise, modelagem, implementação e otimização de dados",
        ),
        alternativaCorreta = "Coleta, análise, visualização e compartilhamento de dados"
    ),
    QuizQuestion(
        questao = "O que é mineração de dados (data mining) em Business Intelligence?",
        alternativas = listOf(
            "Um processo para coletar dados brutos de várias fontes",
            "Um conjunto de técnicas para identificar padrões e tendências nos dados",
            "Um método para armazenar dados de forma eficiente em um data warehouse",
            "Uma estratégia de marketing para atrair novos clientes",
            "Um modelo de negócio baseado em monetização de dados",
        ),
        alternativaCorreta = "Um conjunto de técnicas para identificar padrões e tendências nos dados"
    ),
    QuizQuestion(
        questao = "Quais são os benefícios do uso de Business Intelligence em uma empresa?",
        alternativas = listOf(
            "Melhorias na eficiência operacional e na tomada de decisões, identificação de oportunidades de crescimento e redução de riscos",
            "Aumento da receita, expansão de mercado e melhoria da comunicação interna",
            "Automatização de processos, redução de custos e aumento da produtividade",
            "Otimização da cadeia de suprimentos, aumento da satisfação do cliente e melhoria da segurança de dados",
            "Desenvolvimento de parcerias estratégicas, diversificação de produtos e melhoria da governança corporativa",
        ),
        alternativaCorreta = "Melhorias na eficiência operacional e na tomada de decisões, identificação de oportunidades de crescimento e redução de riscos"
    ),
    QuizQuestion(
        questao = "O que é um painel de indicadores-chave de desempenho (KPI) em Business Intelligence?",
        alternativas = listOf(
            "Uma ferramenta para comunicação interna na empresa",
            "Uma técnica para armazenar dados em nuvem",
            "Um método para avaliar o desempenho financeiro de uma empresa",
            "Um sistema para análise de dados em tempo real",
            "Uma visualização gráfica dos principais indicadores de desempenho de uma empresa"
        ),
        alternativaCorreta = "Uma visualização gráfica dos principais indicadores de desempenho de uma empresa"
    )

)
val backend = listOf(
    QuizQuestion(
        questao = "O que é Backend no desenvolvimento de software?",
        alternativas = listOf(
            "A interface gráfica de um aplicativo",
            "O código executado no cliente",
            "O banco de dados utilizado pelo aplicativo",
            "O servidor e a lógica de negócios do aplicativo",
            "O processo de depuração do código"
        ),
        alternativaCorreta = "O servidor e a lógica de negócios do aplicativo",
    ),
    QuizQuestion(
        questao = "Qual das seguintes linguagens de programação é amplamente usada para desenvolvimento Backend?",
        alternativas = listOf(
            "HTML",
            "CSS",
            "Python",
            "JavaScript",
            "React"
        ),
        alternativaCorreta = "Python"
    ),
    QuizQuestion(
        questao = "O que é uma API (Application Programming Interface)?",
        alternativas = listOf(
            "Um conjunto de regras para o desenvolvimento de interfaces gráficas",
            "Um tipo de banco de dados relacional",
            "Uma biblioteca de funções para o desenvolvimento de aplicativos móveis",
            "Um serviço que permite que aplicativos se comuniquem e interajam com outros aplicativos ou sistemas",
            "Uma técnica de criptografia para garantir a segurança dos dados",
        ),
        alternativaCorreta = "Um serviço que permite que aplicativos se comuniquem e interajam com outros aplicativos ou sistemas"
    ),
    QuizQuestion(
        questao = "O que é um servidor no contexto do desenvolvimento Backend?",
        alternativas = listOf(
            "Um computador que hospeda um website ou aplicativo",
            "Um banco de dados utilizado para armazenar dados de um aplicativo",
            "Uma linguagem de programação utilizada para desenvolver a interface gráfica de um aplicativo",
            "Um ambiente de desenvolvimento integrado (IDE)",
            "Uma ferramenta para testar e depurar o código do aplicativo",
        ),
        alternativaCorreta = "Um computador que hospeda um website ou aplicativo"
    ),
    QuizQuestion(
        questao = "Qual é a diferença entre um servidor web e um servidor de aplicativos?",
        alternativas = listOf(
            "Um servidor web é responsável pela lógica de negócios do aplicativo, enquanto um servidor de aplicativos lida com as requisições HTTP.",
            "Um servidor web é usado para hospedar sites estáticos, enquanto um servidor de aplicativos é usado para hospedar aplicativos dinâmicos.",
            "Um servidor web é uma máquina física, enquanto um servidor de aplicativos é um software.",
            "Um servidor web é usado para desenvolvimento Backend, enquanto um servidor de aplicativos é usado para desenvolvimento Frontend.",
            "Não há diferença significativa entre um servidor web e um servidor de aplicativos."
        ),
        alternativaCorreta = "Um servidor web é usado para hospedar sites estáticos, enquanto um servidor de aplicativos é usado para hospedar aplicativos dinâmicos."
    ),
    QuizQuestion(
        questao = "O que é um banco de dados relacional?",
        alternativas = listOf(
            "Um banco de dados que armazena dados em formato de planilhas",
            "Um banco de dados que armazena dados em formato de gráficos",
            "Um banco de dados que armazena dados em formato de documentos",
            "Um banco de dados que armazena dados em tabelas relacionadas entre si",
            "Um banco de dados que armazena dados em formato de objetos"
        ),
        alternativaCorreta = "Um banco de dados que armazena dados em tabelas relacionadas entre si"
    ),
    QuizQuestion(
        questao = "O que é o protocolo HTTP?",
        alternativas = listOf(
            "Um protocolo de comunicação para transferência de arquivos entre servidores e clientes",
            "Um protocolo de segurança para criptografar dados transmitidos na web",
            "Um protocolo de autenticação para acessar APIs de terceiros",
            "Um protocolo de rede para identificar endereços IP",
            "Um protocolo de comunicação para transferência de dados na web"
        ),
        alternativaCorreta = "Um protocolo de comunicação para transferência de dados na web"
    ),
    QuizQuestion(
        questao = "O que é um servidor de cache?",
        alternativas = listOf(
            "Um servidor que armazena backups de dados do aplicativo",
            "Um servidor que hospeda o código do aplicativo",
            "Um servidor que armazena os arquivos de estilo (CSS) do aplicativo",
            "Um servidor que armazena os arquivos de script (JavaScript) do aplicativo",
            "Um servidor que armazena temporariamente os dados frequentemente acessados para melhorar o desempenho"
        ),
        alternativaCorreta = "Um servidor que armazena temporariamente os dados frequentemente acessados para melhorar o desempenho"
    ),
    QuizQuestion(
        questao = "O que é escalabilidade em um contexto de Backend?",
        alternativas = listOf(
            "A capacidade de um aplicativo de se adaptar a diferentes dispositivos móveis",
            "A velocidade de resposta de um aplicativo em relação às solicitações do usuário",
            "A capacidade de um servidor de lidar com um aumento na demanda de tráfego e usuários",
            "A facilidade de manutenção do código de um aplicativo",
            "O tamanho total dos arquivos do aplicativo"
        ),
        alternativaCorreta = "A capacidade de um servidor de lidar com um aumento na demanda de tráfego e usuários"
    ),
    QuizQuestion(
        questao = "O que é um middleware em um contexto de Backend?",
        alternativas = listOf(
            "Um software de segurança para proteger o servidor de ataques",
            "Um banco de dados utilizado para armazenar logs do servidor",
            "Um software para monitorar o desempenho do servidor",
            "Um componente intermediário que lida com as requisições entre o cliente e o servidor",
            "Uma biblioteca de scripts utilizada para automatizar tarefas do servidor",
        ),
        alternativaCorreta = "Um componente intermediário que lida com as requisições entre o cliente e o servidor"
    )

)


val AllQuiz = mapOf(
    "datascience" to dataScience,
    "frontend" to frontend,
    "machinelearning" to machinelearning,
    "engsoftware" to engSoftware,
    "mobile" to desenvMobile,
    "bi" to bi,
    "backend" to backend
)