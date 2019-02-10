<h1> Strategy (definição) </h1>

Strategy é um padrão que deve ser utilizado quando uma classe possuir 
diversos algoritmos que possam ser utilizados de forma intercambiável. 

A solução proposta pelo padrão consiste em delegar a execução do algoritmo
para uma instância que compõe a classe principal. 

<h2> Primeira solução: Herança </h2>

Na primeira solução, são criadas as classes ContaMensal, ContaHora e ContaDiaria. Por herança, o método <b> valorConta </b> da classe ContaEstacionamento será sobrescrito em cada uma das novas classes. 

Esse seria o príncipio do padrão Strategy. Temos uma estrutura (ContaEstacionamento) na qual precisamos variar um determinado comportamento. 

<h4> Problemas </h4>

Caso as regras de implementação mudem, pode haver uma explosão de subclasses. 

Outro problema, que o método instanciado na classe principal (ContaEstacionamento) não pode ser alterado para suas subclasses. Por exemplo, se um parâmetro é relevante para o método em uma subclasse, mas não o é para outra. Neste caso, teremos um duplicamento do código além de uma complexidade e rigidez desnecessária. 

Portanto, para esse caso, a herança não é a melhor solução. 

<h2> Segunda solução: Composição </h2>

As subclasses implementadas por heranças passam ser implementadas por interface. Se agora a aparecer uma alteração na regra, altera-se a implementação do valorConta de apenas uma classe. A interface cria um ponto de flexibilidade.


