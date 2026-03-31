## Laboratório 3 MC322

# Efeitos

Implementamos o efeito Poison (subtrai vida a cada round) e o Energy (que regenera energia a cada round). A classe abstrata Effect tem metodos para update (ativar o efeito no momento certo, chamado pelo subscriber) e o subscribe(Entity) que inscreve o efeito no subscriber correspondente da entidade.

Os efeitos pode ser tanto imbutidos em uma CardEffect, que é uma carta que apenas ativa um efeito, ou ser imbutida em uma CardDamage

# Subscriber

Cada Entity tem dois subscribers, um que o Combat (observer) ativa no inicio do round dele e um que ativa no fim. Cada effect sabe em qual subscriber se inscrever pois a Entity é passada na função e o effect tem um atributo timingIsEnd que diz se o efeito deve ser ativado no começo ou fim do round. O subscriber tem uma lista de effects e um metodo update all, que chama o update para cada Effect na lista.

# Combat

O combat é a classe observer que lida com a lógica do combate. Agora que os inimigos também usam cartas, a lógica do inimigo e heroi ficaram bem simetricas (tanto que as subclasses são identicas a classe abstrata Entity), com a diferença sendo as cartas de cada um e que a escolha das ações do hero é feita no terminal enquanto a do enemy é RNG.

# To Do

-Implement logic combat with multiple heroes and enemies
-Make isBuff atribute for card so that Combat can decide if the target is the user itself or the opponent (for now it is using everything on the opponent, even buffs). In the future, when there are multiple allies and enemies it will be possible to show the list of them to choose who to use the card on.