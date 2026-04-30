## Laboratório 6

# Eventos
Combat foi refatorado como subclasse de evento, e foram adicionados os eventos Shop, GradeRevision e Postinho. Shop e Postinho são opcoes que o Hero tem apos cada combate da campanha, o shop tem upgrade de dano e compra do Pet (Gemini Pro) e o Postinho serve como uma Campfire. Ja o GradeRevision e um evento aleatorio que pode ocorrer apos o turno do enemy no combat, simula uma recorrecao de prova em que voce pode ganhar ou perder vida.

# Progressao
O Shop da upgrades permanentes que podem ser comprados com gold, que e obtido ganhando combates.

# Interacao Entre Entidades
Foi umplementado Pet (Gemni Pro) que e um atributo do heroi e se nao for nulo, o Pet causa dano no inimigo.

# Padrao de Design
Para o shop o padrao de design utilizado foi decorator, criamos uma classe abstrata upgrade para criar os upgrades que podem ser comprados na loja.

