#language: pt

Funcionalidade: Propondo lances

Cenario: Propondo um lance valido
	Dado um lance valido
	Quando propoe o lance
	Entao o lance e aceito
	
Cenario: Propondo varios lance validos
	Dado um lance de 10.0 reais do usuario "fulano"
	E um lance de 15.0 reais do usuario "beltrano"
	Quando propoe os lances
	Entao os lances sao aceitos
	
Esquema do Cenario: Propondo um lance invalido
	Dado um lance invalido de <valor> reais e do usuario '<nomeUsuario>'
	Quando propoe o lance
	Entao o lance nao e aceito
	
Exemplos:
    | valor  |  nomeUsuario |
    |   0.0  |		beltrano  |
    |  -1.0  |		fulano  	|
    | -100.0 |		sicrano		|
    
Cenario: Propondo uma sequencia de lances
	Dado dois lances
    | valor  |  nomeUsuario |
    |  10.0  |		beltrano  |
    |  15.0  |		beltrano	|
	Quando propoe os lances
	Entao o segundo lance nao e aceito