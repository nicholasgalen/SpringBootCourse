Cliente → Envia requisição HTTP

Controller → Processa requisição e lança exceção em caso de erro

Handler (@ControllerAdvice) → Captura a exceção e constrói o ExceptionResponse

Spring → Converte automaticamente ExceptionResponse para JSON

Cliente ← Recebe resposta com:

    Status HTTP (400, 500, etc)

    Corpo JSON padronizado:
        {
            "timestamp": "2023-10-05T12:30:45.123Z",
            "message": "Operação matemática não suportada",
            "details": "uri=/api/calculate"
        }

Controller → Lança exceção → @ControllerAdvice captura →
Constrói ExceptionResponse (baseado na Exception generica ou a que criamos: UnsuportedMathOperationException) → 
Spring converte para JSON → Cliente recebe resposta padronizada

-------------------------------------------------------------------------------------------------------------------------

# ExceptionResponse → O Corpo 🧠
Função: Estrutura universal que contém todos os elementos essenciais de qualquer erro
    
    timestamp  // Quando o erro ocorreu
    message    // Mensagem humana compreensível
    details    // Informações técnicas/detalhadas

Característica: Modelo único usado para todas as exceções

# UnsuportedMathOperationException → A Carcaça 🦴
Função: Molde reutilizável para erros específicos

Características:

- Poderia ser DatabaseConnectionException, InvalidUserException, etc
- Define o tipo semântico do erro
- Traz o status HTTP associado (@ResponseStatus)
- É "vazia" até ser instanciada com uma mensagem específica

# CustomEntityResponseHandler → O Cérebro 🧠

Função: Controlador central que gerencia como as exceções serão tratadas

Responsabilidades:

- Mapear cada tipo de exceção para um tratamento específico
- Decidir qual status HTTP retornar
- Construir o ExceptionResponse adequado
- Adicionar detalhes contextuais da requisição
