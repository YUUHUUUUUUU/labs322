## Laboratório 5

# Campanha
Foi criada a classe Campaign para que instancia inimigos, cria um DAG com eles e administra o fluxo da campanha onde o
jogador pode escolher o próximo combate ou salvar e sair.

# Testes Unitários
Foram feitos testes unitários que cobrem boa parte do código. Eles atualmente cobrem 60% do código e só não cobrem funções que dependem do jogador digitar algo ou de funções que só tem como função printar coisas. Fizemos também testes gerando turnos aleatórios do inimigo 100 vezes. Fizemos isso pois as escolhas do inimigo são randomizadas, e por isso precisamos de muitos testes para passarmos por todas as linhas.

# Starter commands
Fizemos esse arquivo txt com todos os comandos gradle necessários para a execução do jogo.

# Permanência
Foi feito o esqueleto para um mecanismo de save no jogo, com as interações no terminal onde seria possível salvar ou carregar um save.

# Card Factory
Foi criada uma classe CardFactory que contém a template de efeitos e cartas, além de facilitar instanciar as cartas, isso
centraliza onde as cartas podem ser modificadas, como diferentes inimigos e heróis podem possuir cartas em comum o CardFactory facilita a manutenção (e.g.: buffs e debuffs).

# Expansão (todo)
Com a criação da CardFactory, StandardClassDeck e Campaign ficou prático cria novas campanhas para institutos diferentes com ataques especificos da campanha (e.g.: efeitos de doença para oo IB e armas químicas e radiação para o IQ), bastando transformar Campaign em uma classe abstrats, criar as novas cartas e efeitos no CardFactory e criar o StandardInstituteDeck.