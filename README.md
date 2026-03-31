# tarefa1mc322
Tarefa 1 de mc322

## Arquivos dos objetos

Nos arquivos diferentes do app, o que fizemos foram os atributos de cada objeto (criamos 4) e as funções get e set (quando necessárias);

Os atributos de herói são vida, energia, nome, escudo (que indica quanto um herói tem em um determinado momento);
Os atributos de inimigo são vida, nome e dano padrão. Como tínhamos que fazer apenas uma batalha simples, ele tem um dano padrão.
Nessas duas, temos também funções que indicam se ainda estão vivos e o status de cada personagem, para printarmos a cada round.

Os atributos de dano são: nome, custo e dano em si. Podíamos ter feito um objeto chamado "cartas" e feito o resto por herança especificando os tipos.
Para escudo, apenas troca dano por defesa.
Ambas tem um showStatus para mostrarmos ela pro jogador, além de uma função que chamamos sempre que um jogador as usa no app.

## App

No app, optamos pelo vilão ser o IFGW (instituto de física da unicamp), e deixar o nome do jogador a escolha de quem está jogando.
Pela simplicidade, também criamos opções fixas de escudo e espada, e tornamos o ataque do inimigo padronizado.

A cada rodada, um jogador pode escolher 5 opções: duas de ataque, duas de defesa e uma de skipar o round pra acumular energia (que se regenera).
Tratamos as exceções pra caso um jogador selecione uma opção que usa muita energia que ele não tem, isso seja informado e ele possa jogar novamente. Usamos, para isso, um while(true) e alguns breaks de maneira que o loop seja interrompido somente após uma jogada válida.

Por fim, o vilão ataca de maneira fixa. O programa só para quando um dos dois morre. Além disso, um detalhe interessante é explicar a estrutura de dois while(true) que usamos no código. Nesse caso, usamos dois, um para rodar enquanto ambos estão vivos e só parar com a morte de um, e o outro dentro desse inicial para que o herói só consiga executar uma jogada válida.

## Estrutura de arquivos

> src

    |-- App.java
    |-- CartaDano.java
    |-- CartaEscudo.java
    |-- Herói.java
    |-- Inimigo.java
> .gitignore

> README.md