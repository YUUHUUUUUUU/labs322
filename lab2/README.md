## Laboratório 2 MC322

# Heranças

Implementamos o baralho de compras/lixo e as heranças. As heranças foram dos tipos "entidade" e "carta".

O tipo entidade abstrato tem funções em comum de inimigo e herói, sendo elas: getName, getLife, getShield, isAlive e duas funções abstratas que são ligeiramente diferentes, showStatus e getDamage.

O tipo carta abstrato, por outro lado, tem em comum as funções de getCost, getName, getDescription e os tipos abstratos diferentes usar e showDescription.

# Baralho

Implementamos dois baralhos: de compra e lixo. A cada rodada, o herói pode comprar 0, 1 ou 2 cartas. O de lixo recebe as cartas não compradas pelo herói. A mão do herói é uma terceira lista de cartas com no máximo 4 elementos que contém as cartas compradas mas não usadas ainda. O de compra começa com as 8 cartas e a cada rodada disponibiliza 2 para compra, e quando fica vazio, é "reposto" pelo de lixo e embaralhado, de forma que o jogo tem um elemendo de randomização mas após 4 rodadas o baralho cicla.

Fizemos o jogador gastar energia na hora em que ele compra as cartas, de maneira que limitemos a compra de cartas por parte do herói.